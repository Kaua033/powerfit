package PowerFit.API.TREINADORES;

import PowerFit.API.TREINOS.TreinosModel;
import org.springframework.stereotype.Component;

@Component
public class TreinadoresMapper {


public static TreinadoresModel map(TreinadoresDTO treinadoresDTO){
    TreinadoresModel treinadoresModel1 = new TreinadoresModel();
  treinadoresModel1.setID(treinadoresDTO.getID());
  treinadoresModel1.setNome(treinadoresDTO.getNome());
  treinadoresModel1.setEmail(treinadoresDTO.getEmail());
  treinadoresModel1.setIdade(treinadoresDTO.getIdade());
  treinadoresModel1.setTelefone(treinadoresDTO.getTelefone());
  return treinadoresModel1;

}

public static TreinadoresDTO map(TreinadoresModel treinadoresModel){
    TreinadoresDTO treinadoresDTO =new TreinadoresDTO();
     treinadoresDTO.setEmail(treinadoresModel.getEmail());
     treinadoresDTO.setID(treinadoresModel.getID());
     treinadoresDTO.setNome(treinadoresModel.getNome());
     treinadoresDTO.setIdade(treinadoresModel.getIdade());
     treinadoresDTO.setTelefone(treinadoresModel.getTelefone());
     return treinadoresDTO;
}


    public static Object map(TreinosModel treinosModel) {
        return null;
    }
}
