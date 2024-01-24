package eapli.base.app.teacher.console.presentation.exams;

import eapli.base.course.domain.Course;
import eapli.base.exam.application.ListCourseExamsController;
import eapli.base.exam.domain.Exam;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.Iterator;

/**
 * The type List course exams ui.
 */
public class ListCourseExamsUI extends AbstractUI {
    private final ListCourseExamsController listCourses = new ListCourseExamsController();

    @Override
    protected boolean doShow() {

        Iterable<Course> coursesList = listCourses.listCoursesByUser();

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

        Iterable<Exam> examList = listCourses.listExamsByCourse(c);

        if (!examList.iterator().hasNext()) {
            System.out.println("Doesn't exist exams for this Course");
            return false;
        }

        int j = 1;
        for (Exam exam : examList) {
            System.out.println(j + " - " + exam.toString());
            j++;
        }

        return true;
    }

    @Override
    public String headline() {
        return "List of Exams in a Course";
    }
}
