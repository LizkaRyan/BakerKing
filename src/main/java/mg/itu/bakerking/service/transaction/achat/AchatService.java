package mg.itu.bakerking.service.transaction.achat;

import lombok.Getter;
import mg.itu.bakerking.dto.produit.IngredientDTO;
import mg.itu.bakerking.dto.transaction.AchatDTO;
import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.entity.transaction.achat.Achat;
import mg.itu.bakerking.entity.transaction.achat.AchatDetails;
import mg.itu.bakerking.repository.transaction.achat.AchatRepo;
import mg.itu.bakerking.service.produit.IngredientService;
import org.springframework.stereotype.Service;

@Service
@Getter
public class AchatService {
    private final AchatRepo repo;

    private final IngredientService ingredientService;

    public AchatService(AchatRepo repo, IngredientService ingredientService) {
        this.repo = repo;
        this.ingredientService = ingredientService;
    }

    public Achat save(AchatDTO achatDTO){
        Achat achat=new Achat(achatDTO.getDateTransaction());
        achat.setDateTransaction(achatDTO.getDateTransaction());
        for (IngredientDTO ingredientDTO:achatDTO.getIngredients()) {
            Ingredient ingredient=ingredientService.getRepo().findById(ingredientDTO.getIdIngredient()).orElseThrow(()->new RuntimeException("Id Ingredient:"+ingredientDTO.getIdIngredient()+" non retrouve"));
            AchatDetails achatDetails=new AchatDetails(ingredient, ingredientDTO.getQuantite());
            achat.addAchatDetails(achatDetails);
        }
        return this.repo.save(achat);
    }
}
