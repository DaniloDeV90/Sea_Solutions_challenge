package com.example.sea_solutions_challenge.dto.Trabalhador;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateTrabalhadorDTO {




    @NotBlank (message = "nome não pode ser nulo!")
    @Size(max = 255)
    private  String nome;
    @NotBlank (message = "Cargo não pode ser nulo!")
    @Size (max = 255)
    private  String cargo;
    @NotBlank (message = "CPF não pode ser nulo!")
    private String cpf;
     @NotBlank (message = "Nome do setor não pode ser nulo!")
     private  String nomeSetor;

    public String getNomeSetor() {
        return nomeSetor;
    }
    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
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
