function change() {

    var color = getCookie("color");

    if (color === 'second') {
        var mainColor = document.getElementsByClassName("main-color");
        var mainColorHover = document.getElementsByClassName("main-color-hover");
        var mainColorHoverFont = document.getElementsByClassName("main-color-font-hover");

        changeClass(mainColor, "main-color", "second-main-color");
        changeClass(mainColorHover, "main-color-hover", "second-main-color-hover");
        changeClass(mainColorHoverFont, "main-color-font-hover", "second-main-color-font-hover");
    }

}

function changeClass(arr, rmClass, addClass) {
    while (arr.length) {
        arr[0].classList.add(addClass);
        arr[0].classList.remove(rmClass);
    }
}

change();

function saveColor(color) {
    if (color === 'second') {
        document.cookie = "color=second";
        location.reload();
        console.log(document.cookie);
    }
    if (color === 'main') {
        document.cookie = "color=";
        location.reload();
        console.log(document.cookie);
    }
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}
