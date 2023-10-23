package com.example.sea_solutions_challenge.interfaces.Setor;


import com.example.sea_solutions_challenge.model.Setor;

import java.util.List;

public interface ISetorService {

    void CreateSetor (Setor setor);

    List<Setor> FindAllSetor ();
    Setor EditarSetor (String nome,  String novoNome );

    void DeletSetor (String nome);
}
