package eapli.base.app.teacher.console.presentation.exams;

import eapli.base.app.teacher.console.presentation.printer.PrinterCourse;
import eapli.base.course.domain.Course;
import eapli.base.exam.application.CreateExamController;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.domain.FeedbackType;
import eapli.base.exam.domain.GradeType;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.Arrays;


/**
 * The type Create exam ui.
 */
public class CreateExamUI extends AbstractUI {

    private final CreateExamController controller = new CreateExamController();

    @Override
    protected boolean doShow() {
        Course selectedCourse;
        Exam exam;

        final Iterable<Course> openCourses = this.controller.listCourses();
        if (!openCourses.iterator().hasNext()) System.out.println("No registered courses!");
        else {
            System.out.println("Welcome to the Exam creation:");
            final SelectWidget<Course> selector = new SelectWidget<>("Courses:", openCourses, new PrinterCourse());
            selector.show();
            selectedCourse = selector.selectedElement();
            try {
                if (selectedCourse != null) {
                    final SelectWidget<FeedbackType> fSelector = new SelectWidget<>("Feedback type:", Arrays.asList(FeedbackType.values()));
                    fSelector.show();
                    FeedbackType selectedFeedbackType = fSelector.selectedElement();
                    try {
                        if (selectedFeedbackType != null) {
                            final SelectWidget<GradeType> gSelector = new SelectWidget<>("Grade type:", Arrays.asList(GradeType.values()));
                            gSelector.show();
                            GradeType selectedGradeType = gSelector.selectedElement();
                            try {
                                if (selectedGradeType != null) {
                                    String path = Console.readLine("Enter the path to the Exam: ");
                                    try {
                                        controller.validateExam(path);
                                        exam = controller.createExamFromPath(path, selectedCourse, selectedGradeType, selectedFeedbackType);
                                        if (exam != null) {
                                            System.out.println("Exam created:");
                                            System.out.println("--------------------------------");
                                            System.out.println(exam);
                                            controller.saveExam(selectedCourse, exam);

                                        } else {
                                            System.out.println("Exam not created.");
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            } catch (final Exception e) {
                                System.out.println("No grade types available");
                            }
                        }
                    } catch (final Exception e) {
                        System.out.println("No feedback types available");
                    }
                } else {
                    System.out.println("No courses available.");
                }
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return true;
    }

    @Override
    public String headline() {
        return "Create Exam in a Course";
    }
}




