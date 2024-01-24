package eapli.base.lecture.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LectureTypeTest {
    @Test
    void testLectureTypeEquality() {
        LectureType lectureType1 = LectureType.NORMAL;
        LectureType lectureType2 = LectureType.NORMAL;
        LectureType lectureType3 = LectureType.EXTRA;

        assertEquals(lectureType1, lectureType2); // Same enum value, should be equal
        assertNotEquals(lectureType1, lectureType3); // Different enum values, should not be equal
    }

    @Test
    void testLectureTypeOrdinal() {
        LectureType lectureType = LectureType.NORMAL;

        assertEquals(0, lectureType.ordinal()); // NORMAL has ordinal value 0
    }

    @Test
    void testLectureTypeToString() {
        LectureType lectureType = LectureType.NORMAL;
        String expectedToString = "NORMAL";

        assertEquals(expectedToString, lectureType.toString());
    }
    
}
