package eapli.base.exam.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExamTypeTest {
    @Test
    void testEnumValues() {
        assertEquals(2, ExamType.values().length);
        assertEquals(ExamType.FORMATIVE, ExamType.valueOf("FORMATIVE"));
        assertEquals(ExamType.SUMMATIVE, ExamType.valueOf("SUMMATIVE"));
    }

    @Test
    void testEnumEquality() {
        assertEquals(ExamType.FORMATIVE, ExamType.FORMATIVE);
        assertNotEquals(ExamType.FORMATIVE, ExamType.SUMMATIVE);
    }

    @Test
    void testEnumToString() {
        assertEquals("FORMATIVE", ExamType.FORMATIVE.toString());
        assertEquals("SUMMATIVE", ExamType.SUMMATIVE.toString());
    }
}
