package o_a_ex.Services;

import o_a_ex.Entities.Bibliotheque;
import o_a_ex.Entities.Livre;
import o_a_ex.Entities.Utilisateur;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public interface IServices {

    Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque);
    List<Utilisateur> ajouterLecteurs(List<Utilisateur> lecteurs);
    Bibliotheque ajouterLivreEtAuteurEtAffecterABiblio(Livre l, String nomBibliotheque);
    String affecterLivreALecteur(long idLivre, long idLecteur);
    String rendreLivre(String nom, String prenom);
}
