
var wsUri = "ws://" + document.location.host + document.location.pathname + "gravityendpoint";
var websocket = new WebSocket(wsUri);

websocket.onerror = function(evt) {
    onError(evt);
};

function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}
websocket.onopen = function(evt) {
    onOpen(evt);
};


function onOpen() {
    console.log("Connected to " + wsUri);
}
websocket.onmessage = function(evt) {
    onMessage(evt);
};

function sendText(json) {
    console.log("sending text: " + json);
    websocket.send(json);
}
                
function onMessage(evt) {
    console.log("received: " + evt.data);
    drawImage(evt.data);
}