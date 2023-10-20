package com.example.sea_solutions_challenge.dto.Setor;

import javax.validation.constraints.NotBlank;

public class FindBySetorDTO {

    @NotBlank
    private String nomeSetor;

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
}
