package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.enrollmentapproval.domain.EnrollmentApproval;
import eapli.base.enrollmentapproval.repositories.EnrollmentApprovalRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class JPAEnrollmentApprovalRepository extends JpaAutoTxRepository<EnrollmentApproval, Long, Long>
        implements EnrollmentApprovalRepository {


    public JPAEnrollmentApprovalRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "idEnrollAprov");
    }


    public JPAEnrollmentApprovalRepository(final TransactionalContext autoTx) {
        super(autoTx, "idEnrollAprov");
    }

    }

