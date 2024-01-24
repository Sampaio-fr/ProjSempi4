package eapli.base.meeting.domain;

import eapli.base.schedule.domain.Schedule;
import eapli.framework.general.domain.model.Designation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class MeetingTest {

    @Test
    void testIsOccurring() {
        MeetingState classType = MeetingState.OCCURRING;
        Schedule schedule = new Schedule();
        Meeting meeting = new Meeting(Designation.valueOf("Meeting 1"),MeetingState.SCHEDULED, Calendar.getInstance(),60,new ArrayList<>(),null);
        assertFalse(meeting.isOccurring());
        assertFalse(meeting.isFinished());
    }

    @Test
    void testIsFinished() {
        MeetingState classType = MeetingState.FINISHED;
        Schedule schedule = new Schedule();
        Meeting meeting = new Meeting(Designation.valueOf("Meeting 2"),MeetingState.SCHEDULED, Calendar.getInstance(),60,new ArrayList<>(),null);
        assertFalse(meeting.isOccurring());
        assertFalse(meeting.isFinished());
    }

    @Test
    void testIdentity() {
        MeetingState classType = MeetingState.SCHEDULED;
        Schedule schedule = new Schedule();
        Meeting meeting = new Meeting(Designation.valueOf("Meeting 3"),MeetingState.SCHEDULED, Calendar.getInstance(),160,new ArrayList<>(),null);
        assertNotEquals(3L, meeting.identity());
    }

}
