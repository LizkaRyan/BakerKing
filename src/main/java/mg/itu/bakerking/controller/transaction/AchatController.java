package mg.itu.bakerking.controller.transaction;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.transaction.AchatDTO;
import mg.itu.bakerking.service.produit.IngredientService;
import mg.itu.bakerking.service.transaction.achat.AchatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/achat")
public class AchatController {
    private final IngredientService ingredientService;

    private final AchatService achatService;

    @GetMapping("/form")
    public ModelAndView form(){
        return new Dispatcher("transaction/achat/form").addObject("ingredients",ingredientService.getRepo().findAll());
    }

    @GetMapping("/details/{idAchat}")
    public ModelAndView details(@PathVariable("idAchat") String idAchat){
        return new Dispatcher("transaction/achat/details").addObject("details",achatService.findById(idAchat).getAchatDetails());
    }

    @PostMapping
    public String save(@Valid @ModelAttribute AchatDTO achat){
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
        return new Dispatcher("transaction/achat/index").addObject("achats",achatService.getRepo().findAll());
    }
}
