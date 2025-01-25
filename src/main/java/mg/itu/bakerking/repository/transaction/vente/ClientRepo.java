package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.entity.personne.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, String> {

}
