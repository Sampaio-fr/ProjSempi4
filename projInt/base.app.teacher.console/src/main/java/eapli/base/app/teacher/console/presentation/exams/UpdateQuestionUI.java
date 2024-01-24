package eapli.base.app.teacher.console.presentation.exams;

import eapli.base.app.teacher.console.presentation.printer.PrinterCourse;
import eapli.base.course.domain.Course;
import eapli.base.question.applications.UpdateQuestionController;
import eapli.base.question.domain.Question;
import eapli.base.question.domain.QuestionPrinter;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.io.IOException;


/**
 * The type Update exam ui.
 */
public class UpdateQuestionUI extends AbstractUI {

    private final UpdateQuestionController controller = new UpdateQuestionController();

    @Override
    protected boolean doShow() {

        final Iterable<Course> openCourses = this.controller.listCourses();
        if (!openCourses.iterator().hasNext()) System.out.println("No registered courses!");
        else {
            SelectWidget<Course> cSelector = new SelectWidget<>("Courses:", openCourses, new PrinterCourse());
            cSelector.show();
            Course selectedCourse = cSelector.selectedElement();
            try {
                final Iterable<Question> questionsList = controller.listQuestions(selectedCourse);
                if (!questionsList.iterator().hasNext()) System.out.println("No Questions registered");
                else {
                    SelectWidget<Question> qSelector = new SelectWidget<>("Questions:", questionsList, new QuestionPrinter());
                    qSelector.show();
                    Question selectedQuestion = qSelector.selectedElement();
                    try {
                        if (selectedQuestion != null) {
                            try {
                                System.out.println("Welcome to Update question:");
                                String path = Console.readLine("Write the path to the Question.txt");
                                Question updatedQuestion = controller.updateQuestion(selectedQuestion, path);
                                System.out.println("Question Updated:");
                                System.out.println("--------------------------------");
                                System.out.println(updatedQuestion);
                                controller.saveQuestion(updatedQuestion);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    } catch (final Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return true;
    }


    @Override
    public String headline() {
        return "Update Questions";
    }
}
