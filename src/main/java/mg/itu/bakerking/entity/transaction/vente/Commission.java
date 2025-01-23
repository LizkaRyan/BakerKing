package mg.itu.bakerking.entity.transaction.vente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false)
    private String idCommission;
    private double commission;

    public Commission(double commission){
        this.commission=commission;
    }
}
