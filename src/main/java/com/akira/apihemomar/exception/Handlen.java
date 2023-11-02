package com.akira.apihemomar.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.util.stream.Collectors;

@ControllerAdvice
public class Handlen {
    @ExceptionHandler(ConflitoException.class)
    public ResponseEntity<DetalhesErro> handlenConflitoExceptionException(ConflitoException e) {
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("Conflito de informações já cadastradas!");
        erro.setMensagem(e.getMessage());
        erro.setStatus(409L);
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<DetalhesErro> handlenNotFoundExceptionException(NotFoundException e) {
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("Objeto não encontrado!");
        erro.setMensagem(e.getMessage());
        erro.setStatus(404L);
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<DetalhesErro> argumentoException(IllegalArgumentException ex){
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo(" Argumento não aceito !");
        erro.setStatus(500L);
        erro.setMensagem(ex.getMessage());
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<DetalhesErro> handleNotFoundException(BadRequestException exception){
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("Erro de ao informar dados!");
        erro.setStatus(400L);
        erro.setMensagem(exception.getMessage());
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<DetalhesErro> handleNullPointerException(UnexpectedTypeException e) {
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("Tipo inesperado");
        erro.setMensagem(e.getMessage());
        erro.setStatus(400L);
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DetalhesErro> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("Argumento Inválido!");
        String msm=ex.getFieldErrors()
                        .stream()
                                .map(campo->"campo "+campo.getField().concat(": "+ campo.getDefaultMessage())).collect(Collectors.joining( " ,"));
        erro.setMensagem(msm);
        erro.setStatus(400L);
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<DetalhesErro> handleMethodArgumentNotValidExddception(ConstraintViolationException ex){
        DetalhesErro erro = new DetalhesErro();
        erro.setTitulo("MethodArgumentNotValidException!");
        erro.setMensagem("Ocorreu um erro no sistema! Tente novamente mais tarde!");
        erro.setStatus(400L);
        erro.setTimestamp(System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}
