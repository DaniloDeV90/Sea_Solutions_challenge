package com.example.sea_solutions_challenge.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ErroDeParametros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespotaErro> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {

        String mensagensDeErro = exception.getBindingResult().getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));


       RespotaErro respotaErro =   new RespotaErro(mensagensDeErro, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(respotaErro, HttpStatus.BAD_REQUEST);
    }
}