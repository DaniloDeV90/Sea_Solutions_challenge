package com.example.sea_solutions_challenge.repositories.Cargo;

import com.example.sea_solutions_challenge.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CargoRepositories  extends JpaRepository <Cargo, UUID> {
}
