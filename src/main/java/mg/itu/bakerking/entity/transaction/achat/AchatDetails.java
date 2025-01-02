package mg.itu.bakerking.entity.transaction.achat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.entity.transaction.TransactionDetails;

@Entity
@Getter
@Setter
public class AchatDetails extends TransactionDetails {
    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    private Achat achat;

    public Ingredient getIngredient(){
        return this.ingredient;
    }
}
