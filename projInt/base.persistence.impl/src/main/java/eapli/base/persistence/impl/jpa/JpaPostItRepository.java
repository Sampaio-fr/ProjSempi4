package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.CellLog.domain.CellLog;
import eapli.base.PostItLog.domain.PostItLog;
import eapli.base.cell.domain.Cell;
import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.course.domain.CourseState;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.postIt.domain.PostIt;
import eapli.base.postIt.repositories.PostItRepository;
import eapli.base.student.domain.Student;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


public class JpaPostItRepository extends JpaAutoTxRepository<PostIt, Long, Long>
        implements PostItRepository {
    public JpaPostItRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaPostItRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }
}
