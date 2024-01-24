package eapli.base.question.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTypeTest {

    @Test
    void testDisplayName() {
        assertEquals("MATCHING", QuestionType.MATCHING.displayName());
        assertEquals("MULTIPLE CHOICE", QuestionType.MULTIPLE_CHOICE.displayName());
        assertEquals("SHORT", QuestionType.SHORT_ANSWER.displayName());
        assertEquals("NUMERICAL", QuestionType.NUMERICAL.displayName());
        assertEquals("MISSING WORDS", QuestionType.MISSING_WORDS.displayName());
        assertEquals("TRUE/FALSE", QuestionType.TRUE_FALSE.displayName());
    }

    @Test
    void testDefineFromString() {
        assertEquals(QuestionType.MATCHING, QuestionType.defineFromString("MATCHING"));
        assertEquals(QuestionType.MULTIPLE_CHOICE, QuestionType.defineFromString("MULTIPLE CHOICE"));
        assertEquals(QuestionType.SHORT_ANSWER, QuestionType.defineFromString("SHORT"));
        assertEquals(QuestionType.NUMERICAL, QuestionType.defineFromString("NUMERICAL"));
        assertEquals(QuestionType.MISSING_WORDS, QuestionType.defineFromString("MISSING WORDS"));
        assertEquals(QuestionType.TRUE_FALSE, QuestionType.defineFromString("TRUE/FALSE"));
    }

    @Test
    void testDefineFromStringInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> QuestionType.defineFromString("INVALID"));
    }
}
