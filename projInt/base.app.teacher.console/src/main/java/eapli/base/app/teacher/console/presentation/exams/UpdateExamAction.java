package eapli.base.app.teacher.console.presentation.exams;

import eapli.framework.actions.Action;

public class UpdateExamAction implements Action {

    @Override
    public boolean execute() {
        return new UpdateExamUI().show();
    }
}
