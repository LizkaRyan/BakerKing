package mg.itu.bakerking.entity.stock;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import mg.itu.bakerking.entity.produit.Ingredient;

@Entity
public class MvtStockIngredient extends MvtStock{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;
}
