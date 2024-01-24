package eapli.base.SharedBoardLog.domain;

import eapli.base.SharedBoardLog.domain.SharedBoardStateLog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SharedBoardStateLogTest {

    @Test
    public void testEnumValues() {
        SharedBoardStateLog created = SharedBoardStateLog.Created;
        SharedBoardStateLog updated = SharedBoardStateLog.Updated;
        SharedBoardStateLog undo = SharedBoardStateLog.Undo;

        Assertions.assertEquals("Created", created.name());
        Assertions.assertEquals("Updated", updated.name());
        Assertions.assertEquals("Undo", undo.name());
    }

    @Test
    public void testEnumToString() {
        SharedBoardStateLog created = SharedBoardStateLog.Created;
        SharedBoardStateLog updated = SharedBoardStateLog.Updated;
        SharedBoardStateLog undo = SharedBoardStateLog.Undo;

        Assertions.assertEquals("Created", created.toString());
        Assertions.assertEquals("Updated", updated.toString());
        Assertions.assertEquals("Undo", undo.toString());
    }
}
