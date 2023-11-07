async function popularHistorico(){
    const userData = JSON.parse(localStorage.getItem('userData'));
    const userId = userData.id; 
    const dados= await buscarHistoricoUsuario(userId);       
    var tableBody = document.querySelector("#tabelaHistoricodoacoes tbody");
     tableBody.innerHTML = "";     
    
    dados.forEach(function (item) {      
          var row = tableBody.insertRow(-1);
          var dataCadastroCell = row.insertCell(0);
          var dataAgendadaCell = row.insertCell(1);
          var nomeCell = row.insertCell(2);
          var horaCell = row.insertCell(3);
          var diaCell = row.insertCell(4);
          var observacaoCell = row.insertCell(5);
          var statusCell = row.insertCell(6);
          var acoesCell = row.insertCell(7);    
          dataCadastroCell.textContent = item.dataCadastro;
          dataAgendadaCell.textContent = item.dataDoacao;
          nomeCell.textContent = item.usuarioNome;
          horaCell.textContent = item.hora;
          diaCell.textContent = item.diaSemana;
          observacaoCell.textContent = item.observacao;
          statusCell.textContent = item.status;        
    });
      
}