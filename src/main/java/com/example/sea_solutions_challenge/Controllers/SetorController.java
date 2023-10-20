package com.example.sea_solutions_challenge.Controllers;


import com.example.sea_solutions_challenge.dto.Setor.CreateSetorDTO;
import com.example.sea_solutions_challenge.dto.Setor.FindBySetorDTO;
import com.example.sea_solutions_challenge.interfaces.Setor.ISetorService;
import com.example.sea_solutions_challenge.model.Setor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin (origins = "*" ,maxAge = 5600)
@RequestMapping("/setor")
public class SetorController {

   final ISetorService iSetorService;

    public SetorController(ISetorService iSetorService) {
        this.iSetorService = iSetorService;
    }

    @PostMapping
    public ResponseEntity <Void> CreateSetor (@RequestBody  @Valid  CreateSetorDTO createSetorDTO) {

        Setor setor  = new Setor();

        setor.setNomeSetor(createSetorDTO.getNomeSetor());
        iSetorService.CreateSetor(setor);
        return ResponseEntity.status(HttpStatus.CREATED).build( );


    }

    @PostMapping ("/findSetor")
    public ResponseEntity <Setor> FindBySetor (@RequestBody @Valid FindBySetorDTO findBySetorDTO) {

        return  ResponseEntity.status(HttpStatus.ACCEPTED).body( iSetorService.FindBySetor(findBySetorDTO.getNomeSetor()));

    }
}
