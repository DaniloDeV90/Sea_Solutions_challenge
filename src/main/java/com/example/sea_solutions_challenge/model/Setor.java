package com.example.sea_solutions_challenge.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity

public class Setor  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column (unique = true)
    private String nomeSetor;


    @OneToMany (mappedBy = "setor", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private  List <Trabalhador> trabalhadores = new ArrayList<>();




    @OneToMany  (mappedBy = "setor", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private  List <Cargo> cargos = new ArrayList<>();

    public List<Trabalhador> getTrabalhadores() {
        return trabalhadores;
    }

    public void setTrabalhadores(List<Trabalhador> trabalhadores) {
        this.trabalhadores = trabalhadores;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
}