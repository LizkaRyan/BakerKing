package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.dto.transaction.ChiffreAffaireProduit;
import mg.itu.bakerking.entity.transaction.vente.VenteDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VenteDetailRepository extends JpaRepository<VenteDetails, String> {
    @Query("""
                        select vd from VenteDetails vd where (vd.produit.typeProduit.idTypeProduit=:idTypeProduit or :idTypeProduit = 'Tous') and (
                        vd.produit.categorie.idCategorie=:idCategorie or :idCategorie = 'Tous')
                    """)
    public List<VenteDetails> findByCategorie(@Param("idTypeProduit") String idTypeProduit, @Param("idCategorie") String idCategorie);

    @Query(value = "select nextval('seq_vente_details')",nativeQuery = true)
    public Long findIdDetails();

    @Query("""
            select 
            new mg.itu.bakerking.dto.transaction.ChiffreAffaireProduit(vd.produit.produit,cast(sum(vd.prixUnitaire*vd.quantite) as Double)) 
            from VenteDetails vd 
            inner join vd.vente v 
            where :dateMin < v.dateTransaction and v.dateTransaction <= :dateMax
            group by vd.produit.produit
            """)
    public List<ChiffreAffaireProduit> findChiffreAffaireEachProduct(@Param("dateMin")LocalDate dateMin, @Param("dateMax")LocalDate dateMax);
}
