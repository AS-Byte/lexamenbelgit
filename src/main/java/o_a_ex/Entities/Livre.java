package o_a_ex.Entities;
import java.io.Serializable;
import java.util.Date;

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
public class Livre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idLivre;

    String nom;
    TypeLivre type;

    @Temporal(TemporalType.DATE)
    Date dateEmission;

    boolean reserve;

    @Temporal(TemporalType.DATE)
    Date dateReservation;


    //livre child
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy ="lecteur")
    Utilisateur lecteur;

    //livre parent auteur

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Utilisateur auteur;




}
