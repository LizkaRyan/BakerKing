package mg.itu.bakerking.entity.produit.id;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Data
public class IdIngredientProduit implements Serializable {
    private String idIngredient;
    private String idProduit;
}
