package mg.itu.bakerking.service.transaction.vente;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import mg.itu.bakerking.dto.Config;
import mg.itu.bakerking.dto.produit.ProduitRequest;
import mg.itu.bakerking.dto.transaction.ChiffreAffaireProduit;
import mg.itu.bakerking.dto.transaction.CommissionGenre;
import mg.itu.bakerking.dto.transaction.ComissionResponse;
import mg.itu.bakerking.dto.transaction.VenteRequest;
import mg.itu.bakerking.entity.transaction.vente.Commission;
import mg.itu.bakerking.entity.transaction.vente.Vente;
import mg.itu.bakerking.entity.transaction.vente.VenteDetails;
import mg.itu.bakerking.exception.CreationVenteException;
import mg.itu.bakerking.exception.InsuficientStockException;
import mg.itu.bakerking.repository.transaction.vente.ClientRepo;
import mg.itu.bakerking.repository.transaction.vente.CommissionRepo;
import mg.itu.bakerking.repository.transaction.vente.VendeurRepo;
import mg.itu.bakerking.repository.transaction.vente.VenteRepository;
import mg.itu.bakerking.service.ConfigService;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

    private VendeurRepo vendeurRepo;

    private CommissionRepo commissionRepo;

    private ConfigService configService;

    public List<Vente> getVentes(String idClient, LocalDate date) {
        List<Vente> ventes = venteRepository.findVente(idClient, date);
        return ventes;
    }

    public List<ComissionResponse> getComissions(LocalDate dateMin, LocalDate dateMax) {
        List<ComissionResponse> comissions = venteRepository.findCommission(dateMin, dateMax);
        return comissions;
    }

    public List<CommissionGenre> getComissionGenre(LocalDate dateMin, LocalDate dateMax) {

        return venteRepository.findCommissionByGenre(dateMin, dateMax);

    }

    public List<Vente> getComissionGenre(LocalDate dateMin, LocalDate dateMax, String idGenre) {

        return venteRepository.getComissionByGenre(dateMin, dateMax, idGenre);

    }

    @Transactional
    public Vente save(VenteRequest venteDTO)throws CreationVenteException, IOException {
        List<VenteDetails> venteDetails=new ArrayList<>();
        List<InsuficientStockException> exceptions=new ArrayList<InsuficientStockException>();

        for (ProduitRequest produitDTO: venteDTO.getProduits()) {
            try{
                venteDetails.add(venteDetailsService.createVenteDetails(produitDTO, venteDTO.getDateTransaction()));
            }
            catch (InsuficientStockException ex){
                exceptions.add(ex);
            }
        }
        if(exceptions.size()!=0){
            throw new CreationVenteException(exceptions);
        }

        Vente vente=new Vente(
                vendeurRepo.findById(venteDTO.getIdVendeur()).orElseThrow(()-> new RuntimeException("idVendeur non reconnu")),
                venteDTO.getDateTransaction(),
                venteDetails,
                clientRepo.findById(venteDTO.getIdClient()).orElseThrow(()-> new RuntimeException("Id client non retrouvé")));
        Config config=configService.readProperty();
        double comission = config.getCommissiontaux();
        if(vente.getMontant() <= config.getCommissionMin()){
            comission = 0;
        }

        Commission commission1 = commissionRepo.findCommissionByCommission(comission).orElse(new Commission(comission));

        vente.setCommission(commission1);
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
