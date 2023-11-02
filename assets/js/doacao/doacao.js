function formataData( ){
  alert("teste")
  $(document).ready(function () {
    $('#dataDoacao').mask('dd-mm-yyyy');
  });
}

function gerarLista() {
  var inputData = document.getElementById('dataDoacao').value;
  var data = new Date(inputData);

  // Aqui você pode adicionar a lógica para gerar a lista de acordo com a data
  var lista_horarios = [
    {
      "id": 52,
      "hora": "07:60",
      "dia": "SEXTA",
      "sigla": "SEX"
    },
    {
      "id": 53,
      "hora": "08:00",
      "dia": "SEXTA",
      "sigla": "SEX"
    },
    {
      "id": 54,
      "hora": "08:60",
      "dia": "SEXTA",
      "sigla": "SEX"
    },
    {
      "id": 55,
      "hora": "09:00",
      "dia": "SEXTA",
      "sigla": "SEX"
    },
    {
      "id": 56,
      "hora": "09:60",
      "dia": "SEXTA",
      "sigla": "SEX"
    },
    {
      "id": 57,
      "hora": "10:00",
      "dia": "SEXTA",
      "sigla": "SEX"
    },
    {
      "id": 58,
      "hora": "10:60",
      "dia": "SEXTA",
      "sigla": "SEX"
    },
    {
      "id": 59,
      "hora": "11:00",
      "dia": "SEXTA",
      "sigla": "SEX"
    }
  ];
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