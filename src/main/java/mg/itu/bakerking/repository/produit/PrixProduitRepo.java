package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.PrixProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PrixProduitRepo extends JpaRepository<PrixProduit, String> {

    @Query("select p from PrixProduit p where p.datePrix <= :datePrix and p.produit.idProduit = :idProduit order by p.datePrix desc")
    public List<PrixProduit> getPrixProduit(@Param("datePrix") LocalDate datePrix, @Param("idProduit") String idProduit);

    @Query("""
    select p from PrixProduit p where p.produit.idProduit = :idProduit order by p.datePrix desc
    """)
    public List<PrixProduit> getPrixProduitsByIdProduit(@Param("idProduit") String idProduit);

}
