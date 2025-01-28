package mg.itu.bakerking.controller.produit;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.produit.PrixProduitRequest;
import mg.itu.bakerking.repository.produit.CategorieRepo;
import mg.itu.bakerking.repository.produit.IngredientRepo;
import mg.itu.bakerking.repository.produit.PrixProduitRepo;
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
    private PrixProduitRepo prixProduitRepo;

    @GetMapping("/form")
    public ModelAndView index(){
        return new Dispatcher("stock/production").addObject("produits",produitRepo.findAll());
    }

    @PostMapping("/prix")
    public String save(@ModelAttribute PrixProduitRequest prixProduitRequest) {
        this.produitService.save(prixProduitRequest);
        return "redirect:/produit/prix";
    }

    @GetMapping("/prix")
    public ModelAndView formPrix() {
        return new Dispatcher("produit/formPrix").addObject("produits", produitRepo.findAll());
    }

    @GetMapping("/historique/prix")
    public ModelAndView historiquePrix(@RequestParam("idProduit") String idProduit) {
        return new Dispatcher("produit/historique").addObject("produits", produitRepo.findAll())
                .addObject("historique", prixProduitRepo.getPrixProduitsByIdProduit(idProduit))
                .addObject("idProduit", idProduit);
    }
}
