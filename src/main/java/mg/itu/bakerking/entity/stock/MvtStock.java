package mg.itu.bakerking.entity.stock;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MvtStock {
    @Id
    @GeneratedValue
    private String idMvtStock;

    private double entree;

    private double sortie;

    private LocalDate dateMvt;

    private String description;
}
