package mg.itu.bakerking.controller.produit;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.produit.RecommandationRequest;
import mg.itu.bakerking.service.produit.RecommandationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/recommandations")
public class RecommandationController {

    private RecommandationService recommandationService;
    @GetMapping
    public ModelAndView getRecommandation() {
        return new Dispatcher("recommandation/index").addObject("recommandations", recommandationService.getRecommandations());
    }

    @GetMapping("/form")
    public ModelAndView form() {
        return new Dispatcher("recommandation/form").addObject("produits", recommandationService.getProduitRepo().findAll());
    }

    @PostMapping
    public String insert(@ModelAttribute RecommandationRequest recommandationRequest) {
        recommandationService.save(recommandationRequest);

        return "redirect:/recommandations/form";
    }
}
