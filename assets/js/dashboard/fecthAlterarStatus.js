async function fetchAlterarStatus(doacao,status){

    await fetch(`http://26.49.188.195:8080/doacoes/${doacao}/status/${status}`, {
    method: 'PUT',    
    headers: {
      "Content-Type": "application/json"
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

   

