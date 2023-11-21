async function solicitarCodigo(){
  const email = document.getElementById('email').value;
await fetch('http://localhost:8080/usuarios/recuperar/senha/email/'+ email, {
    method: 'POST',
    headers: {
      "Content-Type": "application/json"
    }
  })
    .then((response) => {        
      if (!response.ok) {         
       throw new Error('Erro', { cause: response.json() });
      }      
      showMessage({
        text: 'Código enviado',
        className: "success-toast",
      });

    })
   
    .catch((e) => {
      e.cause.then((data) => {        
        showMessage({
          text: data?.mensagem || data?.message || data?.titulo || 'Sistema indisponível no momento. Por favor, tente mais tarde.',
          className: "error-toast",
        });
      });
    });

  mostrarCamposAdicionais()
}

function closeAlert() {
  $('#emailAlert').hide();
}

function mostrarCamposAdicionais() {
    $('.novaSenha').find('input').prop('required', true);
    $('.novaSenha').show();

    $('#emailAlert').show();
    setTimeout(function(){
      $('#emailAlert').hide();
  }, 5000);

}

