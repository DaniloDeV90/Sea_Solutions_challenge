package com.example.sea_solutions_challenge.services.Trabalhador;

import com.example.sea_solutions_challenge.dto.Trabalhador.CreateTrabalhadorDTO;
import com.example.sea_solutions_challenge.interfaces.Trabalhador.ITrabalhadorService;
import com.example.sea_solutions_challenge.model.Setor;
import com.example.sea_solutions_challenge.repositories.Cargo.CargoRepositories;
import com.example.sea_solutions_challenge.repositories.Setor.SetorRepositories;
import com.example.sea_solutions_challenge.repositories.Trablhador.TrabalhadorRepositories;
import org.springframework.stereotype.Service;

@Service
public class TrabalhadorService  implements ITrabalhadorService {

    final TrabalhadorRepositories trabalhadorRepositories;

    final CargoRepositories cargoRepositories;
    final SetorRepositories setorRepositories;

    public TrabalhadorService(TrabalhadorRepositories trabalhadorRepositories, CargoRepositories cargoRepositories, SetorRepositories setorRepositories) {
        this.trabalhadorRepositories = trabalhadorRepositories;
        this.cargoRepositories = cargoRepositories;
        this.setorRepositories = setorRepositories;
    }



    public void  CreateTrabalhador (CreateTrabalhadorDTO createTrabalhadorDTO) {



    }
}
