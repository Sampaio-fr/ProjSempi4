package eapli.base.course.builder;

import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.course.domain.CourseState;
import eapli.base.timetable.domain.TimeTable;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Course builder.
 */
public class CourseBuilder {

    private static final Logger LOGGER = LogManager.getLogger(CourseBuilder.class);

    private Designation courseTitle;
    private Description courseDescription;
    private Code code;
    private int minimumCapacity;
    private int maximumCapacity;
    private TimeTable timeTable;

    /**
     * Gets course title.
     *
     * @return the course title
     */
    public Designation getCourseTitle() {
        return courseTitle;
    }

    /**
     * Gets course description.
     *
     * @return the course description
     */
    public Description getCourseDescription() {
        return courseDescription;
    }

    /**
     * Gets edition.
     *
     * @return the edition
     */
    public Code getEdition() {
        return code;
    }

    /**
     * Gets minimum capacity.
     *
     * @return the minimum capacity
     */
    public int getMinimumCapacity() {
        return minimumCapacity;
    }

    /**
     * Gets maximum capacity.
     *
     * @return the maximum capacity
     */
    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    /**
     * With course title course builder.
     *
     * @param courseTitle the course title
     * @return the course builder
     */
    public CourseBuilder withCourseTitle(Designation courseTitle) {
        this.courseTitle = courseTitle;
        return this;
    }

    /**
     * With course description course builder.
     *
     * @param courseDescription the course description
     * @return the course builder
     */
    public CourseBuilder withCourseDescription(Description courseDescription) {
        this.courseDescription = courseDescription;
        return this;
    }

    /**
     * With edition course builder.
     *
     * @param code the edition
     * @return the course builder
     */
    public CourseBuilder withEdition(Code code) {
        this.code = code;
        return this;
    }

    /**
     * With course title course builder.
     *
     * @param courseTitle the course title
     * @return the course builder
     */
    public CourseBuilder withCourseTitle(String courseTitle) {
        this.courseTitle = Designation.valueOf(courseTitle);
        return this;
    }

    /**
     * With course description course builder.
     *
     * @param courseDescription the course description
     * @return the course builder
     */
    public CourseBuilder withCourseDescription(String courseDescription) {
        this.courseDescription = Description.valueOf(courseDescription);
        return this;
    }

    /**
     * With edition course builder.
     *
     * @param edition the edition
     * @return the course builder
     */
    public CourseBuilder withEdition(String edition) {
        this.code = new Code(edition);
        return this;
    }


    /**
     * With minimum capacity course builder.
     *
     * @param minimumCapacity the minimum capacity
     * @return the course builder
     */
    public CourseBuilder withMinimumCapacity(int minimumCapacity) {
        this.minimumCapacity = minimumCapacity;
        return this;
    }

    /**
     * With maximum capacity course builder.
     *
     * @param maximumCapacity the maximum capacity
     * @return the course builder
     */
    public CourseBuilder withMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        return this;
    }

    public CourseBuilder withTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
        return this;
    }

    /**
     * Instantiates a new course builder.
     */
    public CourseBuilder() {
    }

    /**
     * Build course.
     *
     * @return the course
     */
    public Course build() {
        Course course = new Course(this.courseTitle,this.courseDescription, null,this.code,this.minimumCapacity,this.maximumCapacity,timeTable);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating new Course {} {} {} {} {} {} with system info ", this.courseTitle,this.courseDescription,CourseState.CLOSE,this.code,this.minimumCapacity,this.maximumCapacity);
        }

        return course;
    }

}
