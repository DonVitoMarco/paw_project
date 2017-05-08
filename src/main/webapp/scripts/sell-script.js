var ws = new WebSocket('ws://localhost:8081/exchange_websocket/websocket');

ws.onmessage = function (event) {
    var msg = JSON.parse(event.data);

    var code = document.getElementById("code").value;
    console.log(code);

    for(var i = 0; i < msg.companies.length; i++) {
        if (msg.companies[i].code === code) {
            var price = document.getElementById("price");
            price.value = msg.companies[i].price;
        }
    }

};
