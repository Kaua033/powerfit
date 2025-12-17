package PowerFit.API.TREINOS;

import org.springframework.stereotype.Service;

@Service
public class TreinosService {

private  TreinosRepository treinosRepository;

    public TreinosService(TreinosRepository treinosRepository) {
        this.treinosRepository = treinosRepository;
    }
}
