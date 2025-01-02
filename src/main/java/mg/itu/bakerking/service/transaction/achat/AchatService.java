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

    private final AchatDetailsService achatDetailsService;

    public AchatService(AchatRepo repo, IngredientService ingredientService, AchatDetailsService achatDetailsService) {
        this.repo = repo;
        this.ingredientService = ingredientService;
        this.achatDetailsService = achatDetailsService;
    }

    public Achat save(AchatDTO achatDTO){
        Achat achat=new Achat(achatDTO.getDateTransaction());
        achat.setDateTransaction(achatDTO.getDateTransaction());
        for (IngredientDTO ingredientDTO:achatDTO.getIngredients()) {
            Ingredient ingredient=ingredientService.getRepo().findById(ingredientDTO.getIdIngredient()).orElseThrow(()->new RuntimeException("Id Ingredient:"+ingredientDTO.getIdIngredient()+" non retrouve"));
            AchatDetails achatDetails=new AchatDetails(ingredient, ingredientDTO.getQuantite());
            achatDetailsService.setId(achatDetails);
            achat.addAchatDetails(achatDetails);
        }
        return this.repo.save(achat);
    }
}
