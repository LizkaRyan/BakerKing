package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue
    private String idGenre;

    private String genre;
}
