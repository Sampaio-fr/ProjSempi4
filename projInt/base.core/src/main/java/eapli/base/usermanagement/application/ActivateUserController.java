package eapli.base.usermanagement.application;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

/**
 * The type Activate user controller.
 */
@UseCaseController
public class ActivateUserController {
    private final AuthorizationService authz = AuthzRegistry.authorizationService();
    private final UserManagementService userSvc = AuthzRegistry.userService();

    /**
     * Deactived users iterable.
     *
     * @return the iterable
     */
    public Iterable<SystemUser> deactivedUsers() {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

        return userSvc.deactivatedUsers();
    }

    /**
     * Activate user system user.
     *
     * @param user the user
     * @return the system user
     */
    public SystemUser activateUser(final SystemUser user) {
        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.ADMIN);

        return userSvc.activateUser(user);
    }
}
