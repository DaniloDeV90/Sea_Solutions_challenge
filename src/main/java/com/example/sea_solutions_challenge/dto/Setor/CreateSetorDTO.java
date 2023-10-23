package com.example.sea_solutions_challenge.dto.Setor;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class CreateSetorDTO {

    @NotBlank (message = "Nome do setor não pode ser nulo!")
    @Size(max = 255, message = "nome grande demais!")
 private  String nomeSetor;

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
}
