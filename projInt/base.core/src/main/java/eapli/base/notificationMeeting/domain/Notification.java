package eapli.base.notificationMeeting.domain;

import eapli.base.meeting.domain.Meeting;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;

/**
 * The type Notification.
 */
@Entity
@Table
public class Notification implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idNotification")
    private Long idNotification;
    @Enumerated(EnumType.STRING)
    private NotificationState notificationState;
    @Enumerated(EnumType.STRING)
    private TypeOfNotification typeOfNotification;

    @OneToOne
    private Meeting meeting;

    @OneToOne
    private ECourseUser eCourseUser;


    /**
     * Instantiates a new Notification.
     *
     * @param notificationState  the notification state
     * @param typeOfNotification the type of notification
     * @param meeting            the meeting
     * @param eCourseUser        the e course user
     */
    public Notification(NotificationState notificationState, TypeOfNotification typeOfNotification, Meeting meeting, ECourseUser eCourseUser) {
        this.notificationState = notificationState;
        this.typeOfNotification = typeOfNotification;
        this.meeting = meeting;
        this.eCourseUser = eCourseUser;
    }

    /**
     * Instantiates a new Notification.
     */
    protected Notification() {

    }

    public Meeting Meeting() {
        return meeting;
    }

    public void replaceMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public ECourseUser eCourseUser() {
        return eCourseUser;
    }

    public void replaceCourseUser(ECourseUser eCourseUser) {
        this.eCourseUser = eCourseUser;
    }

    @Override
    public boolean sameAs(Object other) {
        if (!(other instanceof Notification)) {
            return false;
        }

        final Notification that = (Notification) other;
        if (this == that) {
            return true;
        }
        return identity().equals(that.identity()) && typeOfNotification == that.typeOfNotification
                && notificationState.equals(that.notificationState);
    }

    @Override
    public Long identity() {
        return this.idNotification;
    }

    @Override
    public boolean equals(Object o) {
        return DomainEntities.areEqual(this, o);
    }

    @Override
    public int hashCode() {
        return DomainEntities.hashCode(this);
    }


    /**
     * Notification state notification state.
     *
     * @return the notification state
     */
    public NotificationState notificationState() {
        return notificationState;
    }

    /**
     * Replace notification state.
     *
     * @param notificationState the notification state
     */
    public void replaceNotificationState(NotificationState notificationState) {
        this.notificationState = notificationState;
    }

    /**
     * Type of notification type of notification.
     *
     * @return the type of notification
     */
    public TypeOfNotification typeOfNotification() {
        return typeOfNotification;
    }

    /**
     * Email.
     */
    public void email(){this.typeOfNotification=TypeOfNotification.EMAIL;}

    /**
     * Message.
     */
    public void message(){this.typeOfNotification=TypeOfNotification.MESSAGE;}


    @Override
    public String toString() {
        return "Notification{" +
                "idNotification=" + idNotification +
                ", notificationDescription=" + notificationState +
                ", typeOfNotification=" + typeOfNotification +
                '}';
    }
}
