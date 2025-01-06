package mg.itu.bakerking.listener.stock;

import jakarta.persistence.PrePersist;
import mg.itu.bakerking.entity.stock.MvtStockIngredient;
import mg.itu.bakerking.repository.stock.MvtStockIngredientRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MvtStockIngredientListener {

    private final MvtStockIngredientRepo repo;

    public MvtStockIngredientListener(@Lazy MvtStockIngredientRepo repo) {
        this.repo = repo;
    }

    @PrePersist
    public void prePersist(MvtStockIngredient mvtStockIngredient){
        mvtStockIngredient.setIdMvtStock("MSI00"+repo.findId());
    }
}
