package eapli.base.course.application;

import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.course.services.CourseManagementService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;


/**
 * The type Enrollments management controller.
 */
@UseCaseController
public class CourseStateManagementController {

    private final CourseManagementService svc = new CourseManagementService();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();

    /**
     * Change state enrollments course.
     *
     * @param course the course
     * @return the course
     */
    public Course changeCourseStateToEnroll(final Course course) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);
        if (course == null){
            throw new IllegalArgumentException();
        }
        course.openEnrollment();
        return courseRepository.save(course);
    }

    public Course changeCourseStateToInProgress(final Course course) {
        authorizationService.ensureAuthenticatedUserHasAnyOf(BaseRoles.ADMIN);
        if (course == null){
            throw new IllegalArgumentException();
        }
        course.closeEnrollment();
        return courseRepository.save(course);
    }

    /**
     * Open courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> listOpenCourses() {
        return this.svc.openCourses();
    }

    /**
     * Is in enroll state courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> listEnrollStateCourses() {
        return this.svc.enrollStateCourses();
    }
}
