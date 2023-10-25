package com.example.sea_solutions_challenge.Controllers;


import com.example.sea_solutions_challenge.dto.Setor.CreateSetorDTO;
import com.example.sea_solutions_challenge.dto.Setor.DeleteSetorDTO;
import com.example.sea_solutions_challenge.dto.Setor.FindBySetorDTO;
import com.example.sea_solutions_challenge.dto.Setor.UpdateSetorDTO;
import com.example.sea_solutions_challenge.interfaces.Setor.ISetorService;
import com.example.sea_solutions_challenge.model.Setor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin (origins = "*" ,maxAge = 5600)
@RequestMapping("/setor")
@Tag(name = "Setor Controller")
public class SetorController {

   final ISetorService iSetorService;

    public SetorController(ISetorService iSetorService) {
        this.iSetorService = iSetorService;
    }
    @Operation(summary = "Criar um setor", method = "POST")
    @ApiResponse(responseCode =  "201", description = "Setor criado com sucesso!")
    @ApiResponse (responseCode =  "409", description = "Erros na criação  do setor")
    @ApiResponse (responseCode =  "400", description = "Campos em branco!")
    @PostMapping
    public ResponseEntity <Void> CreateSetor (@RequestBody  @Valid  CreateSetorDTO createSetorDTO) {


        Setor setor  = new Setor();




        setor.setNomeSetor(createSetorDTO.getNomeSetor());
        iSetorService.CreateSetor(setor);
        return ResponseEntity.status(HttpStatus.CREATED).build( );


    }
    @Operation(summary = "Visualizar Setores", method = "GET")
    @ApiResponse(responseCode =  "201", description = "Setor visualizado com sucesso!")
    @ApiResponse (responseCode =  "409", description = "Erros na visualização  do setor")
    @ApiResponse (responseCode =  "400", description = "Campos em branco!")
    @GetMapping ()
    public ResponseEntity <List <Setor>> FindAllSetor () {

        return  ResponseEntity.status(HttpStatus.ACCEPTED).body( iSetorService.FindAllSetor());

    }
    @Operation(summary = "Editar setores", method = "PUT")
    @ApiResponse(responseCode =  "201", description = "Setor editado com sucesso!")
    @ApiResponse (responseCode =  "409", description = "Erros em editar  o setor")
    @ApiResponse (responseCode =  "400", description = "Campos em branco!")
    @PutMapping
    public ResponseEntity <Setor> EditarSetor (@RequestBody  @Valid UpdateSetorDTO updateSetorDTO) {


     return ResponseEntity.status(HttpStatus.CREATED).body(  iSetorService.EditarSetor(updateSetorDTO.getNome(), updateSetorDTO.getNovoNome()));
    }

    @Operation(summary = "Deletar setores", method = "DELETE")
    @ApiResponse(responseCode =  "201", description = "Setor deletado com sucesso!")
    @ApiResponse (responseCode =  "409", description = "Erros em deletar  o setor")
    @ApiResponse (responseCode =  "400", description = "Campos em branco!")
    @DeleteMapping
    public ResponseEntity <Void> DeleteSetor (@RequestBody  @Valid DeleteSetorDTO deleteSetorDTO) {


        iSetorService.DeletSetor(deleteSetorDTO.getNomeSetor());

        return ResponseEntity.status(HttpStatus.CREATED).build( );
    }

}
