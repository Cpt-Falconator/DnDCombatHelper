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

                const field = document.createElement("div");
                field.className = "field";
                combatOutput.appendChild(field);

                const fieldBody = document.createElement("div");
                fieldBody.className = "field-body";
                field.appendChild(fieldBody);

                const init = document.createElement("span");
                init.className = "td";
                init.innerText = combat.initiative;
                fieldBody.appendChild(init);

                const name = document.createElement("span");
                name.className = "td";
                name.innerText = combat.name;
                fieldBody.appendChild(name);

                const aClass = document.createElement("span");
                aClass.className = "td";
                aClass.innerText = combat.armorClass;
                fieldBody.appendChild(aClass);

                const cHP = document.createElement("span");
                cHP.className = "td";
                cHP.innerText = combat.healthPoints;
                fieldBody.appendChild(cHP);

                const mHP = document.createElement("span");
                mHP.className = "td";
                mHP.innerText = combat.maxHealthPoints;
                fieldBody.appendChild(mHP);

                const isP = document.createElement("span");
                isP.className = "td";
                isP.innerText = combat.player;
                fieldBody.appendChild(isP);

                const deleteSpan = document.createElement("span");
                deleteSpan.className = "td";
                

                const deleteButton = document.createElement("button");
                deleteButton.className = "button";
                deleteButton.innerText = "-";
                deleteButton.addEventListener("click", function () {
                    deleteCombat(combat.id);
                })
                deleteSpan.appendChild(deleteButton);     
                fieldBody.appendChild(deleteSpan);           
            });
        }).catch(error => console.error(error));
}

reloadCombats();

function deleteCombat(id) {
    fetch("http://localhost:8081/delete/combat/" + id, {
        method: "DELETE"
    }).then(response => reloadCombats())
    .catch(error => console.error(error));
}