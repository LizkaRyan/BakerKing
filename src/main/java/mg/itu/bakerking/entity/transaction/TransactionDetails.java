package mg.itu.bakerking.entity.transaction;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TransactionDetails {
    @Id
    private String idDetails;

    private double quantite;

    private double prixUnitaire;

    public TransactionDetails(String idDetails,double quantite,double prixUnitaire){
        this.setIdDetails(idDetails);
        this.setPrixUnitaire(prixUnitaire);
        this.setQuantite(quantite);
    }

    public double getMontant(){
        return this.prixUnitaire*this.quantite;
    }
}
