package eapli.base.exam.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamStateTest {
    @Test
    void testExamStateEquality() {
        ExamState state1 = ExamState.DRAFT;
        ExamState state2 = ExamState.DRAFT;

        assertEquals(state1, state2);
    }

    @Test
    void testExamStateInequality() {
        ExamState state1 = ExamState.DRAFT;
        ExamState state2 = ExamState.PUBLISHED;

        assertNotEquals(state1, state2);
    }

    @Test
    void testExamStateToString() {
        ExamState state = ExamState.PUBLISHED;
        String expectedToString = "PUBLISHED";

        assertEquals(expectedToString, state.toString());
    }
}
