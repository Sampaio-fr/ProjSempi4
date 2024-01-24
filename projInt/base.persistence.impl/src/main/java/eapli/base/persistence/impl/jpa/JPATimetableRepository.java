package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.meeting.domain.Meeting;
import eapli.base.schedule.domain.Schedule;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.timetable.repositories.TimetableRepository;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JPATimetableRepository extends JpaAutoTxRepository<TimeTable, Long, Long> implements TimetableRepository {

    public JPATimetableRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JPATimetableRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }




}
