package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.course.domain.Course;
import eapli.base.sharedBoard.domain.SharedBoard;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPAECourseUserRepository extends JpaAutoTxRepository<ECourseUser, EmailAddress, EmailAddress> implements ECourseUserRepository {

    public JPAECourseUserRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }


    public JPAECourseUserRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    @Override
    public List<ECourseUser> listUsers(ECourseUser user) {
        return null;
    }

    @Override
    public ECourseUser eCourseUserByEmail(EmailAddress email) {
        final TypedQuery<ECourseUser> query = entityManager().createQuery(
                "SELECT ecu FROM ECourseUser ecu WHERE ecu.email = :email",
                ECourseUser.class);
        query.setParameter("email", email);
        List<ECourseUser> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

}
