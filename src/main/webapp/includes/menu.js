/* Adjusts menu's height to place the footer at the bottom of the page */
function adjustMenu() {
    /* Debug code
    document.getElementById("logg").innerHTML = document.getElementById("contenido").scrollHeight + "px";
    document.getElementById("logg1").innerHTML = window.innerHeight + "px";
    document.getElementById("logg2").innerHTML = document.getElementById("footer").clientHeight + "px";
    document.getElementById("logg3").innerHTML = window.innerWidth + "px";
    */
    
    if (window.innerWidth > 767) {
        if (window.innerHeight > document.getElementById("content").scrollHeight + document.getElementById("footer").clientHeight) {
            document.getElementById("row-content").style.height = window.innerHeight - document.getElementById("footer").clientHeight + "px";
        } else {
            document.getElementById("row-content").style.height = document.getElementById("content").scrollHeight + "px";
        }
    } else {
        if (window.innerHeight > document.getElementById("row-content").scrollHeight + document.getElementById("footer").clientHeight) {
            document.getElementById("row-content").style.height = window.innerHeight - document.getElementById("footer").clientHeight + "px";
        } else {
            document.getElementById("row-content").style.height = document.getElementById("row-content").scrollHeight + "px";
        }
    }

}


/* This function is called whenever the user resize the page */
window.onresize = function (event) {
    adjustMenu();
};