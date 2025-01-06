package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.bakerking.entity.transaction.Transaction;
import mg.itu.bakerking.listener.transaction.VenteListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(VenteListener.class)
public class Vente extends Transaction {
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "vente")
    protected List<VenteDetails> venteDetails;

    public Vente(LocalDate dateTransaction,List<VenteDetails> venteDetails){
        super(dateTransaction);
        this.setVenteDetails(venteDetails);
    }

    public void setVenteDetails(List<VenteDetails> venteDetails){
        this.venteDetails=venteDetails;
        double montant=0;
        for (VenteDetails venteDetail:venteDetails) {
            venteDetail.setVente(this);
            montant+= venteDetail.getMontant();
        }
        this.setMontant(montant);
    }
}
