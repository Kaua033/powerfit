package PowerFit.API.TREINADORES;

import org.springframework.stereotype.Service;

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


 public TreinadoresModel treinadoresModel(Long ID){
     Optional<TreinadoresModel> treinadoresModel = treinadoresRepository.findById(ID);
     return treinadoresModel.orElse(null);
 }

}
