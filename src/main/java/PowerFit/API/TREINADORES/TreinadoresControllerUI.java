package PowerFit.API.TREINADORES;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tr/ui")

public class TreinadoresControllerUI {
private final treinadoresService treinadoresService;

    public TreinadoresControllerUI(treinadoresService treinadoresService) {
        this.treinadoresService = treinadoresService;
    }
//@GetMapping("listarT")
//public String listaT(Model model){
   // List<TreinadoresDTO> treinadoresDTOS = treinadoresService.listar();
 //model.addAttribute("TREINADORES" + treinadoresDTOS);
    //return "treinadores";
    //}
    @GetMapping("listarT")
    public String listaT(Model model){
        List<TreinadoresDTO> treinadoresDTOS = treinadoresService.listar();
        model.addAttribute("TREINADORES", treinadoresDTOS);
        return "TREINADORES";
    }
}
