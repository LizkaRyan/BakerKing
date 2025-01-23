package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.dto.transaction.ComissionResponse;
import mg.itu.bakerking.entity.transaction.vente.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VenteRepository extends JpaRepository<Vente,String> {
    @Query(value = "select nextval('seq_vente')",nativeQuery = true)
    public Long findId();

    @Query("""
            select 
            new mg.itu.bakerking.dto.transaction.ComissionResponse(v.vendeur.nom,cast(sum(v.montant*v.commission.commission/100) as Double),v.vendeur.idVendeur) 
            from Vente v
            where :dateMin <= v.dateTransaction and v.dateTransaction <= :dateMax
            group by v.vendeur.nom,v.vendeur.idVendeur
            """)
    public List<ComissionResponse> findCommission(@Param("dateMin")LocalDate dateMin,@Param("dateMax")LocalDate dateMax);

    @Query("""
            select sum(v.montant) from Vente v where :dateMin < v.dateTransaction and v.dateTransaction <= :dateMax
            """)
    public Optional<Double> findChiffreAffaire(@Param("dateMin")LocalDate dateMin,@Param("dateMax")LocalDate dateMax);

    @Query("""
            select v from Vente v where (v.client.idClient = :idClient or :idClient = 'Tous') and v.dateTransaction = :date 
            """)
    public List<Vente> findVente(@Param("idClient")String idClient, @Param("date")LocalDate date);

    @Query("""
    select new mg.itu.bakerking.dto.transaction.ComissionResponse(v.vendeur.nom, cast((sum(v.montant)*5/100) as Double), v.vendeur.idVendeur) from 
    Vente v where :dateMin <= v.dateTransaction and v.dateTransaction <= :dateMax group by v.vendeur.nom, v.vendeur.idVendeur
    """)
    public List<ComissionResponse> getComission(@Param("dateMin") LocalDate dateMin, @Param("dateMax") LocalDate dateMax);

    @Query("""
    select v from 
    Vente v where :dateMin <= v.dateTransaction and v.dateTransaction <= :dateMax and v.vendeur.idVendeur = :idVendeur 
    """)
    public List<Vente> getComission(@Param("dateMin") LocalDate dateMin, @Param("dateMax") LocalDate dateMax, @Param("idVendeur") String idVendeur);
}
