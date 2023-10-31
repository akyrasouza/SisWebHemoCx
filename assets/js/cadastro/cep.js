// cep.js
function buscarCep(input) {
    input.value = input.value.replace(/[^0-9]/g, "");
    if (input.value.length == 8) {
      var url = 'https://viacep.com.br/ws/' + input.value + '/json/';
      $.ajax({
        url: url,
        dataType: 'json',
        success: function (data) {
          $('#endereco').val(data.logradouro);
          $('#bairro').val(data.bairro);
          $('#localidade').val(data.localidade);
          $('#uf').val(data.uf);
        }
      });
    }
  }
  