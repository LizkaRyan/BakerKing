package mg.itu.bakerking.service.transaction.achat;

import mg.itu.bakerking.repository.transaction.achat.AchatRepo;
import org.springframework.stereotype.Service;

@Service
public class AchatService {
    private final AchatRepo repo;

    public AchatService(AchatRepo repo) {
        this.repo = repo;
    }
}
