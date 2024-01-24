package eapli.base.app.teacher.console.presentation.lectures;

import eapli.base.app.teacher.console.presentation.printer.PrinterCourse;
import eapli.base.course.domain.Course;
import eapli.base.lecture.application.ScheduleExtraLectureController;
import eapli.base.lecture.application.ScheduleLectureController;
import eapli.base.student.domain.Student;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ScheduleExtraLectureUI extends AbstractUI {

    private final ScheduleExtraLectureController controller = new ScheduleExtraLectureController();

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
            List<Student> students = controller.findStudentsByCourse(selectedCourse);
            students = selectECourseUsers(students);

            String title = Console.readLine("Please insert the class title:");

            Calendar initial = Console.readCalendar("Please Insert the day you wish to schedule the first class: \n (Format: dd-mm-yyyy hh:mm)", "dd-MM-yy hh:mm");

            int duration = Console.readInteger("Please indicate the duration of the class (in minutes): ");

            controller.scheduleExtraClass(title, selectedCourse, students, initial, duration);

        }

        return true;
    }

    public List<Student> selectECourseUsers(List<Student> students) {
        List<Student> selectedUsers = new ArrayList<>();

        // Display the available ECourseUser objects for selection
        System.out.println("Available Students:");
        for (int i = 0; i < students.size(); i++) {
            Student user = students.get(i);
            System.out.println((i + 1) + ". " + user.identity()+ "->" + user.user().email());
        }

        // Prompt the user for their choices
        System.out.println("Select the Students (separated by commas):");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        // Split the user input into individual choices
        String[] choices = userInput.split(",");

        // Add the selected ECourseUser objects to the list
        for (String choice : choices) {
            int index = Integer.parseInt(choice.trim()) - 1;
            if (index >= 0 && index < students.size()) {
                selectedUsers.add(students.get(index));
            }
        }

        // Return the selected Students objects
        return selectedUsers;
    }
    @Override
    public String headline() {
        return "Schedule a Extra class";
    }
}
