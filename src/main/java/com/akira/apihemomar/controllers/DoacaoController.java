package com.akira.apihemomar.controllers;


import com.akira.apihemomar.dto.request.DoacaoReqDto;
import com.akira.apihemomar.services.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/doacoes")
public class DoacaoController {

    @Autowired
    private DoacaoService  doacaoService;


    @PostMapping
    public ResponseEntity<Void> cadastrarDoacao(@RequestBody @Valid DoacaoReqDto doacaoReqDto){
        doacaoService.cadastrarDoacao(doacaoReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{doacaoId}/status/{statusId}")
    public ResponseEntity<Void> atualizarDoacao(@PathVariable("doacaoId") Long doacaoId,
                                                @PathVariable("statusId") Long status){
        doacaoService.atualizarDoacao(doacaoId,status);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
