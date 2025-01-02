package mg.itu.bakerking.repository.transaction.achat;

import mg.itu.bakerking.entity.transaction.achat.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AchatRepo extends JpaRepository<Achat,String> {
}