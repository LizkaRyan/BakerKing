package mg.itu.bakerking.repository.produit;

import mg.itu.bakerking.entity.produit.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepo extends JpaRepository<Categorie,String> {
}
