package PowerFit.API.TREINADORES;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("TREINADORES")
public class TreinadoresController {

    private treinadoresService treinadoresService;

    public TreinadoresController(treinadoresService treinadoresService) {
        this.treinadoresService = treinadoresService;
    }

    //localhost:8080/TREINADORES/listarT
    @GetMapping("listarT")
    public ResponseEntity<String> listarT() {
        List<TreinadoresDTO> treinadoresDTOS = treinadoresService.listar();
        return ResponseEntity.ok(treinadoresDTOS.toString());
    }
    //localhost:8080/TREINADORES/ID/?
    @GetMapping("ID/{ID}")
    public ResponseEntity<?> listarID(@PathVariable Long ID) {
       TreinadoresDTO treinadoresDTO = treinadoresService.listarID(ID);

        if (treinadoresService.listar() != null) {
            return ResponseEntity.ok("O aluno "+ treinadoresDTO.getNome()  + "Foi encontrado R");
        }
        return null;
    }
    //localhost:8080/TREINADORES/DELETAR/ID
    @DeleteMapping("DELETAR/{ID}")
    public ResponseEntity<?>Deletar(@PathVariable Long ID){
      if (treinadoresService.listarID(ID) != null){
          treinadoresService.listarID(ID);
     return  ResponseEntity.ok("Aluno deletado" + ID + "com suscesso");
      }return null;
    }
    //localhost:8080/TREINADORES/CRIAR
   @PostMapping("CRIAR")
   public ResponseEntity<?> Post( @RequestBody TreinadoresDTO CRIAR){
        TreinadoresDTO treinadoresDTO =treinadoresService.CRIAR(CRIAR);
   return ResponseEntity.ok("O aluno foi Criado com suscesso");
    }
    //localhost:8080/TREINADORES/ATUALIZAR

    @PutMapping("ATUALIZAR")
    public  ResponseEntity<?> ATUALIZAR(@PathVariable Long ID, @RequestBody TreinadoresDTO TREINADORESVCT){

    TreinadoresDTO treinadoresDTO = treinadoresService.ATUALIZAR(ID,TREINADORESVCT);
    if (treinadoresService.listarID(ID) != null){
        return  ResponseEntity.ok("Aluno atualizado");
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno Nâo encontrado");
    }




}