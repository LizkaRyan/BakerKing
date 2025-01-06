package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.bakerking.entity.produit.Produit;
import mg.itu.bakerking.entity.transaction.TransactionDetails;

@Entity
@NoArgsConstructor
@Data
public class VenteDetails extends TransactionDetails {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit")
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transaction")
    private Vente vente;

    public VenteDetails(String idDetails,double quantite,double montant,Produit produit){
        super(idDetails,quantite,montant);
        this.setProduit(produit);
    }
}
