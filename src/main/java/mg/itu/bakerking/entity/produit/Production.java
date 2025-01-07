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
    @JoinColumn(name = "id_produit")
    private Produit produit;
    private LocalDate dateProduction;
    private int quantite;

}
