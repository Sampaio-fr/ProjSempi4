package eapli.base.app.teacher.console.presentation.lectures;

import eapli.base.app.teacher.console.presentation.printer.PrinterCourse;
import eapli.base.course.domain.Course;
import eapli.base.lecture.application.ScheduleLectureController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.Calendar;

public class ScheduleLectureUI extends AbstractUI {

    private final ScheduleLectureController controller = new ScheduleLectureController();

    @Override
    protected boolean doShow() {

        Iterable<Course> allInProgressAndEnrolled = controller.listInProgressCoursesByTeacher();

        if (!allInProgressAndEnrolled.iterator().hasNext()) {
            System.out.println("There aren't available courses to shedule a class!");
            return false;
        } else {
            final SelectWidget<Course> courseSelector = new SelectWidget<>("Courses you teach:", allInProgressAndEnrolled, new PrinterCourse());
            courseSelector.show();
            Course selectedCourse = courseSelector.selectedElement();

            String title = Console.readLine("Please insert the class title:");

            Calendar initial = Console.readCalendar("Please Insert the day you wish to schedule the first class: \n (Format: dd-mm-yyyy hh:mm)", "dd-mm-yy hh:mm");

            int duration = Console.readInteger("Please indicate the duration of the class (in minutes): ");

            int weeks = Console.readInteger("For how many weeks do you wish to lecture it?");
            controller.scheduleNormalClass(title, selectedCourse, initial, duration, weeks);

        }

        return true;
    }

    @Override
    public String headline() {
        return "Schedule a regular class";
    }
}
