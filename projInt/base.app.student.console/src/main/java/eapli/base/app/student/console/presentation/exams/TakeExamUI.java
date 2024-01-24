package eapli.base.app.student.console.presentation.exams;

import eapli.base.app.student.console.ExamConfig;
import eapli.base.exam.application.DisplayExam;
import eapli.base.exam.application.TakeExamController;
import eapli.base.exam.domain.Exam;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TakeExamUI extends AbstractUI {

    ApplicationContext context = new AnnotationConfigApplicationContext(ExamConfig.class);
    TakeExamController controller = context.getBean(TakeExamController.class);
    DisplayExam displayExam = context.getBean(DisplayExam.class);

    @Override
    protected boolean doShow() {

        controller.setDisplayExam(displayExam);
        final Iterable<Exam> iterable = controller.findActiveExams();

        if (iterable == null) {
            System.out.println("There are no active exams at this time!");
        } else {
            final SelectWidget<Exam> selector = new SelectWidget<>("Active Exams:", iterable, new ExamPrinterStudent());
            selector.show();
            Exam selectedExam = selector.selectedElement();

            if (selectedExam != null) {
                controller.doExamEvaluation(selectedExam);
            }
            else {
                System.out.println("Quitting to the main menu!");
            }
        }

        return true;
    }

    public String headline() {
        return "Take Exam";
    }
}
