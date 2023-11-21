async function solicitarNovaSenha(){
  validarSenhas();
  const formEl = document.getElementById('resetSenhaForm');   
  const body = {};
  Array.from(formEl.elements).forEach(element => {
    if (element?.id && element?.value) {
      body[element.id] = element.value;
    }
  });  
  await fetch('http://localhost:8080/usuarios/atualizar/senha', {
    method: 'PUT',
    body: JSON.stringify(body),
    headers: {
      "Content-Type": "application/json"
    }
  })
    .then((response) => {        
      if (!response.ok) {         
       throw new Error('Erro', { cause: response.json() });
      }      
      showMessage({
        text: 'Senha Alterada com Sucesso',
        className: "success-toast",
      });

    })
    .then(data => {           
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

function validarSenhas() {
  var novaSenha = document.getElementById('senha').value;
  var confirmarSenha = document.getElementById('confirmaSenha').value;

  if (novaSenha !== confirmarSenha) {
    showMessage({
      text: 'Senhas não coincidem',
      className: "error-toast",
    });   
  }
 
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