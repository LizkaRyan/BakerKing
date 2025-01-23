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
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class RecommandationService {
    private RecommandationRepo recommandationRepo;
    private ProduitRepo produitRepo;

    public List<Recommandation> getRecommandations(Integer mois, Integer annee) {

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

    public List<String> getMonths() {
        List<String> list = new ArrayList<>();
        list.add("Tous");
        list.add("Janvier");
        list.add("Fevrier");
        list.add("Mars");
        list.add("Avril");
        list.add("Mai");
        list.add("Juin");
        list.add("Juillet");
        list.add("Aout");
        list.add("Septembre");
        list.add("Octobre");
        list.add("Novembre");
        list.add("Decembre");

        return list;
    }

}
