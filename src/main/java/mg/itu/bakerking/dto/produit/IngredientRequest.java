package mg.itu.bakerking.dto.produit;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IngredientRequest {
    @NotNull
    String idIngredient;
    @Min(value = 0)
    double quantite;
}
