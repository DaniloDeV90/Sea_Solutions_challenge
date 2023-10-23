package com.example.sea_solutions_challenge.services.Setor;

import com.example.sea_solutions_challenge.Errors.MeuErro;
import com.example.sea_solutions_challenge.interfaces.Setor.ISetorService;

import com.example.sea_solutions_challenge.model.Setor;
import com.example.sea_solutions_challenge.repositories.Setor.SetorRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class SetorService  implements ISetorService {

   final SetorRepositories setorRepositories;


    public SetorService(SetorRepositories setorRepositories) {
        this.setorRepositories = setorRepositories;
    }

    public void  CreateSetor (Setor setor) {

        Setor setorExiste =  setorRepositories.findByNomeSetor(setor.getNomeSetor());
        if (setorExiste != null) throw  new MeuErro("Este setor já existe!", HttpStatus.CONFLICT);

        this.setorRepositories.save(setor);
    }

    public List <Setor> FindAllSetor () {

       return  setorRepositories.findAll();
    }

    public Setor EditarSetor (String nome,  String novoNome ) {

        Setor setor = setorRepositories.findByNomeSetor(nome);
        Setor setor1 = setorRepositories.findByNomeSetor(novoNome);
        if (setor1 != null) throw  new MeuErro("Este nome é invalido, pois já existe outro setor com esse nome!", HttpStatus.CONFLICT);

        if (setor == null) throw  new MeuErro("Este setor não existe", HttpStatus.CONFLICT);

        setor.setNomeSetor(novoNome);

       return  setorRepositories.save(setor);



    }

    public void DeletSetor (String nome) {
        Setor setor = setorRepositories.findByNomeSetor(nome);
        if (setor == null) throw  new MeuErro("Este setor não existe", HttpStatus.CONFLICT);

        setorRepositories.delete(setor);

    }

}
