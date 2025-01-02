package mg.itu.bakerking.service.produit;

import lombok.Getter;
import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.repository.produit.IngredientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class IngredientService {
    private IngredientRepo repo;

    public IngredientService(IngredientRepo repo) {
        this.repo = repo;
    }

    public IngredientRepo getRepo(){
        return this.repo;
    }
}
