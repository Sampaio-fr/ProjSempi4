package eapli.base.enrollmentapproval.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DecisionTest {

    @Test
    public void testEquals() {
        Decision decision1 = new Decision(true);
        Decision decision2 = new Decision(true);
        Decision decision3 = new Decision(false);

        // Test equality
        assertEquals(decision1, decision2);

        // Test inequality
        assertNotEquals(decision1, decision3);
    }

    @Test
    public void testHashCode() {
        Decision decision1 = new Decision(true);
        Decision decision2 = new Decision(true);

        // Test hashCode equality
        assertEquals(decision1.hashCode(), decision2.hashCode());
    }

    @Test
    public void testToString() {
        Decision decision = new Decision(true);

        // Test toString output
        assertEquals("Decision{Decision=true}", decision.toString());
    }
}
