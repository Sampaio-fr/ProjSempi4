package eapli.base.invitation;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

/**
 * The type Invitation.
 */
@Entity
@Table
public class Invitation implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInvitation;

    @Enumerated(EnumType.STRING)
    private InvitationState invitationState;

    /**
     * Instantiates a new Invitation.
     */
    protected Invitation() {
    }

    /**
     * Instantiates a new Invitation.
     *
     * @param idInvitation the id invitation
     */
    public Invitation(final Long idInvitation) {
        this.idInvitation = idInvitation;
        this.invitationState = InvitationState.DENIED;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Invitation)) {
            return false;
        }

        final Invitation that = (Invitation) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) && invitationState == that.invitationState;
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
        return this.idInvitation;
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "idInvitation=" + idInvitation +
                ", invitationState=" + invitationState +
                '}';
    }
}
