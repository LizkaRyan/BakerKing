package mg.itu.bakerking.dto.transaction;

import lombok.Data;
import mg.itu.bakerking.dto.produit.ProduitDTO;

import java.time.LocalDate;
import java.util.List;

@Data
public class VenteDTO {

    private LocalDate dateTransaction;
    private List<ProduitDTO> produits;
}
