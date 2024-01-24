package eapli.base.notificationMeeting;

import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.domain.MeetingState;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.notificationMeeting.domain.NotificationState;
import eapli.base.notificationMeeting.domain.TypeOfNotification;
import eapli.base.schedule.domain.Schedule;
import eapli.base.teacher.domain.Acronym;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.domain.FullName;
import eapli.base.user.domain.ShortName;
import eapli.base.user.domain.TaxNumber;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificationTest {

    private Notification notification;
    private ECourseUser eCourseUser;

    @BeforeEach
    public void setup() {
        // Create a sample meeting and user
        Schedule sh = new Schedule();
        Meeting meeting = new Meeting(Designation.valueOf("Meeting 1"), MeetingState.FINISHED, Calendar.getInstance(),1,null,null);
        Course c1 = new Course(Designation.valueOf("Java"), Description.valueOf("Java - avancado"),null, Code.valueOf("Edicao 1"), 10, 20,null);

        // Create a sample notification
        NotificationState notificationState = NotificationState.PENDING;
        TypeOfNotification typeOfNotification = TypeOfNotification.EMAIL;
        notification = new Notification(notificationState, typeOfNotification, meeting, eCourseUser);
    }

    @Test
    public void testReplaceMeeting() {
        // Create a new meeting
        Schedule sh = new Schedule();
        Meeting newMeeting = new Meeting(Designation.valueOf("Meeting 2"), MeetingState.FINISHED, Calendar.getInstance(),2,null,null);

        // Replace the meeting of the notification
        notification.replaceMeeting(newMeeting);

        // Verify that the meeting has been replaced
        assertEquals(newMeeting, notification.Meeting());
    }

    @Test
    public void testReplaceCourseUser() {
        // Create a new user
        Course c1 = new Course(Designation.valueOf("Java"), Description.valueOf("Java - avancado"),null, Code.valueOf("Edicao 1"), 10, 20,null);
        Acronym acronym = new Acronym("ABC");
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joe").withPassword("Password1").withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser newUser = userBuilder.build();
        ECourseUser eCourseUser = new ECourseUser(newUser.email(),new ShortName("joe"),new FullName("joe","power"), Calendar.getInstance(),new TaxNumber("123456789"),null);
        // Replace the user of the notification
        notification.replaceCourseUser(eCourseUser);

        // Verify that the user has been replaced
        assertEquals(eCourseUser, notification.eCourseUser());
    }
}
