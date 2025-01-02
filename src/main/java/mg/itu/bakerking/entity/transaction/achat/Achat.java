package mg.itu.bakerking.entity.transaction.achat;

import jakarta.persistence.*;
import lombok.Data;
import mg.itu.bakerking.entity.transaction.Transaction;

import java.util.List;

@Entity
public class Achat extends Transaction {
    @OneToMany(fetch = FetchType.LAZY)
    public List<AchatDetails> achatDetails;

    public List<AchatDetails> getAchatDetails() {
        return achatDetails;
    }

    public void setAchatDetails(List<AchatDetails> achatDetails){
        this.achatDetails=achatDetails;
    }
}
