package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.CellLog.domain.CellLog;
import eapli.base.SharedBoardLog.domain.SharedBoardLog;
import eapli.base.SharedBoardLog.repositories.SharedBoardLogRepository;
import eapli.base.participant.domain.Participant;
import eapli.base.participant.repositories.ParticipantRepository;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Jpa enrollment repository.
 */
public class JPASharedBoardLogRepository extends JpaAutoTxRepository<SharedBoardLog, Long, Long>
        implements SharedBoardLogRepository {


    public JPASharedBoardLogRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param autoTx the auto tx
     */
    public JPASharedBoardLogRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }


    @Override
    public SharedBoardLog findSharedBoardLogContainsSharedBoard(SharedBoard sharedBoardd) {

        final TypedQuery<SharedBoardLog> query = entityManager().createQuery(
                "SELECT s FROM SharedBoardLog s  WHERE s.sharedBoard= :sharedBoardd",
                SharedBoardLog.class);
        query.setParameter("sharedBoardd", sharedBoardd);
        return query.getSingleResult();
    }

    @Override
    public SharedBoardLog findSharedBoardLogContainsSharedBoardId(Long identity) {
        final TypedQuery<SharedBoardLog> query = entityManager().createQuery(
                "SELECT s FROM SharedBoardLog S  WHERE s.sharedBoard.id= :identity",
                SharedBoardLog.class);
        query.setParameter("identity", identity);
        return query.getSingleResult();
    }

    @Override
    public SharedBoardLog findSharedBoardHistory(SharedBoard sharedBoard) {
        final TypedQuery<SharedBoardLog> query = entityManager().createQuery(
                "SELECT s FROM SharedBoardLog s  WHERE s.sharedBoard= :sharedBoard",
                SharedBoardLog.class);
        query.setParameter("sharedBoard", sharedBoard);
        return query.getSingleResult();
    }

    @Override
    public List<CellLog> findCellsHistory(SharedBoardLog boardLog) {
        final TypedQuery<SharedBoardLog> query = entityManager().createQuery(
                "SELECT sbl FROM SharedBoardLog sbl LEFT JOIN FETCH sbl.cellLogList cl WHERE sbl = :boardLog",
                SharedBoardLog.class);
        query.setParameter("boardLog", boardLog);
        SharedBoardLog result = query.getSingleResult();

        return result.cellLogList();
    }
}
