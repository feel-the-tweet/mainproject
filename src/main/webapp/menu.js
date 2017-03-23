/* Ajusta la altura ("height") para que el menú se alargue hasta el final de la página */
function adjustMenu() {
    /* Debug code
    document.getElementById("logg").innerHTML = document.getElementById("contenido").scrollHeight + "px";
    document.getElementById("logg1").innerHTML = window.innerHeight + "px";
    document.getElementById("logg2").innerHTML = document.getElementById("footer").clientHeight + "px";
    document.getElementById("logg3").innerHTML = window.innerWidth + "px";
    */
    
    if (window.innerWidth > 767) {
        if (window.innerHeight > document.getElementById("contenido").scrollHeight + document.getElementById("footer").clientHeight) {
            document.getElementById("row-content").style.height = window.innerHeight - document.getElementById("footer").clientHeight + "px";
        } else {
            document.getElementById("row-content").style.height = document.getElementById("contenido").scrollHeight + "px";
        }
    } else {
        if (window.innerHeight > document.getElementById("row-content").scrollHeight + document.getElementById("footer").clientHeight) {
            document.getElementById("row-content").style.height = window.innerHeight - document.getElementById("footer").clientHeight + "px";
        } else {
            document.getElementById("row-content").style.height = document.getElementById("row-content").scrollHeight + "px";
        }
    }

}


/* Esta función se llama cada vez que se redimensiona la página */
window.onresize = function (event) {
    adjustMenu();
};