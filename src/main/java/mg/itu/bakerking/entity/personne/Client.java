package mg.itu.bakerking.entity.personne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    private String idClient;

    private String nom;

}
