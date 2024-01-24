package eapli.base.participant.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ParticipantStateTest {

    @Test
    void testAcceptedState() {
        ParticipantState state = ParticipantState.ACCEPTED;
        assertEquals("ACCEPTED", state.name());
        assertEquals(0, state.ordinal());
    }

    @Test
    void testDeclinedState() {
        ParticipantState state = ParticipantState.DECLINED;
        assertEquals("DECLINED", state.name());
        assertEquals(1, state.ordinal());
    }
}
