package mg.itu.bakerking.service.transaction.vente;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import mg.itu.bakerking.dto.produit.ProduitRequest;
import mg.itu.bakerking.dto.transaction.ChiffreAffaireProduit;
import mg.itu.bakerking.dto.transaction.VenteRequest;
import mg.itu.bakerking.entity.transaction.vente.Vente;
import mg.itu.bakerking.entity.transaction.vente.VenteDetails;
import mg.itu.bakerking.exception.CreationVenteException;
import mg.itu.bakerking.exception.InsuficientStockException;
import mg.itu.bakerking.repository.transaction.vente.ClientRepo;
import mg.itu.bakerking.repository.transaction.vente.VenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@AllArgsConstructor
public class VenteService {
    private VenteRepository venteRepository;

    private VenteDetailsService venteDetailsService;

    private ClientRepo clientRepo;

    public List<Vente> getVentes(String idClient, LocalDate date) {
        List<Vente> ventes = venteRepository.findVente(idClient, date);
        return ventes;
    }

    @Transactional
    public Vente save(VenteRequest venteDTO)throws CreationVenteException{
        List<VenteDetails> venteDetails=new ArrayList<>();
        List<InsuficientStockException> exceptions=new ArrayList<InsuficientStockException>();
        for (ProduitRequest produitDTO: venteDTO.getProduits()) {
            try{
                venteDetails.add(venteDetailsService.createVenteDetails(produitDTO));
            }
            catch (InsuficientStockException ex){
                exceptions.add(ex);
            }
        }
        if(exceptions.size()!=0){
            throw new CreationVenteException(exceptions);
        }
        Vente vente=new Vente(venteDTO.getDateTransaction(),venteDetails, clientRepo.findById(venteDTO.getIdClient()).orElseThrow(()-> new RuntimeException("Id client non retrouvé")));
        return venteRepository.save(vente);
    }

    public Vente findById(String idVente){
        return this.venteRepository.findById(idVente).orElseThrow(()->new RuntimeException("Id Vente non reconnue"));
    }

    public List<VenteDetails> findVenteDetailsByCategorie(String idTypeProduit, String idCategorie) {
        return venteDetailsService.getVenteDetailRepo().findByCategorie(idTypeProduit, idCategorie);
    }

    public Double findChiffreAffaire(LocalDate dateMin,LocalDate dateMax){
        return this.venteRepository.findChiffreAffaire(dateMin,dateMax).orElse(0d);
    }

    public List<ChiffreAffaireProduit> findChiffreAffaireProduit(LocalDate dateMin,LocalDate dateMax){
        return this.venteDetailsService.getVenteDetailRepository().findChiffreAffaireEachProduct(dateMin,dateMax);
    }
}
