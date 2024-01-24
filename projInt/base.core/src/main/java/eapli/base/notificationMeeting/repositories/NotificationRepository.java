package eapli.base.notificationMeeting.repositories;

import eapli.base.meeting.domain.Meeting;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.ArrayList;


public interface NotificationRepository extends DomainRepository<Long, Notification> {


    ArrayList<Notification> findAllNotificationsForThisMeeting(Meeting current);

    Iterable<Notification> findListNotificationsByUser(ECourseUser eCourseUser);
}
