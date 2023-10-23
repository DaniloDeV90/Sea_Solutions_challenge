package com.example.sea_solutions_challenge.Errors;

import org.springframework.http.HttpStatus;

public class RespotaErro {
    private  String message;

    private HttpStatus status;

    public RespotaErro(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
