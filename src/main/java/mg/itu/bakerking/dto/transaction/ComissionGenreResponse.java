package mg.itu.bakerking.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ComissionGenreResponse {

    private String idGenre;
    private String genre;
    private double montant;
}
