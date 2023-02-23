package o_a_ex.Entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idUser;

    String nom;
    String prenom;
    String nationalite;

    @Enumerated(EnumType.STRING)
    Role role;

    @Temporal(TemporalType.DATE)
    Date dateDebutAbonnement;

    @Temporal(TemporalType.DATE)
    Date dateFinAbonnement;

    @Enumerated(EnumType.STRING)
    Etat etat;

    //utilisateur lecteur parent
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Livre lecteur;

    //utilisateur auteur child
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy ="auteur")
    List<Livre> livres=new ArrayList<>();






    /*
    @Column(length = 10, unique = true)
    String nom;
    @Enumerated(EnumType.STRING) //comment l'écrire dans la base
    TypeFilm type;
    @Temporal(TemporalType.DATE)
    Date dateProduction;
    */

}
