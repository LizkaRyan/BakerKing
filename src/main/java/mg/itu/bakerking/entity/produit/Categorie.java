package mg.itu.bakerking.entity.produit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Categorie {
    @Id
    @GeneratedValue
    private String idCategorie;

    private String categorie;
}
