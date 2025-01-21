package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
}
