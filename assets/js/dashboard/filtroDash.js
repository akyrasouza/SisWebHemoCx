async function filtroDash(parametros){  
 
   const filtro= await fetch(`http://26.49.188.195:8080/dashboard?${parametros}`, {
        method: 'GET',    
        headers: {
          "Content-Type": "application/json"
        }
      })  
      .then((response) => {        
        if (!response.ok) {         
         throw new Error('Erro', { cause: response.json() });
        }    
        return response;  
      })      
        .catch((e) => {
          e.cause.then((data) => {        
            showMessage({
              text: data?.mensagem || data?.message || data?.titulo || 'Sistema indisponível no momento. Por favor, tente mais tarde.',
              className: "error-toast",
            });
          });
    });    

    return await filtro.json();

}


