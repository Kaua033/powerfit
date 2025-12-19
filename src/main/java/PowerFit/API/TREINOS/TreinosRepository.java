package PowerFit.API.TREINOS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinosRepository extends JpaRepository<TreinosModel,Long> {
}
