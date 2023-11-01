function horarios(){   
       
       var   horario= [
            "",
            "07:30",
            "08:00",
            "08:30",
            "09:00",
            "09:30",
            "10:00",
            "10:30",
            "11:00",
            "13:30",
            "14:00",
            "14:30",
            "15:00",
            "15:30",
            "16:00",
            "07:30",
            "08:00",
            "08:30",
            "09:00",
            "09:30",
            "10:00",
            "10:30",
            "11:00",
            "13:30",
            "14:00",
            "14:30",
            "15:00",
            "15:30",
            "16:00",
            "07:40",
            "08:00",
            "08:40",
            "09:00",
            "09:40",
            "10:00",
            "10:40",
            "11:00",
            "14:40",
            "14:00",
            "14:40",
            "15:00",
            "15:40",
            "16:00",
            "07:50",
            "08:00",
            "08:50",
            "09:00",
            "09:50",
            "10:00",
            "10:50",
            "11:00"
          ]
   
var select = document.getElementById("hora");
horario.forEach(function (horario) {
  var option = document.createElement("option");
  option.value = horario;
  option.textContent = horario;
  select.appendChild(option);
});      
      
}
horarios();