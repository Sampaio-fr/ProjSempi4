package eapli.base.course.builder;

import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.course.domain.CourseState;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The type Course builder test.
 */
public class CourseBuilderTest {

    /**
     * Test with course title.
     */
    @Test
    public void testWithCourseTitle() {
        Designation courseTitle = Designation.valueOf("Course Title");
        CourseBuilder courseBuilder = new CourseBuilder();

        CourseBuilder result = courseBuilder.withCourseTitle(courseTitle);

        Assertions.assertEquals(courseTitle, result.getCourseTitle());
    }

    /**
     * Test with course description.
     */
    @Test
    public void testWithCourseDescription() {
        Description courseDescription = Description.valueOf("Course Description");
        CourseBuilder courseBuilder = new CourseBuilder();

        CourseBuilder result = courseBuilder.withCourseDescription(courseDescription);

        Assertions.assertEquals(courseDescription, result.getCourseDescription());
    }

    /**
     * Test with edition.
     */
    @Test
    public void testWithEdition() {
        Code code = new Code("2023");
        CourseBuilder courseBuilder = new CourseBuilder();

        CourseBuilder result = courseBuilder.withEdition(code);

        Assertions.assertEquals(code, result.getEdition());
    }

    /**
     * Test with minimum capacity.
     */
    @Test
    public void testWithMinimumCapacity() {
        int minimumCapacity = 10;
        CourseBuilder courseBuilder = new CourseBuilder();

        CourseBuilder result = courseBuilder.withMinimumCapacity(minimumCapacity);

        Assertions.assertEquals(minimumCapacity, result.getMinimumCapacity());
    }

    /**
     * Test with maximum capacity.
     */
    @Test
    public void testWithMaximumCapacity() {
        int maximumCapacity = 50;
        CourseBuilder courseBuilder = new CourseBuilder();

        CourseBuilder result = courseBuilder.withMaximumCapacity(maximumCapacity);

        Assertions.assertEquals(maximumCapacity, result.getMaximumCapacity());
    }

    /**
     * Test build.
     */
    @Test
    public void testBuild() {
        Designation courseTitle = Designation.valueOf("Course Title");
        Description courseDescription = Description.valueOf("Course Description");
        Code code = new Code("2023");
        int minimumCapacity = 10;
        int maximumCapacity = 50;

        CourseBuilder courseBuilder = new CourseBuilder()
                .withCourseTitle(courseTitle)
                .withCourseDescription(courseDescription)
                .withEdition(code)
                .withMinimumCapacity(minimumCapacity)
                .withMaximumCapacity(maximumCapacity);

        Course course = courseBuilder.build();

        Assertions.assertEquals(courseTitle, course.courseTitle());
        Assertions.assertEquals(courseDescription, course.courseDescription());
        Assertions.assertEquals(CourseState.CLOSE, course.courseState());
        Assertions.assertEquals(code, course.identity());
        Assertions.assertEquals(minimumCapacity, course.minimumCapacity());
        Assertions.assertEquals(maximumCapacity, course.maximumCapacity());
    }
}
