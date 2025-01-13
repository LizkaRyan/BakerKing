package mg.itu.bakerking.exception;

import lombok.Data;

import java.util.List;

@Data
public class CreationVenteException extends RuntimeException{
    List<InsuficientStockException> insuficientStockExceptions;

    public CreationVenteException(List<InsuficientStockException> insuficientStockExceptions){
        super("Impossible de faire cette transaction car certain(es) produit(s) ne sont pas disponible");
        this.setInsuficientStockExceptions(insuficientStockExceptions);
    }
}
