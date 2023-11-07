package com.akira.apihemomar.controllers;


import com.akira.apihemomar.dto.response.HorarioRespDto;
import com.akira.apihemomar.enums.SIGLA;
import com.akira.apihemomar.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/horarios")
public class HorarioController {
    @Autowired
    private HorarioService horarioService;

    @GetMapping
    public ResponseEntity<List<HorarioRespDto>> buscarHorariosDiasSemana(
            @RequestParam(value = "data", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date data) {
        return ResponseEntity.ok(horarioService.buscarHorarioPeloDia(data));
    }

    @GetMapping("/semana/{sigla}")
    public ResponseEntity<List<HorarioRespDto>> buscarHorariosPeloDiaSemana(@PathVariable("sigla") SIGLA sigla) {
        return ResponseEntity.status(HttpStatus.OK).body(horarioService.buscarHorariosPeloDiaSemana(sigla));
    }

}
