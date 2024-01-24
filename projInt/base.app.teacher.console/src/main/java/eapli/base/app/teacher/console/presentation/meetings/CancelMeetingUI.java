package eapli.base.app.teacher.console.presentation.meetings;

import eapli.base.app.teacher.console.presentation.lectures.LecturePrinter;
import eapli.base.lecture.domain.Lecture;
import eapli.base.meeting.application.CancelMeetingController;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.printer.MeetingPrinter;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;

public class CancelMeetingUI extends AbstractUI {

    private final CancelMeetingController cancelMeetingController= new CancelMeetingController();

    @Override
    protected boolean doShow() {
        boolean flag;
        Iterable<Meeting> meetingArrayList = cancelMeetingController.listOfMeetingsOwner();
         if (meetingArrayList.iterator().hasNext()) {
             final SelectWidget<Meeting> selector = new SelectWidget<Meeting>("Meetings:", meetingArrayList, new MeetingPrinter());
             selector.show();
             final Meeting current = selector.selectedElement();

             try{
             cancelMeetingController.deleteMeeting(current);
             flag = true;
             }
             catch (final Exception e){
                 flag = false;
             }

             if (flag){
                 System.out.println("Cancelled with success");
             }else {
                 System.out.println("Cancelled with failure");
             }
         }
        return false;
    }

    @Override
    public String headline() {
        return "Cancel Meeting";
    }
}
