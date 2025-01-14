package mg.itu.bakerking.dto.produit;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProductionRequest {
    List<ProduitRequest> stockDTO;
    LocalDate date;
}
