package mg.itu.bakerking.entity.produit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Produit {
    @Id
    @GeneratedValue
    private String idProduit;

    private String produit;

    private double prixUnitaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @OneToMany(fetch = FetchType.LAZY)
    private List<IngredientProduit> listIngredientProduit;
}
