package mg.itu.bakerking.entity.produit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingredient {
    @Id
    @GeneratedValue
    private String idIngredient;

    private String ingredient;

    private double prixUnitaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_unite")
    private Unite unite;
}
