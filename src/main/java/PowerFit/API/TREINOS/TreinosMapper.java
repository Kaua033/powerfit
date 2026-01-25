package PowerFit.API.TREINOS;

import org.springframework.stereotype.Component;

@Component
public class TreinosMapper {

    public static TreinosModel map(TreinosDTO treinosDTO) {
        TreinosModel treinosModel = new TreinosModel();
        treinosModel.setID(treinosDTO.getID());
        treinosModel.setNome(treinosDTO.getNome());

    return treinosModel;
    }

    public static TreinosDTO map(TreinosModel treinosModel){
        TreinosDTO treinosDTO = new TreinosDTO();
     treinosDTO.setID(treinosModel.getID());
    treinosDTO.setNome(treinosModel.getNome());
    return treinosDTO;
    }







}




