package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.meeting.domain.Meeting;
import eapli.base.meeting.repositories.MeetingRepository;
import eapli.base.schedule.domain.Schedule;
import eapli.base.schedule.repositories.ScheduleRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JPAScheduleRepository extends JpaAutoTxRepository<Schedule, Long, Long> implements ScheduleRepository {

    public JPAScheduleRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JPAScheduleRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }
}
