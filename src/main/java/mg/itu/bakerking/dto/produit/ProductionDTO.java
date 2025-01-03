package mg.itu.bakerking.dto.produit;

import lombok.Data;
import mg.itu.bakerking.dto.stock.MvtStockDTO;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProductionDTO {
    List<MvtStockDTO> stockDTO;
    LocalDate date;
}
