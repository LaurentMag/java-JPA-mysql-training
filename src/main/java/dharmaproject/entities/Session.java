package dharmaproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String nom;
    int nbreEleves;
    Date dateDebut;
    Date dateFin;

    // fetchTYpe eager => toutes les données
    // lazy = va tout prendre seulement si on le demande
    @OneToMany(mappedBy = "session", fetch = FetchType.EAGER)
    List<Stagiaire> listStagiaire;

    @ManyToMany
    @JoinTable(
            name ="session_salledeclass",
            // session doit être le même nom que la table
            joinColumns = @JoinColumn(name ="session"),
            inverseJoinColumns = @JoinColumn(name ="salledeclas")
    )
    private List<SalleDeClass> listSalles = new ArrayList<>();


    @ManyToMany(mappedBy = "listSession")
    private List<Formateur> listformateur = new ArrayList<>();


}
