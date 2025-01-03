package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.entity.produit.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepo extends JpaRepository<Produit,String>  {

}
