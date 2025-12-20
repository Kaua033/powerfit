package PowerFit.API.ALUNOS;

import org.springframework.stereotype.Component;

@Component
public class AlunosMapper {

    public AlunosModel map( AlunosDTO alunosDTO){
        AlunosModel alunosModel1 =new AlunosModel();
        alunosModel1.setID(alunosDTO.getID());
       alunosModel1.setNome(alunosDTO.getNome());
    alunosModel1.setIdade(alunosDTO.getIdade());
    alunosModel1.setEmail(alunosDTO.getEmail());
    alunosModel1.setTelefone(alunosDTO.getTelefone());
    return alunosModel1;
    }

public AlunosDTO map(AlunosModel alunosModel){
        AlunosDTO alunosDTO = new AlunosDTO();
        alunosDTO.setID(alunosModel.getID());
        alunosDTO.setNome(alunosModel.getNome());
       alunosDTO.setIdade(alunosModel.getIdade());
       alunosDTO.setEmail(alunosModel.getEmail());
      alunosDTO.setTelefone(alunosModel.getTelefone());
    return alunosDTO;
    }

}
