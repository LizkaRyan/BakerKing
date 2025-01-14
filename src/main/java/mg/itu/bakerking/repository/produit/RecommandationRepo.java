package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommandationRepo extends JpaRepository<Recommandation, String> {
    @Query("""
            select r from Recommandation r where r.mois = :mois and r.annee = :annee         
            """)
    public List<Recommandation> getRecommandations(@Param("mois") int mois, @Param("annee") int annee);

    @Query(value = "select nextval('seq_recommandation')",nativeQuery = true)
    public Integer findId();
}
