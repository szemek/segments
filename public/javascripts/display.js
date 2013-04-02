// Global variables
var canvas;
var ctx;

function draw(i, max) {
  if(i < max) {
    ctx.beginPath();
    ctx.moveTo(captures[i].x, captures[i].y);
    ctx.lineTo(captures[i+1].x, captures[i+1].y);
    ctx.stroke();
    setTimeout(function() {
      draw(i+1, max);
    }, 20);
  }
}

function init() {
  canvas = document.querySelector('canvas');
  canvas.width = window.innerWidth;
  canvas.height = window.innerHeight;
  ctx = canvas.getContext('2d');

  draw(0, captures.length-1);
}

window.addEventListener('load', init);
