package eapli.base.cell.domain;

import static org.junit.jupiter.api.Assertions.*;

import eapli.base.sharedBoard.domain.SharedBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellTest {
    private CellRow cellRow1;
    private CellRow cellRow2;
    private CellColumn cellColumn1;
    private CellColumn cellColumn2;
    private SharedBoard sharedBoard1;
    private SharedBoard sharedBoard2;
    private Cell cell1;
    private Cell cell2;
    private Cell cell3;

    @BeforeEach
    void setUp() {
        cellRow1 = new CellRow("Title 1", 1);
        cellRow2 = new CellRow("Title 2", 2);
        cellColumn1 = new CellColumn("Title 1", 1);
        cellColumn2 = new CellColumn("Title 2", 2);
        sharedBoard1 = new SharedBoard();
        sharedBoard2 = new SharedBoard();
        cell1 = new Cell(cellRow1, cellColumn1, sharedBoard1);
        cell2 = new Cell(cellRow2, cellColumn2, sharedBoard2);
        cell3 = new Cell(cellRow1, cellColumn1, sharedBoard1);
    }

    @Test
    void testSameAs_SameObject() {
        assertTrue(cell1.sameAs(cell1));
    }


    @Test
    void testSameAs_Null() {
        assertFalse(cell1.sameAs(null));
    }

    @Test
    void testSameAs_DifferentObjectType() {
        assertFalse(cell1.sameAs("not a Cell object"));
    }


}
