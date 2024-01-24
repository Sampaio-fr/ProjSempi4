package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.course.domain.Course;


import eapli.base.student.domain.Student;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Jpa student repository.
 */
public class JPAStudentRepository extends JpaAutoTxRepository<Student, MecanographicNumber, MecanographicNumber>
        implements StudentRepository {

    /**
     * Instantiates a new Jpa student repository.
     *
     * @param autoTx the auto tx
     */
    public JPAStudentRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    /**
     * Instantiates a new Jpa student repository.
     *
     * @param puname the puname
     */
    public JPAStudentRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    @Override
    public List<Course> coursesByStudent(Student student) {
        return null;
    }

    @Override
    public Student findStudentByEmail(EmailAddress email) {
        final TypedQuery<Student> query = entityManager().createQuery(
                "SELECT l FROM Student l WHERE l.user.email = :email",
                Student.class);
        query.setParameter("email", email);
        List<Student> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);

    }

    public Iterable<Student> studentByUsername(Username username) {
        Query query = super.createQuery("SELECT s FROM Student s where s.systemUser.username = :username", Student.class);
        query.setParameter("username", username);
        return query.getResultList();
    }

    @Override
    public List<Student> getStudentFromMecNumber(MecanographicNumber mecNum) {
        final TypedQuery<Student> query = entityManager().createQuery(
                "SELECT s FROM Student s WHERE s.mechanographic = :mecNum",
                Student.class);
        query.setParameter("mecNum", mecNum);

        return query.getResultList();

    }

    @Override
    public Iterable<Student> searchUsersavailable() {
       return  null;
    }
}
