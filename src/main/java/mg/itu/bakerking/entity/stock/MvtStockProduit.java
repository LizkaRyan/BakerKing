package mg.itu.bakerking.entity.stock;

import jakarta.persistence.*;
import lombok.Data;
import mg.itu.bakerking.entity.produit.Produit;
import mg.itu.bakerking.listener.transaction.MvtStockProduitListener;

@Entity
@Data
@EntityListeners(MvtStockProduitListener.class)
public class MvtStockProduit extends MvtStock{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produit")
    private Produit produit;
}
