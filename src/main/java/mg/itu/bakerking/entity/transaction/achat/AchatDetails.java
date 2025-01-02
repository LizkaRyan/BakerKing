package mg.itu.bakerking.entity.transaction.achat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.entity.transaction.TransactionDetails;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AchatDetails extends TransactionDetails {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transaction")
    private Achat achat;

    public Ingredient getIngredient(){
        return this.ingredient;
    }

    public AchatDetails(Ingredient ingredient,double quantite){
        this.setIngredient(ingredient);
        this.setQuantite(quantite);
        this.setMontant(ingredient.getPrixUnitaire());
    }
}
