package PowerFit.API.TREINADORES;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("TREINADORES")
public class TreinadoresController {

private treinadoresService treinadoresService;

    public TreinadoresController(treinadoresService treinadoresService) {
        this.treinadoresService = treinadoresService;
    }



}
