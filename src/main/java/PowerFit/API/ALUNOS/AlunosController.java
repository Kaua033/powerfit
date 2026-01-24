package PowerFit.API.ALUNOS;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> listarALunos(){
      List<AlunosDTO> alunosDTOS =alunosService.listar();
        if (alunosService.listar() != null){
            return ResponseEntity.ok(alunosDTOS.toString());
        }
        return null;
    }


@GetMapping("ID/{ID}")
    public ResponseEntity<?> alunosID(@PathVariable long ID){
       AlunosDTO  alunosDTO = alunosService.LISTARID(ID);
        if (alunosService.listar()!= null){
            return ResponseEntity.ok("Nosso  ALuno " + alunosDTO.getNome());
        }
return  ResponseEntity.notFound().build();
    }

@DeleteMapping("DELETAR/{ID}")
public ResponseEntity<String>  DELTAR(@PathVariable Long ID){
if (alunosService.LISTARID(ID) != null){
    alunosService.LISTARID(ID);
return ResponseEntity.ok("O aluno " + ID + "Foi deletado com sucesso");
}
return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O aluno " + ID + "Nâo fio encontrado");
}


@PostMapping("criarA")
public  ResponseEntity<String> criaçao(@RequestBody AlunosDTO alunosDTO){
    AlunosDTO alunosDTO1 = alunosService.CRIAR(alunosDTO);
return ResponseEntity.ok("O aluno " + alunosDTO1.getNome()  + "Foi criado com suscesso");
    }

@PutMapping("ATUALIZAR/")
public  ResponseEntity<?> ATUALIZAR(@RequestBody AlunosDTO  ALUNO, @PathVariable Long ID){
   AlunosDTO alunosDTO = alunosService.ATUALIZAR(ALUNO,ID);
if (alunosService.LISTARID(ID) != null){
    return  ResponseEntity.ok(ALUNO);
}
return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ALuno Nâo Atualizado");

    }
}
