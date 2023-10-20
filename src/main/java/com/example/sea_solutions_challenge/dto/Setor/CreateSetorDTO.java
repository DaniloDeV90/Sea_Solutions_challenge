package com.example.sea_solutions_challenge.dto.Setor;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CreateSetorDTO {

    @NotBlank
    @Size(max = 255)
 private  String nomeSetor;

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
}
