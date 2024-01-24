package eapli.base.app.teacher.console.presentation.exams;

import eapli.framework.actions.Action;


public class ListCourseGradesAction implements Action {

    @Override
    public boolean execute() {
        return new ListCourseGradesUI().show();
    }
}
