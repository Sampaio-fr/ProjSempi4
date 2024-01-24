package eapli.base.course.application;

import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.course.services.CreateCourseService;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

/**
 * The type Create course controller.
 */
public class CreateCourseController {


    private final CreateCourseService createCourseService;
    private Course course;


    /**
     * Instantiates a new course controller.
     */
    public CreateCourseController() {
        this.createCourseService = new CreateCourseService();
    }

    /**
     * Create courses.
     *
     * @param courseTitle       the course title
     * @param courseDescription the course description
     * @param code           the edition
     * @param minimumCapacity   the minimum capacity
     * @param maximumCapacity   the maximum capacity
     */
    public void createCourses(Designation courseTitle,
                              Description courseDescription,
                              Code code,
                              int minimumCapacity, int maximumCapacity) {
        if (!createCourseService.findCourseByIdBoolean(String.valueOf(code))) {
            course = createCourseService.createCourse(courseTitle, courseDescription, code, minimumCapacity, maximumCapacity);
            System.out.println("Course created:");
            System.out.println(course.identity());
            System.out.println(course.courseDescription());
            System.out.println();
        } else {
            System.out.println("Already Exists");
        }

    }


}
