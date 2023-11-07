package com.akira.apihemomar.controllers;


import com.akira.apihemomar.dto.response.StatusRespDto;
import com.akira.apihemomar.services.StatusDoacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusDoacaoController {
    private  final StatusDoacaoService  statusDoacaoService;
    public StatusDoacaoController(StatusDoacaoService statusDoacaoService) {
        this.statusDoacaoService = statusDoacaoService;
    }
    @GetMapping
    public ResponseEntity<List<StatusRespDto>> buscarTodosStatus(){
        return ResponseEntity.status(HttpStatus.OK).body(statusDoacaoService.buscarTodosStatus());
    }
}
