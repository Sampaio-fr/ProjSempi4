package eapli.base.app.teacher.console.presentation.exams;

import eapli.base.app.teacher.console.presentation.printer.PrinterCourse;
import eapli.base.course.application.ListCourseGradesController;
import eapli.base.course.domain.Course;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class ListCourseGradesUI extends AbstractUI {

    ListCourseGradesController controller = new ListCourseGradesController();

    @Override
    protected boolean doShow() {

        Iterable<Course> myCourses = controller.myCourses();
        if (myCourses == null) {
            System.out.println("There are no available courses");
        } else {
            final SelectWidget<Course> selector = new SelectWidget<>("Your Courses:", myCourses, new PrinterCourse());
            selector.show();
            Course selectedCourse = selector.selectedElement();

            if (selectedCourse != null) {
                List<String> gradesList = controller.courseGrades(selectedCourse);
                for (String grade : gradesList) {
                    System.out.println(grade);
                }
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "List of Course Grades";
    }
}
