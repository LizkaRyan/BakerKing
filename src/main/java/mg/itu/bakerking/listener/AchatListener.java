package mg.itu.bakerking.listener;

import jakarta.persistence.PrePersist;
import mg.itu.bakerking.entity.transaction.achat.Achat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AchatListener {

    private JdbcTemplate template;
    public AchatListener(JdbcTemplate template) {
        this.template = template;
    }

    @PrePersist
    public void prePersist(Achat achat){
        Long id=template.query("select nextval('seq_achat') as id_achat",rs -> {
            return rs.getLong(0);
        });
        achat.setIdTransaction("ACH00"+id);
    }
}
