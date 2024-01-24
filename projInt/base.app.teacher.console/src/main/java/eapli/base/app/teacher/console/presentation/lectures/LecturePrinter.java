package eapli.base.app.teacher.console.presentation.lectures;

import eapli.base.lecture.domain.Lecture;
import eapli.framework.visitor.Visitor;

/**
 * The type Lecture printer.
 */
public class LecturePrinter implements Visitor<Lecture> {

    @Override
    public void visit(Lecture visitee) {
        System.out.printf("%-10s%-6s", visitee.identity(), visitee.type());
    }
}
