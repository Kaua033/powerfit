package PowerFit.API.ALUNOS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface ALUNOSRepository  extends JpaRepository<AlunosModel, Long>{

}
