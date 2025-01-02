package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import mg.itu.bakerking.entity.transaction.TransactionDetails;

@Entity
public class VenteDetails extends TransactionDetails {
    @ManyToOne(fetch = FetchType.LAZY)
    private Vente vente;
}
