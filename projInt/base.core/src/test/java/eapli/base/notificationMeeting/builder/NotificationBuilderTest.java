package eapli.base.notificationMeeting.builder;

import eapli.base.meeting.builder.MeetingBuilder;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.domain.MeetingState;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.notificationMeeting.domain.NotificationState;
import eapli.base.notificationMeeting.domain.TypeOfNotification;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.general.domain.model.Designation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationBuilderTest {

    @Test
    void testBuildNotification() {
        MeetingBuilder builderr = new MeetingBuilder();
        NotificationState notificationState = NotificationState.PENDING;
        TypeOfNotification typeOfNotification = TypeOfNotification.EMAIL;
        Meeting meeting = builderr.withMeetingState(MeetingState.SCHEDULED).withmeetingTitle(Designation.valueOf("Titulo")).
                withCalendarInitial(Calendar.getInstance()).withDuration(60).
                withListUsers(new ArrayList<>()).withUserOwner(null).build();
        ECourseUser eCourseUser = null;

        NotificationBuilder builder = new NotificationBuilder()
                .withNotificationState(notificationState)
                .withTypeOfNotification(typeOfNotification)
                .withMeeting(meeting)
                .withUser(eCourseUser);

        Notification notification = builder.build();

        assertNotNull(notification);
        assertEquals(notificationState, notification.notificationState());
        assertEquals(typeOfNotification, notification.typeOfNotification());
        assertEquals(meeting, notification.Meeting());
        assertEquals(eCourseUser, notification.eCourseUser());
    }
}
