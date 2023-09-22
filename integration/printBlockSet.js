const tableBlock = {
    "Tester" : ["Se connecter à la caméra", "Voir ce qu'il y a sur la caméra", "Autres tests", "Autres tests"],
    "Tourner" : ["Tourner à droite 3 fois","Tourner à droite 5 fois", "Tourner à droite 10 fois", "Tourner à gauche 3 fois", "Tourner à gauche 5 fois","Tourner à gauche 10 fois"],
    "Déplacer" : ["Avancer de 10", "Avancer de 20", "Reculer de 10", "Reculer de 20"],
    "Attraper" : ["Resserrer la pince"] ,
    "Relacher" : ["Déserrer la pince"]
}

function changeOfSet(p){
    // Pour la couleur dans le aside
    const divActive = document.querySelector(".divActive");
    divActive.classList.remove("divActive") ;
    const parentP = p.parentElement ;
    parentP.classList.add("divActive") ;

    // Pour le changement des blocs
    const newSet = String(p.textContent);
    var listBlock = tableBlock[newSet] ;

    var containBlock = document.getElementById('contain-bloc') ;
    containBlock.innerHTML = '' ; //je vide d'abord le contenu
    var typeSet = document.getElementById("typeSetOfBlock");
    typeSet.innerHTML = '' ;
    typeSet.textContent = newSet ;

    listBlock.forEach(e => {
        var divBlock = document.createElement("div");
        divBlock.classList.add("bloc") ;
        divBlock.classList.add(newSet) ;
        divBlock.textContent = e ;
        containBlock.appendChild(divBlock);
    });
}