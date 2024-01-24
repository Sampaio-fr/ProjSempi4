package eapli.base.exam.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FeedbackTypeTest {
    @Test
    void testEnumValues() {
        assertEquals(3, FeedbackType.values().length);
        assertEquals(FeedbackType.NONE, FeedbackType.valueOf("NONE"));
        assertEquals(FeedbackType.ON_SUBMISSION, FeedbackType.valueOf("ON_SUBMISSION"));
        assertEquals(FeedbackType.AFTER_CLOSING, FeedbackType.valueOf("AFTER_CLOSING"));
    }

    @Test
    void testEnumEquality() {
        assertEquals(FeedbackType.NONE, FeedbackType.NONE);
        assertNotEquals(FeedbackType.NONE, FeedbackType.ON_SUBMISSION);
    }

    @Test
    void testEnumToString() {
        assertEquals("NONE", FeedbackType.NONE.toString());
        assertEquals("ON_SUBMISSION", FeedbackType.ON_SUBMISSION.toString());
        assertEquals("AFTER_CLOSING", FeedbackType.AFTER_CLOSING.toString());
    }
}
