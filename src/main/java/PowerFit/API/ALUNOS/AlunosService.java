package PowerFit.API.ALUNOS;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {
private ALUNOSRepository alunosRepository;

    public AlunosService(ALUNOSRepository alunosRepository) {
        this.alunosRepository = alunosRepository;
    }

    public List<AlunosModel> listar (){
    return alunosRepository.findAll();
}


public  AlunosModel LISTARID(Long ID){
    Optional<AlunosModel> LISTAID = alunosRepository.findById(ID);
    return LISTAID.orElse(null);

}

    public void deletar (Long ID) {
        alunosRepository.deleteById(ID);
    }

    public  void   AlunosModel  (Long ID){
         alunosRepository.deleteById(ID);
    }



public AlunosModel CRIAR(AlunosModel alunosModel){
        return alunosRepository.save(alunosModel);
}

public AlunosModel ATUALIZAR(AlunosModel ALUNO, long ID){


        if (alunosRepository.existsById(ID)){
    alunosRepository.existsById(ID);
       ALUNO.setID(ID);
    return alunosRepository.save(ALUNO);
}
  return  null;
    }

}
