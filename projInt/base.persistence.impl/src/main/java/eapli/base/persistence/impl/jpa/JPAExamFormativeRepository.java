package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.course.domain.Course;
import eapli.base.examformative.domain.ExamFormative;
import eapli.base.examformative.repositories.ExamFormativeRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Jpa exam repository.
 */
public class JPAExamFormativeRepository extends JpaAutoTxRepository<ExamFormative, Long, Long> implements ExamFormativeRepository {
    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param puname the puname
     */
    public JPAExamFormativeRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "idExam");
    }

    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param autoTx the auto tx
     */
    public JPAExamFormativeRepository(final TransactionalContext autoTx) {
        super(autoTx, "idExam");
    }

    @Override
    public List<ExamFormative> examsByCourse(Course course) {
        final TypedQuery<ExamFormative> query = entityManager().createQuery(
                "SELECT e FROM ExamFormative e  WHERE e.course=:course",
                ExamFormative.class);
        query.setParameter("course", course);
        return query.getResultList();

    }

    @Override
    public List<ExamFormative> examsByCourseAndTeacher(Course course, Teacher teacher) {
        final TypedQuery<ExamFormative> query = entityManager().createQuery(
                "SELECT e FROM Exam e  WHERE e.course=:course and e.teacher=:teacher",
                ExamFormative.class);
        query.setParameter("course", course);
        query.setParameter("teacher", teacher);
        return query.getResultList();

    }
}
