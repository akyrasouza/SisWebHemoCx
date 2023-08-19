package com.akira.apihemomar.controllers;


import com.akira.apihemomar.dto.request.EnderecoReqDto;
import com.akira.apihemomar.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<Void> cadastarEndereco(@RequestBody @Valid EnderecoReqDto enderecoReqDto, @PathVariable("usuarioId") Long usuarioId) {
        enderecoService.cadastrarEndereco(usuarioId,enderecoReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
