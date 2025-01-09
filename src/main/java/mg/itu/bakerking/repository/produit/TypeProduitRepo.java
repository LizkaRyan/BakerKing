package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.TypeProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeProduitRepo extends JpaRepository<TypeProduit, String> {

}
