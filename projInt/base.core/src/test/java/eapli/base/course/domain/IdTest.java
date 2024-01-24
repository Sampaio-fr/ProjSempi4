package eapli.base.course.domain;

import eapli.base.course.domain.Id;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IdTest {

    @Test
    public void testIdCreation_ValidId() {
        String validId = "CS101";

        Id id = new Id(validId);

        Assertions.assertEquals(validId, id.toString());
    }

    @Test
    public void testIdCreation_NullId_ThrowsIllegalArgumentException() {
        String nullId = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Id(nullId);
        });
    }

    @Test
    public void testIdCreation_EmptyId_ThrowsIllegalArgumentException() {
        String emptyId = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Id(emptyId);
        });
    }

    @Test
    public void testIdCreation_InvalidId_ThrowsIllegalArgumentException() {
        String invalidId = "CS101-CS102414141414144241241441424141241241244214141414141414141414141414141414";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Id(invalidId);
        });
    }

    @Test
    public void testIdEquality_SameIdInstances_AreEqual() {
        String idValue = "CS101";
        Id id1 = new Id(idValue);
        Id id2 = new Id(idValue);

        Assertions.assertEquals(id1, id2);
    }

    @Test
    public void testIdEquality_DifferentIdInstances_AreNotEqual() {
        String idValue1 = "CS101";
        String idValue2 = "CS102";
        Id id1 = new Id(idValue1);
        Id id2 = new Id(idValue2);

        Assertions.assertNotEquals(id1, id2);
    }

    @Test
    public void testIdEquality_IdAndOtherObject_AreNotEqual() {
        String idValue = "CS101";
        Id id = new Id(idValue);
        Object otherObject = new Object();

        Assertions.assertNotEquals(id, otherObject);
    }
}
