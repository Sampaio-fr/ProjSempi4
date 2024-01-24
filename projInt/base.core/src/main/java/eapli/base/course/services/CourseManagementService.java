package eapli.base.course.services;

import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.ApplicationService;

/**
 * The type Course management service.
 */
@ApplicationService
public class CourseManagementService {

    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();

    /**
     * All courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> allCourses() {
        return courseRepository.findAll();
    }

    /**
     * Open courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> openCourses(){return courseRepository.findOpen();}

    /**
     * Enroll state courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> enrollStateCourses(){return courseRepository.findEnrollStateCourses();}
}
