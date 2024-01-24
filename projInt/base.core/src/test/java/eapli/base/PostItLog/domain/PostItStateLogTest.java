package eapli.base.PostItLog.domain;

import eapli.base.PostItLog.domain.PostItStateLog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostItStateLogTest {

    @Test
    public void testEnumValues() {
        PostItStateLog create = PostItStateLog.Create;
        PostItStateLog update = PostItStateLog.Update;
        PostItStateLog undo = PostItStateLog.Undo;

        Assertions.assertEquals("Create", create.name());
        Assertions.assertEquals("Update", update.name());
        Assertions.assertEquals("Undo", undo.name());
    }

    @Test
    public void testEnumToString() {
        PostItStateLog create = PostItStateLog.Create;
        PostItStateLog update = PostItStateLog.Update;
        PostItStateLog undo = PostItStateLog.Undo;

        Assertions.assertEquals("Create", create.toString());
        Assertions.assertEquals("Update", update.toString());
        Assertions.assertEquals("Undo", undo.toString());
    }
}
