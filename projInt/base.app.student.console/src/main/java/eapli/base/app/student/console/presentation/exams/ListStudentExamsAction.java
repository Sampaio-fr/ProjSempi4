package eapli.base.app.student.console.presentation.exams;

import eapli.framework.actions.Action;

public class ListStudentExamsAction implements Action {

    @Override
    public boolean execute() {
        return new ListStudentExamsUI().show();
    }
}
