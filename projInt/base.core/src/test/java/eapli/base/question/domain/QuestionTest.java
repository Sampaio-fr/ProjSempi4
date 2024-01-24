package eapli.base.question.domain;

import eapli.base.course.domain.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    private Question question;
    private QuestionType questionType;
    private String questionText;
    private Course questionCourse;

    @BeforeEach
    void setUp() {
        questionType = QuestionType.MATCHING;
        questionText = "What is the capital of France?";
        questionCourse = null;

        question = new Question(questionType, questionText, questionCourse);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(questionType, question.questionType());
        assertEquals(questionText, question.question());
        assertEquals(questionCourse, question.questionCourse());
    }

    @Test
    void testChangeQuestion() {
        String newQuestionText = "What is the largest country in the world?";
        question.changeQuestion(newQuestionText);
        assertEquals(newQuestionText, question.question());
    }

    @Test
    void testChangeQuestionCourse() {
        Course newQuestionCourse = null;
        question.changeQuestionCourse(newQuestionCourse);
        assertEquals(newQuestionCourse, question.questionCourse());
    }

    @Test
    void testIdentity() {
        assertNull(question.identity());
    }


    @Test
    void testToString() {
        String expectedString = "Question{" +
                "idQuestion=" + question.identity() +
                ", questionType=" + questionType +
                ", question='" + questionText + '\'' +
                ", questionCourse=" + questionCourse +
                '}';
        assertEquals(expectedString, question.toString());
    }
}
