package com.example.sea_solutions_challenge.interfaces.Setor;


import com.example.sea_solutions_challenge.model.Setor;

public interface ISetorService {

    void CreateSetor (Setor setor);

    Setor FindBySetor (String nomeSetor);
}
