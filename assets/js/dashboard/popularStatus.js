async function popularStatus() {
    try {
      const response = await fetch(`http://localhost:8080/status`, {
        method: 'GET',
        headers: {
          "Content-Type": "application/json"
        }
      });
  
      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.mensagem || errorData.message || errorData.titulo || 'Sistema indisponível no momento. Por favor, tente mais tarde.');
      }
  
      const filtro = await response.json();
      return filtro;
    } catch (error) {
      showMessage({
        text: error.message,
        className: "error-toast",
      });
      return [];
    }
  }
  
  (async () => {
    try {
      const todosStatus = await popularStatus();
  
      var select = document.getElementById("status");
      todosStatus.forEach(function (status) {
        var option = document.createElement("option");
        option.value = status.id;
        option.textContent = status.descricao;
        select.appendChild(option);
      });
    } catch (error) {
      console.error("Erro ao popular os status:", error);
    }
  })();
  