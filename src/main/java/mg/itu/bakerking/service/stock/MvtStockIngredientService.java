package mg.itu.bakerking.service.stock;

import mg.itu.bakerking.dto.produit.IngredientDTO;
import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.entity.stock.MvtStockIngredient;
import mg.itu.bakerking.repository.stock.MvtStockIngredientRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MvtStockIngredientService {
    private MvtStockIngredientRepo repo;

    public MvtStockIngredientService(MvtStockIngredientRepo repo) {
        this.repo = repo;
    }

    public MvtStockIngredient save(Ingredient ingredient, double quantite, LocalDate date) {
        MvtStockIngredient mvtStockIngredient=new MvtStockIngredient(date,"Achat d'ingredients");
        mvtStockIngredient.setEntree(quantite);
        mvtStockIngredient.setIngredient(ingredient);
        return repo.save(mvtStockIngredient);
    }
}
