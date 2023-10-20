package com.example.sea_solutions_challenge.Controllers;


import com.example.sea_solutions_challenge.dto.Setor.CreateSetorDTO;
import com.example.sea_solutions_challenge.dto.Trabalhador.CreateTrabalhadorDTO;
import com.example.sea_solutions_challenge.interfaces.Setor.ISetorService;
import com.example.sea_solutions_challenge.model.Setor;
import com.example.sea_solutions_challenge.utils.VerificarFormatoCPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin (origins = "*" ,maxAge = 5600)
@RequestMapping("/trabalhador")
public class TrabalhadorController {



    @PostMapping
    public ResponseEntity <Void> CreateSetor (@RequestBody  @Valid   CreateTrabalhadorDTO createTrabalhadorDTO) {


        boolean  verificarCpf =  new VerificarFormatoCPF ().execute(createTrabalhadorDTO.getCpf());

        if (!verificarCpf) System.out.println("Formato invalido!");


        return ResponseEntity.status(HttpStatus.CREATED).build( );


    }
}
