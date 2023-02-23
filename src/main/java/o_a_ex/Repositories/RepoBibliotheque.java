package o_a_ex.Repositories;

import o_a_ex.Entities.Bibliotheque;
import o_a_ex.Entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepoBibliotheque extends CrudRepository<Bibliotheque,Long> {
Bibliotheque findByNom(String nomBibliotheque);
}
