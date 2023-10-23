package com.example.sea_solutions_challenge.services.Trabalhador;

import com.example.sea_solutions_challenge.Errors.MeuErro;
import com.example.sea_solutions_challenge.dto.Trabalhador.CreateTrabalhadorDTO;
import com.example.sea_solutions_challenge.interfaces.Trabalhador.ITrabalhadorService;
import com.example.sea_solutions_challenge.model.Cargo;
import com.example.sea_solutions_challenge.model.Setor;
import com.example.sea_solutions_challenge.model.Trabalhador;
import com.example.sea_solutions_challenge.repositories.Cargo.CargoRepositories;
import com.example.sea_solutions_challenge.repositories.Setor.SetorRepositories;
import com.example.sea_solutions_challenge.repositories.Trablhador.TrabalhadorRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class TrabalhadorService  implements ITrabalhadorService {

    final TrabalhadorRepositories trabalhadorRepositories;

    final CargoRepositories cargoRepositories;
    final SetorRepositories setorRepositories;

    public TrabalhadorService(TrabalhadorRepositories trabalhadorRepositories, CargoRepositories cargoRepositories, SetorRepositories setorRepositories) {
        this.trabalhadorRepositories = trabalhadorRepositories;
        this.cargoRepositories = cargoRepositories;
        this.setorRepositories = setorRepositories;
    }


    public Setor CreateTrabalhador(CreateTrabalhadorDTO createTrabalhadorDTO) {




            Trabalhador trabalhador = new Trabalhador();


            Cargo cargo = cargoRepositories.findByCargo(createTrabalhadorDTO.getCargo());
            if (cargo == null) throw  new MeuErro("Esse cargo não existe!",HttpStatus.BAD_REQUEST );
            cargo.setCargo(createTrabalhadorDTO.getCargo());
            Setor setor = setorRepositories.findByNomeSetor(createTrabalhadorDTO.getNomeSetor());
            if (setor == null) throw  new MeuErro("Esse setor não existe!", HttpStatus.BAD_REQUEST);
            Trabalhador cpfExiste =  trabalhadorRepositories.findByCPF(createTrabalhadorDTO.getCpf());
            if (cpfExiste != null)  throw  new MeuErro("Este CPF Já está cadastrado!", HttpStatus.CONFLICT);
            if ( cargo.getTrabalhador() != null ) throw  new MeuErro("Este  Cargo Já tem um trabalhador!", HttpStatus.CONFLICT);
            List <Cargo> cargo1 =  setor.getCargos().stream().filter(filter -> { return filter.getCargo().equals( createTrabalhadorDTO.getCargo());  }).collect(Collectors.toList());
            if (cargo1.stream().count() == 0)  throw  new MeuErro("Esse setor não possui esse cargo!", HttpStatus.CONFLICT);

             cargo.setSetor(setor);
            trabalhador.setCargo(cargo);
            trabalhador.setSetor(setor);
            trabalhador.setCPF(createTrabalhadorDTO.getCpf());
            trabalhador.setNome(createTrabalhadorDTO.getNome());
            cargo.setTrabalhador(trabalhador);
            setor.getTrabalhadores().add(trabalhador);

            trabalhadorRepositories.save(trabalhador);
            cargoRepositories.save(cargo);
            return setorRepositories.save(setor);





    }




}
