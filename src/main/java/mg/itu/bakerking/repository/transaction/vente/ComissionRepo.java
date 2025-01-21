package mg.itu.bakerking.repository.transaction.vente;

import mg.itu.bakerking.dto.transaction.ComissionResponse;
import mg.itu.bakerking.entity.transaction.vente.Comission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ComissionRepo extends JpaRepository<Comission, String> {

    @Query("""
    select new mg.itu.bakerking.dto.transaction.ComissionResponse(c.vendeur.nom, sum(c.montant),c.vendeur.idVendeur) from Comission c where c.dateComission >= :dateMin and c.dateComission <= :dateMax
""")
    public List<ComissionResponse> getComissions(@Param("dateMin") LocalDate dateMin, @Param("dateMax") LocalDate dateMax);
}
