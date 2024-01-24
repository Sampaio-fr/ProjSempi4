package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.lecture.domain.Lecture;
import eapli.base.lecture.repositories.LecturesRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;

public class JpaLecturesRepository extends JpaAutoTxRepository<Lecture, Long, Long>
        implements LecturesRepository {

    public JpaLecturesRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaLecturesRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

}
