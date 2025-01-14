package mg.itu.bakerking.service.produit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mg.itu.bakerking.dto.produit.ProductionRequest;
import mg.itu.bakerking.entity.produit.IngredientProduit;
import mg.itu.bakerking.entity.produit.Production;
import mg.itu.bakerking.entity.stock.MvtStockProduit;
import mg.itu.bakerking.repository.produit.CategorieRepo;
import mg.itu.bakerking.repository.produit.IngredientRepo;
import mg.itu.bakerking.repository.produit.ProductionRepo;
import mg.itu.bakerking.repository.produit.ProduitRepo;
import mg.itu.bakerking.service.stock.MvtProduitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class ProductionService {
    private ProductionRepo productionRepo;
    private IngredientRepo ingredientRepo;
    private CategorieRepo categorieRepo;
    private ProduitRepo produitRepo;
    private MvtProduitService mvtProduitService;
    public List<Production> getProduction(String idCategorie, String idIngredient) {
        List<Production> productions = productionRepo.getListProduction(idCategorie,idCategorie.equals("Tous"));
        List<Production> valiny = new ArrayList<>();
        boolean allIngredient=idIngredient.equals("Tous");
        for (Production p : productions) {
            boolean ok = false;
            for (IngredientProduit i : p.getProduit().getListIngredientProduit()) {
                if (i.getIngredient().getIdIngredient().equals(idIngredient) || allIngredient) {
                    ok = true;
                    break;
                }
            }
            if (ok) {
                valiny.add(p);
            }
        }

        return valiny;
    }

    public void save(ProductionRequest productionDTO){
        List<MvtStockProduit> mvtStockProduits=this.mvtProduitService.save(productionDTO);
        for (MvtStockProduit mvtStockProduit:mvtStockProduits) {
            productionRepo.save(new Production(mvtStockProduit));
        }
    }
}
