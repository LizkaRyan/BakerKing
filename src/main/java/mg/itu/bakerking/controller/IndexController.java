package mg.itu.bakerking.controller;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.dto.Chart;
import mg.itu.bakerking.service.transaction.vente.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {
    private VenteService venteService;
    @GetMapping
    public ModelAndView index(){
        return new Dispatcher("stock/index");
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(@RequestParam(value = "dateMin",required = false)LocalDate dateMin,
                                  @RequestParam(value = "dateMax",required = false)LocalDate dateMax){
        if(dateMin==null){
            dateMin=LocalDate.of(2022,1,1);
        }
        if(dateMax==null){
            dateMax=LocalDate.now();
        }
        return new Dispatcher("dashboard")
                .addObject("chiffreAffaire",venteService.findChiffreAffaire(dateMin,dateMax))
                .addObject("chiffreAffaireProductsChart", Chart.getChiffreAffaireProduitChar(venteService.findChiffreAffaireProduit(dateMin,dateMax)))
                .addObject("dateMin",dateMin)
                .addObject("chiffreAffaireProducts", venteService.findChiffreAffaireProduit(dateMin,dateMax))
                .addObject("dateMax",dateMax);
    }
}
