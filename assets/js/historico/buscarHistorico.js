async function buscarHistoricoUsuario(id){  
 
    const filtro= await fetch(`http://localhost:8080/dashboard/usuario/${id}`, {
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