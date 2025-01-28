package mg.itu.bakerking.service.transaction.vente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mg.itu.bakerking.dto.produit.ProduitRequest;
import mg.itu.bakerking.entity.produit.Produit;
import mg.itu.bakerking.entity.transaction.vente.VenteDetails;
import mg.itu.bakerking.exception.InsuficientStockException;
import mg.itu.bakerking.repository.produit.PrixProduitRepo;
import mg.itu.bakerking.repository.transaction.vente.VenteDetailRepository;
import mg.itu.bakerking.service.produit.ProduitService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
@Getter
public class VenteDetailsService {
    private VenteDetailRepository venteDetailRepository;
    private ProduitService produitService;
    private VenteDetailRepository venteDetailRepo;
    private PrixProduitRepo prixProduitRepo;

    public VenteDetails createVenteDetails(ProduitRequest produitDTO, LocalDate dateTransaction)throws InsuficientStockException {
        Produit produit = produitService.findByIdProduit(produitDTO.getIdProduit());
        double etatStock=produitService.getMvtProduitService().findEtatStock(produitDTO.getIdProduit());
//        if(etatStock< produitDTO.getQuantite()){
//            throw new InsuficientStockException(etatStock, produitDTO.getQuantite(), produit.getProduit());
//        }
        return new VenteDetails("VTD00"+venteDetailRepo.findIdDetails(), produitDTO.getQuantite(), prixProduitRepo.getPrixProduit(dateTransaction, produitDTO.getIdProduit()).get(0).getPrixUnitaire(),produit);
    }
}
