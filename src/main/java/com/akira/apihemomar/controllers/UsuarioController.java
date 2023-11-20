package com.akira.apihemomar.controllers;


import com.akira.apihemomar.dto.request.AtualizarSenhaReqDto;
import com.akira.apihemomar.dto.request.LoginReqDto;
import com.akira.apihemomar.dto.request.UsuarioReqDto;
import com.akira.apihemomar.dto.response.LoginUsuarioRespDto;
import com.akira.apihemomar.dto.response.UsuarioRespDto;
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

    @PostMapping("/login")
    public  ResponseEntity<LoginUsuarioRespDto> loginUsuario(@RequestBody LoginReqDto loginReqDto){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.loginUsuario(loginReqDto));
    }

    @PostMapping
    public ResponseEntity<UsuarioRespDto> cadastrarUsuario(@RequestBody @Valid UsuarioReqDto usuarioReqDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastraUsuario(usuarioReqDto));
    }
    @GetMapping
    public ResponseEntity<List<UsuarioRespDto>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }
    @PostMapping("/recuperar/senha/email/{email}")
    public  ResponseEntity<Void> recuperarSenhaUsuario(@PathVariable("email") String email){
        usuarioService.recuperarSenhaUsuario(email);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PutMapping("/atualizar/senha")
    public  ResponseEntity<Void> atualizarSenhaUsuario(@RequestBody @Valid AtualizarSenhaReqDto atualizarSenhaReqDto){
        usuarioService.atualizarSenhaUsuario(atualizarSenhaReqDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
