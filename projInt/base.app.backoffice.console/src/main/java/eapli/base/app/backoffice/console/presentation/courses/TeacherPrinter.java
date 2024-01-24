package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.teacher.domain.Teacher;
import eapli.framework.visitor.Visitor;

/**
 * The type Course printer.
 */
public class TeacherPrinter implements Visitor<Teacher> {

    @Override
    public void visit(Teacher visitee) {
        System.out.printf("%-20s-%10s", visitee.systemUser().name(),visitee.acronym());
    }
}
