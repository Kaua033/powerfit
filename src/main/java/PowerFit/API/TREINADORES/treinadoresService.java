package PowerFit.API.TREINADORES;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class treinadoresService {


    private TreinadoresRepository treinadoresRepository;

    public treinadoresService(TreinadoresRepository treinadoresRepository) {
        this.treinadoresRepository = treinadoresRepository;
    }

    public List<TreinadoresModel> listar(){
        return treinadoresRepository.findAll();
}

}
