package mg.itu.bakerking.service.personne;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.entity.personne.Role;
import mg.itu.bakerking.entity.personne.Vendeur;
import mg.itu.bakerking.repository.transaction.vente.VendeurRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VendeurService {

    private VendeurRepo vendeurRepo;

    public List<Vendeur> getAllVendeurs() {
        return vendeurRepo.findAll();
    }

    public Vendeur findById(String id) {
        return vendeurRepo.findById(id).orElseThrow(() -> new RuntimeException("Vendeur non trouvé"));
    }

    public void updateRole(String vendeurId, Role role) {
        Vendeur vendeur = findById(vendeurId);
        vendeur.setRole(role);
        vendeurRepo.save(vendeur);
    }

    public boolean isAdmin(String vendeurId) {
        Vendeur vendeur = findById(vendeurId);
        return vendeur.getRole() == Role.ADMIN;
    }
}