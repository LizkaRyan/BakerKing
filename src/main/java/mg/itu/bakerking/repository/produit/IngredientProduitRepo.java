package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.IngredientProduit;
import mg.itu.bakerking.entity.produit.id.IdIngredientProduit;
import mg.itu.bakerking.entity.stock.MvtStockIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientProduitRepo extends JpaRepository<IngredientProduit, IdIngredientProduit> {
    @Query(value = "select * from ingredient_produit where id_produit=:idProduit", nativeQuery = true)
    public List<IngredientProduit> ingPro(@Param("idProduit") String idProduit);
}
