package mg.itu.bakerking.entity.produit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TypeProduit
{
    private String typeProduit;

    @Id
    @GeneratedValue
    private String idTypeProduit;
}
