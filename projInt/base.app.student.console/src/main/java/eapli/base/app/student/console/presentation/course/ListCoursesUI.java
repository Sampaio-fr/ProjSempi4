package eapli.base.app.student.console.presentation.course;

import eapli.base.course.application.ListCoursesController;
import eapli.base.course.domain.Course;
import eapli.framework.presentation.console.AbstractUI;


public class ListCoursesUI extends AbstractUI {

    private final ListCoursesController listCoursesStudent = new ListCoursesController();

    @Override
    protected boolean doShow() {

        Iterable<Course> enrolledCourses = listCoursesStudent.listCoursesEnrolled();

        Iterable<Course> availableCourses = listCoursesStudent.listCoursesAvailable();

        int i = 0;

        if (!enrolledCourses.iterator().hasNext()) {
            System.out.println("Student is not enrolled in any courses!");
        }else {
            for (Course c : enrolledCourses) {
                i++;
                System.out.printf(i + " - " + c.toString() + " - ENROLLED\n");
            }
        }
        System.out.println();
        if (availableCourses.iterator().hasNext()) {
            for (Course c : availableCourses) {
                i++;
                System.out.printf(i + " - " + c.toString() + " - AVAILABLE TO ENROLL\n");
            }
        }else {
            System.out.println("There are no courses available!");
        }
        return true;
    }

    @Override
    public String headline() {return "List of Courses";}

}
