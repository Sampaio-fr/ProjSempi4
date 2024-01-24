package eapli.base.SharedBoardLog.domain;

import eapli.base.CellLog.domain.CellLog;
import eapli.base.sharedBoard.domain.SharedBoard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SharedBoardLogTest {

    @Test
    public void testConstructorAndGetters() {
        Calendar date = Calendar.getInstance();
        SharedBoard sharedBoard = new SharedBoard();
        List<CellLog> cellLogList = new ArrayList<>();

        SharedBoardLog sharedBoardLog = new SharedBoardLog(date, sharedBoard);

        Assertions.assertEquals(date, sharedBoardLog.date());
        Assertions.assertEquals(sharedBoard, sharedBoardLog.sharedBoard());
        Assertions.assertEquals(cellLogList, sharedBoardLog.cellLogList());
        Assertions.assertEquals(SharedBoardStateLog.Created, sharedBoardLog.sharedBoardStateLog());
    }

    @Test
    public void testReplaceId() {
        SharedBoardLog sharedBoardLog = new SharedBoardLog();
        Long newId = 1L;

        sharedBoardLog.replaceId(newId);

        Assertions.assertEquals(newId, sharedBoardLog.id());
    }

    @Test
    public void testReplaceDate() {
        SharedBoardLog sharedBoardLog = new SharedBoardLog();
        Calendar newDate = Calendar.getInstance();

        sharedBoardLog.replaceDate(newDate);

        Assertions.assertEquals(newDate, sharedBoardLog.date());
    }

    @Test
    public void testReplaceSharedBoard() {
        SharedBoardLog sharedBoardLog = new SharedBoardLog();
        SharedBoard newSharedBoard = new SharedBoard();

        sharedBoardLog.replaceSharedBoard(newSharedBoard);

        Assertions.assertEquals(newSharedBoard, sharedBoardLog.sharedBoard());
    }

    @Test
    public void testReplaceCellLogList() {
        SharedBoardLog sharedBoardLog = new SharedBoardLog();
        List<CellLog> newCellLogList = new ArrayList<>();

        sharedBoardLog.replaceCellLogList(newCellLogList);

        Assertions.assertEquals(newCellLogList, sharedBoardLog.cellLogList());
    }

    @Test
    public void testReplaceSharedBoardStateLog() {
        SharedBoardLog sharedBoardLog = new SharedBoardLog();
        SharedBoardStateLog newStateLog = SharedBoardStateLog.Updated;

        sharedBoardLog.replaceSharedBoardStateLog(newStateLog);

        Assertions.assertEquals(newStateLog, sharedBoardLog.sharedBoardStateLog());
    }

}
