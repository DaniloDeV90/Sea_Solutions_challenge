package com.example.sea_solutions_challenge.dto.Setor;

import javax.validation.constraints.NotBlank;

public class UpdateSetorDTO {
    @NotBlank (message = "nome  não deve está nulo!")
    private String nome;
    @NotBlank (message = "novo nome não deve está nulo")
    private  String novoNome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNovoNome() {
        return novoNome;
    }

    public void setNovoNome(String novoNome) {
        this.novoNome = novoNome;
    }
}
