function buscarPorData() {  
  $('#modalBusca').modal('hide');
  const formEl = document.getElementById('formAgenda');    
  const body = {};
  Array.from(formEl.elements).forEach(element => {
    if (element?.id && element?.value) {
      body[element.id] = element.value;
    }
  });  
  console.log(body)

  var listaDeDoacoes = [
        {
          "id": 6,
          "dataCadastro": "18/08/2023",
          "ativo": true,
          "tipoDoacaoId": 1,
          "dataDoacao": "10/09/2023",
          "usuarioId": 5,
          "usuarioNome": "RENAN OTÁVIO MONTEIRO",
          "tipoDoacao": "DOAÇÃO DE SANGUE",
          "hora": "07:40",
          "diaSemana": "QUARTA",
          "observacao": "teste",
          "status": "EM ANALISE",
          "statusId": 1
        }
   ];    
    popularTabela(listaDeDoacoes);
  }