package eapli.base.notificationMeeting.printer;

import eapli.base.notificationMeeting.domain.Notification;
import eapli.framework.visitor.Visitor;

public class NotificationPrinter implements Visitor<Notification> {
    @Override
    public void visit(Notification visitee) {
        System.out.println("Notification:");
        System.out.println("Meeting Title: " + visitee.Meeting().meetingTitle());
        System.out.println("Start Date: " + visitee.Meeting().initialDate().getTime());
        System.out.println("Final Date: " + visitee.Meeting().finalDate().getTime());
        System.out.println("------------------------------------------------");
    }
}
