package mg.itu.bakerking.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChiffreAffaireProduit {
    private String produit;
    private double chiffreAffaire;
}
