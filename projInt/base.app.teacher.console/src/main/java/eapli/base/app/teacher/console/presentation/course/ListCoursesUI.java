package eapli.base.app.teacher.console.presentation.course;

import eapli.base.course.application.ListCoursesController;
import eapli.base.course.domain.Course;
import eapli.framework.presentation.console.AbstractUI;


public class ListCoursesUI extends AbstractUI {

    private final ListCoursesController listCourses = new ListCoursesController();

    @Override
    protected boolean doShow() {

        Iterable<Course> coursesList = listCourses.listCoursesByUser();

        if (!coursesList.iterator().hasNext()) {
            System.out.println("Doesn't exists courses!");
            return false;
        }

        int i = 0;
        for (Course c: coursesList){
            i++;
            System.out.printf(i + " - " + c.toString());
        }

        return true;
    }

    @Override
    public String headline() {return "List of Courses";}

}
