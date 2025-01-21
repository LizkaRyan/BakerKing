package mg.itu.bakerking.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ComissionResponse {
    private String nom;

    private Double montant;

    private String idVendeur;

    public ComissionResponse(String nom,Double montant,String idVendeur){
        this.setNom(nom);
        this.setMontant(montant);
        this.setIdVendeur(idVendeur);
    }
}
