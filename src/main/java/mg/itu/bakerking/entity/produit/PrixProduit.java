package mg.itu.bakerking.entity.produit;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class PrixProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private String idPrixProduit;

    private LocalDate datePrix;
    private double prixUnitaire;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_produit")
    private Produit produit;

    public PrixProduit(LocalDate datePrix, double prixUnitaire, Produit produit) {
        this.setDatePrix(datePrix);
        this.setPrixUnitaire(prixUnitaire);
        this.setProduit(produit);
    }
}
