package eapli.base.app.teacher.console.presentation.exams;

import eapli.base.app.teacher.console.presentation.printer.ExamFormativePrinter;
import eapli.base.app.teacher.console.presentation.printer.PrinterCourse;
import eapli.base.course.domain.Course;
import eapli.base.examformative.application.UpdateFormativeExamController;
import eapli.base.examformative.domain.ExamFormative;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import lombok.SneakyThrows;

import java.io.IOException;

/**
 * The type Update exam ui.
 */
public class UpdateFormativeExamUI extends AbstractUI {

    private final UpdateFormativeExamController controller = new UpdateFormativeExamController();

    @SneakyThrows
    @Override
    protected boolean doShow() {
        ExamFormative selectedExam;
        Course selectedCourse;

        Iterable<Course> coursesList = controller.findCourses();
        if (!coursesList.iterator().hasNext()) {
            System.out.println("Doesn't exist courses!");
        } else {
            SelectWidget<Course> selector = new SelectWidget<>("Courses:", coursesList, new PrinterCourse());
            selector.show();
            selectedCourse = selector.selectedElement();

            Iterable<ExamFormative> exams = controller.findExams(selectedCourse);
            if (!exams.iterator().hasNext()) {
                System.out.println("Doesn't exist courses!");

            } else {
                SelectWidget<ExamFormative> select = new SelectWidget<>("Formative Exams:", exams, new ExamFormativePrinter());
                select.show();
                selectedExam = select.selectedElement();

                String filepath = controller.getFilePath(selectedExam);

                String section = Console.readLine("Which section do you want to update? \n(Please insert the section name)");

                String newsection = Console.readLine("Please insert new Section name");
                String newdescr = Console.readLine("Please insert new Section description");

                controller.updateSection(filepath,section,newsection,newdescr);

                try {
                    controller.validateFormativeExam(filepath);
                } catch (IOException e) {
                    System.out.println("Formative Exam Failed");
                }

                controller.saveUpdatedExam(filepath,selectedExam);

                return true;
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "Update Exams";
    }
}
