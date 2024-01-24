package eapli.base.invitation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvitationTest {
    @Test
    void testInvitationEquality() {
        Invitation invitation1 = new Invitation(1L);
        Invitation invitation2 = new Invitation(1L);

        assertEquals(invitation1, invitation2);
    }

    @Test
    void testInvitationInequality() {
        Invitation invitation1 = new Invitation(1L);
        Invitation invitation2 = new Invitation(2L);

        assertNotEquals(invitation1, invitation2);
    }

    @Test
    void testInvitationIdentity() {
        Invitation invitation = new Invitation(1L);
        Long expectedIdentity = 1L;

        assertEquals(expectedIdentity, invitation.identity());
    }

    @Test
    void testInvitationToString() {
        Invitation invitation = new Invitation(1L);
        String expectedToString = "Invitation{idInvitation=1, invitationState=DENIED}";

        assertEquals(expectedToString, invitation.toString());
    }
}
