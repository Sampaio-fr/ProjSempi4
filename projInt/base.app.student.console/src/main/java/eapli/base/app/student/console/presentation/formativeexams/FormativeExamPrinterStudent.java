package eapli.base.app.student.console.presentation.formativeexams;

import eapli.base.exam.domain.Exam;
import eapli.base.examformative.domain.ExamFormative;
import eapli.framework.visitor.Visitor;

public class FormativeExamPrinterStudent implements Visitor<ExamFormative> {

    @Override
    public void visit(ExamFormative visitee) {
        System.out.printf("%-20s%-20s", visitee.title(), visitee.course().identity());
    }
}
