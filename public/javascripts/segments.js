$(window).on('mousemove', function(event) {
  var X = event.clientX;
  var Y = event.clientY;
  var id = $('#capture').data('id');
  $.ajax({
    type: 'POST',
    url: '/capture/' + id + '/create',
    data: JSON.stringify({X: X, Y: Y}),
    contentType: 'application/json',
    dataType: 'json'
  });
});
