package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.*;
import mg.itu.bakerking.entity.transaction.TransactionDetails;

import java.util.List;

@Entity
public class Vente extends TransactionDetails {
    @OneToMany(fetch = FetchType.LAZY)
    private List<VenteDetails> venteDetails;
}
