async function envioAlterarStatus(doacao,status){

    await fetch(`http://localhost:8080/doacoes/${doacao}/status/${status}`, {
    method: 'PUT',    
    headers: {
      "Content-Type": "application/json"
    }
  })   
  .then((response) => {        
    if (!response.ok) {         
     throw new Error('Erro', { cause: response.json() });
    }      
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


   

