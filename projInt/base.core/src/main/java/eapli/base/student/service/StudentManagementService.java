package eapli.base.student.service;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.student.domain.Student;
import eapli.base.student.domain.StudentBuilder;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.user.domain.ECourseUser;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Create student service.
 */
public class StudentManagementService {

    private final StudentRepository studentRepository;
    private final AuthorizationService authz;
    public StudentManagementService(){
        this.studentRepository = PersistenceContext.repositories().studentRepository();
        this.authz = AuthzRegistry.authorizationService();
    }


    @Transactional
    public Student registerNewStudent(final MecanographicNumber mecanographicNumber, final ECourseUser user, final SystemUser systemUser) {
        StudentBuilder studentBuilder = new StudentBuilder();
        studentBuilder.withMecanographicNumber(mecanographicNumber).withUser(user).withSystemUser(systemUser);
        Student newStudent = studentBuilder.build();
        return this.studentRepository.save(newStudent);
    }

    public Student findStudentByEmail(){
        EmailAddress email = authz.session().get().authenticatedUser().email();
        return studentRepository.findStudentByEmail(email);
    }

}
