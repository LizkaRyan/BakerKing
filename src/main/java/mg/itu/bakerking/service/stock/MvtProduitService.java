package mg.itu.bakerking.service.stock;

import mg.itu.bakerking.dto.stock.MvtStockDTO;
import mg.itu.bakerking.entity.produit.IngredientProduit;
import mg.itu.bakerking.entity.stock.MvtStockProduit;
import mg.itu.bakerking.repository.produit.IngredientProduitRepo;
import mg.itu.bakerking.repository.produit.ProduitRepo;
import mg.itu.bakerking.repository.stock.MvtStockProduitRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MvtProduitService {
    private MvtStockProduitRepo repo;
    private IngredientProduitRepo ingrepo;
    private ProduitRepo produitrepo;

    public MvtProduitService(MvtStockProduitRepo repo, IngredientProduitRepo ingrepo, ProduitRepo produitrepo) {
        this.repo = repo;
        this.ingrepo = ingrepo;
        this.produitrepo = produitrepo;
    }

    public void save(List<MvtStockDTO> stock) {
        for (MvtStockDTO m: stock) {
            List<IngredientProduit> ingpro = ingrepo.ingPro(m.getIdProduit());
            for (IngredientProduit i: ingpro) {
                /*if (repo.quantiteFinal(i.getIngredient().getIdIngredient()) < i.getQuantite()* m.getQuantite()){
                    throw new RuntimeException("Stock insuffisant");
                }*/
            }

            MvtStockProduit mvtStockProduit = new MvtStockProduit();
            mvtStockProduit.setProduit(produitrepo.findById(m.getIdProduit()).orElseThrow(()->new RuntimeException("Id non reconnu")));
            mvtStockProduit.setDateMvt(LocalDate.now());
            mvtStockProduit.setEntree(m.getQuantite());
            mvtStockProduit.setDescription("Production");
            repo.save(mvtStockProduit);
        }


    }
}
