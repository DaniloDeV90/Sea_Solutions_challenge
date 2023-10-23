package com.example.sea_solutions_challenge.Controllers;


import com.example.sea_solutions_challenge.Errors.MeuErro;
import com.example.sea_solutions_challenge.Errors.MeuErroAdvice;
import com.example.sea_solutions_challenge.dto.Setor.CreateSetorDTO;
import com.example.sea_solutions_challenge.dto.Trabalhador.CreateTrabalhadorDTO;
import com.example.sea_solutions_challenge.interfaces.Setor.ISetorService;
import com.example.sea_solutions_challenge.interfaces.Trabalhador.ITrabalhadorService;
import com.example.sea_solutions_challenge.model.Setor;
import com.example.sea_solutions_challenge.utils.VerificarFormatoCPF;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin (origins = "*" ,maxAge = 5600)
@RequestMapping("/trabalhador")
@Tag(name = "Trabalhador Controller")
public class TrabalhadorController {

   final   ITrabalhadorService iTrabalhadorService;

    public TrabalhadorController(ITrabalhadorService iTrabalhadorService) {
        this.iTrabalhadorService = iTrabalhadorService;
    }
    @Operation(summary = "Criar um trabalhador", method = "POST")
    @ApiResponse(responseCode =  "201", description = "trabalhador criado com sucesso!")
    @ApiResponse (responseCode =  "409", description = "Erros na criação  do trabalhador")
    @ApiResponse (responseCode =  "400", description = "Campos em branco!")
    @PostMapping
    public ResponseEntity <Setor> CreateTrabalhador (@RequestBody  @Valid   CreateTrabalhadorDTO createTrabalhadorDTO) {


    boolean verificarCpf = new VerificarFormatoCPF().execute(createTrabalhadorDTO.getCpf());

    if (!verificarCpf) throw new MeuErro("CPF INVÁLIDO!", HttpStatus.BAD_REQUEST);


    return ResponseEntity.status(HttpStatus.CREATED).body(iTrabalhadorService.CreateTrabalhador(createTrabalhadorDTO));


    }
}
