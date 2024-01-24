package eapli.base.persistence.impl.jpa;


import eapli.base.Application;
import eapli.base.course.domain.Course;
import eapli.base.question.domain.Question;
import eapli.base.question.domain.QuestionType;
import eapli.base.question.repositories.QuestionRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * The type Jpa question repository.
 */
public class JPAQuestionRepository  extends JpaAutoTxRepository<Question,Long, Long> implements QuestionRepository {

    /**
     * Instantiates a new Jpa question repository.
     *
     * @param puname the puname
     */
    public JPAQuestionRepository(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "idQuestion");
    }

    /**
     * Instantiates a new Jpa exam repository.
     *
     * @param autoTx the auto tx
     */
    public JPAQuestionRepository(final TransactionalContext autoTx) {
         super(autoTx, "idQuestion");
    }

    @Override
    public Iterable<Question> listQuestions(Course course) {
        final TypedQuery<Question> query = entityManager().createQuery(
                "SELECT c FROM Question c WHERE c.questionCourse= :course",
                Question.class);
        query.setParameter("course", course);

        return query.getResultList();
    }

    @Override
    public Iterable<Question> listQuestionsByType(QuestionType questionType) {
        final TypedQuery<Question> query = entityManager().createQuery(
                "SELECT q FROM Question q WHERE q.questionType= :questionType",
                Question.class);
        query.setParameter("questionType", questionType);

        return query.getResultList();
    }

    @Override
    public Iterable<Question> listQuestionsByCourseAndType(Course course, QuestionType questionType) {
        final TypedQuery<Question> query = entityManager().createQuery(
                "SELECT q FROM Question q WHERE q.questionType= :questionType AND q.questionCourse = :course",
                Question.class);
        query.setParameter("questionType", questionType);
        query.setParameter("course",course);

        return query.getResultList();
    }
}
