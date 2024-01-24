package eapli.base.app.student.console.presentation.meetings;

import eapli.base.meeting.domain.Meeting;
import eapli.framework.visitor.Visitor;

import java.text.SimpleDateFormat;

public class ListMeetingPrinter implements Visitor<Meeting> {
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH:mm");
    @Override
    public void visit(Meeting meeting) {
        System.out.println("----------Meeting----------");
        System.out.println(meeting.meetingTitle().toString());
        System.out.println("Date: " + format.format(meeting.initialDate().getTime()));
        System.out.println("Duration: " + meeting.duration()+ " mins");
        System.out.println("--------------------------------");
    }
}

