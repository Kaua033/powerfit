package PowerFit.API.TREINOS;

import PowerFit.API.TREINADORES.TreinadoresModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinosService {

private  TreinosRepository treinosRepository;

    public TreinosService(TreinosRepository treinosRepository) {
        this.treinosRepository = treinosRepository;
    }

public  List<TreinosModel>listar(){
        return treinosRepository.findAll();
}
 public  TreinosModel  LISTARID(Long ID){
     Optional<TreinosModel>  VARIAVEL = treinosRepository.findById(ID);
     return VARIAVEL.orElse(null);
 }

    public  void  DELETAR(Long ID){
      treinosRepository.deleteById(ID);

    }


    public TreinosModel criar( TreinosModel  CRIARV){
        return treinosRepository.save(CRIARV);
    }


    public TreinosModel ATUALIZAR(Long ID,TreinosModel ATUALIZARVC){
        if (treinosRepository.existsById(ID)) {
            ATUALIZARVC.setID(ID);
            return treinosRepository.save(ATUALIZARVC);
        }
        return  null;
    }

}



