package mg.itu.bakerking.entity.produit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mg.itu.bakerking.listener.produit.RecommandationListener;

@Entity
@Getter
@Setter
@EntityListeners(RecommandationListener.class)
public class Recommandation {

    @Id
    private String idRecommandation;

    private int mois;
    private int annee;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produit")
    private Produit produit;


}
