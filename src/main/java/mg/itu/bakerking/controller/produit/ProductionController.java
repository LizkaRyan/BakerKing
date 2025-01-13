package mg.itu.bakerking.controller.produit;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.produit.ProductionRequest;
import mg.itu.bakerking.service.produit.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/production")
public class ProductionController {
    private ProductionService productionService;
    @GetMapping
    public ModelAndView production(@RequestParam(value = "idIngredient",defaultValue = "Tous") String idIngredient,
                                   @RequestParam(value = "idCategorie",defaultValue = "Tous") String idCategorie) {
        return new Dispatcher("production/index")
                .addObject("production", productionService.getProduction(idCategorie, idIngredient))
                .addObject("ingredients",productionService.getIngredientRepo().findAll())
                .addObject("categories",productionService.getCategorieRepo().findAll())
                .addObject("idIngredient",idIngredient)
                .addObject("idCategorie",idCategorie);
    }

    @GetMapping("/form_production")
    public ModelAndView form(){
        return new Dispatcher("production/form")
                .addObject("produits",productionService.getProduitRepo().findAll());
    }

    @PostMapping
    public String insert(@ModelAttribute ProductionRequest productionDTO){
        productionService.save(productionDTO);
        return "redirect:/production/form";
    }
}
