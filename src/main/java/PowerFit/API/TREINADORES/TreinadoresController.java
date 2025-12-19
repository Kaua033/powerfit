package PowerFit.API.TREINADORES;

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
    public List<TreinadoresModel> listarT() {
        return treinadoresService.listar();

    }
    //localhost:8080/TREINADORES/ID/?
    @GetMapping("ID/{ID}")
    public TreinadoresModel listarID(@PathVariable Long ID) {
        TreinadoresModel TID = treinadoresService.listarID(ID);
        if (treinadoresService.listar() != null) {
            return treinadoresService.listarID(ID);
        }
        return null;
    }
    //localhost:8080/TREINADORES/DELETAR/ID
    @DeleteMapping("DELETAR/{ID}")
    public void Deletar(@PathVariable Long ID){
        treinadoresService.DELETAR(ID);
    }
    //localhost:8080/TREINADORES/CRIAR
   @PostMapping("CRIAR")
   public TreinadoresModel Post( @RequestBody TreinadoresModel CRIAR){
        return treinadoresService.CRiAR(CRIAR);
   }
    //localhost:8080/TREINADORES/ATUALIZAR
    @PutMapping("ATUALIZAR")
   public  TreinadoresModel ATUALIZAR(@PathVariable Long ID, @RequestBody TreinadoresModel TREINADORESVCT){
        return treinadoresService.ATUALIZAR(ID,TREINADORESVCT);
}





}