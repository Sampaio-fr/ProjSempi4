package eapli.base.exam.services;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.student.domain.Student;
import eapli.base.student.repositories.StudentRepository;
import eapli.framework.application.ApplicationService;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

@ApplicationService
public class ListExamsManagementService {

    public final StudentRepository studentRepository = PersistenceContext.repositories().studentRepository();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    public Student findStudentByEmail() {
        EmailAddress email = authz.session().get().authenticatedUser().email();
        return studentRepository.findStudentByEmail(email);
    }
}
