var socket = new WebSocket('ws://localhost:9000/stream');

socket.onopen = function(e) {
  console.log('Socket opened');
};

socket.onclose = function(e) {
  console.log('Socket closed');
};

socket.onerror = function(e) {
  console.log('Socket error');
};

$(window).on('mousemove', function(event) {
  var X = event.clientX;
  var Y = event.clientY;
  var id = $('#capture').data('id');

  socket.send(JSON.stringify({id: id, X: X, Y: Y}));
});
