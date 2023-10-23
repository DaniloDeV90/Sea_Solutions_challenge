package com.example.sea_solutions_challenge.Errors;

import org.springframework.http.HttpStatus;

public class MeuErro extends  RuntimeException {
    private HttpStatus status;
    public  MeuErro (String message, HttpStatus status) {
        super( message);
        this.status = status;

    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
