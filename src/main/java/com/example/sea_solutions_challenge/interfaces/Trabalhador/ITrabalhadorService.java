package com.example.sea_solutions_challenge.interfaces.Trabalhador;

import com.example.sea_solutions_challenge.dto.Trabalhador.CreateTrabalhadorDTO;
import com.example.sea_solutions_challenge.model.Setor;

public interface ITrabalhadorService {

    Setor CreateTrabalhador (CreateTrabalhadorDTO createTrabalhadorDTO);
}
