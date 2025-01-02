package mg.itu.bakerking.service.transaction.achat;

import mg.itu.bakerking.entity.transaction.achat.AchatDetails;
import mg.itu.bakerking.repository.transaction.achat.AchatDetailsRepo;
import org.springframework.stereotype.Service;

@Service
public class AchatDetailsService {
    private final AchatDetailsRepo repo;

    public AchatDetailsService(AchatDetailsRepo repo) {
        this.repo = repo;
    }

    public AchatDetails save(AchatDetails achatDetails){
        this.setId(achatDetails);
        return repo.save(achatDetails);
    }

    public void setId(AchatDetails achatDetails){
        Long id=repo.findId();
        achatDetails.setIdDetails("ACD00"+id);
    }
}
