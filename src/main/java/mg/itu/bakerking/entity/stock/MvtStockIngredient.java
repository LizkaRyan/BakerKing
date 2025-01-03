package mg.itu.bakerking.entity.stock;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mg.itu.bakerking.entity.produit.Ingredient;
import mg.itu.bakerking.listener.transaction.MvtStockIngredientListener;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(MvtStockIngredientListener.class)
public class MvtStockIngredient extends MvtStock{
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;

    public MvtStockIngredient(LocalDate date,String description){
        this.setDateMvt(date);
        this.setDescription(description);
    }
}