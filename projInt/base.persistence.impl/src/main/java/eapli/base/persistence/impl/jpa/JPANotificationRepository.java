package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.meeting.domain.Meeting;
import eapli.base.notificationMeeting.domain.Notification;
import eapli.base.notificationMeeting.repositories.NotificationRepository;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;

/**
 * The type Jpa enrollment repository.
 */
public class JPANotificationRepository extends JpaAutoTxRepository<Notification, Long, Long>
        implements NotificationRepository {


    /**
     * Instantiates a new Jpa notification repository.
     *
     * @param puname the puname
     */
    public JPANotificationRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "idNotification");
    }

    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param autoTx the auto tx
     */
    public JPANotificationRepository(final TransactionalContext autoTx) {
        super(autoTx, "idNotification");
    }

    @Override
    public ArrayList<Notification> findAllNotificationsForThisMeeting(Meeting current) {
            final TypedQuery<Notification> query = entityManager().createQuery(
                    "SELECT ecu FROM Notification ecu WHERE ecu.meeting = :current",
                    Notification.class);
            query.setParameter("current", current);
            return (ArrayList<Notification>) query.getResultList();

    }

    @Override
    public Iterable<Notification> findListNotificationsByUser(ECourseUser eCourseUser) {
        final TypedQuery<Notification> query = entityManager().createQuery(
                "SELECT ecu FROM Notification ecu WHERE ecu.eCourseUser = :eCourseUser",
                Notification.class);
        query.setParameter("eCourseUser", eCourseUser);
        return query.getResultList();

    }



}
