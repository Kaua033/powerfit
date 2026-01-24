package PowerFit.API.TREINADORES;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class treinadoresService {


    private TreinadoresRepository treinadoresRepository;

    public treinadoresService(TreinadoresRepository treinadoresRepository) {
        this.treinadoresRepository = treinadoresRepository;
    }

    public List<TreinadoresDTO> listar(){
        List<TreinadoresModel> treinadoresModels = treinadoresRepository.findAll();
    return treinadoresModels.stream().map(TreinadoresMapper :: map).collect(Collectors.toList());
    }


 public TreinadoresDTO  listarID(Long ID){
   Optional<TreinadoresModel> treinadoresModel =treinadoresRepository.findById(ID);
    return treinadoresModel.map(TreinadoresMapper ::map).orElse(null);
    }



 public void DELETAR(Long ID){
        treinadoresRepository.deleteById(ID);
 }

public TreinadoresDTO CRIAR( TreinadoresDTO CRIARDTO){
TreinadoresModel treinadoresModel = TreinadoresMapper.map(CRIARDTO);
       treinadoresModel = treinadoresRepository.save(treinadoresModel);
        return TreinadoresMapper.map(treinadoresModel);
}


public  TreinadoresDTO ATUALIZAR(Long ID,TreinadoresDTO ATUALIZALUNO){
        // treinadoresRepository.save(Long ID, TreinadoresModel ATUALIZARVC);
    TreinadoresModel treinadoresAtualizado = (TreinadoresModel) treinadoresRepository.findAllById(Collections.singleton(ID));
    if (treinadoresAtualizado != null) {
       TreinadoresModel treinadoresModelAT = TreinadoresMapper.map(ATUALIZALUNO);
       treinadoresModelAT.setID(ID);
    TreinadoresModel ATUALIZADO = treinadoresRepository.save(treinadoresModelAT);
    }
return  null;
    }
}
