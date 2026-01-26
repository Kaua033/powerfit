package PowerFit.API.TREINOS;

import PowerFit.API.TREINADORES.TreinadoresMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TreinosService {
    @Autowired
private  TreinosRepository treinosRepository;

    public TreinosService(TreinosRepository treinosRepository) {
        this.treinosRepository = treinosRepository;
    }

public List<TreinosDTO> listar(){
        List<TreinosModel> treinosModels = treinosRepository.findAll();
    return  treinosModels.stream().map(TreinosMapper::map).collect(Collectors.toList( ));

}



 public  TreinosDTO  LISTARID(Long ID){
     Optional<TreinosModel>  VARIAVEL = treinosRepository.findById(ID);
   if (treinosRepository.findById(ID) != null){
       return (TreinosDTO) VARIAVEL.map( TreinadoresMapper ::map).orElse(null);
   }
return null;
 }

    public void DELETAR(Long ID){
        treinosRepository.deleteById(ID);
    }


    public TreinosDTO criar( TreinosDTO  CRIARV){
       TreinosModel treinosModel =TreinosMapper.map(CRIARV);
        treinosModel = treinosRepository.save(treinosModel);
       return TreinosMapper.map(treinosModel);

    }


    public TreinosDTO ATUALIZAR(Long ID, TreinosDTO ATUALIZARVC){
        Optional<TreinosModel> treinosModel = treinosRepository.findById(ID);
        if (treinosRepository.existsById(ID)) {
            TreinosModel treinosModelV1 = TreinosMapper.map(ATUALIZARVC);
            treinosModelV1.setID(ID);
      TreinosModel Atualizado = treinosRepository.save(treinosModelV1);
        return TreinosMapper.map(Atualizado);
        }
        return  null;
    }

}



