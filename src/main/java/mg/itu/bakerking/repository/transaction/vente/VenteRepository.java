package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.entity.transaction.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<Vente,String> {
    @Query(value = "select nextval('seq_vente')",nativeQuery = true)
    public Long findId();

    @Query(value = "select nextval('seq_vente_details')",nativeQuery = true)
    public Long findIdDetails();
}
