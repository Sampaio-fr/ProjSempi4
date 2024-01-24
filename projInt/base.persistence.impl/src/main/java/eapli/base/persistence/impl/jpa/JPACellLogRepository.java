package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.CellLog.domain.CellLog;
import eapli.base.CellLog.repositories.CellLogRepository;
import eapli.base.SharedBoardLog.domain.SharedBoardLog;
import eapli.base.SharedBoardLog.repositories.SharedBoardLogRepository;
import eapli.base.cell.domain.Cell;
import eapli.base.permission.domain.Permission;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Jpa enrollment repository.
 */
public class JPACellLogRepository extends JpaAutoTxRepository<CellLog, Long, Long>
        implements CellLogRepository {


    public JPACellLogRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param autoTx the auto tx
     */
    public JPACellLogRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }



    @Override
    public CellLog findCellLogContainsCell(Cell cell){
        final TypedQuery<CellLog> query = entityManager().createQuery(
                "SELECT p FROM CellLog p WHERE p.cell = :cell",
                CellLog.class);
        query.setParameter("cell", cell);
        return  query.getSingleResult();
    }


}
