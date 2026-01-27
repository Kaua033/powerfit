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
           return  ResponseEntity.ok(treinosDTO);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao encontrado");
    }



@DeleteMapping("DELETAR/{ID}")
public ResponseEntity<?> deletar(@PathVariable Long ID) {
        if (treinosService.LISTARID(ID) != null){
        treinosService.DELETAR(ID);
        return ResponseEntity.ok("Aluno Deletado com sucesso" + ID);
    }
    return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("oi");
    }


@PostMapping("CRIAR")
public ResponseEntity <?> criar(@RequestBody TreinosDTO CRIAR){
    TreinosDTO  treinosDTO =treinosService.criar(CRIAR);
return  ResponseEntity.ok("Treino criado " + treinosDTO.getNome());
    }


@PutMapping("ATUALIZAR/{ID}")
public ResponseEntity<?> ATUALIZAR(@PathVariable Long ID, @RequestBody TreinosDTO treinosModelVR){
        TreinosDTO treinosDTO = treinosService.ATUALIZAR(ID,treinosModelVR);
        return ResponseEntity.ok("Treino Atualizado");
}
}
