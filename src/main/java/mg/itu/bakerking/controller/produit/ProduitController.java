package mg.itu.bakerking.controller.produit;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.repository.produit.CategorieRepo;
import mg.itu.bakerking.repository.produit.IngredientRepo;
import mg.itu.bakerking.repository.produit.ProduitRepo;
import mg.itu.bakerking.service.produit.ProduitService;
import mg.itu.bakerking.service.stock.MvtProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/produit")
public class ProduitController {
    private MvtProduitService mvtProduitService;
    private ProduitRepo produitRepo;
    private ProduitService produitService;
    private IngredientRepo ingredientRepo;
    private CategorieRepo categorieRepo;

    @GetMapping("/form")
    public ModelAndView index(){
        return new Dispatcher("stock/production").addObject("produits",produitRepo.findAll());
    }
}
