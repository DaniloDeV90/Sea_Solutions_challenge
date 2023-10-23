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

    @Column
    private  String cargo;


   @OneToOne (mappedBy = "cargo" , cascade = CascadeType.ALL)
    private  Trabalhador trabalhador;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Trabalhador getTrabalhador() {
        return trabalhador;
    }

    public void setTrabalhador(Trabalhador trabalhador) {
        this.trabalhador = trabalhador;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
