package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.Recommandation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecommandationRepo extends JpaRepository<Recommandation, String> {
    @Query("""
            select r from Recommandation r where (r.annee = :annee or 0 = :annee) and (0 = :mois or r.mois = :mois) order by r.mois asc           
            """)
    public List<Recommandation> getRecommandations(@Param("mois") Integer mois, @Param("annee") Integer annee);

    @Query(value = "select nextval('seq_recommandation')",nativeQuery = true)
    public Integer findId();
}
