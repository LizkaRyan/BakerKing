package mg.itu.bakerking.dto.transaction;

import lombok.Data;
import mg.itu.bakerking.dto.produit.IngredientRequest;

import java.time.LocalDate;
import java.util.List;

@Data
public class AchatRequest {
    private LocalDate dateTransaction;
    private List<IngredientRequest> ingredients;
}
