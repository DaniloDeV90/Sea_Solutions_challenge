package com.example.sea_solutions_challenge.Controllers;



import com.example.sea_solutions_challenge.dto.Cargo.CreateCargoDTO;
import com.example.sea_solutions_challenge.dto.Cargo.DeleteCargoDTO;
import com.example.sea_solutions_challenge.dto.Cargo.EditCargoDTO;
import com.example.sea_solutions_challenge.interfaces.Cargo.ICargoService;
import com.example.sea_solutions_challenge.model.Cargo;
import com.example.sea_solutions_challenge.model.Setor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin (origins = "*")
@RequestMapping("/cargo")
@Tag(name = "Cargos controller")
public class CargoController {

   final  ICargoService iCargoService;

    public CargoController(ICargoService iCargoService) {
        this.iCargoService = iCargoService;
    }


    @Operation (summary = "Cria um cargo", method = "POST")
    @ApiResponse (responseCode =  "201", description = "Cargo criado com sucesso!")
    @ApiResponse (responseCode =  "409", description = "Erros na criação do cargo")
    @ApiResponse (responseCode =  "400", description = "Campos em branco!")
    @PostMapping
    public ResponseEntity <Setor> CreateCargo (@RequestBody @Valid CreateCargoDTO createCargoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.iCargoService.CreateCargo(createCargoDTO.getNomeSetor(), createCargoDTO.getNomeCargo())) ;
    }
    @Operation (summary = "Edita um cargo", method = "PUT")
    @ApiResponse (responseCode =  "201", description = "Cargo editado com sucesso!")
    @ApiResponse (responseCode =  "409", description = "Erros na edição do cargo")
    @PutMapping
    public ResponseEntity <Setor> EditCargo (@RequestBody @Valid EditCargoDTO editCargoDTO) {

        return ResponseEntity.status(HttpStatus.OK).body(iCargoService.EditCargo(editCargoDTO.getNomeSetor(),editCargoDTO.getNomeCargo(),editCargoDTO.getNovoNomeCargo()));
    }
    @Operation (summary = "Excluir um cargo", method = "DELETE")
    @ApiResponse (responseCode =  "201", description = "Cargo excluído com sucesso!")
    @ApiResponse (responseCode =  "409", description = "Erros na exclusão do cargo")
    @ApiResponse (responseCode =  "400", description = "Campos em branco!")

    @DeleteMapping
    public ResponseEntity <Void> DeleteCargo (@RequestBody @Valid DeleteCargoDTO deleteCargoDTO) {

        iCargoService.DeleteCargo(deleteCargoDTO.getSetorNome(), deleteCargoDTO.getNomeCargo());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
