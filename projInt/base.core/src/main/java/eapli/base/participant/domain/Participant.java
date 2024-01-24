package eapli.base.participant.domain;

import eapli.base.meeting.domain.Meeting;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Participant.
 */
@Entity
@Table
public class Participant implements AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idParticipant")
    private Long idParticipant;

    @Enumerated(EnumType.STRING)
    private ParticipantState participantState;
    @OneToOne
    private Meeting meeting;

    @OneToOne
    private ECourseUser eCourseUser;

    /**
     * Instantiates a new Participant.
     *
     * @param meeting          the meeting
     * @param eCourseUser      the e course user
     * @param participantState the participant state
     */
    public Participant(Meeting meeting, ECourseUser eCourseUser,ParticipantState participantState) {
        this.meeting = meeting;
        this.eCourseUser = eCourseUser;
        this.participantState = participantState;
    }

    /**
     * Instantiates a new Participant.
     */
    public Participant() {

    }

    public ParticipantState participantState() {
        return participantState;
    }

    public void replaceParticipantState(ParticipantState participantState) {
        this.participantState = participantState;
    }

    /**
     * Meeting meeting.
     *
     * @return the meeting
     */
    public Meeting meeting() {
        return meeting;
    }

    /**
     * Replace meeting.
     *
     * @param meeting the meeting
     */
    public void replaceMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    /**
     * E course user e course user.
     *
     * @return the e course user
     */
    public ECourseUser eCourseUser() {
        return eCourseUser;
    }

    /**
     * Replacee course user.
     *
     * @param eCourseUser the e course user
     */
    public void replaceeCourseUser(ECourseUser eCourseUser) {
        this.eCourseUser = eCourseUser;
    }


    @Override
    public boolean sameAs(Object other) {
        return DomainEntities.areEqual(this, other);
    }

    @Override
    public Long identity() {
        return idParticipant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(idParticipant, that.idParticipant) && Objects.equals(meeting, that.meeting) && Objects.equals(eCourseUser, that.eCourseUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipant, meeting, eCourseUser);
    }

    @Override
    public String toString() {
        return "Participant" + "\n" +
                "Id :" + idParticipant + "\n" +
                "Meeting :" + meeting + "\n" +
                "Ecourse User :" + eCourseUser + "\n";
    }

    public String statusToString(){
        return "Participant:" + eCourseUser.email() + " | " +
                       "Participant status: " + participantState ;

    }
}
