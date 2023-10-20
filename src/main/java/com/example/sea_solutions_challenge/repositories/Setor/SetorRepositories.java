package com.example.sea_solutions_challenge.repositories.Setor;

import com.example.sea_solutions_challenge.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SetorRepositories  extends JpaRepository<Setor, UUID> {

    Setor findByNomeSetor (String nome);

}
