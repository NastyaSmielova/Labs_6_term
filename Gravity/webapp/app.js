var vertexShaderText = 
[
'precision mediump float;',
'',
'attribute vec2 vertPosition;',
'varying vec3 fragColor;',
'',
'void main()',
'{',
'  fragColor =  vec3(0.2, 0.2, 0.2);',
'  gl_Position = vec4(vertPosition, 0.0, 1.0);',
'}'
].join('\n');



var fragmentShaderText =
[
'precision mediump float;',
'',
'varying vec3 fragColor;',
'void main()',
'{',
'  gl_FragColor = vec4(fragColor, 0.8);',
'}'
].join('\n');


function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}
var canvas = document.getElementById('game-surface');
var gl = canvas.getContext('webgl');
var program = gl.createProgram();



function initShaders(){
   var vertexShader = gl.createShader(gl.VERTEX_SHADER);
	var fragmentShader = gl.createShader(gl.FRAGMENT_SHADER);

	gl.shaderSource(vertexShader, vertexShaderText);
	gl.shaderSource(fragmentShader, fragmentShaderText);

	gl.compileShader(vertexShader);
	if (!gl.getShaderParameter(vertexShader, gl.COMPILE_STATUS)) {
		console.error('ERROR compiling vertex shader!', gl.getShaderInfoLog(vertexShader));
		return;
	}

	gl.compileShader(fragmentShader);
	if (!gl.getShaderParameter(fragmentShader, gl.COMPILE_STATUS)) {
		console.error('ERROR compiling fragment shader!', gl.getShaderInfoLog(fragmentShader));
		return;
	}
	

	gl.attachShader(program, vertexShader);
	gl.attachShader(program, fragmentShader);
	gl.linkProgram(program);
	if (!gl.getProgramParameter(program, gl.LINK_STATUS)) {
		console.error('ERROR linking program!', gl.getProgramInfoLog(program));
		return;
	}
	gl.validateProgram(program);
	if (!gl.getProgramParameter(program, gl.VALIDATE_STATUS)) {
		console.error('ERROR validating program!', gl.getProgramInfoLog(program));
		return;
	}
}
var cylindr = [
           -0.05,-0.05,
            -0.05, 0.05,
            0.05, 0.05,
            0.05, - 0.05           
            
         ]

         
function rotateCylindr(angle){
    cylindr = [
           -0.05,-0.05,
            -0.05, 0.05,
            0.05, 0.05,
            0.05, - 0.05         
            
         ]
    for (i = 0; i < cylindr.length; i+=2){
        NewX = cylindr[i]*Math.cos(angle*180/Math.PI)-cylindr[i+1]*Math.sin(angle*180/Math.PI);
        NewY = cylindr[i+1]*Math.cos(angle*180/Math.PI)+cylindr[i]*Math.sin(angle*180/Math.PI);
        cylindr[i] = NewX;
        cylindr[i+1] = NewY;
    }
} 

function draw(){
    gl.useProgram(program);
    var x, y;
    var radius = 0.05;
    var j  = 0;
    
	var loop = function () {
            if (j < points.length ){
                circleVertexes = [];
                x = points[j++];
                    y = points[j++];
                    for(i = 0; i < 2.5 * Math.PI;i += Math.PI/8){
                            circleVertexes.push(Math.cos(i) * radius + x); 
                            circleVertexes.push(Math.sin(i) * radius + y); 
                    }

	            gl.clearColor(0.05, 0.05, 0.1, 1.0);
                    gl.clear(gl.DEPTH_BUFFER_BIT | gl.COLOR_BUFFER_BIT);
                    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(circleVertexes), gl.DYNAMIC_DRAW);
                            gl.drawArrays(gl.TRIANGLE_FAN, 0, circleVertexes.length/2);
                            
                    gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(cylindr), gl.STATIC_DRAW);
                    gl.drawArrays(gl.TRIANGLE_FAN, 0, cylindr.length/2);


                    sleep(10);
                    requestAnimationFrame(loop);
            }
        };
	requestAnimationFrame(loop);

}

var points = [];


function setPoints(newPoints){
    console.log("receive points ");

    points = newPoints;
    console.log(points);
    	draw();

}
var InitDemo = function () {
	console.log('This is working');
        points.push(0.0);
        points.push(0.0);

	if (!gl) {
		console.log('WebGL not supported, falling back on experimental-webgl');
		gl = canvas.getContext('experimental-webgl');
	}

	if (!gl) {
		alert('Your browser does not support WebGL');
	}

	gl.clearColor(0.05, 0.05, 0.1, 1.0);
	gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

	initShaders();

	var buffer = gl.createBuffer();
	gl.bindBuffer(gl.ARRAY_BUFFER, buffer);

	var positionAttribLocation = gl.getAttribLocation(program, 'vertPosition');
	gl.vertexAttribPointer(
		positionAttribLocation, 2, 
		gl.FLOAT, gl.FALSE,
		2 * Float32Array.BYTES_PER_ELEMENT, 0);
	gl.enableVertexAttribArray(positionAttribLocation);
        gl.viewport(0, 0, canvas.width, canvas.height);
    draw();
};
