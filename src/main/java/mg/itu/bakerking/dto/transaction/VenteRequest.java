package mg.itu.bakerking.dto.transaction;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mg.itu.bakerking.dto.produit.ProduitRequest;

import java.time.LocalDate;
import java.util.List;

@Data
public class VenteRequest {

    @NotNull
    private LocalDate dateTransaction;
    @Valid
    private List<ProduitRequest> produits;

    private String idClient;

    private String idVendeur;
}
