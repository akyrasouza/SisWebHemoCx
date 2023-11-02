function formataData( ){
  $(document).ready(function () {
    $('#dataDoacao').mask('dd-mm-yyyy');
  });
}

async function gerarLista() {
  var inputData = document.getElementById('dataDoacao').value;
  var data = new Date(inputData);

  // Aqui você pode adicionar a lógica para gerar a lista de acordo com a data
   // Obtém a data atual
  const dataAtual = new Date();
// Formata a data no formato "dd-mm-yyyy"
 const dataFormatada = formatarData(dataAtual);
  var lista_horarios= await buscarHorarios(dataFormatada);
  var select = document.getElementById("horario");
  lista_horarios.forEach(function (horario) {
  var option = document.createElement("option");
  option.value = horario.id;
  option.textContent = horario.hora +"/"+ horario.dia;
  select.appendChild(option);
});
}

function agendarDoacao() {
  const userData = JSON.parse(localStorage.getItem('userData'));
  const formEl = document.getElementById('formDoacao');
    
  const body = {};
  Array.from(formEl.elements).forEach(element => {
    if (element?.id && element?.value) {
      body[element.id] = element.value;
    }
  }); 
  body["tipoDoacao"] = 1;  
  body["usuario"] = userData.id;
  // var objeto = {
  //   "dataDoacao": "string",
  //   "horario": 0,
  //   "observacao": "string",
  //   "tipoDoacao": 1,
  //   "usuario": 1
  // };

  console.log(body); // Exibe o objeto preenchido no console (para fins de demonstração)
}
formataData();
