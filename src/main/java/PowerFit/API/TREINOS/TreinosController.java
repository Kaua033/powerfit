package PowerFit.API.TREINOS;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TREINOS")
public class TreinosController {
private  TreinosService treinosService;

    public TreinosController(TreinosService treinosService) {
        this.treinosService = treinosService;
    }
@GetMapping("lista")
    public List<TreinosModel>LISTA(){
        return treinosService.listar();
}
@GetMapping("listarID/{ID}")
    public TreinosModel ID(@PathVariable Long ID){
        return treinosService.LISTARID(ID);
}

@DeleteMapping("DELETAR")
public void deletar(@PathVariable Long ID) {
        treinosService.DELETAR(ID);
}

@PostMapping("CRIAR")
public  TreinosModel criar(@RequestBody TreinosModel CRIAR){
        return treinosService.criar(CRIAR);
}

@PutMapping("ATUALIZAR")
public TreinosModel ATUALIZAR(@PathVariable Long ID, @RequestBody TreinosModel treinosModelVR){
        return treinosService.ATUALIZAR(ID,treinosModelVR);
}
}
