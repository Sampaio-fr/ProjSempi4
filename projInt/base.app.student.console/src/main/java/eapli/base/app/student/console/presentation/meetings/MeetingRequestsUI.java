package eapli.base.app.student.console.presentation.meetings;


import eapli.base.notificationMeeting.applications.MeetingRequestsController;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.notificationMeeting.printer.NotificationPrinter;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;


public class MeetingRequestsUI extends AbstractUI {
    MeetingRequestsController meetingRequestsController = new MeetingRequestsController();

    @Override
    protected boolean doShow() {
        int x = 999;
        boolean answer = false;
        boolean flag,flag2;

        Iterable<Notification> notificationIterable = meetingRequestsController.listOfNotifications();

        if (notificationIterable.iterator().hasNext()) {
            final SelectWidget<Notification> selector = new SelectWidget<Notification>("Notifications:", notificationIterable, new NotificationPrinter());
            selector.show();
            final Notification current = selector.selectedElement();
            do {
                try {
                    System.out.println(current.Meeting().meetingTitle());
                    answer = Console.readBoolean("Want to accept ? y or n");
                    flag = true;
                }catch (Exception e){
                    flag = false;
                }
            }while (!flag);


            try {
                meetingRequestsController.notificationOption(current,answer);
                flag2 = true;
            }catch (Exception e){
                System.out.println("Error accepting or declining the notification");
                flag2 = false;
            }

            if (flag2) {
                System.out.println("Notification confirmed.");
            }



        }else {
            System.out.println("Does not exit Notifications.");
        }



        return false;
    }

    @Override
    public String headline() {
        return "List of Meeting Requests";
    }
}
