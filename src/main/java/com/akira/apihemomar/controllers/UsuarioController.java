package com.akira.apihemomar.controllers;


import com.akira.apihemomar.dto.request.UsuarioReqDto;
import com.akira.apihemomar.dto.response.UsuarioRespDto;
import com.akira.apihemomar.models.Usuario;
import com.akira.apihemomar.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService   usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioRespDto> cadastrarUsuario(@RequestBody @Valid UsuarioReqDto usuarioReqDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastraUsuario(usuarioReqDto));
    }
    @GetMapping
    public ResponseEntity<List<UsuarioRespDto>> findall(){
        return ResponseEntity.ok(usuarioService.findAll());
    }
}
