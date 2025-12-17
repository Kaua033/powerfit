package PowerFit.API.ALUNOS;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunosService {
private ALUNOSRepository alunosRepository;

    public AlunosService(ALUNOSRepository alunosRepository) {
        this.alunosRepository = alunosRepository;
    }

    public List<AlunosModel> listar (){
    return alunosRepository.findAll();
}

}
