package com.example.sea_solutions_challenge.services.Cargo;

import com.example.sea_solutions_challenge.Errors.MeuErro;
import com.example.sea_solutions_challenge.interfaces.Cargo.ICargoService;
import com.example.sea_solutions_challenge.model.Cargo;
import com.example.sea_solutions_challenge.model.Setor;
import com.example.sea_solutions_challenge.repositories.Cargo.CargoRepositories;
import com.example.sea_solutions_challenge.repositories.Setor.SetorRepositories;
import org.springframework.http.HttpStatus;
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
if (setor == null) throw  new MeuErro ("Este  setor não existe!", HttpStatus.CONFLICT );
        Cargo cargoExiste = setor.getCargos().stream().filter(cargos -> cargos.getCargo().equals(NameCargo)).findFirst().orElse(null);

        if (cargoExiste != null) throw  new MeuErro ("Este cargo ja existe nesse setor!", HttpStatus.CONFLICT);

        Cargo cargo = new Cargo();
        cargo.setCargo(NameCargo);
        cargo.setSetor(setor);

        cargoRepositories.save(cargo);
      setor.getCargos().add(cargo);
     return setorRepositories.save(setor);


    }

    public Setor EditCargo (String NomeSetor,String cargoNome,  String cargoEditado) {
        Setor setor =  setorRepositories.findByNomeSetor(NomeSetor);
        if (setor == null) throw  new MeuErro( "Este Setor não existe!!", HttpStatus.CONFLICT);

      Cargo cargo =  setor.getCargos().stream().filter(cargos ->  cargos.getCargo().equals(cargoNome))
              .findFirst()
              .orElse(null);

      if (cargo == null)  throw  new MeuErro( "Este Cargo não existe!!", HttpStatus.CONFLICT);
        cargo.setCargo(cargoEditado);


      cargoRepositories.save(cargo);
        return setorRepositories.save(setor);
    }


    public  void DeleteCargo (String setorNome, String cargoNome) {

       Setor setor =  setorRepositories.findByNomeSetor(setorNome);

        if (setor == null)  throw  new MeuErro( "Este Setor não existe!!", HttpStatus.CONFLICT);

        Cargo cargo =  setor.getCargos().stream().filter(cargos ->  cargos.getCargo().equals(cargoNome))
                .findFirst()
                .orElse(null);

        if (cargo == null)  throw  new MeuErro( "Este Cargo não existe!!", HttpStatus.CONFLICT);



        setor.getCargos().remove(cargo);
        setorRepositories.save(setor);
         cargoRepositories.delete( cargo);


    }
}
