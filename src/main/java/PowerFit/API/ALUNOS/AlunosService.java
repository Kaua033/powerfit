package PowerFit.API.ALUNOS;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunosService {
private ALUNOSRepository alunosRepository;

    public AlunosService(ALUNOSRepository alunosRepository) {
        this.alunosRepository = alunosRepository;
    }

    public List<AlunosDTO> listar (){
    List<AlunosModel> all =  alunosRepository.findAll();
  return  all.stream().map(AlunosMapper ::map).collect(Collectors.toList());

    }


public  AlunosDTO  LISTARID(Long ID){
    Optional<AlunosModel> LISTAID = alunosRepository.findById(ID);
    return LISTAID.map(AlunosMapper::map).orElse(null);
}

    public void deletar (Long ID) {
        alunosRepository.deleteById(ID);
    }



public AlunosDTO CRIAR(AlunosDTO alunosDTO){
AlunosModel alunosModel = AlunosMapper.map(alunosDTO);
 alunosModel = alunosRepository.save(alunosModel);
        return AlunosMapper.map(alunosModel);
}

public AlunosDTO ATUALIZAR(AlunosDTO ALUNO, long ID){
        AlunosModel alunosExiste = (AlunosModel) alunosRepository.findAllById(Collections.singleton(ID));
        if (alunosExiste != null){
   AlunosModel atualizado = AlunosMapper.map(ALUNO);
    atualizado.setID(ID);
    AlunosModel AlunosSalvo = alunosRepository.save(atualizado);
            return AlunosMapper.map(AlunosSalvo);
}
  return  null;
    }

}
