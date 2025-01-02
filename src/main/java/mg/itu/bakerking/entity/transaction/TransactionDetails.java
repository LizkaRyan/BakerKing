package mg.itu.bakerking.entity.transaction;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TransactionDetails {
    @Id
    private String idDetails;

    private double quantite;

    private double montant;
}
