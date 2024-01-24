package eapli.base.enrollmentapproval.builder;

import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollmentapproval.domain.Decision;
import eapli.base.enrollmentapproval.domain.EnrollmentApproval;
import eapli.framework.general.domain.model.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Enrollment approval builder test.
 */
public class EnrollmentApprovalBuilderTest {

    private EnrollmentApprovalBuilder enrollmentApprovalBuilder;

    /**
     * Sets .
     */
    @BeforeEach
    public void setup() {
        enrollmentApprovalBuilder = new EnrollmentApprovalBuilder();
    }

    /**
     * Test with explanation.
     */
    @Test
    public void testWithExplanation() {
        Description explanation = Description.valueOf("Approved");

        EnrollmentApprovalBuilder result = enrollmentApprovalBuilder.withExplanation(explanation);

        assertEquals(explanation, result.getExplanation());
    }

    /**
     * Test with enrollment.
     */
    @Test
    public void testWithEnrollment() {
        Enrollment enrollment = new Enrollment();

        EnrollmentApprovalBuilder result = enrollmentApprovalBuilder.withEnrollment(enrollment);

        assertEquals(enrollment, result.getEnrollment());
    }

    /**
     * Test with decision.
     */
    @Test
    public void testWithDecision() {
        Decision decision = new Decision(true);

        EnrollmentApprovalBuilder result = enrollmentApprovalBuilder.withDecision(decision);

        assertEquals(decision, result.getDecision());
    }

    /**
     * Test with explanation string.
     */
    @Test
    public void testWithExplanation_String() {
        String explanation = "Approved";

        EnrollmentApprovalBuilder result = enrollmentApprovalBuilder.withExplanation(explanation);

        assertEquals(Description.valueOf(explanation), result.getExplanation());
    }

    /**
     * Test with decision boolean.
     */
    @Test
    public void testWithDecision_Boolean() {
        boolean decision = true;

        EnrollmentApprovalBuilder result = enrollmentApprovalBuilder.withDecision(decision);

        assertEquals(new Decision(decision), result.getDecision());
    }

    /**
     * Test build.
     */
    @Test
    public void testBuild() {
        Description explanation = Description.valueOf("Approved");
        Enrollment enrollment = new Enrollment();
        Decision decision = new Decision(true);

        EnrollmentApprovalBuilder result = enrollmentApprovalBuilder
                .withExplanation(explanation)
                .withEnrollment(enrollment)
                .withDecision(decision);

        EnrollmentApproval enrollmentApproval = result.build();

        assertEquals(explanation, enrollmentApproval.description());
        assertEquals(enrollment, enrollmentApproval.enrollment());
        assertEquals(decision, enrollmentApproval.decision());
    }
}
