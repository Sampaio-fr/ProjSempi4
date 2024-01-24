package eapli.base.enrollmentapproval.domain;

import java.util.Objects;

/**
 * The type Decision.
 */
public class Decision {

    private Boolean Decision;

    /**
     * Instantiates a new Decision.
     */
    public Decision() {
    }

    /**
     * Instantiates a new Decision.
     *
     * @param decision the decision
     */
    public Decision(Boolean decision) {
        Decision = decision;
    }

    /**
     * Gets decision.
     *
     * @return the decision
     */
    public Boolean getDecision() {
        return Decision;
    }

    /**
     * Sets decision.
     *
     * @param decision the decision
     */
    public void setDecision(Boolean decision) {
        Decision = decision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decision decision = (Decision) o;
        return Objects.equals(Decision, decision.Decision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Decision);
    }

    @Override
    public String toString() {
        return "Decision{" +
                "Decision=" + Decision +
                '}';
    }
}
