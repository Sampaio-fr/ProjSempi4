package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.course.application.AddTeachersToCourseController;
import eapli.base.course.domain.Course;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ListWidget;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;

public class AddTeachersToCourseUI extends AbstractUI {

    private final AddTeachersToCourseController controller = new AddTeachersToCourseController();
    @Override
    protected boolean doShow() {
        Iterable<Course> allOpenCourses = this.controller.listOpenCourses();
        ArrayList<Teacher> allRegisteredTeachers = this.controller.listTeachers();

        if (!allOpenCourses.iterator().hasNext()){
            System.out.println("There aren't registered courses!");
        } else if(!allRegisteredTeachers.iterator().hasNext()){
            System.out.println("There aren't registered teachers!");
        }else {
            final SelectWidget<Course> courseSelector = new SelectWidget<>("Courses:", allOpenCourses, new CoursePrinter());
            courseSelector.show();
            Course selectedCourse = courseSelector.selectedElement();

            final ListWidget<Teacher> allTeachers = new ListWidget<>("Teachers:", allRegisteredTeachers, new TeacherPrinter());
            allTeachers.show();

            String input = Console.readLine("Please enter the numbers of the teachers you want to select (separated by commas):");

            ArrayList<Teacher> selectedTeachers = this.controller.selectedTeachers(allRegisteredTeachers,input);

            System.out.println("\n===================\n");
            final ListWidget<Teacher> chosenTeachers = new ListWidget<>("Selected Teachers:", selectedTeachers, new TeacherPrinter());
            chosenTeachers.show();
            int teacherInChargeIndex = Console.readInteger("Please insert the number of the teacher you wish to set as the Course charge teacher: ");

            boolean aux = controller.setTeachersToSelectedCourse(selectedCourse,selectedTeachers,teacherInChargeIndex);
            if(aux){
                System.out.println("Teachers were set!");
            }else{
                System.out.println("The course has already teachers!");
            }

        }
        return true;
    }

    @Override
    public String headline() {
        return "Add teachers to a course";
    }
}
