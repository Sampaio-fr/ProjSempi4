package eapli.base.notificationMeeting.builder;

import eapli.base.meeting.builder.MeetingBuilder;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.domain.MeetingState;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.notificationMeeting.domain.NotificationState;
import eapli.base.notificationMeeting.domain.TypeOfNotification;
import eapli.base.user.domain.ECourseUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class NotificationBuilder {

    private static final Logger LOGGER = LogManager.getLogger(NotificationBuilder.class);

    private NotificationState notificationState;
    private TypeOfNotification typeOfNotification;
    private Meeting meeting;
    private ECourseUser eCourseUser;

    public NotificationBuilder withNotificationState(NotificationState notificationState) {
        this.notificationState = notificationState;
        return this;
    }

    public NotificationBuilder withTypeOfNotification(TypeOfNotification typeOfNotification) {
        this.typeOfNotification = typeOfNotification;
        return this;
    }

    public NotificationBuilder withMeeting(Meeting meeting) {
        this.meeting = meeting;
        return this;
    }

    public NotificationBuilder withUser(ECourseUser eCourseUser) {
        this.eCourseUser = eCourseUser;
        return this;
    }


    public NotificationBuilder() {
    }


    public Notification build() {
        Notification notification = new Notification(this.notificationState,this.typeOfNotification,this.meeting,this.eCourseUser);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating new Notification {}  with system info ", this.typeOfNotification);
        }

        return notification;
    }

}
