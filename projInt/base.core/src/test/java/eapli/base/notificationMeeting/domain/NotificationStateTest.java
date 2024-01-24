package eapli.base.notificationMeeting.domain;

import eapli.base.notificationMeeting.domain.NotificationState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationStateTest {

    @Test
    void testPendingState() {
        NotificationState state = NotificationState.PENDING;
        assertEquals("PENDING", state.name());
        assertEquals(0, state.ordinal());
    }

    @Test
    void testAcceptedState() {
        NotificationState state = NotificationState.ACCEPTED;
        assertEquals("ACCEPTED", state.name());
        assertEquals(1, state.ordinal());
    }

    @Test
    void testDeclinedState() {
        NotificationState state = NotificationState.DECLINED;
        assertEquals("DECLINED", state.name());
        assertEquals(2, state.ordinal());
    }
}
