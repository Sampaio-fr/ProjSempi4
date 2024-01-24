package eapli.base.course.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CodeTest {

    @Test
    public void testEditionCreation_ValidEdition_Success() {
        String validEdition = "2023";

        Code code = new Code(validEdition);

        Assertions.assertEquals(validEdition, code.toString());
    }

    @Test
    public void testEditionCreation_NullEdition_ThrowsIllegalArgumentException() {
        String nullEdition = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Code(nullEdition);
        });
    }

    @Test
    public void testEditionCreation_EmptyEdition_ThrowsIllegalArgumentException() {
        String emptyEdition = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Code(emptyEdition);
        });
    }


    @Test
    public void testEditionValueOf_ValidEdition_Success() {
        String validEdition = "2023";

        Code code = Code.valueOf(validEdition);

        Assertions.assertEquals(validEdition, code.toString());
    }

    @Test
    public void testEquals_SameEdition_ReturnsTrue() {
        String editionString = "2023";
        Code code1 = new Code(editionString);
        Code code2 = new Code(editionString);

        Assertions.assertEquals(code1, code2);
    }

    @Test
    public void testEquals_DifferentEdition_ReturnsFalse() {
        Code code1 = new Code("2023");
        Code code2 = new Code("2022");

        Assertions.assertNotEquals(code1, code2);
    }

    @Test
    public void testHashCode_SameEdition_ReturnsSameHashCode() {
        String editionString = "2023";
        Code code1 = new Code(editionString);
        Code code2 = new Code(editionString);

        Assertions.assertEquals(code1.hashCode(), code2.hashCode());
    }

    @Test
    public void testToString_ReturnsEditionString() {
        String editionString = "2023";
        Code code = new Code(editionString);

        Assertions.assertEquals(editionString, code.toString());
    }

    @Test
    public void testCompareTo_LessThan_ReturnsNegativeValue() {
        Code code1 = new Code("2022");
        Code code2 = new Code("2023");

        Assertions.assertTrue(code1.compareTo(code2) < 0);
    }

    @Test
    public void testCompareTo_GreaterThan_ReturnsPositiveValue() {
        Code code1 = new Code("2023");
        Code code2 = new Code("2022");

        Assertions.assertTrue(code1.compareTo(code2) > 0);
    }

    @Test
    public void testCompareTo_Equal_ReturnsZero() {
        Code code1 = new Code("2023");
        Code code2 = new Code("2023");

        Assertions.assertEquals(0, code1.compareTo(code2));
    }
}
