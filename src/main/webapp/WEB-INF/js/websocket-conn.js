var ws = new WebSocket("ws://localhost:8080/exchange_websocket/websocket");

ws.onopen = function (event) {
    console.log("open session ws");
    ws.send("Session Start : Sync");
};

ws.onmessage = function (event) {
    console.log("on message ws")
    console.log(event.data);
};

ws.onclose = function (event) {

};