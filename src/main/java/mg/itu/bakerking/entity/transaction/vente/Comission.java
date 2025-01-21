package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Comission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComission;
    private double montant;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vendeur")
    private Vendeur vendeur;

    private LocalDate dateComission;

}
