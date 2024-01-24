package eapli.base.enrollment.repositories;

import eapli.base.course.domain.Course;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

/**
 * The interface Enrollment repository.
 */
public interface EnrollmentRepository extends DomainRepository<Long, Enrollment> {

    /**
     * Find enrollment application to evaluate iterable.
     *
     * @return the iterable
     */
    Iterable<Enrollment> findEnrollmentApplicationToEvaluate();
    

    /**
     * Find by enrollment enrollment.
     *
     * @param enrollment the enrollment
     * @return the enrollment
     */
    Enrollment findByEnrollment(Enrollment enrollment);
}
