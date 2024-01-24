package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.course.application.CourseStateManagementController;
import eapli.base.course.domain.Course;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

/**
 * The type Open enrollments ui.
 */
public class OpenEnrollmentsUI extends AbstractUI {

    private final CourseStateManagementController controller = new CourseStateManagementController();

    @Override
    protected boolean doShow() {

        final Iterable<Course> openCourses = this.controller.listOpenCourses();
        if (!openCourses.iterator().hasNext()) System.out.println("No registered courses!");
        else {
            final SelectWidget<Course> selector = new SelectWidget<>("Courses:", openCourses, new CoursePrinter());
            selector.show();
            final Course selectedCourse = selector.selectedElement();
            try {
                if (selectedCourse != null) {
                    this.controller.changeCourseStateToEnroll(selectedCourse);
                }
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }

    public String headline() {
        return "Open Enrollments";
    }
}
