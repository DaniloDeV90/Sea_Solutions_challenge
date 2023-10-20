package com.example.sea_solutions_challenge.services.Setor;

import com.example.sea_solutions_challenge.interfaces.Setor.ISetorService;

import com.example.sea_solutions_challenge.model.Setor;
import com.example.sea_solutions_challenge.repositories.Setor.SetorRepositories;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class SetorService  implements ISetorService {

   final SetorRepositories setorRepositories;


    public SetorService(SetorRepositories setorRepositories) {
        this.setorRepositories = setorRepositories;
    }

    public void  CreateSetor (Setor setor) {

        this.setorRepositories.save(setor);
    }

    public Setor FindBySetor (String nomeSetor) {

       return  setorRepositories.findByNomeSetor(nomeSetor);
    }

}
