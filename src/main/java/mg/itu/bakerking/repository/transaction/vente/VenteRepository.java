package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.entity.transaction.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente,String> {
}
