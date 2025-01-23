package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.entity.transaction.vente.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendeurRepo extends JpaRepository<Vendeur, String> {

}
