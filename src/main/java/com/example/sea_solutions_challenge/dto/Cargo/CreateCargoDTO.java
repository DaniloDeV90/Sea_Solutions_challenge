package com.example.sea_solutions_challenge.dto.Cargo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateCargoDTO  {

    @NotBlank
    @Size (max = 255)
    private  String nomeCargo;

    @NotBlank
    @Size (max = 255)
    private  String nomeSetor;

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
}
