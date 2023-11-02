async function alterarStatus() {  
$('#modalAlterar').modal("hide");
const id=localStorage.getItem('modalAlterar'); 
const param=localStorage.getItem('buscaDash'); 
if(id !== undefined){

  const selectElement = document.getElementById("status");  
  const selectedValue = selectElement.value;
  const doacao=localStorage.getItem('modalAlterar'); 
  await envioAlterarStatus(doacao,selectedValue); 
  const body = JSON.parse(param);
  const parametros = Object.keys(body)
  .map(key => `${key}=${body[key]}`)
  .join('&');    
  popularTabela(await filtroDash(parametros)); 
  
}


}