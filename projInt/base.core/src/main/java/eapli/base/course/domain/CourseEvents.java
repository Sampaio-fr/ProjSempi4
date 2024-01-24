package eapli.base.course.domain;

/**
 * The interface Course events.
 *
 * @author Inês Alves (09-05-2023)
 */
public interface CourseEvents {
    /**
     * Open course.
     */
    void openCourse();

    /**
     * Open enrollment.
     */
    void openEnrollment();

    /**
     * Close enrollment.
     */
    void closeEnrollment();

    /**
     * Close course.
     */
    void closeCourse();
}
