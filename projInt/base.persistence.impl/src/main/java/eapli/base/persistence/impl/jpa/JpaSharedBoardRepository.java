package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.sharedBoard.repositories.SharedBoardRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class JpaSharedBoardRepository extends JpaAutoTxRepository<SharedBoard, Long, Long>
        implements SharedBoardRepository {

    public JpaSharedBoardRepository(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }

    public JpaSharedBoardRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "eapli.base");
    }

    @Override
    public Iterable<SharedBoard> listOwnedBoards(EmailAddress email) {
        final TypedQuery<SharedBoard> query = entityManager().createQuery(
                "SELECT s FROM SharedBoard s  WHERE s.ownerSharedBoard.email = :email",
                SharedBoard.class);
        query.setParameter("email", email);
        return query.getResultList();
    }

    @Override
    public SharedBoard getBoardWithTitle(Designation title) {
        final TypedQuery<SharedBoard> query = entityManager().createQuery(
                "SELECT s FROM SharedBoard s WHERE s.sharedBoardTitle = :sbTitle", SharedBoard.class);
        query.setParameter("sbTitle", title);
        List<SharedBoard> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    public SharedBoard findSharedBoardByTitle(Designation title) {
        final TypedQuery<SharedBoard> query = entityManager().createQuery(
                "SELECT s FROM SharedBoard s  WHERE s.sharedBoardTitle= :title",
                SharedBoard.class);
        query.setParameter("title", title);
        return query.getSingleResult();
    }

    @Override
    public SharedBoard findSharedBoardString(Long id) {
        final TypedQuery<SharedBoard> query = entityManager().createQuery(
                "SELECT s FROM SharedBoard s  WHERE s.id= :id",
                SharedBoard.class);
        query.setParameter("id", id);
        return query.getSingleResult();
}
}