package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.course.domain.Course;
import eapli.base.meeting.domain.Meeting;
import eapli.base.participant.domain.Participant;
import eapli.base.participant.repositories.ParticipantRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Jpa enrollment repository.
 */
public class JPAParticipantRepository extends JpaAutoTxRepository<Participant, Long, Long>
        implements ParticipantRepository {


    public JPAParticipantRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "idParticipant");
    }

    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param autoTx the auto tx
     */
    public JPAParticipantRepository(final TransactionalContext autoTx) {
        super(autoTx, "idParticipant");
    }


    @Override
    public List<Participant> meetingParticipants(Meeting meeting) {
        TypedQuery<Participant> query = entityManager().createQuery(
                "SELECT p FROM Participant p WHERE p.meeting = :meeting",
                Participant.class);
        query.setParameter("meeting", meeting);
        return query.getResultList();
    }
}
