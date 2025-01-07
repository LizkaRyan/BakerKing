package mg.itu.bakerking.service.transaction.achat;

import lombok.Getter;
import mg.itu.bakerking.dto.produit.IngredientDTO;
import mg.itu.bakerking.dto.transaction.AchatDTO;
import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.entity.transaction.achat.Achat;
import mg.itu.bakerking.entity.transaction.achat.AchatDetails;
import mg.itu.bakerking.repository.transaction.achat.AchatRepo;
import mg.itu.bakerking.service.produit.IngredientService;
import mg.itu.bakerking.service.stock.MvtStockIngredientService;
import org.springframework.stereotype.Service;

@Service
@Getter
public class AchatService {
    private final AchatRepo repo;

    private final IngredientService ingredientService;

    private final AchatDetailsService achatDetailsService;

    private final MvtStockIngredientService mvtStockIngredientService;

    public AchatService(AchatRepo repo, IngredientService ingredientService, AchatDetailsService achatDetailsService, MvtStockIngredientService mvtStockIngredientService) {
        this.repo = repo;
        this.ingredientService = ingredientService;
        this.achatDetailsService = achatDetailsService;
        this.mvtStockIngredientService = mvtStockIngredientService;
    }

    public Achat save(AchatDTO achatDTO){
        Achat achat=new Achat(achatDTO.getDateTransaction());
        achat.setDateTransaction(achatDTO.getDateTransaction());
        for (IngredientDTO ingredientDTO:achatDTO.getIngredients()) {
            Ingredient ingredient=ingredientService.getRepo().findById(ingredientDTO.getIdIngredient()).orElseThrow(()->new RuntimeException("Id Ingredient:"+ingredientDTO.getIdIngredient()+" non retrouve"));
            AchatDetails achatDetails=new AchatDetails(ingredient, ingredientDTO.getQuantite());

            mvtStockIngredientService.save(ingredient, ingredientDTO.getQuantite(), achatDTO.getDateTransaction());
            achatDetailsService.setId(achatDetails);
            achat.addAchatDetails(achatDetails);
        }
        return this.repo.save(achat);
    }

    public Achat findById(String idAchat){
        return this.repo.findById(idAchat).orElseThrow(()->new RuntimeException("Id achat non retrouvé"));
    }
}
