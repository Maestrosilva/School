var open = false;
function dropdown() {
    if (!open) {
        document.getElementById("map").style.height = "450px";
        document.getElementById("map-btn").innerHTML =
            "скрий картата <i id=\"map-icon\" class=\"fa fa-caret-up\"></i>";
        open = true;
    }
    else {
        document.getElementById("map").style.height = "0px";
        document.getElementById("map-btn").innerHTML =
            "виж на картата <i id=\"map-icon\" class=\"fa fa-caret-down\"></i>";
        open = false;
    }
}