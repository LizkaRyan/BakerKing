package mg.itu.bakerking.dto.transaction;

import lombok.Data;
import mg.itu.bakerking.dto.produit.IngredientDTO;

import java.time.LocalDate;
import java.util.List;

@Data
public class AchatDTO {
    private LocalDate dateTransaction;
    private List<IngredientDTO> ingredients;
}
