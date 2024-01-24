package eapli.base.participant.domain;

import eapli.base.meeting.domain.Meeting;
import eapli.base.user.domain.ECourseUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    private Participant participant;
    private Long idParticipant;
    private Meeting meeting;
    private ECourseUser eCourseUser;
    private ParticipantState participantState;

    @BeforeEach
    void setUp() {
        idParticipant = 1L;
        meeting = null;
        eCourseUser = null;
        participantState = ParticipantState.ACCEPTED;

        participant = new Participant(meeting, eCourseUser, participantState);
    }


    @Test
    void testReplaceMeeting() {
        Meeting newMeeting = null;
        participant.replaceMeeting(newMeeting);
        assertEquals(newMeeting, participant.meeting());
    }

    @Test
    void testReplaceECourseUser() {
        ECourseUser newECourseUser = null;
        participant.replaceeCourseUser(newECourseUser);
        assertEquals(newECourseUser, participant.eCourseUser());
    }

    @Test
    void testSameAs() {
        Participant sameParticipant = new Participant(meeting, eCourseUser, participantState);
        assertTrue(participant.sameAs(sameParticipant));

        Participant differentParticipant = new Participant(meeting, eCourseUser, ParticipantState.DECLINED);
        assertTrue(participant.sameAs(differentParticipant));
    }

}
