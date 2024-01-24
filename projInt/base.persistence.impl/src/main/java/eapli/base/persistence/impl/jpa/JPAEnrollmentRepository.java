package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.course.domain.Course;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollment.repositories.EnrollmentRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;

/**
 * The type Jpa enrollment repository.
 */
public class JPAEnrollmentRepository extends JpaAutoTxRepository<Enrollment, Long, Long>
        implements EnrollmentRepository {

    /**
     * Instantiates a new Jpa enrollment repository.
     *
     * @param autoTx the auto tx
     */
    public JPAEnrollmentRepository(final TransactionalContext autoTx) {
        super(autoTx, "username");
    }

    /**
     * Instantiates a new Jpa enrollment repository.
     *
     * @param puname the puname
     */
    public JPAEnrollmentRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "username");
    }

    @Override
    public Iterable<Enrollment> findEnrollmentApplicationToEvaluate() {
        return this.findAll();
    }


    @Override
    public Enrollment findByEnrollment(Enrollment enrollment) {
        return null;
    }
}
