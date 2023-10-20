package com.example.sea_solutions_challenge.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity

public class Cargo  implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;

    @Column (unique = true)
    private  String NomeCargo;


   @OneToOne (mappedBy = "cargo")
    private  Trabalhador trabalhador;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getNomeCargo() {
        return NomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        NomeCargo = nomeCargo;
    }

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }
}
