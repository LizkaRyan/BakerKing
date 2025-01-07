package mg.itu.bakerking.controller.produit;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.produit.ProductionDTO;
import mg.itu.bakerking.repository.produit.ProduitRepo;
import mg.itu.bakerking.service.stock.MvtProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/produit")
public class ProduitController {
    private MvtProduitService produitService;
    private ProduitRepo produitRepo;

    @GetMapping("/form")
    public ModelAndView index(){
        return new Dispatcher("stock/production").addObject("produits",produitRepo.findAll());
    }

    @PostMapping
    public String insert(@ModelAttribute ProductionDTO productionDTO){
        produitService.save(productionDTO.getStockDTO());
        return "redirect:/produit/form";
    }
}
