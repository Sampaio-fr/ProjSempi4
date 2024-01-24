package eapli.base.app.teacher.console.presentation.lectures;

import eapli.framework.actions.Action;

/**
 * The type Change lecture schedule action.
 */
public class ChangeLectureScheduleAction implements Action {

    @Override
    public boolean execute() {
        return new ChangeLectureScheduleUI().show();
    }
}
