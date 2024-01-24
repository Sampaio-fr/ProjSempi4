package eapli.base.app.teacher.console.presentation.exams;

import eapli.base.app.teacher.console.presentation.printer.PrinterCourse;
import eapli.base.course.domain.Course;
import eapli.base.question.applications.CreateQuestionController;
import eapli.base.question.domain.Question;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;


/**
 * The type Create exam ui.
 */
public class CreateQuestionUI extends AbstractUI {

    private final CreateQuestionController controller = new CreateQuestionController();

    @Override
    protected boolean doShow() {
        Course selectedCourse;
        Question question;
        boolean flag;
        do{
            flag = true;
            final Iterable<Course> openCourses = this.controller.listCourses();
            if (!openCourses.iterator().hasNext()) System.out.println("No registered courses!");
            else {
                final SelectWidget<Course> selector = new SelectWidget<>("Courses:", openCourses, new PrinterCourse());
                selector.show();
                selectedCourse = selector.selectedElement();
                if (selectedCourse != null) {
            try {
                System.out.println("Welcome to create question:");
                String path = Console.readLine("Write the path to the Question.txt");
                question = controller.createQuestion(selectedCourse, path);
                System.out.println("Question created:");
                System.out.println("--------------------------------");
                System.out.println(question);
                controller.saveQuestion(question);
            } catch (final Exception e) {
                flag = false;
                System.out.println(e.getMessage());
            }
                }

            }

        }while (!flag);

        return true;
    }

    @Override
    public String headline() {
        return "Create Question in a Course";
    }
}




