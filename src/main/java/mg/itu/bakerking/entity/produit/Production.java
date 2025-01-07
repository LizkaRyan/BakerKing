package mg.itu.bakerking.entity.produit;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Production {

    @Id
    @GeneratedValue
    private String idProduction;

    @ManyToOne(fetch = FetchType.LAZY)
    private Produit produit;
    private LocalDate dateProduit;
    private int quantite;

}
