package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredient,String> {

}
