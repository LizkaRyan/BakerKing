package mg.itu.bakerking.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comission {
    private String nom;

    private double montant;

    private String idVendeur;
}
