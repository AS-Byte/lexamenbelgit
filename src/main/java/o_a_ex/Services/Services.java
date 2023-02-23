package o_a_ex.Services;
import lombok.extern.slf4j.Slf4j;
import o_a_ex.Entities.Bibliotheque;
import o_a_ex.Entities.Livre;
import o_a_ex.Entities.Utilisateur;
import o_a_ex.Repositories.RepoBibliotheque;
import o_a_ex.Repositories.RepoLivre;
import o_a_ex.Repositories.RepoUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
@Slf4j
@Service
public class Services implements IServices {

    @Autowired
    RepoUtilisateur repoUtilisateur;

    @Autowired
    RepoBibliotheque repoBibliotheque;

    @Autowired
    RepoLivre repolivre;

    @Override
    public Bibliotheque ajouterBibliotheque(Bibliotheque bibliotheque) {
        return repoBibliotheque.save(bibliotheque);
    }

    @Override
    public List<Utilisateur> ajouterLecteurs(List<Utilisateur> lecteurs) {
        return (List<Utilisateur>) repoUtilisateur.saveAll(lecteurs);
    }

    @Override
    public Bibliotheque ajouterLivreEtAuteurEtAffecterABiblio(Livre l, String nomBibliotheque) {
        Bibliotheque y=repoBibliotheque.findByNom(nomBibliotheque);
        Livre x=repolivre.save(l);
        y.getLivres().add(x);
        repoBibliotheque.save(y);
        return y;
    }

    @Override
    public String affecterLivreALecteur(long idLivre, long idLecteur) {
        Livre x= repolivre.findById(idLivre).get();
        Utilisateur y=repoUtilisateur.findById(idLecteur).get();
        String msg="";
        if (y.getLecteur()==null){
            y.setLecteur(x)
            ;
            msg= "Le livre est déja reservé!";
        }else  { msg="l'affectation du livre XXX est effectuée avec succès" ;}
        return msg;
    }

    @Override
    public String rendreLivre(String nom, String prenom) {
        Utilisateur x =repoUtilisateur.findByNomAndPrenom(nom,prenom);
        x.setLecteur(null);
        return "livre desaffecté";
    }

}
