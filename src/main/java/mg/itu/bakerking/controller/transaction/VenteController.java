package mg.itu.bakerking.controller.transaction;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.transaction.AchatDTO;
import mg.itu.bakerking.dto.transaction.VenteDTO;
import mg.itu.bakerking.service.produit.ProduitService;
import mg.itu.bakerking.service.transaction.vente.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/vente")
public class VenteController {

    private final ProduitService produitService;
    private final VenteService venteService;
    @GetMapping("/form")
    public ModelAndView form(){
        return new Dispatcher("transaction/vente/form").addObject("produits",produitService.getRepo().findAll());
    }

    @GetMapping
    public ModelAndView liste(){
        return new Dispatcher("transaction/vente/index").addObject("ventes",venteService.getVenteRepository().findAll());
    }

    @GetMapping("/details/{idVente}")
    public ModelAndView listeDetails(@PathVariable("idVente")String idVente){
        return new Dispatcher("transaction/vente/details.jsp").addObject("details",venteService.findById(idVente).getVenteDetails());
    }
    @PostMapping
    public String save(@Valid @ModelAttribute VenteDTO venteDTO){
        try{
            this.venteService.save(venteDTO);
        }
        catch (Exception ex){
            throw ex;
        }
        return "redirect:/achat";
    }

}
