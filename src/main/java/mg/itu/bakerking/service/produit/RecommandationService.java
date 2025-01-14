package mg.itu.bakerking.service.produit;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import mg.itu.bakerking.dto.produit.RecommandationRequest;
import mg.itu.bakerking.entity.produit.Recommandation;
import mg.itu.bakerking.repository.produit.ProduitRepo;
import mg.itu.bakerking.repository.produit.RecommandationRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class RecommandationService {
    private RecommandationRepo recommandationRepo;
    private ProduitRepo produitRepo;

    public List<Recommandation> getRecommandations(int mois, int annee) {

        return recommandationRepo.getRecommandations(mois, annee);
    }

    @Transactional
    public void save(RecommandationRequest recommandationRequest) {
        for (String idProduit : recommandationRequest.getIdProduit()) {
            Recommandation recommandation = new Recommandation();
            recommandation.setMois(recommandationRequest.getMois());
            recommandation.setAnnee(recommandationRequest.getAnnee());
            recommandation.setProduit(produitRepo.findById(idProduit).orElseThrow(()->new RuntimeException("Id produit non retrouvé")));

            recommandationRepo.save(recommandation);
        }
    }

}
