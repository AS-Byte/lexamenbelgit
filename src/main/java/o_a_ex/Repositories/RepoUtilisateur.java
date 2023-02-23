package o_a_ex.Repositories;
import o_a_ex.Entities.Utilisateur;
import  org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface RepoUtilisateur extends CrudRepository<Utilisateur,Long> {
Utilisateur findByNomAndPrenom(String nom, String prenom);

}
