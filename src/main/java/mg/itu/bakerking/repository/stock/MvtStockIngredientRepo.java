package mg.itu.bakerking.repository.stock;

import mg.itu.bakerking.entity.stock.MvtStockIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MvtStockIngredientRepo extends JpaRepository<MvtStockIngredient,String> {
    @Query(value = "select nextval('seq_mvt_stock_ingredient')",nativeQuery = true)
    public Long findId();


}