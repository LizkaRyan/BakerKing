package mg.itu.bakerking.listener.transaction;

import jakarta.persistence.PrePersist;
import mg.itu.bakerking.entity.transaction.vente.Vente;
import mg.itu.bakerking.repository.transaction.vente.VenteRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class VenteListener {
    private VenteRepository venteRepo;
    public VenteListener(@Lazy VenteRepository venteRepo) {
        this.venteRepo = venteRepo;
    }

    @PrePersist
    public void prePersist(Vente vente){
        vente.setIdTransaction("VNT00"+venteRepo.findId());
    }
}
