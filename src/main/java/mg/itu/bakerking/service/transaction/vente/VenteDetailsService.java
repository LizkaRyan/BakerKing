package mg.itu.bakerking.service.transaction.vente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mg.itu.bakerking.dto.produit.ProduitRequest;
import mg.itu.bakerking.entity.produit.Produit;
import mg.itu.bakerking.entity.transaction.vente.VenteDetails;
import mg.itu.bakerking.exception.InsuficientStockException;
import mg.itu.bakerking.repository.transaction.vente.VenteDetailRepository;
import mg.itu.bakerking.service.produit.ProduitService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
public class VenteDetailsService {
    private VenteDetailRepository venteDetailRepository;
    private ProduitService produitService;
    private VenteDetailRepository venteDetailRepo;

    public VenteDetails createVenteDetails(ProduitRequest produitDTO)throws InsuficientStockException {
        Produit produit = produitService.findByIdProduit(produitDTO.getIdProduit());
        double etatStock=produitService.getMvtProduitService().findEtatStock(produitDTO.getIdProduit());
        if(etatStock< produitDTO.getQuantite()){
            throw new InsuficientStockException(etatStock, produitDTO.getQuantite(), produit.getProduit());
        }
        return new VenteDetails("VTD00"+venteDetailRepo.findIdDetails(), produitDTO.getQuantite(),produit.getPrixUnitaire(),produit);
    }
}
