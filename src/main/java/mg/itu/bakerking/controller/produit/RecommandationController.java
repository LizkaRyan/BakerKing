package mg.itu.bakerking.controller.produit;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.produit.RecommandationRequest;
import mg.itu.bakerking.service.produit.RecommandationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
@RequestMapping("/recommandations")
public class RecommandationController {

    private RecommandationService recommandationService;
    @GetMapping
    public ModelAndView getRecommandation(@RequestParam(value = "mois", required = false) Integer mois, @RequestParam(value = "annee", required = false) Integer annee) {
        LocalDate date = LocalDate.now();
        if(mois == null) {
            mois = date.getMonth().getValue();
        }
        if(annee == null) {
            annee = date.getYear();
        }
        return new Dispatcher("recommandation/index")
                .addObject("recommandations", recommandationService.getRecommandations(mois, annee))
                .addObject("mois", mois)
                .addObject("annee", annee)
                .addObject("months", recommandationService.getMonths());
    }

    @GetMapping("/form-recommandation")
    public ModelAndView form() {
        return new Dispatcher("recommandation/form").addObject("produits", recommandationService.getProduitRepo().findAll());
    }

    @PostMapping
    public String insert(@ModelAttribute RecommandationRequest recommandationRequest) {
        recommandationService.save(recommandationRequest);

        return "redirect:/recommandations/form-recommandation";
    }


}
