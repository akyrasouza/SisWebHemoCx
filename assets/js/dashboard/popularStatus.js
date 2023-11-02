const popularStatus=()=>     
       [
        {
            "id":1,
            "descricao":"EM ANALISE"
        },
        {
            "id":2,
            "descricao":"CONFIRMADO"
        },
        {
            "id":3,
            "descricao":"SEM VAGA"
        },
        {
            "id":4,
            "descricao":"AGUARDANDO"
        },
        {
            "id":5,
            "descricao":"NEGADO"
        },
        {
            "id":6,
            "descricao":"CONCLUIDO"
        }
       ]
    

  var select = document.getElementById("status");
  popularStatus().forEach(function (status) {    
  var option = document.createElement("option");
  option.value = status.id;
  option.textContent = status.descricao;
  select.appendChild(option);

}); 


