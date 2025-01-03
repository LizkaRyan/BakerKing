package mg.itu.bakerking.repository.transaction.achat;

import mg.itu.bakerking.entity.transaction.achat.Achat;
import mg.itu.bakerking.entity.transaction.achat.AchatDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchatRepo extends JpaRepository<Achat,String> {
    @Query(value = "select nextval('seq_achat')",nativeQuery = true)
    public Long findId();

    @Query(value = "select a from AchatDetails a where a.achat.idTransaction=:idTransaction")
    public List<AchatDetails> findAchatDetailsById(@Param("idTrasanction")String idTransaction);
}