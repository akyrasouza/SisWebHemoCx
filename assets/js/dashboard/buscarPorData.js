async function buscarPorData() { 

  $('#modalBusca').modal('hide');
  const formEl = document.getElementById('formAgenda');    
  const body = {};
  Array.from(formEl.elements).forEach(element => {
    if (element?.id && element?.value) {
      body[element.id] = element.value;
    }
  });  
   
  localStorage.setItem('buscaDash', JSON.stringify(body));   
  const parametros = Object.keys(body)
  .map(key => `${key}=${body[key]}`)
  .join('&');
  popularTabela(await filtroDash(parametros)); 
    
 }