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
package eapli.base.app.student.console.presentation;

import eapli.base.Application;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.app.student.console.presentation.course.ListCoursesUI;
import eapli.base.app.student.console.presentation.enrollmentstudent.EnrollmentStudentUI;
import eapli.base.app.student.console.presentation.exams.ListStudentExamsAction;
import eapli.base.app.student.console.presentation.exams.TakeExamAction;
import eapli.base.app.student.console.presentation.formativeexams.TakeFormativeExamUI;
import eapli.base.app.student.console.presentation.grade.StudentGradesUI;
import eapli.base.app.student.console.presentation.meetings.CancelMeetingUI;
import eapli.base.app.student.console.presentation.meetings.CreateMeetingUI;
import eapli.base.app.student.console.presentation.meetings.ListMeetingParticipantsUI;
import eapli.base.app.student.console.presentation.meetings.MeetingRequestsUI;
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

    private static final String SEPARATOR_LABEL = "--------------";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int EXAMS_OPTION = 2;
    private static final int ENROLL_OPTION = 3;
    private static final int MEETING_OPTION = 4;


    //STUDENT MENU
    private static final int ENROLLMENT = 1;
    private static final int LISTCOURSES = 2;
    private static final int CREATEMEETING = 1;
    private static final int CANCELMEETING = 2;
    private static final int MEETINGREQUESTS = 3;
    private static final int MEETINGPARTICIPANTS = 4;


    //EXAMS
    private static final int LIST_EXAMS = 1;
    private static final int TAKE_EXAM = 2;
    private static final int LISTGRADES = 3;
    private static final int FORMATIVE_EXAM = 4;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final Menu menu;
    private final MenuRenderer renderer;

    /**
     * Instantiates a new Main menu.
     */
    public MainMenu() {
        menu = buildMainMenu();
        renderer = getRenderer(menu);
    }

    private MenuRenderer getRenderer(final Menu menu) {
        final MenuRenderer theRenderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            theRenderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            theRenderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return theRenderer;
    }


    @Override
    public boolean doShow() {
        return renderer.render();
    }

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu(BaseRoles.STUDENT);
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.STUDENT)) {
            final Menu coursesMenu = buildExamsMenu();
            final Menu enrollment = buildStudentMenu();
            final Menu meeting = buildMeetingMenu();
            mainMenu.addSubMenu(EXAMS_OPTION, coursesMenu);
            mainMenu.addSubMenu(ENROLL_OPTION, enrollment);
            mainMenu.addSubMenu(MEETING_OPTION, meeting);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Hope to see you again."));

        return mainMenu;
    }

    private Menu buildStudentMenu() {
        final Menu menu = new Menu("Students Menu >");
        menu.addItem(ENROLLMENT, "Enrollment", new EnrollmentStudentUI()::show);
        menu.addItem(LISTCOURSES, "List Courses", new ListCoursesUI()::show);
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return menu;
    }

    private Menu buildExamsMenu() {
        final Menu menu = new Menu("Exams Menu >");
        menu.addItem(LIST_EXAMS, "List my exams", new ListStudentExamsAction());
        menu.addItem(TAKE_EXAM, "Take an Exams", new TakeExamAction());
        menu.addItem(LISTGRADES, "List Grades", new StudentGradesUI()::show);
        menu.addItem(FORMATIVE_EXAM, "Take Formative Exam", new TakeFormativeExamUI()::show);
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return menu;
    }

    private Menu buildMeetingMenu() {
        final Menu courseMenu = new Menu("Meeting Menu >");
        courseMenu.addItem(CREATEMEETING, "Create Meeting", new CreateMeetingUI()::show);
        courseMenu.addItem(CANCELMEETING, "Cancel Meeting", new CancelMeetingUI()::show);
        courseMenu.addItem(MEETINGREQUESTS, "List of Notifications", new MeetingRequestsUI()::show);
        courseMenu.addItem(MEETINGPARTICIPANTS, "List of participants", new ListMeetingParticipantsUI()::show);
        courseMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return courseMenu;
    }
}
