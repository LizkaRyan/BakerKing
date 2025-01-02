package mg.itu.bakerking.controller.transaction.achat;

import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.AchatDTO;
import mg.itu.bakerking.entity.transaction.achat.Achat;
import mg.itu.bakerking.service.produit.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/achat")
public class AchatController {
    private final IngredientService ingredientService;

    public AchatController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/form")
    public ModelAndView form(){
        return new Dispatcher("transaction/achat/form.jsp").addObject("ingredients",ingredientService.getRepo().findAll());
    }

    @PostMapping
    public String save(@ModelAttribute AchatDTO achat){
        return achat.getIngredients().get(0);
    }
}
