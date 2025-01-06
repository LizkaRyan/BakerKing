package mg.itu.bakerking.controller.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.transaction.AchatDTO;
import mg.itu.bakerking.dto.transaction.VenteDTO;
import mg.itu.bakerking.service.produit.ProduitService;
import mg.itu.bakerking.service.transaction.vente.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/vente")
public class VenteController {

    private final ProduitService produitService;
    private final VenteService venteService;
    @GetMapping("/form")
    public ModelAndView form(){
        return new Dispatcher("transaction/vente/form.jsp").addObject("ingredients",produitService.getRepo().findAll());
    }

    @PostMapping
    public String save(@ModelAttribute VenteDTO venteDTO){
        try{
            this.venteService.save(venteDTO);
        }
        catch (Exception ex){
            throw ex;
        }
        return "redirect:/achat";
    }

}
