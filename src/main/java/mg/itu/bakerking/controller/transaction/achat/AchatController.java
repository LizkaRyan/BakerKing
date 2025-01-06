package mg.itu.bakerking.controller.transaction.achat;

import jakarta.validation.Valid;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.transaction.AchatDTO;
import mg.itu.bakerking.service.produit.IngredientService;
import mg.itu.bakerking.service.transaction.achat.AchatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/achat")
public class AchatController {
    private final IngredientService ingredientService;

    private final AchatService achatService;

    public AchatController(IngredientService ingredientService, AchatService achatService) {
        this.ingredientService = ingredientService;
        this.achatService = achatService;
    }

    @GetMapping("/form")
    public ModelAndView form(){
        return new Dispatcher("transaction/achat/form.jsp").addObject("ingredients",ingredientService.getRepo().findAll());
    }

    @PostMapping
    public String save(@Valid @ModelAttribute AchatDTO achat, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("errors",result.getAllErrors());
            // Gérer les erreurs de validation ici
            return "redirect:/achat/form";  // Renvoie à la page du formulaire si des erreurs sont présentes
        }
        try{
            this.achatService.save(achat);
        }
        catch (Exception ex){
            throw ex;
        }
        return "redirect:/achat";
    }

    @GetMapping
    public ModelAndView index(){
        return new Dispatcher("stock/index.jsp");
    }
}
