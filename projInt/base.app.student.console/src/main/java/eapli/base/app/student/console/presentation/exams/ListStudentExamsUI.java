package eapli.base.app.student.console.presentation.exams;

import eapli.base.exam.application.ListStudentExamsController;
import eapli.base.exam.domain.Exam;
import eapli.framework.presentation.console.AbstractUI;

public class ListStudentExamsUI extends AbstractUI {

    ListStudentExamsController controller = new ListStudentExamsController();

    @Override
    protected boolean doShow() {


        final Iterable<Exam> examIterable = controller.listMyExams();

        if (examIterable == null) {
            System.out.println("You are not registered in any exams\n");
        } else {
            for (Exam exam : examIterable) {
                System.out.printf("Exam title: %s  From Course: %s%n", exam.examTitle(), exam.course().courseTitle());
            }
        }

        return true;
    }

    public String headline() {
        return "My exams list";
    }
}
