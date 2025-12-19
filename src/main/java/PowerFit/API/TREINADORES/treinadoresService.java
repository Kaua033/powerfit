package PowerFit.API.TREINADORES;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class treinadoresService {


    private TreinadoresRepository treinadoresRepository;

    public treinadoresService(TreinadoresRepository treinadoresRepository) {
        this.treinadoresRepository = treinadoresRepository;
    }

    public List<TreinadoresModel> listar(){
        return treinadoresRepository.findAll();
}


 public TreinadoresModel listarID(Long ID){
     Optional<TreinadoresModel> treinadoresModel = treinadoresRepository.findById(ID);
     return treinadoresModel.orElse(null);
 }

 public void DELETAR(Long ID){
        treinadoresRepository.deleteById(ID);
 }

public TreinadoresModel CRiAR( TreinadoresModel CRIARMODEL){
        return treinadoresRepository.save(CRIARMODEL);
}


public  TreinadoresModel ATUALIZAR(Long ID,TreinadoresModel ATUALIZARVC){
        // treinadoresRepository.save(Long ID, TreinadoresModel ATUALIZARVC);
    if (treinadoresRepository.existsById(ID)) {
        ATUALIZARVC.setID(ID);
    return treinadoresRepository.save(ATUALIZARVC);
    }
return  null;
    }
}
