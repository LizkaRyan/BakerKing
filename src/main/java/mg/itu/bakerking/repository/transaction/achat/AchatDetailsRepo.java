package mg.itu.bakerking.repository.transaction.achat;

import mg.itu.bakerking.entity.transaction.achat.AchatDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatDetailsRepo extends JpaRepository<AchatDetails,String> {
}
