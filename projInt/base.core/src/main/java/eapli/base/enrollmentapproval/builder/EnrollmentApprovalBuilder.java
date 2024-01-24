package eapli.base.enrollmentapproval.builder;


import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollmentapproval.domain.Decision;
import eapli.base.enrollmentapproval.domain.EnrollmentApproval;
import eapli.framework.general.domain.model.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Enrollment approval builder.
 */
public class EnrollmentApprovalBuilder {

    private static final Logger LOGGER = LogManager.getLogger(EnrollmentApprovalBuilder.class);
    private Description explanation;
    private Enrollment enrollment;
    private Decision decision;

    /**
     * Gets explanation.
     *
     * @return the explanation
     */
    public Description getExplanation() {
        return explanation;
    }

    /**
     * Gets enrollment.
     *
     * @return the enrollment
     */
    public Enrollment getEnrollment() {
        return enrollment;
    }

    /**
     * Gets decision.
     *
     * @return the decision
     */
    public Decision getDecision() {
        return decision;
    }

    /**
     * With explanation enrollment approval builder.
     *
     * @param explanation the explanation
     * @return the enrollment approval builder
     */
    public EnrollmentApprovalBuilder withExplanation(Description explanation) {
        this.explanation = explanation;
        return this;
    }

    /**
     * With enrollment enrollment approval builder.
     *
     * @param enrollment the enrollment
     * @return the enrollment approval builder
     */
    public EnrollmentApprovalBuilder withEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
        return this;
    }

    /**
     * With decision enrollment approval builder.
     *
     * @param decision the decision
     * @return the enrollment approval builder
     */
    public EnrollmentApprovalBuilder withDecision(Decision decision) {
        this.decision = decision;
        return this;
    }


    /**
     * With explanation enrollment approval builder.
     *
     * @param explanation the explanation
     * @return the enrollment approval builder
     */
    public EnrollmentApprovalBuilder withExplanation(String explanation) {
        this.explanation = Description.valueOf(explanation);
        return this;
    }


    /**
     * With decision enrollment approval builder.
     *
     * @param decision the decision
     * @return the enrollment approval builder
     */
    public EnrollmentApprovalBuilder withDecision(boolean decision) {
        this.decision = new Decision(decision);
        return this;
    }

    /**
     * Instantiates a new Enrollment approval builder.
     */
    public EnrollmentApprovalBuilder() {
    }


    /**
     * Build enrollment approval.
     *
     * @return the enrollment approval
     */
    public EnrollmentApproval build() {
        EnrollmentApproval enrollmentApproval = new EnrollmentApproval(this.explanation,this.enrollment,this.decision);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Creating new EnrollmentApproval {} {} {} with system info ", this.explanation,this.enrollment,this.decision);
        }

        return enrollmentApproval;
    }

}
