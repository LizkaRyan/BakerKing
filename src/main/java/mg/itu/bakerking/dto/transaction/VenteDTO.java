package mg.itu.bakerking.dto.transaction;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mg.itu.bakerking.dto.produit.ProduitDTO;

import java.time.LocalDate;
import java.util.List;

@Data
public class VenteDTO {

    @NotNull
    private LocalDate dateTransaction;
    @Valid
    private List<ProduitDTO> produits;
}
