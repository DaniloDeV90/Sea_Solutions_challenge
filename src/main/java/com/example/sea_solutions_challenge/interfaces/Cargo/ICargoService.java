package com.example.sea_solutions_challenge.interfaces.Cargo;


import com.example.sea_solutions_challenge.model.Setor;

public interface ICargoService {

    Setor CreateCargo (String NomeSetor, String cargo);

    Setor EditCargo (String NomeSetor,String cargoNome,  String cargoEditado);

    void DeleteCargo (String setorNome, String cargoNome);
}
