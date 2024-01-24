/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.authz.ActivateUserAction;
import eapli.base.app.backoffice.console.presentation.courses.CloseEnrollmentsAction;
import eapli.base.app.backoffice.console.presentation.courses.CreateCourseUI;
import eapli.base.app.backoffice.console.presentation.courses.EnrollmentApprovalUI;
import eapli.base.app.backoffice.console.presentation.courses.OpenEnrollmentsAction;
import eapli.base.app.backoffice.console.presentation.courses.*;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACTIVATE_USER_OPTION = 4;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 5;

    //COURSES
    private static final int COURSE_CREATION = 1;
    private static final int TEACHERS_COURSE = 2;
    private static final int CHANGE_COURSE_STATE = 3;
    private static final int OPEN_ENROLLMENTS = 4;
    private static final int CLOSE_ENROLLMENTS = 5;
    private static final int ENROLLMENT_APPROVAL = 6;
    private static final int BULK_ENROLLMENT = 7;
    private static final int COURSE_LIST = 8;


    private static final int SHARED_BOARD = 1;

    //SHARED BOARD
    private static final int SHARED_BOARD_CREATION = 1;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;

    private static final int COURSES_OPTION = 3;

    private static final int SHARED_BOARD_OPTION = 3;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.ADMIN)) {
            final Menu coursesMenu = buildCoursesMenu();
            mainMenu.addSubMenu(COURSES_OPTION, coursesMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Hope to see you back again."));

        return mainMenu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACTIVATE_USER_OPTION, "Activate User", new ActivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildCoursesMenu(){
        final Menu menu = new Menu("Courses >");

        menu.addItem(COURSE_CREATION, "Create Course", new CreateCourseUI()::show);
        menu.addItem(TEACHERS_COURSE,"Set Teachers to Course", new AddTeachersToCourseUI()::show);
        menu.addItem(CHANGE_COURSE_STATE, "Change Course State", new ChangeCourseStateUI()::show);
        menu.addItem(OPEN_ENROLLMENTS, "Open Enrollments", new OpenEnrollmentsAction());
        menu.addItem(CLOSE_ENROLLMENTS, "Close Enrollments", new CloseEnrollmentsAction());
        menu.addItem(ENROLLMENT_APPROVAL, "Enrollment Approval", new EnrollmentApprovalUI()::show);
        menu.addItem(BULK_ENROLLMENT, "Bulk Enrollment", new BulkEnrollmentUI()::show);
        menu.addItem(COURSE_LIST, "List of Courses", new ListCoursesUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
