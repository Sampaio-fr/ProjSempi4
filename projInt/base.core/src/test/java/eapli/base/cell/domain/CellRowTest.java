package eapli.base.cell.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellRowTest {
    private CellRow cellRow1;
    private CellRow cellRow2;
    private CellRow cellRow3;

    @BeforeEach
    void setUp() {
        cellRow1 = new CellRow("Title 1", 1);
        cellRow2 = new CellRow("Title 2", 2);
        cellRow3 = new CellRow("Title 1", 1);
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(cellRow1, cellRow1);
    }

    @Test
    void testEquals_SameValues() {
        assertEquals(cellRow1, cellRow3);
    }

    @Test
    void testEquals_DifferentValues() {
        assertNotEquals(cellRow1, cellRow2);
    }


}
