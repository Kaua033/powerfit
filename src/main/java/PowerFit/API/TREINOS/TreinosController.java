package PowerFit.API.TREINOS;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    public ResponseEntity<String>LISTA() {
        List<TreinosDTO> treinosDTOS = Collections.singletonList(treinosService.listar());
      if (treinosService.listar() != null){
          return ResponseEntity.ok("Aluno listado");
      }
    return null;
    }



@GetMapping("listarID/{ID}")
    public  ResponseEntity<?> ID(@PathVariable Long ID){
        TreinosDTO treinosDTO = treinosService.LISTARID(ID);
        return ResponseEntity.ok("Aluno Encontrado " + treinosDTO.getID());
    }



@DeleteMapping("DELETAR/{ID}")
public ResponseEntity<?> deletar(@PathVariable Long ID) {
    if (treinosService.LISTARID(ID) != null){
        treinosService.LISTARID(ID);
        return ResponseEntity.ok("Aluno Deletado com sucesso");
    }
    return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
