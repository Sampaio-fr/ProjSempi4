package eapli.base.CellLog.domain;

import eapli.base.PostItLog.domain.PostItLog;
import eapli.base.cell.domain.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CellLogTest {

    @Test
    public void testConstructorAndGetters() {
        Calendar date = Calendar.getInstance();
        Cell cell = new Cell();
        List<PostItLog> postItLogList = new ArrayList<>();

        CellLog cellLog = new CellLog(date, cell);

        Assertions.assertEquals(date, cellLog.date());
        Assertions.assertEquals(cell, cellLog.cell());
        Assertions.assertEquals(postItLogList, cellLog.postItLogList());
    }

    @Test
    public void testReplaceId() {
        CellLog cellLog = new CellLog();
        Long newId = 1L;

        cellLog.replaceId(newId);

        Assertions.assertEquals(newId, cellLog.id());
    }

    @Test
    public void testReplaceDate() {
        CellLog cellLog = new CellLog();
        Calendar newDate = Calendar.getInstance();

        cellLog.replaceDate(newDate);

        Assertions.assertEquals(newDate, cellLog.date());
    }

    @Test
    public void testReplaceCell() {
        CellLog cellLog = new CellLog();
        Cell newCell = new Cell();

        cellLog.replaceCell(newCell);

        Assertions.assertEquals(newCell, cellLog.cell());
    }

    @Test
    public void testReplacePostItLogList() {
        CellLog cellLog = new CellLog();
        List<PostItLog> newPostItLogList = new ArrayList<>();

        cellLog.replacePostItLogList(newPostItLogList);

        Assertions.assertEquals(newPostItLogList, cellLog.postItLogList());
    }

}
