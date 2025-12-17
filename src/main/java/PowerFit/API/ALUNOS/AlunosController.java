package PowerFit.API.ALUNOS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ALUNOS")
public class AlunosController {
private AlunosService alunosService;

    public AlunosController(AlunosService alunosService) {
        this.alunosService = alunosService;
    }

    @GetMapping ("lista")
    public List<AlunosModel> listarALunos(){
    return alunosService.listar();
}

}
