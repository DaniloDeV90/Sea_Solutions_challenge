package com.example.sea_solutions_challenge.services.Cargo;

import com.example.sea_solutions_challenge.interfaces.Cargo.ICargoService;
import com.example.sea_solutions_challenge.model.Cargo;
import com.example.sea_solutions_challenge.model.Setor;
import com.example.sea_solutions_challenge.repositories.Cargo.CargoRepositories;
import com.example.sea_solutions_challenge.repositories.Setor.SetorRepositories;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CargoService  implements ICargoService {

    final CargoRepositories cargoRepositories;

    final SetorRepositories setorRepositories;

    public CargoService(CargoRepositories cargoRepositories, SetorRepositories setorRepositories) {
        this.cargoRepositories = cargoRepositories;
        this.setorRepositories = setorRepositories;
    }



    public  Setor CreateCargo (String NomeSetor, String NameCargo) {
        Setor setor =  setorRepositories.findByNomeSetor(NomeSetor);

        Cargo cargo = new Cargo();

        cargo.setNomeCargo(NameCargo);


         cargo.setSetor(setor);

         setor.getCargos().add(cargo);
         cargoRepositories.save(cargo);

        return setorRepositories.save(setor);


    }
}
