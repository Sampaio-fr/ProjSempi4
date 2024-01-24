package eapli.base.meeting.printer;

import eapli.base.lecture.domain.Lecture;
import eapli.base.meeting.domain.Meeting;
import eapli.framework.visitor.Visitor;

public class MeetingPrinter  implements Visitor<Meeting>{

    @Override
    public void visit(Meeting meeting) {
        System.out.println("----------Meeting----------");
        System.out.printf( meeting.meetingTitle().toString());
        System.out.println(meeting.initialDate().toString());
        System.out.println("--------------------------------");
    }
}

