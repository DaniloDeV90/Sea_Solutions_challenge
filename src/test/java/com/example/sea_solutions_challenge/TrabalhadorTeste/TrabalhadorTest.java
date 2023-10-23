package TrabalhadorTeste;

import com.example.sea_solutions_challenge.dto.Trabalhador.CreateTrabalhadorDTO;
import com.example.sea_solutions_challenge.interfaces.Trabalhador.ITrabalhadorService;
import com.example.sea_solutions_challenge.repositories.Cargo.CargoRepositories;
import com.example.sea_solutions_challenge.repositories.Setor.SetorRepositories;
import com.example.sea_solutions_challenge.repositories.Trablhador.TrabalhadorRepositories;
import com.example.sea_solutions_challenge.services.Trabalhador.TrabalhadorService;
import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;


public class TrabalhadorTest {

    final ITrabalhadorService    TrabalhadorService ;

    public TrabalhadorTest(ITrabalhadorService trabalhadorService) {
        TrabalhadorService = trabalhadorService;
    }

    @Test
    public  void CreateUserTrabalhadorTest ()   {


        CreateTrabalhadorDTO createTrabalhadorDTO = new CreateTrabalhadorDTO();

        createTrabalhadorDTO.setCargo("123");
        createTrabalhadorDTO.setCpf("123");
        createTrabalhadorDTO.setNome("john doe");
        createTrabalhadorDTO.setNomeSetor("setor 2");

        TrabalhadorService.CreateTrabalhador(createTrabalhadorDTO);






    }

}
