package mg.itu.bakerking.repository.stock;

import mg.itu.bakerking.entity.stock.MvtStockIngredient;
import mg.itu.bakerking.entity.stock.MvtStockProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MvtStockProduitRepo extends JpaRepository<MvtStockProduit,String> {

    @Query(value = "select nextval('seq_mvt_stock_produit')",nativeQuery = true)
    public Long findId();

    @Query(value = "select SUM(entree-sortie) as s from mvt_stock_produit where id_produit=:idProduit", nativeQuery = true)
    public Optional<Double> findEtatStock(@Param("idProduit") String idProduit);
}
