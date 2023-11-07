async function populaHoras(){
    const diaSelect = document.getElementById("dia");
    if(diaSelect.value){
        const horarios = await buscarHorarios(diaSelect.value);
        var select = document.getElementById("hora");
        horarios.forEach(function (hora) {
          var option = document.createElement("option");
          option.value = hora.hora;
          option.textContent = hora.hora;
          select.appendChild(option);
        });
    }

}