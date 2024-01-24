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
package eapli.base.app.teacher.console.presentation;

import eapli.base.Application;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.app.teacher.console.presentation.course.ListCoursesUI;
import eapli.base.app.teacher.console.presentation.exams.*;
import eapli.base.app.teacher.console.presentation.lectures.ChangeLectureScheduleAction;
import eapli.base.app.teacher.console.presentation.lectures.ScheduleExtraLectureUI;
import eapli.base.app.teacher.console.presentation.lectures.ScheduleLectureUI;
import eapli.base.app.teacher.console.presentation.meetings.CancelMeetingUI;
import eapli.base.app.teacher.console.presentation.meetings.CreateMeetingUI;
import eapli.base.app.teacher.console.presentation.meetings.ListMeetingParticipantsUI;
import eapli.base.app.teacher.console.presentation.meetings.MeetingRequestsUI;
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
    private static final int LECTURES_OPTION = 2;
    private static final int EXAM_OPTION = 3;
    private static final int COURSE_OPTION = 4;
    private static final int MEETING_OPTION = 5;


    //LECTURES
    private static final int SCHEDULE_LECTURE = 1;
    private static final int SCHEDULE_EXTRA_LECTURE = 2;
    private static final int CHANGE_SCHEDULE = 3;

    //EXAMS
    private static final int CREATE_EXAM = 1;
    private static final int UPDATE_EXAM = 2;
    private static final int PUBLISH_EXAM = 3;
    private static final int CREATE_FORMATIVE_QUESTION = 4;
    private static final int UPDATE_FORMATIVE_QUESTION = 5;
    private static final int CREATE_FORMATIVE_EXAM = 6;
    private static final int UPDATE_FORMATIVE_EXAM = 7;
    private static final int LIST_EXAM = 8;

    //COURSES
    private static final int LISTCOURSE = 1;
    private static final int LIST_COURSE_GRADES = 2;

    //Meeting
    private static final int CREATEMEETING = 1;
    private static final int CANCELMEETING = 2;
    private static final int MEETINGREQUESTS = 3;
    private static final int MEETINGPARTICIPANTS = 4;


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

        final Menu myUserMenu = new MyUserMenu(BaseRoles.TEACHER);
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.TEACHER)) {
            final Menu lecturesMenu = buildLecturesMenu();
            final Menu examMenu = buildExamsMenu();
            final Menu courseMenu = buildCourseMenu();
            final Menu meetingMenu = buildMeetingMenu();
            mainMenu.addSubMenu(LECTURES_OPTION, lecturesMenu);
            mainMenu.addSubMenu(EXAM_OPTION, examMenu);
            mainMenu.addSubMenu(COURSE_OPTION, courseMenu);
            mainMenu.addSubMenu( MEETING_OPTION,meetingMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Hope to see you again."));

        return mainMenu;
    }

    private Menu buildLecturesMenu() {
        final Menu lecturesMenu = new Menu("Lectures Menu >");
        lecturesMenu.addItem(SCHEDULE_LECTURE,"Schedule Regular Class",new ScheduleLectureUI()::show);
        lecturesMenu.addItem(SCHEDULE_EXTRA_LECTURE,"Schedule Extra Class",new ScheduleExtraLectureUI()::show);
        lecturesMenu.addItem(CHANGE_SCHEDULE, "Change Lecture Schedule", new ChangeLectureScheduleAction());
        lecturesMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return lecturesMenu;
    }

    private Menu buildExamsMenu() {
        final Menu examMenu = new Menu("Exams Menu >");
        examMenu.addItem(CREATE_EXAM, "Create Exam", new CreateExamAction());
        examMenu.addItem(UPDATE_EXAM, "Update Exam", new UpdateExamAction());
        examMenu.addItem(PUBLISH_EXAM, "Publish Exam", new PublishExamAction());
        examMenu.addItem(CREATE_FORMATIVE_QUESTION, "Create Formative Question", new CreateQuestionAction());
        examMenu.addItem(UPDATE_FORMATIVE_QUESTION, "Update Formative Question", new UpdateQuestionAction());
        examMenu.addItem(CREATE_FORMATIVE_EXAM,"Create Formative Exam", new CreateFormativeExamUI()::show);
        examMenu.addItem(UPDATE_FORMATIVE_EXAM,"Update Formative Exam",new UpdateFormativeExamUI()::show);
        examMenu.addItem(LIST_EXAM, "List Exams Course", new ListCourseExamsUI()::show);
        examMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return examMenu;
    }

    private Menu buildCourseMenu() {
        final Menu courseMenu = new Menu("Courses Menu >");
        courseMenu.addItem(LISTCOURSE, "List Courses", new ListCoursesUI()::show);
        courseMenu.addItem(LIST_COURSE_GRADES, "List Courses Grades", new ListCourseGradesAction());
        courseMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return courseMenu;
    }

    private Menu buildMeetingMenu() {
        final Menu courseMenu = new Menu("Meeting Menu >");
        courseMenu.addItem(CREATEMEETING, "Create Meeting", new CreateMeetingUI()::show);
        courseMenu.addItem(CANCELMEETING, "Cancel Meeting", new CancelMeetingUI()::show);
        courseMenu.addItem(MEETINGREQUESTS, "List of Notifications", new MeetingRequestsUI()::show);
        courseMenu.addItem(MEETINGPARTICIPANTS,"List of meeting participants",new ListMeetingParticipantsUI()::show);
        courseMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return courseMenu;
    }

}
