package dharmaproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "salledeclass")
public class SalleDeClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nom;
    private int capacity;

    @ManyToMany(mappedBy = "listSalles")
    private List<Session> listSession;

    @ManyToOne
    private Localisation localisation;
}
