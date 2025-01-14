package mg.itu.bakerking.dto.produit;

import lombok.Data;

import java.util.List;

@Data
public class RecommandationRequest {
    private int mois;
    private int annee;

    private List<String> idProduit;

}
