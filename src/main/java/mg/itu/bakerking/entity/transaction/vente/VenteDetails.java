package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.entity.produit.Produit;
import mg.itu.bakerking.entity.transaction.TransactionDetails;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class VenteDetails extends TransactionDetails {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit")
    private Produit produit;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vente vente;

    public VenteDetails(double quantite,double montant,Produit produit){
        super(quantite,montant);
        this.setProduit(produit);
    }
}
