package o_a_ex.RestControllers;
import o_a_ex.Entities.Bibliotheque;
import o_a_ex.Entities.Livre;
import o_a_ex.Entities.Utilisateur;
import o_a_ex.Services.IServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllers {
    @Autowired
    IServices is;

    @PostMapping("ajouterBibliotheque")
    Bibliotheque ajouterBibliotheque(@RequestBody Bibliotheque bibliotheque){
        return is.ajouterBibliotheque(bibliotheque);
    }

    @PostMapping("ajouterLecteurs")
    List<Utilisateur> ajouterLecteurs(@RequestBody List<Utilisateur> lecteurs){
        return is.ajouterLecteurs(lecteurs);
    }

    @PostMapping("ajouterLivreEtAuteurEtAffecterABiblio")
    Bibliotheque ajouterLivreEtAuteurEtAffecterABiblio(@RequestBody Livre l,@RequestParam String nomBibliotheque){
        return is.ajouterLivreEtAuteurEtAffecterABiblio(l,nomBibliotheque);
    }
    @PutMapping("affecterLivreALecteur")
    String affecterLivreALecteur(@RequestParam long idLivre,@RequestParam long idLecteur){
        return is.affecterLivreALecteur(idLivre,idLecteur);
    }




    /*
    @PostMapping("addUniversite")
    Universite addUniversite (@RequestBody Universite u){
        return is.addUniversite(u);
    }
    @PutMapping("assignEtudiantToDepartement")
    public void assignEtudiantToDepartement(@RequestParam Integer etudiantId,@RequestParam Integer departementId){
        is.assignEtudiantToDepartement(etudiantId,departementId);
    }
    @PostMapping("addAndAssignEtudiantToEquipeAndContract")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@RequestParam Integer idContrat,@RequestParam Integer idEquipe){
        return is.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }
    @GetMapping("nbContratsValides")
    public Integer nbContratsValides(
            @RequestParam @DateTimeFormat (pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat (pattern = "yyyy-MM-dd") Date endDate){
        return is.nbContratsValides(startDate, endDate);
    }
    */
}
