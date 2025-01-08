package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductionRepo extends JpaRepository<Production,String> {
    @Query(value = """
        select pr from Production pr 
        inner join pr.produit p 
        where p.categorie.idCategorie = :idCategorie or true = :allCategorie
        """)
    public List<Production> getListProduction(@Param("idCategorie") String idCategorie,@Param("allCategorie") boolean allCategorie);
}
