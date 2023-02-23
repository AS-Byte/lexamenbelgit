package o_a_ex.Repositories;

import o_a_ex.Entities.Bibliotheque;
import o_a_ex.Entities.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepoLivre extends CrudRepository<Livre,Long> {

}
