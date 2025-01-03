package mg.itu.bakerking.entity.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class MvtStock {
    @Id
    private String idMvtStock;

    private double entree;

    private double sortie;

    private LocalDate dateMvt;

    private String description;
}
