
const formEl = document.getElementById('formEtapa');
$('.dropdown-toggle').dropdown();
let etapaAtual = 1;

(() => {
  const modelo = {
    "nome": "",
    "cpf": "",
    "dataNascimento": "",
    "sexo": "",
    "nomeMae": "",
    "telefone": "",
    "tipoSanguineo": "",
    "fatorRH": "",
    "email": "",
    "senha": ""
  };

  Object.entries(modelo).forEach(([key, value]) => {
    if (formEl.elements[key]) {
      formEl.elements[key].value = value;
    }
  });
})();

function proximaEtapa(etapa) {
  const camposValidos = validarCamposEtapa(etapaAtual);
  if (camposValidos.length > 0) {    
    return;
  }
  document.getElementById('etapa' + etapaAtual).style.display = 'none';
  document.getElementById('etapa' + etapa).style.display = 'block';
  etapaAtual = etapa;
}

function etapaAnterior(etapa) {
  document.getElementById('etapa' + etapaAtual).style.display = 'none';
  document.getElementById('etapa' + etapa).style.display = 'block';
  etapaAtual = etapa;
}

function validarCamposEtapa(etapa) {  
  const camposEtapa = document.querySelectorAll(`#etapa${etapa} input[required]`);
  const camposComErro = [];
  
    for (campo of camposEtapa) {  
      if(!campo.value){ 
        camposComErro.push(campo);
        showMessage({
        text:" o campo "+campo.id+" é obrigatorio",
        className: "error-toast",       
          
    });     
  } 
}

  return camposComErro.length === 0 ? [] : camposComErro;
}

async function enviarRelatorio() {
  const body = {};
  Array.from(formEl.elements).forEach(element => {
    if (element?.id && element?.value) {
      body[element.id] = element.value;
    }
  });

  await fetch('http://localhost:8080/usuarios', {
    method: 'POST',
    body: JSON.stringify(body),
    headers: {
      "Content-Type": "application/json"
    }
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error('Erro', { cause: response.json() });
      }
      return response.json();
    })
    .then(data => {
      showMessage({
        text: "Relatório enviado com sucesso!",
        className: "success-toast",       
        
      });
      window.location.href = "./login.html";
    })
    .catch((e) => {
      e.cause.then((data) => {
        showMessage({
          text: data?.mensagem || data?.message || data?.titulo || 'Sistema indisponível no momento. Por favor, tente mais tarde.',
          className: "error-toast",
        });
      });
    });
}

function validarUltimaEtapa() {
  const camposValidos = validarCamposEtapa(etapaAtual);
  if (camposValidos.length>0) {   
      return;
  }
  enviarRelatorio();
}

const showMessage = (options) => {
  Toastify({
    duration: 5_000,
    close: true,
    gravity: "top",
    position: "right",
    stopOnFocus: true,
    ...options
  }).showToast();
};
