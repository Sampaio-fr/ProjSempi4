package eapli.base.invitation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvitationStateTest {
    @Test
    void testInvitationStateEquality() {
        InvitationState state1 = InvitationState.ACCEPTED;
        InvitationState state2 = InvitationState.ACCEPTED;

        assertEquals(state1, state2);
    }

    @Test
    void testInvitationStateInequality() {
        InvitationState state1 = InvitationState.ACCEPTED;
        InvitationState state2 = InvitationState.DENIED;

        assertNotEquals(state1, state2);
    }

    @Test
    void testInvitationStateToString() {
        InvitationState state = InvitationState.DENIED;
        String expectedToString = "DENIED";

        assertEquals(expectedToString, state.toString());
    }
}
