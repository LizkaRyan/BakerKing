package mg.itu.bakerking.entity.transaction;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TransactionDetails {
    @Id
    @GeneratedValue
    private String idDetails;

    private double quantite;

    private double montant;
}
