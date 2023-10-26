package com.example.sea_solutions_challenge;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition (info = @Info (title = "Sea_SolutionAPI", version = "1", description = "Api de cadastro de trabalhadores"))
public class SeaSolutionsChallengeApplication {

    public String PORT = System.getenv( "PORT");
    public static void main(String[] args) {
        SpringApplication.run(SeaSolutionsChallengeApplication.class, args);
    }

}
