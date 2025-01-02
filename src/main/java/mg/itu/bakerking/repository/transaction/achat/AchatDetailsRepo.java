package mg.itu.bakerking.repository.transaction.achat;

import mg.itu.bakerking.entity.transaction.achat.AchatDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatDetailsRepo extends JpaRepository<AchatDetails,String> {
    @Query(value = "select nextval('seq_achat_details')",nativeQuery = true)
    public Long findId();
}
