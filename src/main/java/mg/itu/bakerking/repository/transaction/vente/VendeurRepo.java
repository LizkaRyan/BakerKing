package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.entity.personne.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendeurRepo extends JpaRepository<Vendeur, String> {

}
