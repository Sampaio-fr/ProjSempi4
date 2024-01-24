package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.teacher.domain.Acronym;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Jpa teacher repository.
 */
public class JPATeacherRepository extends JpaAutoTxRepository<Teacher, Acronym, Acronym> implements TeacherRepository {
    /**
     * Instantiates a new Jpa teacher repository.
     *
     * @param puname the puname
     */
    public JPATeacherRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    /**
     * Instantiates a new Jpa teacher repository.
     *
     * @param autoTx the auto tx
     */
    public JPATeacherRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    @Override
    public Teacher teacherByUsername(EmailAddress email) {
        final TypedQuery<Teacher> query = entityManager().createQuery(
                "SELECT t FROM Teacher t WHERE t.user.email = :email",
                Teacher.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public Teacher findTeacherByEmail(EmailAddress email) {
        final TypedQuery<Teacher> query = entityManager().createQuery(
                "SELECT l FROM Teacher l WHERE l.user.email = :email",
                Teacher.class);
        query.setParameter("email", email);
        List<Teacher> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);

    }

    @Override
    public Iterable<Teacher> searchUsersavailable() {
        return null;
    }

    @Override
    public Iterable<Teacher> myDetails(SystemUser user) {
        final TypedQuery<Teacher> query = entityManager().createQuery(
                "SELECT t FROM Teacher t WHERE t.systemUser = :systemUser",
                Teacher.class);
        query.setParameter("systemUser", user);

        return query.getResultList();
    }
}

