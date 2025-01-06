package mg.itu.bakerking.listener.stock;

import jakarta.persistence.PrePersist;
import mg.itu.bakerking.entity.stock.MvtStockProduit;
import mg.itu.bakerking.repository.stock.MvtStockProduitRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MvtStockProduitListener {
    private final MvtStockProduitRepo repo;

    public MvtStockProduitListener(@Lazy MvtStockProduitRepo repo) {
        this.repo = repo;
    }

    @PrePersist
    public void prePersist(MvtStockProduit mvtStockProduit){
        mvtStockProduit.setIdMvtStock("MSI00"+repo.findId());
    }
}
