const createForm = document.getElementById("frm_createFighter");
const combatOutput = document.getElementById("out_CombatList");

createForm.addEventListener('submit', function (event) {
    event.preventDefault();
    console.log(this.name);
    const data = {
        initiative: this.nm_FighterInit.value,
        name: this.nm_FighterName.value,
        armorClass: this.nm_FighterAC.value,
        healthPoints: this.nm_FighterHP.value,
        maxHealthPoints: this.nm_FighterMaxHP.value,
        isPlayer: this.nm_FighterPC.value
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
            combatOutput.innerHTML = '';
            combatList.forEach(function(combat) {

                const newLine = document.createElement("tr");
                newLine.className = "td";
                
                const init = document.createElement("span");
                init.className = "td";
                init.innerText = combat.initiative;
                newLine.appendChild(init);

                const name = document.createElement("span");
                name.className = "td";
                name.innerText = combat.name;
                newLine.appendChild(name);

                const aClass = document.createElement("span");
                aClass.className = "td";
                aClass.innerText = combat.armorClass;

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

                const cHP = document.createElement("span");
                cHP.className = "td";
                cHP.innerText = combat.healthPoints;

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

                const mHP = document.createElement("span");
                mHP.className = "td";
                mHP.innerText = combat.maxHealthPoints;
                newLine.appendChild(mHP);

                const isP = document.createElement("span");
                isP.className = "td";
                isP.innerText = combat.player;
                newLine.appendChild(isP);

                const deleteSpan = document.createElement("span");
                deleteSpan.className = "td";
                
                    const deleteButton = document.createElement("button");
                    deleteButton.className = "button";
                    deleteButton.innerText = "-";
                    deleteButton.addEventListener("click", function () {
                        deleteCombat(combat.id);
                    })
                    
                deleteSpan.appendChild(deleteButton);     
                newLine.appendChild(deleteSpan);    
                combatOutput.parentElement.appendChild(newLine);       
            });
            combatOutput.parentElement.appendChild(frm_createFighter);
        }).catch(error => console.error(error));
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