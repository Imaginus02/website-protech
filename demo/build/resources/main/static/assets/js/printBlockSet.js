
// Tableau des blocs que je veux tester 
// Les clefs de tableBlock doivent correspondre avec le <aside> dans mainPage.html
const tableBlock = {
    "Allumer": ["Couleur Rouge", "Couleur Bleue", "Couleur Verte", "Couleur Blanche", "Eteindre"],
    "Temps": ["1 seconde", "2 secondes", "3 secondes", "5 secondes"]
}

function changeOfSet(p){
    // Pour la couleur dans le aside
    const divActive = document.querySelector(".divActive");
    divActive.classList.remove("divActive") ;
    const parentP = p.parentElement ;
    parentP.classList.add("divActive") ;

    // Pour le changement des blocs
    const newSet = String(p.textContent);

    var containBlock = document.getElementById('contain-bloc') ;
    containBlock.innerHTML = '' ; //je vide d'abord le contenu
    var typeSet = document.getElementById("typeSetOfBlock");
    typeSet.innerHTML = '' ;
    typeSet.textContent = newSet ;

    printSetBlock(newSet,containBlock);

    
}


function printSetBlock(type, containBlock) {
    var listBlock = tableBlock[type] ;
    listBlock.forEach(e => {
        var divBlock = document.createElement("div");
        divBlock.classList.add("bloc") ;
        divBlock.classList.add(type) ;
        divBlock.onclick = function() {move(this) ; };
        divBlock.textContent = e ;
        containBlock.appendChild(divBlock);
    });
}