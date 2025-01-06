package mg.itu.bakerking.entity.transaction.achat;

import jakarta.persistence.*;
import lombok.*;
import mg.itu.bakerking.entity.transaction.Transaction;
import mg.itu.bakerking.listener.transaction.AchatListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AchatListener.class)
public class Achat extends Transaction {
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "achat")
    @Getter(AccessLevel.PROTECTED)
    protected List<AchatDetails> achatDetails=new ArrayList<AchatDetails>();

    public List<AchatDetails> getAchatDetails() {
        return achatDetails;
    }

    public void setAchatDetails(List<AchatDetails> achatDetails){
        this.achatDetails=achatDetails;
    }

    public Achat(LocalDate date){
        this.setDateTransaction(date);
    }

    public void addAchatDetails(AchatDetails achatDetails){
        this.achatDetails.add(achatDetails);
        achatDetails.setAchat(this);
        this.setMontant(this.getMontant()+achatDetails.getMontant());
    }

    public void removeAchatDetails(AchatDetails achatDetails){
        this.achatDetails.remove(achatDetails);
        this.setMontant(this.getMontant()-achatDetails.getMontant());
    }
}