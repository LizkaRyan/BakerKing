package mg.itu.bakerking.controller.transaction;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.transaction.VenteRequest;
import mg.itu.bakerking.exception.CreationVenteException;
import mg.itu.bakerking.repository.transaction.vente.ClientRepo;
import mg.itu.bakerking.service.produit.ProduitService;
import mg.itu.bakerking.service.transaction.vente.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
@RequestMapping("/vente")
public class VenteController {

    private final ProduitService produitService;
    private final VenteService venteService;
    private ClientRepo clientRepo;
    @GetMapping("/form_vente")
    public ModelAndView form(){
        return new Dispatcher("transaction/vente/form").addObject("produits",produitService.getRepo().findAll())
                .addObject("clients", clientRepo.findAll());
    }

    @GetMapping
    public ModelAndView liste(@RequestParam(value = "idClient") String idClient, @RequestParam(value = "date", required = false) LocalDate date){
        if(date == null) {
            date = LocalDate.now();
        }
        return new Dispatcher("transaction/vente/index").addObject("ventes", venteService.getVentes(idClient, date))
                .addObject("clients", clientRepo.findAll());
    }



    @GetMapping("/details/{idVente}")
    public ModelAndView listeDetails(@PathVariable("idVente")String idVente){
        return new Dispatcher("transaction/vente/details.jsp").addObject("details",venteService.findById(idVente).getVenteDetails());
    }
    @PostMapping
    public Object save(@ModelAttribute VenteRequest venteDTO){
        try{
            this.venteService.save(venteDTO);
        }
        catch (CreationVenteException ex){
            return new Dispatcher("transaction/vente/form")
                    .addObject("exception",ex)
                    .addObject("produits",produitService.getRepo().findAll());
        }
        return "redirect:/vente/filter?idTypeProduit=Tous&idCategorie=Tous";
    }

    @GetMapping("/filter")
    public ModelAndView filter(@RequestParam(value = "idTypeProduit", required = false) String idTypeProduit, @RequestParam(value = "idCategorie", required = false) String idCategorie) {
        return new Dispatcher("transaction/vente/listFilter")
                .addObject("details", venteService.findVenteDetailsByCategorie(idTypeProduit, idCategorie))
                .addObject("categories", produitService.getCategorieRepo().findAll())
                .addObject("TypeProduits", produitService.getTypeProduitRepo().findAll())
                .addObject("idTypeProduit", idTypeProduit)
                .addObject("idCategorie", idCategorie);
    }

}
