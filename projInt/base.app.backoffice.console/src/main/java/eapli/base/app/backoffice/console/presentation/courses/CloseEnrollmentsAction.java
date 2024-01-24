package eapli.base.app.backoffice.console.presentation.courses;

import eapli.framework.actions.Action;

/**
 * The type Close enrollments action.
 */
public class CloseEnrollmentsAction implements Action {

    @Override
    public boolean execute() {
        return new CloseEnrollmentsUI().show();
    }
}
