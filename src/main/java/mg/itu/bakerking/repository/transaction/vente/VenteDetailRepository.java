package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.entity.transaction.vente.VenteDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenteDetailRepository extends JpaRepository<VenteDetails, String> {
    @Query("""
                        select vd from VenteDetails vd where (vd.produit.typeProduit.idTypeProduit=:idTypeProduit or :idTypeProduit = 'Tous') and (
                        vd.produit.categorie.idCategorie=:idCategorie or :idCategorie = 'Tous')
                    """)
    public List<VenteDetails> findByCategorie(@Param("idTypeProduit") String idTypeProduit, @Param("idCategorie") String idCategorie);
}
