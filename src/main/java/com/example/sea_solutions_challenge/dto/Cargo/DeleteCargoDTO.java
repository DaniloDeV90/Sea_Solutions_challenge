package com.example.sea_solutions_challenge.dto.Cargo;

import javax.validation.constraints.NotBlank;

public class DeleteCargoDTO {

    @NotBlank (message = "nome do setor não deve está nulo!")
    private String setorNome;

    @NotBlank (message = "nome do cargo não deve está nulo!")
    private  String nomeCargo;

    public String getSetorNome() {
        return setorNome;
    }

    public void setSetorNome(String setorNome) {
        this.setorNome = setorNome;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }
}
