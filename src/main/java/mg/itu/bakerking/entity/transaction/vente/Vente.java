package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.bakerking.entity.personne.Client;
import mg.itu.bakerking.entity.personne.Vendeur;
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vendeur")
    private Vendeur vendeur;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_commission")
    private Commission commission;

    public Vente(Vendeur vendeur, LocalDate dateTransaction,List<VenteDetails> venteDetails, Client client){
        super(dateTransaction);
        this.setVenteDetails(venteDetails);

        this.setClient(client);
        this.setVendeur(vendeur);
        this.setCommission(commission);
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
