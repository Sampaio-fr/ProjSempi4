package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.CellLog.domain.CellLog;
import eapli.base.PostItLog.domain.PostItLog;
import eapli.base.PostItLog.repositories.PostItLogRepository;
import eapli.base.postIt.domain.PostIt;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Jpa post it log repository.
 */
public class JPAPostItLogRepository extends JpaAutoTxRepository<PostItLog, Long, Long>
        implements PostItLogRepository {


    /**
     * Instantiates a new Jpa post it log repository.
     *
     * @param puname the puname
     */
    public JPAPostItLogRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    /**
     * Instantiates a new Jpa post it log repository.
     *
     * @param autoTx the auto tx
     */
    public JPAPostItLogRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }


    @Override
    public PostItLog findLastPostItLogUpdate(PostIt postIt) {
        final TypedQuery<PostItLog> query = entityManager().createQuery(
                "SELECT pl FROM PostItLog pl WHERE pl.postIt.postItId = :pID AND pl.date = " +
                        "( SELECT MAX(date) FROM PostItLog pl2 WHERE pl2.date < (SELECT MAX(date) FROM PostItLog ) ) ", PostItLog.class);
        query.setParameter("pID", postIt.identity());
        List<PostItLog> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public PostItLog findLastPostItLog(PostIt postIt) {
        final TypedQuery<PostItLog> query = entityManager().createQuery(
                "SELECT pl FROM PostItLog pl WHERE pl.postIt.postItId = :pID order by date desc " , PostItLog.class);
        query.setParameter("pID", postIt.identity());
        List<PostItLog> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<PostItLog> findPostItHistory(CellLog cellLog) {
        final TypedQuery<PostItLog> query = entityManager().createQuery(
                "SELECT p FROM PostItLog p JOIN CellLog c WHERE c = :cellLog",
                PostItLog.class);
        query.setParameter("cellLog", cellLog);
        return query.getResultList();
    }
}
