package PowerFit.API.TREINADORES;

import PowerFit.API.ALUNOS.AlunosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TreinadoresRepository extends  JpaRepository<TreinadoresModel, Long> {
}
