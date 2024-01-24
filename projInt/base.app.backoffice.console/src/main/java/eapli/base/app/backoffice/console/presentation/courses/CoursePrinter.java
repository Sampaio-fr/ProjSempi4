package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.course.domain.Course;
import eapli.framework.visitor.Visitor;

/**
 * The type Course printer.
 */
public class CoursePrinter implements Visitor<Course> {

    @Override
    public void visit(Course visitee) {
        System.out.printf("%-20s%-10s", visitee.identity(), visitee.courseState());
    }
}
