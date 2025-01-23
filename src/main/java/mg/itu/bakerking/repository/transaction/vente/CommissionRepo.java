package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.entity.transaction.vente.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CommissionRepo extends JpaRepository<Commission, String> {
    @Query("""
    select c from Commission c where c.commission = :commission
""")
    Optional<Commission> findCommissionByCommission(@Param("commission") double commission);
}
