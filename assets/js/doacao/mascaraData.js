$('#dataDoacao').datepicker({
<<<<<<< HEAD
  format: "dd-mm-yyyy"
});
=======
  closeText: "", 
  prevText: "Anterior", 
  nextText: "Próximo",
  currentText: "",    
  monthNamesShort: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
  "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
  dayNames: ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"],    
  dayNamesMin: ["D", "S", "T", "Q", "Q", "S", "S"],   
  dateFormat: "dd-mm-yy",
  firstDay: 0,
  isRTL: false,
  showMonthAfterYear: false,
  yearSuffix: "",
  changeMonth: true,
  changeYear: true,
  yearRange: "2023:2050",
  beforeShow: function(input, inst) {      
    inst.dpDiv.addClass("datepicker-container");
  }
});
>>>>>>> ea42e22f9f7c673b1b66b77072e74d749b2409ff
