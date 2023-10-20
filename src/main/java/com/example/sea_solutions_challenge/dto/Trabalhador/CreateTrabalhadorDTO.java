package com.example.sea_solutions_challenge.dto.Trabalhador;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateTrabalhadorDTO {




    @NotBlank
    @Size(max = 255)
    private  String nome;

@NotBlank
@Size (max = 255)
    private  String cargo;


@NotBlank

private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
