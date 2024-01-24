package eapli.base.enrollmentapproval.domain;

import eapli.base.enrollment.domain.Enrollment;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;
import eapli.framework.general.domain.model.Description;
import eapli.framework.validations.Preconditions;

import javax.persistence.*;

/**
 * The type Enrollment approval.
 */
@Entity
@Table
public class EnrollmentApproval implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnrollAprov;

    //tp sobre acesso concorrente a base de dados

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "description"))
    private Description description;

    @OneToOne
    private Enrollment enrollment;

    @Embedded
    @Column(name = "decision")
    private Decision decision;

    /**
     * Instantiates a new Enrollment approval.
     */
    protected EnrollmentApproval() {
    }


    /**
     * Instantiates a new Enrollment approval.
     *
     * @param description the description
     * @param enrollment  the enrollment
     * @param decision    the decision
     */
    public EnrollmentApproval(final Description description, final Enrollment enrollment, Decision decision) {
        Preconditions.noneNull(description, enrollment);
        this.decision = decision;
        this.description = description;
        this.enrollment = enrollment;
    }


    /**
     * Gets description.
     *
     * @return the description
     */
    public Description description() {
        return description;
    }


    /**
     * Gets enrollment.
     *
     * @return the enrollment
     */
    public Enrollment enrollment() {
        return enrollment;
    }

    /**
     * Gets decision.
     *
     * @return the decision
     */
    public Decision decision() {
        return decision;
    }

    /**
     * Sets decision.
     *
     * @param decision the decision
     */
    public void changeDecision(Decision decision) {
        this.decision = decision;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof EnrollmentApproval)) {
            return false;
        }

        final EnrollmentApproval that = (EnrollmentApproval) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) && decision.equals(that.decision) && enrollment.equals(that.enrollment);
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }

    @Override
    public Long identity() {
        return this.idEnrollAprov;
    }

    @Override
    public String toString() {
        return "EnrollmentApproval = " + "\n" +
                "Id = " + idEnrollAprov + "\n" +
                "Decision=" + decision + "\n" +
                "Enrollment=" + enrollment + "\n" ;
    }
}
