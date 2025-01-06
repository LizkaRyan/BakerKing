package mg.itu.bakerking.dto.produit;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IngredientDTO {
    @NotNull
    String idIngredient;
    @Min(value=0,message = "Quantite doit etre supérieur a 0")
    double quantite;
}
