package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.student.domain.Student;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.teacherInCharge.domain.TeacherInCharge;
import eapli.base.teacherInCharge.repositories.TeacherInChargeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JPATeacherInChargeRepository extends JpaAutoTxRepository<TeacherInCharge,Long,Long> implements TeacherInChargeRepository {

    /**
     * Instantiates a new Jpa student repository.
     *
     * @param autoTx the auto tx
     */
    public JPATeacherInChargeRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    /**
     * Instantiates a new Jpa student repository.
     *
     * @param puname the puname
     */
    public JPATeacherInChargeRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }
}
