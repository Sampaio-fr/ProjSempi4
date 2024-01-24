package eapli.base.exam.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GradeTypeTest {
    @Test
    void testEnumValues() {
        assertEquals(3, GradeType.values().length);
        assertEquals(GradeType.NONE, GradeType.valueOf("NONE"));
        assertEquals(GradeType.ON_SUBMISSION, GradeType.valueOf("ON_SUBMISSION"));
        assertEquals(GradeType.AFTER_CLOSING, GradeType.valueOf("AFTER_CLOSING"));
    }

    @Test
    void testEnumEquality() {
        assertEquals(GradeType.NONE, GradeType.NONE);
        assertNotEquals(GradeType.NONE, GradeType.ON_SUBMISSION);
    }

    @Test
    void testEnumToString() {
        assertEquals("NONE", GradeType.NONE.toString());
        assertEquals("ON_SUBMISSION", GradeType.ON_SUBMISSION.toString());
        assertEquals("AFTER_CLOSING", GradeType.AFTER_CLOSING.toString());
    }
}
