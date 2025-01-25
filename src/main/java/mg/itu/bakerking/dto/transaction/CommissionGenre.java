package mg.itu.bakerking.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommissionGenre {

    private String idGenre;
    private String genre;
    private double montant;
}
