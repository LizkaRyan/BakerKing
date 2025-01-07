package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.entity.produit.IngredientProduit;
import mg.itu.bakerking.entity.produit.Production;
import mg.itu.bakerking.entity.produit.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepo extends JpaRepository<Produit,String>  {

}
