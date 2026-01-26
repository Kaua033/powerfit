package PowerFit.API.TREINOS;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("TREINOS")
public class TreinosController {
private  TreinosService treinosService;

    public TreinosController(TreinosService treinosService) {
        this.treinosService = treinosService;
    }
@GetMapping("lista")
    public ResponseEntity<?>LISTA() {
        List<TreinosDTO> treinosDTOS = treinosService.listar();
    return ResponseEntity.ok(treinosDTOS);
    }



@GetMapping("listarID/{ID}")
    public  ResponseEntity<?> ID(@PathVariable Long ID){
      TreinosDTO  treinosDTO = treinosService.LISTARID(ID);
       if (treinosDTO != null){
           treinosService.LISTARID(ID);
           return  ResponseEntity.ok("treino encontrado" + treinosDTO.getNome());
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao encontrado");
    }



@DeleteMapping("DELETAR/{ID}")
public ResponseEntity<String> deletar(@PathVariable Long ID) {

        if (treinosService.LISTARID(ID) != null){
        treinosService.DELETAR(ID);
        return ResponseEntity.ok("Aluno Deletado com sucesso" + ID);
    }
    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("oi");
    }


@PostMapping("CRIAR")
public ResponseEntity <String> criar(@RequestBody TreinosDTO CRIAR){
    Optional<TreinosDTO>  treinosDTO = Optional.ofNullable(treinosService.criar(CRIAR));
return  ResponseEntity.ok("Alunos criado ");
    }


@PutMapping("ATUALIZAR")
public ResponseEntity<String> ATUALIZAR(@PathVariable Long ID, @RequestBody TreinosDTO treinosModelVR){
        TreinosDTO treinosDTO = treinosService.ATUALIZAR(ID,treinosModelVR);
        return ResponseEntity.ok("Aluno Atualizado");
}
}
