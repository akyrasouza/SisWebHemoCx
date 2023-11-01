$(document).ready(function () {
  
  $('[data-toggle="modal"]').click(function () {
    var targetModal = $(this).data("target");
    $(targetModal).modal("show");
  });
  
  $('#modalBusca .close, #modalBusca [data-dismiss="modal"]').click(function () {
    $('#modalBusca').modal("hide");
  });
 
  $('#modalBusca').modal({ backdrop: 'static', keyboard: false });
 
  $('#modalAlterar .close, #modalAlterar [data-dismiss="modal"]').click(function () {
    $('#modalAlterar').modal("hide");
  });
 
  $('#modalAlterar').modal({ backdrop: 'static', keyboard: false });
});
function modal(){
  console.log("deu certo porra!")
  $('#modalAlterar').modal("show");
}

