package mg.itu.bakerking.service.produit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import mg.itu.bakerking.dto.produit.PrixProduitRequest;
import mg.itu.bakerking.entity.produit.IngredientProduit;
import mg.itu.bakerking.entity.produit.PrixProduit;
import mg.itu.bakerking.entity.produit.Production;
import mg.itu.bakerking.entity.produit.Produit;
import mg.itu.bakerking.repository.produit.*;
import mg.itu.bakerking.service.stock.MvtProduitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class ProduitService {
    private ProduitRepo repo;
    private TypeProduitRepo typeProduitRepo;
    private CategorieRepo categorieRepo;

    private MvtProduitService mvtProduitService;

    private PrixProduitRepo prixProduitRepo;


    public Produit findByIdProduit(String idProduit){
        return repo.findById(idProduit).orElseThrow(()->new RuntimeException("Id Produit non reconnue"));
    }

    public void save(PrixProduitRequest prixProduitRequest) {
        Produit produit =  repo.findById(prixProduitRequest.getIdProduit()).orElseThrow(()-> new RuntimeException("Id Produit non reconnu"));
        PrixProduit prixProduit = new PrixProduit(prixProduitRequest.getDatePrix(), prixProduitRequest.getPrixUnitaire(), produit);
        prixProduitRepo.save(prixProduit);
    }
}
