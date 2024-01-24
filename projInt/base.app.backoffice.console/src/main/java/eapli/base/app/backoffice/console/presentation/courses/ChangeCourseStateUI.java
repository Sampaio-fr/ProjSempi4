package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.course.application.ChangeCourseStateController;
import eapli.base.course.domain.Course;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;


/**
 * @author : Inês Alves (17/05/2023)
 */

public class ChangeCourseStateUI extends AbstractUI {

    private final ChangeCourseStateController controller = new ChangeCourseStateController();

    @Override
    protected boolean doShow() {

        Iterable<Course> allCourses = this.controller.listCourses();

        Course c = null;
        boolean flag = true;

        if (!allCourses.iterator().hasNext()){
            System.out.println("No registered courses!");
        } else {
            final SelectWidget<Course> selector = new SelectWidget<>("Courses:", allCourses, new CoursePrinter());
            selector.show();
            c = selector.selectedElement();

            int option;

            System.out.println("1.Open course");
            System.out.println("2.Close course");

            while (flag) {
                option = Console.readInteger("Choose the option correspondent to the action you desire to do (0 to exit)");
                if (option == 0) {
                    return false;
                } else if (option == 1) { // open course
                    controller.openCourse(c);
                    flag = false;
                } else if (option == 2) { // close course
                    controller.closeCourse(c);
                    flag = false;
                } else {
                    System.out.println("Choose a valid index!");
                }
            }

            System.out.println("Course Actual State: " + c.courseState());

        }
        return true;
    }

    public String headline() {
        return "Change Course State";
    }
}
