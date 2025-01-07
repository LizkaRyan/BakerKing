package mg.itu.bakerking.entity.produit;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.bakerking.entity.stock.MvtStockProduit;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private String idProduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit")
    private Produit produit;
    private LocalDate dateProduction;
    private double quantite;

    public Production(MvtStockProduit mvtStockProduit){
        this.setProduit(mvtStockProduit.getProduit());
        this.setDateProduction(mvtStockProduit.getDateMvt());
        this.setQuantite(mvtStockProduit.getEntree());
    }
}
