package PowerFit.API.TREINADORES;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@GetMapping("ID/{ID}")
    public TreinadoresModel listarID(@PathVariable Long ID){
 TreinadoresModel TID = treinadoresService.treinadoresModel(ID);
 if (treinadoresService.treinadoresModel(ID) != null){
     return treinadoresService.treinadoresModel(ID);
 }
 return null;
}

}