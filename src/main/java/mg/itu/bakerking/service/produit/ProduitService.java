package mg.itu.bakerking.service.produit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import mg.itu.bakerking.entity.produit.IngredientProduit;
import mg.itu.bakerking.entity.produit.Production;
import mg.itu.bakerking.entity.produit.Produit;
import mg.itu.bakerking.repository.produit.IngredientProduitRepo;
import mg.itu.bakerking.repository.produit.ProduitRepo;
import mg.itu.bakerking.service.stock.MvtProduitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class ProduitService {
    private ProduitRepo repo;

    private MvtProduitService mvtProduitService;

    public Produit findByIdProduit(String idProduit){
        return repo.findById(idProduit).orElseThrow(()->new RuntimeException("Id Produit non reconnue"));
    }
}
