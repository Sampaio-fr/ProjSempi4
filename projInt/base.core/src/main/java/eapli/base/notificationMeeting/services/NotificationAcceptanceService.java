package eapli.base.notificationMeeting.services;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.repositories.MeetingRepository;
import eapli.base.notificationMeeting.builder.NotificationBuilder;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.notificationMeeting.domain.NotificationState;
import eapli.base.notificationMeeting.domain.TypeOfNotification;
import eapli.base.notificationMeeting.repositories.NotificationRepository;
import eapli.base.participant.domain.Participant;
import eapli.base.participant.service.ParticipantService;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.timetable.repositories.TimetableRepository;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * The type Notification acceptance service.
 */
public class NotificationAcceptanceService {

    private final AuthorizationService authorizationService;
    private MeetingRepository meetingRepository;

    private NotificationRepository notificationRepository;
    private TimetableRepository timetableRepository;
    private NotificationBuilder notificationBuilder;
    private ECourseUserRepository eCourseUserRepository;
    private ParticipantService participantService;


    /**
     * Instantiates a new Notification acceptance service.
     */
    public NotificationAcceptanceService() {
        this.authorizationService = AuthzRegistry.authorizationService();
        this.meetingRepository = PersistenceContext.repositories().meetingRepository();
        this.notificationRepository = PersistenceContext.repositories().notificationRepository();
        this.eCourseUserRepository = PersistenceContext.repositories().eCourseUserRepository();
        this.timetableRepository = PersistenceContext.repositories().timetableRepository();
        this.notificationBuilder = new NotificationBuilder();
        this.participantService = new ParticipantService();
    }

    /**
     * Create notifications.
     *
     * @param meeting the meeting
     * @param users   the users
     */
    public void createNotifications(Meeting meeting, ArrayList<ECourseUser> users) {
        Notification notification;
        for (ECourseUser user : users) {
            notification = notificationBuilder.withNotificationState(NotificationState.PENDING).withTypeOfNotification(TypeOfNotification.EMAIL).withMeeting(meeting).withUser(user).build();
            this.notificationRepository.save(notification);
        }

    }

    /**
     * Find all notifications for this meeting array list.
     *
     * @param current the current
     * @return the array list
     */
    public ArrayList<Notification> findAllNotificationsForThisMeeting(Meeting current) {
        return  notificationRepository.findAllNotificationsForThisMeeting(current);
    }

    /**
     * Delete notifications.
     *
     * @param list the list
     */
    public void deleteNotifications(ArrayList<Notification> list) {
        for (Notification notification : list) {
            notificationRepository.remove(notification);
        }
    }

    /**
     * View notifications iterable.
     *
     * @return the iterable
     */
    public Iterable<Notification> viewNotifications() {
        ECourseUser eCourseUser = findUser();
        Iterable<Notification> notifications = new ArrayList<>();
        try {
            notifications = notificationRepository.findListNotificationsByUser(eCourseUser);
        }catch (Exception e) {
            System.out.println("Doesnt exit Notifications.");
        }
        return notifications;


    }

    private ECourseUser findUser() {
        EmailAddress email = authorizationService.session().get().authenticatedUser().email();
        return eCourseUserRepository.ofIdentity(email).get();
    }


    /**
     * Notification option.
     *
     * @param notification the notification
     * @param flag         the flag
     */
    @Transactional
    public void notificationOption(Notification notification,Boolean flag) {
        if (flag){
            notification.replaceNotificationState(NotificationState.ACCEPTED);
        }else {
            notification.replaceNotificationState(NotificationState.DECLINED);
        }
        notification =notificationRepository.save(notification);
        Meeting meeting = notification.Meeting();
        Participant participant = participantService.createParticipant(notification);
        meeting.addCourseUsers(participant);
        meeting =meetingRepository.save(meeting);

        if (flag) {
            ECourseUser eCourseUser = notification.eCourseUser();
            TimeTable timeTable = eCourseUser.timeTable();
            timeTable.addSchedules(meeting);
            timeTable = timetableRepository.save(timeTable);
            eCourseUser.replaceTimeTable(timeTable);
            eCourseUserRepository.save(eCourseUser);
        }

    }



}
