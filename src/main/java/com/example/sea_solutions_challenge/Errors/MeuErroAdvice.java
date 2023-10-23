package com.example.sea_solutions_challenge.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MeuErroAdvice {
    @ExceptionHandler (MeuErro.class)
    public ResponseEntity <RespotaErro> erroPersonalizado (MeuErro e) {
       RespotaErro erro = new RespotaErro(e.getMessage(), e.getStatus());
        return  ResponseEntity.status(erro.getStatus()).body(erro);
    }
}
