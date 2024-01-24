package eapli.base.clientusermanagement.domain;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MecanographicNumberTest {
    @Test
    void testConstructor_ValidNumber() {
        String validNumber = "12345";
        MecanographicNumber mecanographicNumber = new MecanographicNumber(validNumber);
        assertEquals(validNumber, mecanographicNumber.toString());
    }

    @Test
    void testConstructor_NullNumber() {
        assertThrows(IllegalArgumentException.class, () -> new MecanographicNumber(null));
    }

    @Test
    void testConstructor_EmptyNumber() {
        assertThrows(IllegalArgumentException.class, () -> new MecanographicNumber(""));
    }

    @Test
    void testEquals_SameObject() {
        MecanographicNumber mecanographicNumber = new MecanographicNumber("12345");
        assertTrue(mecanographicNumber.equals(mecanographicNumber));
    }

    @Test
    void testEquals_SameValues() {
        MecanographicNumber mecanographicNumber1 = new MecanographicNumber("12345");
        MecanographicNumber mecanographicNumber2 = new MecanographicNumber("12345");
        assertTrue(mecanographicNumber1.equals(mecanographicNumber2));
    }

    @Test
    void testEquals_DifferentValues() {
        MecanographicNumber mecanographicNumber1 = new MecanographicNumber("12345");
        MecanographicNumber mecanographicNumber2 = new MecanographicNumber("67890");
        assertFalse(mecanographicNumber1.equals(mecanographicNumber2));
    }

    @Test
    void testEquals_Null() {
        MecanographicNumber mecanographicNumber = new MecanographicNumber("12345");
        assertFalse(mecanographicNumber.equals(null));
    }

    @Test
    void testEquals_DifferentObjectType() {
        MecanographicNumber mecanographicNumber = new MecanographicNumber("12345");
        assertFalse(mecanographicNumber.equals("not a MecanographicNumber object"));
    }

    @Test
    void testHashCode_SameValues() {
        MecanographicNumber mecanographicNumber1 = new MecanographicNumber("12345");
        MecanographicNumber mecanographicNumber2 = new MecanographicNumber("12345");
        assertEquals(mecanographicNumber1.hashCode(), mecanographicNumber2.hashCode());
    }

    @Test
    void testHashCode_DifferentValues() {
        MecanographicNumber mecanographicNumber1 = new MecanographicNumber("12345");
        MecanographicNumber mecanographicNumber2 = new MecanographicNumber("67890");
        assertNotEquals(mecanographicNumber1.hashCode(), mecanographicNumber2.hashCode());
    }

    @Test
    void testToString() {
        String number = "12345";
        MecanographicNumber mecanographicNumber = new MecanographicNumber(number);
        assertEquals(number, mecanographicNumber.toString());
    }

    @Test
    void testCompareTo_SameValues() {
        MecanographicNumber mecanographicNumber1 = new MecanographicNumber("12345");
        MecanographicNumber mecanographicNumber2 = new MecanographicNumber("12345");
        assertEquals(0, mecanographicNumber1.compareTo(mecanographicNumber2));
    }

    @Test
    void testCompareTo_DifferentValues() {
        MecanographicNumber mecanographicNumber1 = new MecanographicNumber("12345");
        MecanographicNumber mecanographicNumber2 = new MecanographicNumber("67890");
        assertTrue(mecanographicNumber1.compareTo(mecanographicNumber2) < 0);
        assertTrue(mecanographicNumber2.compareTo(mecanographicNumber1) > 0);
    }
}
