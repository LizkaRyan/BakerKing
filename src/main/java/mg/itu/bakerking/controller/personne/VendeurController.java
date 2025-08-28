package mg.itu.bakerking.controller.personne;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.controller.affichage.Dispatcher;
import mg.itu.bakerking.entity.personne.Role;
import mg.itu.bakerking.service.personne.VendeurService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/vendeur")
public class VendeurController {

    private VendeurService vendeurService;

    @GetMapping("/gestion-roles")
    public ModelAndView gestionRoles() {
        return new Dispatcher("personne/gestion-roles")
                .addObject("vendeurs", vendeurService.getAllVendeurs())
                .addObject("roles", Role.values());
    }

    @PostMapping("/update-role")
    public String updateRole(@RequestParam String vendeurId, @RequestParam Role role) {
        vendeurService.updateRole(vendeurId, role);
        return "redirect:/vendeur/gestion-roles";
    }
}