package mg.itu.bakerking.listener.produit;


import jakarta.persistence.PrePersist;
import mg.itu.bakerking.entity.produit.Recommandation;
import mg.itu.bakerking.repository.produit.RecommandationRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class RecommandationListener {

    private RecommandationRepo recommandationRepo;

    public RecommandationListener(@Lazy RecommandationRepo recommandationRepo){
        this.recommandationRepo=recommandationRepo;
    }

    @PrePersist
    public void prePersist(Recommandation recommandation){
        recommandation.setIdRecommandation("RCM00"+recommandationRepo.findId());
    }
}
