package eapli.base.course.application;

import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.course.services.CourseManagementService;
import eapli.base.infrastructure.persistence.PersistenceContext;


/**
 * The type Change course state controller.
 */
public class ChangeCourseStateController {

    private final CourseManagementService service = new CourseManagementService();
    private final CourseRepository courseRepo = PersistenceContext.repositories().courseRepository();

    /**
     * Open courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> listCourses() {
        return this.service.allCourses();
    }

    public void openCourse(Course selectedCourse){
        selectedCourse.openCourse();
        courseRepo.save(selectedCourse);
    }

    public void closeCourse(Course selectedCourse){
        selectedCourse.closeCourse();
        courseRepo.save(selectedCourse);
    }


}
