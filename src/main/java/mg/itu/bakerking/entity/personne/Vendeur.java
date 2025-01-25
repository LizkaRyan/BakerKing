package mg.itu.bakerking.entity.personne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vendeur {

    @Id
    @GeneratedValue
    private String idVendeur;
    private String nom;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_genre")
    private Genre genre;
}
