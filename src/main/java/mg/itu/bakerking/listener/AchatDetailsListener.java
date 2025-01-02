package mg.itu.bakerking.listener;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import mg.itu.bakerking.entity.transaction.achat.AchatDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AchatDetailsListener {

    private JdbcTemplate jdbcTemplate;

    public AchatDetailsListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PrePersist
    public void prePersist(AchatDetails achatDetails){
        Long id=jdbcTemplate.query("select nextval('seq_achat_details') as id_achat",rs -> {
            return rs.getLong(0);
        });
        achatDetails.setIdDetails("ACD00"+id);
    }
}
