package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.bakerking.entity.transaction.Transaction;
import mg.itu.bakerking.listener.transaction.VenteListener;

import javax.lang.model.element.Name;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(VenteListener.class)
public class Vente extends Transaction {
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "vente")
    protected List<VenteDetails> venteDetails;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;

    public Vente(LocalDate dateTransaction,List<VenteDetails> venteDetails, Client client){
        super(dateTransaction);
        this.setVenteDetails(venteDetails);
        this.setClient(client);
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
