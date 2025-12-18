package PowerFit.API.ALUNOS;

import org.springframework.web.bind.annotation.*;

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


@GetMapping("ID/{ID}")
    public AlunosModel listarID(@PathVariable  long ID){
        AlunosModel V = alunosService.LISTARID(ID);
        if (alunosService.listar()!= null){
            return alunosService.LISTARID(ID);
        }
return null;
    }

@DeleteMapping("DELETAR/{ID}")
public void  DELTAR(@PathVariable Long ID){
 alunosService.deletar(ID);
}


@PostMapping("criarA")
public AlunosModel criaçao(@RequestBody AlunosModel alunosModel){
        return alunosService.CRIAR(alunosModel);
}

@PutMapping("ATUALIZAR/")
public  AlunosModel ATUALIZAR(@RequestBody AlunosModel ALUNO, @PathVariable Long ID){
        return alunosService.ATUALIZAR(ALUNO,ID);
}
}
