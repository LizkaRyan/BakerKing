package mg.itu.bakerking.controller.produit;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.service.produit.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/production")
public class ProductionController {
    private ProductionService productionService;
    @GetMapping
    public ModelAndView production(@RequestParam("idIngredient") String idIngredient, @RequestParam("idCategorie") String idCategorie) {
        return new Dispatcher("produitList")
                .addObject("production", productionService.getProduction(idCategorie, idIngredient))
                .addObject("ingredients",productionService.getIngredientRepo().findAll())
                .addObject("categories",productionService.getProductionRepo().findAll())
                .addObject("idIngredient",idIngredient)
                .addObject("idCategorie",idCategorie);
    }

    @GetMapping("/form")
    public ModelAndView form(){
        return new Dispatcher("stock/form").addObject();
    }
}
