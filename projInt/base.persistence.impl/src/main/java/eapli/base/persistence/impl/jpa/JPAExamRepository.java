package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.course.domain.Course;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.repositories.ExamRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Jpa exam repository.
 */
public class JPAExamRepository extends JpaAutoTxRepository<Exam, Long, Long> implements ExamRepository {
    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param puname the puname
     */
    public JPAExamRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "id");
    }

    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param autoTx the auto tx
     */
    public JPAExamRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    @Override
    public List<Exam> examsByCourse(Course course) {
        final TypedQuery<Exam> query = entityManager().createQuery(
                "SELECT e FROM Exam e  WHERE e.course=:course",
                Exam.class);
        query.setParameter("course", course);
        return query.getResultList();

    }

    @Override
    public List<Exam> examsByCourseAndTeacher(Course course, Teacher teacher) {
        final TypedQuery<Exam> query = entityManager().createQuery(
                "SELECT e FROM Exam e  WHERE e.course=:course and e.teacher=:teacher",
                Exam.class);
        query.setParameter("course", course);
        query.setParameter("teacher", teacher);
        return query.getResultList();

    }
}
