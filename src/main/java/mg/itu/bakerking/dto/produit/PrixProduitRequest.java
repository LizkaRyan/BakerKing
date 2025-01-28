package mg.itu.bakerking.dto.produit;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrixProduitRequest {

    private String idProduit;
    private double prixUnitaire;
    private LocalDate datePrix;

}
