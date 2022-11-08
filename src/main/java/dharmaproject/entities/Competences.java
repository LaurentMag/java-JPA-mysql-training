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
@Table(name = "competences")
public class Competences {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String  nom;

    @ManyToMany(mappedBy = "listcompetences")
    private List<Formateur> listformateur = new ArrayList<>();


}
