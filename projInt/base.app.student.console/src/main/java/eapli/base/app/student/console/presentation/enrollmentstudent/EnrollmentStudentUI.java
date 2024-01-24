package eapli.base.app.student.console.presentation.enrollmentstudent;

import eapli.base.course.domain.Course;
import eapli.base.enrollment.application.StudentEnrollmentController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Iterator;

/**
 * The type Enrollment student ui.
 */
public class EnrollmentStudentUI extends AbstractUI {

    private final StudentEnrollmentController enrollStudent= new StudentEnrollmentController();

    @Override
    protected boolean doShow() {
        Iterable<Course> coursesList = enrollStudent.allCoursesToEnroll();

        if (!coursesList.iterator().hasNext()) {
            System.out.println("Doesn't exist courses!");
            return false;
        }

        int i = 0;
        for (Course course : coursesList) {
            i++;
            System.out.println(i + " - " + course.toString());
        }

        boolean flag = true;
        Course c = null;

        while (flag) {
            int indexCourse = Console.readInteger("Choose the Course index (0 to exit)");
            if (indexCourse == 0) {
                return false;
            } else {
                Iterator<Course> iterator = coursesList.iterator();
                for (int j = 0; j < indexCourse; j++) {
                    c = iterator.next();
                }
                if (c != null) {
                    flag = false;
                } else {
                    System.out.println("Choose a valid index!");
                }
            }
        }
        if(enrollStudent.enrollStudent(c)){
            System.out.println("Success! The Student is the waiting list.");
        }

        return true;
    }

    @Override
    public String headline() {
        return "Student Enrollment";
    }
}
