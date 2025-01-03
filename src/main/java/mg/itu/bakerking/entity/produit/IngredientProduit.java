package mg.itu.bakerking.entity.produit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mg.itu.bakerking.entity.produit.id.IdIngredientProduit;

@Entity
@Getter
@Setter
public class IngredientProduit {

    @EmbeddedId
    private IdIngredientProduit id;

    @MapsId("idIngredient")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingredient",insertable = false,updatable = false)
    private Ingredient ingredient;

    @MapsId("idProduit")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit",insertable = false,updatable = false)
    private  Produit produit;

    private double quantite;
}
