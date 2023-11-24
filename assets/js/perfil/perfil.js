let preencherPerfil = function(){
  const formEl = document.getElementById('formPerfil');
  const userData = JSON.parse(localStorage.getItem('userData')); 
    Array.from(formEl.elements).forEach(element => {   
        element.value = userData[element.id];
        element.style.backgroundColor = 'white';
        element.style.border = '1px solid gray';

    });     
}
preencherPerfil();