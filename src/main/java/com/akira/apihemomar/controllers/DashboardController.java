package com.akira.apihemomar.controllers;


import com.akira.apihemomar.dto.response.DashboardRespDto;
import com.akira.apihemomar.enums.SIGLA;
import com.akira.apihemomar.services.DashboardService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }
    @GetMapping
    public ResponseEntity<List<DashboardRespDto>> buscarDoacoesAgendadas(
            @RequestParam(value = "dataInicio",required = false)@DateTimeFormat(pattern = "dd-MM-yyyy") Date  dataInicio,
            @RequestParam(value = "dataFim",required = false)@DateTimeFormat(pattern = "dd-MM-yyyy") Date  dataFim,
            @RequestParam(value = "nome",required = false)String nome,
            @RequestParam(value = "dia",required = false) SIGLA dia,
            @RequestParam(value = "hora",required = false)String  hora
            ) {
        return ResponseEntity.status(HttpStatus.OK).body(dashboardService.buscarDoacoesAgendadas(dataInicio,dataFim,nome,dia,hora));
    }
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<DashboardRespDto>> buscarDoacoesAgendadasUsuarioId(@PathVariable("usuarioId") Long usuarioId){
        return  ResponseEntity.status(HttpStatus.OK).body(dashboardService.buscarDoacoesAgendadas(usuarioId));
    }

}
