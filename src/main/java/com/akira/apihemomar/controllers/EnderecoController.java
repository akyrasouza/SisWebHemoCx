package com.akira.apihemomar.controllers;


import com.akira.apihemomar.dto.request.EnderecoReqDto;
import com.akira.apihemomar.dto.response.EnderecoRespDto;
import com.akira.apihemomar.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public  ResponseEntity<List<EnderecoRespDto>> finAll(){
        return ResponseEntity.ok(enderecoService.findAll());

    }
    @PostMapping
    public ResponseEntity<Void> cadastarEndereco(@RequestBody @Valid EnderecoReqDto enderecoReqDto) {
        enderecoService.cadastrarEndereco(enderecoReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
