package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.repositories.MeetingRepository;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JPAMeetingRepository extends JpaAutoTxRepository<Meeting, Long, Long> implements MeetingRepository {

    public JPAMeetingRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JPAMeetingRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public Iterable<Meeting> meetingOwnerList(ECourseUser eCourseUser) {
        final TypedQuery<Meeting> query = entityManager().createQuery(
                "SELECT meeting from Meeting meeting where meeting.eCourseUser = :eCourseUser",
                Meeting.class);
        query.setParameter("eCourseUser", eCourseUser);
        return query.getResultList();
    }
}
