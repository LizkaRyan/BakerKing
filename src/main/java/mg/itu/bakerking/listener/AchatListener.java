package mg.itu.bakerking.listener;

import jakarta.persistence.PrePersist;
import mg.itu.bakerking.entity.transaction.achat.Achat;
import mg.itu.bakerking.repository.transaction.achat.AchatRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AchatListener {

    private AchatRepo achatRepo;
    public AchatListener(@Lazy AchatRepo achatRepo) {
        this.achatRepo = achatRepo;
    }

    @PrePersist
    public void prePersist(Achat achat){
        achat.setIdTransaction("ACH00"+achatRepo.findId());
    }
}
