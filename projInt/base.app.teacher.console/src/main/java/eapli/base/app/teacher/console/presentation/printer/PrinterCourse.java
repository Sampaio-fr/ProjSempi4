package eapli.base.app.teacher.console.presentation.printer;

import eapli.base.course.domain.Course;
import eapli.framework.visitor.Visitor;

public class PrinterCourse implements Visitor<Course> {

    @Override
    public void visit(Course visitee) {
        System.out.printf("%-20s%-10s", visitee.identity(), visitee.courseTitle());
    }
}
