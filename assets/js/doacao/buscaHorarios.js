async function buscarHorarios(data){  
  console.log(data)
    const filtro= await fetch(`http://26.49.188.195:8080/horarios?data=${data}`, {
         method: 'GET',    
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
 
     return await filtro.json();
 
 }
 