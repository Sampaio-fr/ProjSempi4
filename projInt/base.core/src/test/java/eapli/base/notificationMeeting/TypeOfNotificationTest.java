package eapli.base.notificationMeeting;

import eapli.base.notificationMeeting.domain.TypeOfNotification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class TypeOfNotificationTest {
    @Test
    void testEmailNotification() {
        TypeOfNotification email = TypeOfNotification.EMAIL;
        assertEquals("EMAIL", email.name());
        assertEquals(0, email.ordinal());
        assertEquals(TypeOfNotification.EMAIL, TypeOfNotification.valueOf("EMAIL"));
    }

    @Test
    void testMessageNotification() {
        TypeOfNotification message = TypeOfNotification.MESSAGE;
        assertEquals("MESSAGE", message.name());
        assertEquals(1, message.ordinal());
        assertEquals(TypeOfNotification.MESSAGE, TypeOfNotification.valueOf("MESSAGE"));
    }

    @Test
    void testEquality() {
        assertEquals(TypeOfNotification.EMAIL, TypeOfNotification.valueOf("EMAIL"));
        assertEquals(TypeOfNotification.MESSAGE, TypeOfNotification.valueOf("MESSAGE"));
    }

    @Test
    void testInequality() {
        assertNotEquals(TypeOfNotification.EMAIL, TypeOfNotification.MESSAGE);
        assertNotEquals(TypeOfNotification.EMAIL, null);
        assertNotEquals(TypeOfNotification.EMAIL, "EMAIL");
    }
}
