package com.example.sea_solutions_challenge.Controllers;



import com.example.sea_solutions_challenge.dto.Cargo.CreateCargoDTO;
import com.example.sea_solutions_challenge.interfaces.Cargo.ICargoService;
import com.example.sea_solutions_challenge.model.Cargo;
import com.example.sea_solutions_challenge.model.Setor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/cargo")
public class CargoController {

   final  ICargoService iCargoService;

    public CargoController(ICargoService iCargoService) {
        this.iCargoService = iCargoService;
    }

    @PostMapping
    public ResponseEntity <Setor> CreateCargo (@RequestBody @Valid CreateCargoDTO createCargoDTO) {



        return ResponseEntity.status(HttpStatus.CREATED).body(this.iCargoService.CreateCargo(createCargoDTO.getNomeSetor(), createCargoDTO.getNomeCargo())) ;
    }

}
