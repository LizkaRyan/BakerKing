package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.bakerking.entity.transaction.Transaction;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Vente extends Transaction {
    @OneToMany(fetch = FetchType.LAZY)
    protected List<VenteDetails> venteDetails;

    public Vente(LocalDate dateTransaction,List<VenteDetails> venteDetails){
        super(dateTransaction);
        this.setVenteDetails(venteDetails);
    }

    public void setVenteDetails(List<VenteDetails> venteDetails){
        this.venteDetails=venteDetails;
        double montant=0;
        for (VenteDetails venteDetail:venteDetails) {
            montant+= venteDetail.getMontant();
        }
        this.setMontant(montant);
    }
}
