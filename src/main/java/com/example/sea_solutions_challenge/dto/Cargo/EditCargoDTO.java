package com.example.sea_solutions_challenge.dto.Cargo;

import javax.validation.constraints.NotBlank;

public class EditCargoDTO {
    @NotBlank (message = "nome do setor não deve está em branco")
    private String nomeSetor;

    @NotBlank (message = "nome do cargo não deve está em branco!!")
    private  String nomeCargo;

    @NotBlank (message = "novo nome do cargo nao deve está em branco!")
   private  String novoNomeCargo;

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getNovoNomeCargo() {
        return novoNomeCargo;
    }

    public void setNovoNomeCargo(String novoNomeCargo) {
        this.novoNomeCargo = novoNomeCargo;
    }
}
