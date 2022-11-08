package dharmaproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "formateur")
public class Formateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;


    @ManyToMany
    @JoinTable(
            name = "formateur_competences",
            joinColumns = @JoinColumn(name = "formateur"),
            inverseJoinColumns = @JoinColumn(name = "competences")
    )
    private List<Competences> listcompetences = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name="formateur_session",
            joinColumns = @JoinColumn(name = "formateur_id"),
            inverseJoinColumns = @JoinColumn(name = "session_id")
    )
    private List<Session> listSession = new ArrayList<>();

}
