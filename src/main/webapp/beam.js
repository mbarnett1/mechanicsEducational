
//WINDOW VARIABLES
var width = 1600;
var height = 300;

var stage = new Konva.Stage({
  container: 'container',
  width: width,
  height: height
});

var stage2 = new Konva.Stage({
  container: 'container2',
  width: width,
  height: height
});

var layer =  new Konva.Layer();
var layer2 = new Konva.Layer();

//DRAWING VARIABLES
var offsetX = 75 ;
var offsetY = 100;
var beamThickness = 50;
var rollerSupportLocation = 500 ;
var pinSupportLocation = 200;


//SHAPES
var rect = new Konva.Rect({
  x: offsetX,
  y: offsetY,
  width: 1000,
  height: beamThickness,
  fill: '#1a75ff',
  stroke: 'black',
  strokeWidth: 2
});

var rect2 = new Konva.Rect({
  x: offsetX,
  y: offsetY,
  width: 1000,
  height: beamThickness,
  fill: '#1a75ff',
  stroke: 'black',
  strokeWidth: 2
});

var circle = new Konva.Circle({
  x: offsetX + rollerSupportLocation,
  y: offsetY + beamThickness + 25,
  radius: 25,
  fill: '#3dce33',
  stroke: 'black',
  strokeWidth: 2
});

var triangle = new Konva.RegularPolygon({
  x: offsetX + pinSupportLocation,
  y: 183,
  sides: 3,
  radius: 33,
  fill: '#3dce33',
  stroke: 'black',
  strokeWidth: 2
});


// ARRROWS
var loadArrow = new Konva.Arrow({
  x: offsetX + 500,
  y: offsetY - 6,
  points: [0,20, 0,100],
  pointerLength: 15,
  pointerWidth : 15,
  fill: 'red',
  stroke: 'red',
  strokeWidth: 5,
  offsetY: 100,
  rotation: 0
});

var pinArrowY = new Konva.Arrow({
  x: offsetX + pinSupportLocation,
  y: offsetY + beamThickness + 6,
  points: [0,20, 0,100],
  pointerLength: 15,
  pointerWidth : 15,
  fill: '#3dce33',
  stroke: '#3dce33',
  strokeWidth: 5,
  offsetY: 100,
  rotation: 180
});

var pinArrowX = new Konva.Arrow({
  x: offsetX - 5 + pinSupportLocation,
  y: offsetY + beamThickness,
  points: [0,10, 0,100],
  pointerLength: 15,
  pointerWidth : 15,
  fill: '#3dce33',
  stroke: '#3dce33',
  strokeWidth: 5,
  offsetY: 100,
  rotation: -90
});

var rollerArrow = new Konva.Arrow({
  x: offsetX + rollerSupportLocation,
  y: offsetY + beamThickness + 6,
  points: [0,20, 0,100],
  pointerLength: 15,
  pointerWidth : 15,
  fill: '#3dce33',
  stroke: '#3dce33',
  strokeWidth: 5,
  offsetY: 100,
  rotation: 180
});


//TEXT
var rollerText = new Konva.Text({
  x: rollerSupportLocation + 85,
  y: 190,
  text: 'Ry',
  fontSize: 30,
  fontFamily: 'Calibri',
  fill: '#3dce33'
});

var pinTextY = new Konva.Text({
  x: pinSupportLocation + 20,
  y: 160,
  text: 'Px',
  fontSize: 30,
  fontFamily: 'Calibri',
  fill: '#3dce33'
});

var pinTextX = new Konva.Text({
  x: pinSupportLocation + 85,
  y: 190,
  text: 'Py',
  fontSize: 30,
  fontFamily: 'Calibri',
  fill: '#3dce33'
});


// ADD SHAPES TO LAYERS
layer.add(rect);
layer.add(circle);
layer.add(triangle);
layer.add(loadArrow);

layer2.add(rect2);
layer2.add(pinArrowY);
layer2.add(pinArrowX);
layer2.add(rollerArrow);

layer2.add(rollerText);
layer2.add(pinTextX);
layer2.add(pinTextY);


// ADD LAYERS TO STAGE
stage.add(layer);
stage2.add(layer2)
