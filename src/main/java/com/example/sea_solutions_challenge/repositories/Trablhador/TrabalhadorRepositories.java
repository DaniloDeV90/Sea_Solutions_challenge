package com.example.sea_solutions_challenge.repositories.Trablhador;

import com.example.sea_solutions_challenge.model.Trabalhador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrabalhadorRepositories  extends JpaRepository <Trabalhador, UUID> {
}
