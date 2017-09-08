
function send() {
    var x = document.getElementById("speed").value;
    var y = document.getElementById("angle").value;
    if (isNaN(x) || isNaN(y))  {  alert("have to be positive number");}
    else{
        if (x < 0 || y < 0)   {  alert("have to be positive");}
        else{ 
            if (y >= 180 ) {  alert("angle have to be less than 180");}
            else{
                var json = JSON.stringify({
                    "speed": x,
                    "angle": y,
                });
                rotateCylindr(y);
                sendText(json);     
            }
        }
    }
}  
 

function drawImage(image) {
    console.log("drawImage");
    var json = JSON.parse(image);
    
    var max = json.max;
    
    var array = [];
        for (var i=0; i<json.points.length; i++) {
            var counter = json.points[i] / max;
            array.push(counter);
            console.log(counter);
        }
    setPoints(array);
}
