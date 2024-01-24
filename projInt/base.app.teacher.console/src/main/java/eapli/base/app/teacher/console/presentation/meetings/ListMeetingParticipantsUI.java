package eapli.base.app.teacher.console.presentation.meetings;

import eapli.base.app.teacher.console.presentation.printer.ListMeetingPrinter;
import eapli.base.course.domain.Course;
import eapli.base.meeting.application.ListMeetingParticipantsController;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.printer.MeetingPrinter;
import eapli.base.participant.domain.Participant;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.List;

public class ListMeetingParticipantsUI extends AbstractUI {

    ListMeetingParticipantsController controller = new ListMeetingParticipantsController();

    @Override
    protected boolean doShow() {
        Iterable<Meeting> userMeetings = controller.userMeetings();
        Meeting selectedMeeting;

        if (!userMeetings.iterator().hasNext()){
            System.out.println("You haven't created meeting!");
        } else {
            final SelectWidget<Meeting> selector = new SelectWidget<>("Meetings created:", userMeetings, new ListMeetingPrinter());
            selector.show();
            selectedMeeting = selector.selectedElement();

            List<Participant> meetingParticipants = controller.meetingParticipants(selectedMeeting);
            if(meetingParticipants.isEmpty()){
                System.out.println("None of the participants have seen the notification yet!");
            }else{
                for(Participant p: meetingParticipants){
                    System.out.println(p.statusToString());
                }
            }
        }
        return false;
    }

    @Override
    public String headline() {
        return "List meeting participants";
    }
}
