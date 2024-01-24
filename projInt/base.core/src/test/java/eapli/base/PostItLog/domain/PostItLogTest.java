package eapli.base.PostItLog.domain;

import eapli.base.cell.domain.Cell;
import eapli.base.postIt.domain.Description;
import eapli.base.postIt.domain.PostIt;
import eapli.base.postIt.domain.Title;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class PostItLogTest {

    @Test
    public void testConstructorAndGetters() {
        Calendar date = Calendar.getInstance();
        Cell cell = new Cell();
        PostIt postIt = new PostIt();
        PostItStateLog postItStateLog = PostItStateLog.Create;

        PostItLog postItLog = new PostItLog(Calendar.getInstance(),cell,postIt,PostItStateLog.Create,new Title("Title"),new Description("Description"));

        Assertions.assertEquals(cell, postItLog.cell());
        Assertions.assertEquals(postIt, postItLog.postIt());
        Assertions.assertEquals(postItStateLog, postItLog.postItStateLog());
    }

    @Test
    public void testReplaceId() {
        PostItLog postItLog = new PostItLog();
        Long newId = 1L;

        postItLog.replaceId(newId);

        Assertions.assertEquals(newId, postItLog.id());
    }

    @Test
    public void testReplaceDate() {
        PostItLog postItLog = new PostItLog();
        Calendar newDate = Calendar.getInstance();

        postItLog.replaceDate(newDate);

        Assertions.assertEquals(newDate, postItLog.date());
    }

    @Test
    public void testReplaceCell() {
        PostItLog postItLog = new PostItLog();
        Cell newCell = new Cell();

        postItLog.replaceCell(newCell);

        Assertions.assertEquals(newCell, postItLog.cell());
    }

    @Test
    public void testReplacePostIt() {
        PostItLog postItLog = new PostItLog();
        PostIt newPostIt = new PostIt();

        postItLog.replacePostIt(newPostIt);

        Assertions.assertEquals(newPostIt, postItLog.postIt());
    }

    @Test
    public void testReplacePostItStateLog() {
        PostItLog postItLog = new PostItLog();
        PostItStateLog newStateLog = PostItStateLog.Create;

        postItLog.replacePostItStateLog(newStateLog);

        Assertions.assertEquals(newStateLog, postItLog.postItStateLog());
    }

    @Test
    public void testEqualsAndHashCode() {
        PostItLog postItLog1 = new PostItLog();
        postItLog1.replaceId(1L);
        PostItLog postItLog2 = new PostItLog();
        postItLog2.replaceId(1L);
        PostItLog postItLog3 = new PostItLog();
        postItLog3.replaceId(2L);

        Assertions.assertEquals(postItLog1, postItLog2);
        Assertions.assertNotEquals(postItLog1, postItLog3);

        Assertions.assertEquals(postItLog1.hashCode(), postItLog2.hashCode());
        Assertions.assertNotEquals(postItLog1.hashCode(), postItLog3.hashCode());
    }

    @Test
    public void testSameAs() {
        PostItLog postItLog1 = new PostItLog();
        postItLog1.replaceId(1L);
        PostItLog postItLog2 = new PostItLog();
        postItLog2.replaceId(1L);
        PostItLog postItLog3 = new PostItLog();
        postItLog3.replaceId(2L);

        Assertions.assertTrue(postItLog1.sameAs(postItLog2));
        Assertions.assertFalse(postItLog1.sameAs(postItLog3));
    }
}
