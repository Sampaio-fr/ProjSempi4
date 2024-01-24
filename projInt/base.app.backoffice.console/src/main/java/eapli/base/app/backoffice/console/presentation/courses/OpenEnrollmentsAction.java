package eapli.base.app.backoffice.console.presentation.courses;

import eapli.framework.actions.Action;

/**
 * The type Open enrollments action.
 */
public class OpenEnrollmentsAction implements Action {

    @Override
    public boolean execute() {
        return new OpenEnrollmentsUI().show();
    }
}
