package eapli.base.course.domain;

/**
 * The enum Course state.
 *
 * @author Inês Alves (09-05-2023)
 */
public enum CourseState {
    /**
     * When course is created
     */
    CLOSE,
    /**
     * When course is opened
     */
    OPEN,
    /**
     * When enrollments are opened
     */
    ENROLL,
    /**
     * When enrollemnts are closed
     */
    INPROGRESS,
    /**
     * When course is closed
     */
    CLOSED
}
