package eapli.base.meeting.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class MeetingStateTest {
    @Test
    void testScheduledMeetingState() {
        assertEquals(MeetingState.SCHEDULED, MeetingState.valueOf("SCHEDULED"));
    }

    @Test
    void testOccurringMeetingState() {
        assertEquals(MeetingState.OCCURRING, MeetingState.valueOf("OCCURRING"));
    }

    @Test
    void testFinishedMeetingState() {
        assertEquals(MeetingState.FINISHED, MeetingState.valueOf("FINISHED"));
    }
}
