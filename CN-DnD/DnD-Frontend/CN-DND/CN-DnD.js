const combatContainer = document.getElementById("tbl_Combat");
const containerHeadings = document.getElementById("tbl_heading");
const combatOutput = document.getElementById("out_combat");
const createForm = document.getElementById("frm_createFighter");


createForm.addEventListener('submit', function (event) {
    event.preventDefault();
    console.log(this.name);
    const data = {
        initiative: this.nm_FighterInit.value,
        name: this.nm_FighterName.value,
        armorClass: this.nm_FighterAC.value,
        healthPoints: this.nm_FighterHP.value,
        maxHealthPoints: this.nm_FighterMaxHP.value,
        player: this.nm_FighterPC.checked
    }
    fetch("http://localhost:8081/create/combat", { //Make request
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            'Content-Type': "application/json",
        }
    }).then(response =>{
     reloadCombats();
        this.reset();
    }).catch(error => console.log(error));
});

function reloadCombats() {
    fetch("http://localhost:8081/get/allCombat")
        .then(response => response.json())
        .then(combatList => {
            combatContainer.innerHTML =''
            combatList.forEach(function(combat) {

                const newLine = document.createElement("div");
                newLine.className = "row";

                //Creating a new initiative
                const init = document.createElement("div");
                init.className = "col";
                //Creating a new text for initiative
                const initp = document.createElement("p");
                initp.innerText = combat.initiative;
                init.appendChild(initp);
                newLine.appendChild(init);

                //Creating a new name
                const name = document.createElement("div");
                name.className = "col";
                //Creating a new text for name
                const initName = document.createElement("p");
                initName.innerText = combat.name;
                name.appendChild(initName);
                newLine.appendChild(name);

                //Creating a new Armor class
                const aClass = document.createElement("div");
                aClass.className = "col";
                const aClassVal = document.createElement("p");
                aClassVal.innerText = combat.armorClass;
                aClass.appendChild(aClassVal);

                const mButton = document.createElement("button");
                    mButton.className = "button";
                    mButton.innerText = "-";
                    mButton.addEventListener("click", function () {
                            updateAC(combat.id, -1);
                        })
                    aClass.prepend(mButton); 

                const aButton = document.createElement("button");
                aButton.className = "button";
                aButton.innerText = "+";
                aButton.addEventListener("click", function () {
                            updateAC(combat.id, 1);
                    })
                aClass.appendChild(aButton); 
                newLine.appendChild(aClass);

                const cHP = document.createElement("div");
                cHP.className = "col";
                const cHPVal = document.createElement("p");
                cHPVal.innerText = combat.healthPoints;
                cHP.appendChild(cHPVal);

                const mButton2 = document.createElement("button");
                mButton2.className = "button";
                mButton2.innerText = "-";
                mButton2.addEventListener("click", function () {
                        updateHP(combat.id, -1);
                    })
                cHP.prepend(mButton2); 

                const aButton2 = document.createElement("button");
                aButton2.className = "button";
                aButton2.innerText = "+";
                aButton2.addEventListener("click", function () {
                        updateHP(combat.id, 1);
                    })
                cHP.appendChild(aButton2)
                newLine.appendChild(cHP);


                const mHP = document.createElement("div");
                mHP.className = "col";
                const mHPval = document.createElement("p");
                mHPval.innerText = combat.maxHealthPoints;
                mHP.appendChild(mHPval);
                newLine.appendChild(mHP);

                const isP = document.createElement("div");
                isP.className = "col";
                const isPval = document.createElement("p");
                isPval.innerText = combat.player;
                isP.appendChild(isPval);
                newLine.appendChild(isP);

                const deleteSpan = document.createElement("div");
                deleteSpan.className = "col";
                
                    const deleteButton = document.createElement("button");
                    deleteButton.className = "button";
                    deleteButton.innerText = "-";
                    deleteButton.addEventListener("click", function () {
                        deleteCombat(combat.id);
                    })
                    
                deleteSpan.appendChild(deleteButton);     
                newLine.appendChild(deleteSpan);    
                combatContainer.appendChild(newLine);       
            });
            combatContainer.prepend(containerHeadings);
            combatContainer.appendChild(createForm);
        }).catch(error => {
            console.error(error);
            this.location = "/Error/503.html"
        });
}

reloadCombats();

function deleteCombat(id) {
    fetch("http://localhost:8081/delete/combat/" + id, {
        method: "DELETE"
    }).then(response => reloadCombats())
    .catch(error => console.error(error));
}

function updateAC(id, mod){
    fetch("http://localhost:8081/patch/combatAC/" + id,{
        method: "PATCH",
        body: JSON.stringify(mod),
        headers: {
            'Content-Type': "application/json",
        }
    }).then(response => reloadCombats())
    .catch(error => console.log(error));
}

function updateHP(id, mod){
    fetch("http://localhost:8081/patch/combatHP/" + id,{
        method: "PATCH",
        body: JSON.stringify(mod),
        headers: {
            'Content-Type': "application/json",
        }
    }).then(response => reloadCombats())
    .catch(error => console.log(error));
}