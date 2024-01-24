package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.student.domain.Grade;
import eapli.base.student.repositories.GradeRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JPAGradeRepository extends JpaAutoTxRepository<Grade, Long, Long> implements GradeRepository {

    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param puname the puname
     */
    public JPAGradeRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param autoTx the auto tx
     */
    public JPAGradeRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }
}
