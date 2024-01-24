package eapli.base.notificationMeeting.applications;

import eapli.base.meeting.service.MeetingManagementService;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.notificationMeeting.services.NotificationAcceptanceService;

import java.util.ArrayList;

public class MeetingRequestsController {


    private MeetingManagementService meetingManagementService ;

    private NotificationAcceptanceService notificationAcceptanceService;


    public MeetingRequestsController() {
        meetingManagementService = new MeetingManagementService();
        notificationAcceptanceService = new NotificationAcceptanceService();
    }


    public Iterable<Notification> listOfNotifications() {
        return notificationAcceptanceService.viewNotifications();
    }

    public void notificationOption(Notification notification,Boolean flag) {
        notificationAcceptanceService.notificationOption(notification,flag);
    }
}
