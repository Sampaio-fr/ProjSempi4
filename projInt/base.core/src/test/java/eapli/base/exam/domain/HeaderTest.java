package eapli.base.exam.domain;

import static org.junit.jupiter.api.Assertions.*;
import eapli.framework.general.domain.model.Description;
import org.junit.jupiter.api.Test;



class HeaderTest {


    @Test
    void testFeedbackMethods() {
        Header header = new Header( Description.valueOf("Description"), FeedbackType.NONE, GradeType.NONE);

        assertEquals(FeedbackType.NONE, header.getExamFeedBack());

        header.feedBackOnSubmission();
        assertEquals(FeedbackType.ON_SUBMISSION, header.getExamFeedBack());

        header.feedBackAfterClosing();
        assertEquals(FeedbackType.AFTER_CLOSING, header.getExamFeedBack());
    }

    @Test
    void testGradeMethods() {
        Header header = new Header( Description.valueOf("Description"), FeedbackType.NONE, GradeType.NONE);

        assertEquals(GradeType.NONE, header.getExamGrade());

        header.gradeOnSubmission();
        assertEquals(GradeType.ON_SUBMISSION, header.getExamGrade());

        header.gradeAfterClosing();
        assertEquals(GradeType.AFTER_CLOSING, header.getExamGrade());
    }

    @Test
    void testIdentity() {
        Header header = new Header(Description.valueOf("Description"), FeedbackType.NONE, GradeType.NONE);
        assertNotEquals(1L, header.identity());
    }



    @Test
    void testHashCode() {
        Header header1 = new Header(Description.valueOf("Description"), FeedbackType.NONE, GradeType.NONE);
        Header header2 = new Header(Description.valueOf("Description"), FeedbackType.NONE, GradeType.NONE);
        Header header3 = new Header(Description.valueOf("Description"), FeedbackType.NONE, GradeType.NONE);

        assertEquals(header1.hashCode(), header1.hashCode()); // Same instance
        assertEquals(header1.hashCode(), header2.hashCode()); // Different instance with different attributes
        assertEquals(header1.hashCode(), header3.hashCode()); // Different instance with same attributes
    }

    @Test
    void testToString() {
        Header header = new Header(Description.valueOf("Description"), FeedbackType.NONE, GradeType.NONE);

        String expected = "Header{idHeader=1, examDescription=Description, examFeedBack=NONE, examGrade=NONE}";
        assertNotEquals(expected, header.toString());
    }
}


