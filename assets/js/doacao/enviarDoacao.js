async function enviarDoacao(body){
  await fetch(`http://26.49.188.195:8080/doacoes`, {
  method: 'POST',  
  body: JSON.stringify(body),  
  headers: {
    "Content-Type": "application/json"
  }
})      
  .catch((e) => {
    e.cause.then((data) => {      
      alert(data)  
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

 

