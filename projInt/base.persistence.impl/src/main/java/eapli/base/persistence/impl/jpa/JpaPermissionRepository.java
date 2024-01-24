package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.course.domain.Course;
import eapli.base.permission.domain.Permission;
import eapli.base.permission.repositories.PermissionRepository;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaPermissionRepository extends JpaAutoTxRepository<Permission, Long, Long>
        implements PermissionRepository {

    public JpaPermissionRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaPermissionRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }


    @Override
    public Permission hasPermissionByEmail(EmailAddress email) {
        final TypedQuery<Permission> query = entityManager().createQuery(
                "SELECT p FROM Permission p WHERE p.user.email = :email  and p.sharedBoard.boardState = 'ENABLED'",
                Permission.class);
        query.setParameter("email", email);
        List<Permission> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public Permission hasBoardPermissionByEmail(EmailAddress email, Long board) {
        final TypedQuery<Permission> query = entityManager().createQuery(
                "SELECT p FROM Permission p WHERE p.user.email = :email AND p.sharedBoard.id = :board and p.sharedBoard.boardState = 'ENABLED'",
                Permission.class);
        query.setParameter("email", email);
        query.setParameter("board", board);
        List<Permission> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }


    public Iterable<Permission> findWriteAdmin(EmailAddress emailAddress) {
        final TypedQuery<Permission> query = entityManager().createQuery(
                "SELECT p FROM Permission p WHERE p.user.email = :emailAddress and p.accessLevel = 'WRITE' or p.accessLevel = 'ADMIN' and p.user.email = :emailAddress  and p.sharedBoard.boardState = 'ENABLED'",
                Permission.class);
        query.setParameter("emailAddress", emailAddress);
        return  query.getResultList();
    }
}
