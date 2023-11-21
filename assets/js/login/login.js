async function login() {
  
    const formEl = document.getElementById('formLogin');
    
    const body = {};
    Array.from(formEl.elements).forEach(element => {
      if (element?.id && element?.value) {
        body[element.id] = element.value;
      }
    });     
  
    await fetch('http://localhost:8080/usuarios/login', {
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
        localStorage.setItem('userData', JSON.stringify(data)); 
        window.location.href = "./index.html";
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
      duration: 30_000,
      close: true,
      gravity: "top",
      position: "right",
      stopOnFocus: true,
      ...options
    }).showToast();
  };