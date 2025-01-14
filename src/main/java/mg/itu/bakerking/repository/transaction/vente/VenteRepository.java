package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.entity.transaction.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface VenteRepository extends JpaRepository<Vente,String> {
    @Query(value = "select nextval('seq_vente')",nativeQuery = true)
    public Long findId();

    @Query("""
            select sum(v.montant) from Vente v where :dateMin < v.dateTransaction and v.dateTransaction <= :dateMax
            """)
    public Optional<Double> findChiffreAffaire(@Param("dateMin")LocalDate dateMin,@Param("dateMax")LocalDate dateMax);
}
