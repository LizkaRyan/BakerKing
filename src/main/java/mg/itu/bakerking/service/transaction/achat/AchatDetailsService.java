package mg.itu.bakerking.service.transaction.achat;

import lombok.AllArgsConstructor;
import mg.itu.bakerking.entity.transaction.achat.AchatDetails;
import mg.itu.bakerking.repository.transaction.achat.AchatDetailsRepo;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AchatDetailsService {
    private final AchatDetailsRepo repo;

    public AchatDetails save(AchatDetails achatDetails){
        this.setId(achatDetails);
        return repo.save(achatDetails);
    }

    public void setId(AchatDetails achatDetails){
        Long id=repo.findId();
        achatDetails.setIdDetails("ACD00"+id);
    }
}
