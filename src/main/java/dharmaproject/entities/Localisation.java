package dharmaproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "localisation")
public class Localisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String position;

    @OneToMany(mappedBy = "localisation", fetch = FetchType.EAGER)
    private List<SalleDeClass> listSalleDeClass;
}
