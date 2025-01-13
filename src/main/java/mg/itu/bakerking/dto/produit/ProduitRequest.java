package mg.itu.bakerking.dto.produit;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class ProduitRequest {
    String idProduit;
    @Min(value = 0)
    double quantite;
}
