package mg.itu.bakerking.service.stock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mg.itu.bakerking.dto.produit.ProductionRequest;
import mg.itu.bakerking.dto.produit.ProduitRequest;
import mg.itu.bakerking.entity.produit.IngredientProduit;
import mg.itu.bakerking.entity.stock.MvtStockProduit;
import mg.itu.bakerking.repository.produit.IngredientProduitRepo;
import mg.itu.bakerking.repository.produit.ProduitRepo;
import mg.itu.bakerking.repository.stock.MvtStockProduitRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class MvtProduitService {
    private MvtStockProduitRepo repo;
    private IngredientProduitRepo ingrepo;
    private ProduitRepo produitrepo;

    public boolean isAvailable(String idProduit,double quantite){
        Double quantiteStock=this.findEtatStock(idProduit);
        return quantiteStock>=quantite;
    }

    public Double findEtatStock(String idProduit){
        return repo.findEtatStock(idProduit).orElse(0d);
    }

    public List<MvtStockProduit> save(ProductionRequest productionDTO) {
        List<ProduitRequest> stock=productionDTO.getStockDTO();
        List<MvtStockProduit> mvtStockProduits=new ArrayList<>();
        for (ProduitRequest m: stock) {
            List<IngredientProduit> ingpro = ingrepo.findByIdProduit(m.getIdProduit());
            for (IngredientProduit i: ingpro) {
                /*if (repo.findEtatStock(i.getIngredient().getIdIngredient()) < i.getQuantite()* m.getQuantite()){
                    throw new RuntimeException("Stock insuffisant");
                }*/
            }

            MvtStockProduit mvtStockProduit = new MvtStockProduit();
            mvtStockProduit.setProduit(produitrepo.findById(m.getIdProduit()).orElseThrow(()->new RuntimeException("Id non reconnu")));
            mvtStockProduit.setDateMvt(productionDTO.getDate());
            mvtStockProduit.setEntree(m.getQuantite());
            mvtStockProduit.setDescription("Production");
            mvtStockProduits.add(repo.save(mvtStockProduit));
        }
        return mvtStockProduits;
    }
}
