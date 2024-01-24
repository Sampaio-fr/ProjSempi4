package eapli.base.app.student.console.presentation.formativeexams;

import eapli.base.app.student.console.ExamConfig;
import eapli.base.examformative.application.DisplayFormativeExam;
import eapli.base.examformative.application.TakeFormativeExamController;
import eapli.base.examformative.domain.ExamFormative;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TakeFormativeExamUI extends AbstractUI {
    ApplicationContext context = new AnnotationConfigApplicationContext(ExamFormativeConfig.class);
    TakeFormativeExamController controller = context.getBean(TakeFormativeExamController.class);
    DisplayFormativeExam displayExam = context.getBean(DisplayFormativeExam.class);

    @Override
    protected boolean doShow() {
        controller.setDisplayExam(displayExam);
        final Iterable<ExamFormative> iterable = controller.findFormativeExams();

        if (iterable == null) {
            System.out.println("There are no formative exams available at this time!");
        } else {
            final SelectWidget<ExamFormative> selector = new SelectWidget<>("Formative Exams:", iterable);
            selector.show();
            ExamFormative selectedExam = selector.selectedElement();

            if (selectedExam != null) {
                controller.doFormativeExamEvaluation(selectedExam);
            }
            else {
                System.out.println("Quitting to the main menu!");
            }
        }

        return true;
    }

    public String headline() {
        return "Take Formative Exam";
    }

}
