package eapli.base.cell.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CellColumnTest {
    private CellColumn cellColumn1;
    private CellColumn cellColumn2;
    private CellColumn cellColumn3;

    @BeforeEach
    void setUp() {
        cellColumn1 = new CellColumn("Title 1", 1);
        cellColumn2 = new CellColumn("Title 2", 2);
        cellColumn3 = new CellColumn("Title 1", 1);
    }

    @Test
    void testEquals_SameObject() {
        assertEquals(cellColumn1, cellColumn1);
    }

    @Test
    void testEquals_SameValues() {
        assertEquals(cellColumn1, cellColumn3);
    }

    @Test
    void testEquals_DifferentValues() {
        assertNotEquals(cellColumn1, cellColumn2);
    }

}
