var ws = new WebSocket('ws://localhost:8081/exchange_websocket/websocket');

ws.onmessage = function (event) {
    var msg = JSON.parse(event.data);

    var res = window.location.href.split("?");
    var codeToBuy = res[1];

    for(var i = 0; i < msg.companies.length; i++) {
        if (msg.companies[i].code === codeToBuy) {
            var code = document.getElementById("code");
            var fullname = document.getElementById("fullname");
            var price = document.getElementById("price");
            code.value = msg.companies[i].code;
            price.value = msg.companies[i].price;
            fullname.value = msg.companies[i].fullName;
        }
    }

};