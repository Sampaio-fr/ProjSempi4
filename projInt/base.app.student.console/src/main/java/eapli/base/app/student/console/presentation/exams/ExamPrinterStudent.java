package eapli.base.app.student.console.presentation.exams;

import eapli.base.exam.domain.Exam;
import eapli.framework.visitor.Visitor;

public class ExamPrinterStudent implements Visitor<Exam> {

    @Override
    public void visit(Exam visitee) {
        System.out.printf("%-20s%-20s", visitee.examTitle(), visitee.course().identity());
    }
}
