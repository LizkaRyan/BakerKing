package mg.itu.bakerking.entity.transaction;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Transaction {
    @Id
    @GeneratedValue
    private String idTransaction;

    private double montant=0;

    private LocalDate dateTransaction;
}
