package com.example.sea_solutions_challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Trabalhador implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;


    @Column (unique = true, nullable = false)
    private  String CPF;

    @Column (nullable = false)
    private  String nome;


    @JsonIgnore
    @OneToOne
    @JoinColumn (name = "cargo_id",  nullable = false)
    private  Cargo  cargo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn (name = "setor_id",  nullable = false)
    private  Setor  setor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}

