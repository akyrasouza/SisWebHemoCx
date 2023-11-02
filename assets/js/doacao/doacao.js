
async function gerarLista() {
  var data = document.getElementById('dataDoacao').value;
  var lista_horarios= await buscarHorarios(data);
  var select = document.getElementById("horario");
  lista_horarios.forEach(function (horario) {
  var option = document.createElement("option");
  option.value = horario.id;
  option.textContent = horario.hora +"/"+ horario.dia;
  select.appendChild(option);
});
}

async function agendarDoacao() {
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
  await enviarDoacao(body);
}
