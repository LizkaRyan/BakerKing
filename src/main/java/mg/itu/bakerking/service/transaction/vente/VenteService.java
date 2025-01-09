package mg.itu.bakerking.service.transaction.vente;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import mg.itu.bakerking.dto.produit.ProduitDTO;
import mg.itu.bakerking.dto.transaction.VenteDTO;
import mg.itu.bakerking.entity.produit.Produit;
import mg.itu.bakerking.entity.transaction.vente.Vente;
import mg.itu.bakerking.entity.transaction.vente.VenteDetails;
import mg.itu.bakerking.repository.transaction.vente.VenteDetailRepository;
import mg.itu.bakerking.repository.transaction.vente.VenteRepository;
import mg.itu.bakerking.service.produit.ProduitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@AllArgsConstructor
public class VenteService {
    private VenteRepository venteRepository;

    private ProduitService produitService;
    private VenteDetailRepository venteDetailRepo;

    @Transactional
    public Vente save(VenteDTO venteDTO){
        List<VenteDetails> venteDetails=new ArrayList<>();
        for (ProduitDTO produitDTO: venteDTO.getProduits()) {
            Produit produit= produitService.findByIdProduit(produitDTO.getIdProduit());
            /*if(!produitService.getMvtProduitService().isAvailable(produitDTO.getIdProduit(), produitDTO.getQuantite())){
                throw new RuntimeException("Stock insuffisante pour "+produit.getProduit());
            }*/
            venteDetails.add(new VenteDetails("VTD00"+venteRepository.findIdDetails(), produitDTO.getQuantite(),produit.getPrixUnitaire(),produit));
        }
        Vente vente=new Vente(venteDTO.getDateTransaction(),venteDetails);
        return venteRepository.save(vente);
    }

    public Vente findById(String idVente){
        return this.venteRepository.findById(idVente).orElseThrow(()->new RuntimeException("Id Vente non reconnue"));
    }

    public List<VenteDetails> findVenteDetailsByCategorie(String idTypeProduit, String idCategorie) {
        List<VenteDetails> list = venteDetailRepo.findByCategorie(idTypeProduit, idCategorie);
        return list;
    }
}
