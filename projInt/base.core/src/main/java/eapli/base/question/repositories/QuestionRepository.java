package eapli.base.question.repositories;


import eapli.base.course.domain.Course;
import eapli.base.question.domain.Question;
import eapli.base.question.domain.QuestionType;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

/**
 * The interface Question repository.
 */
public interface QuestionRepository extends DomainRepository<Long, Question> {
    Iterable<Question> listQuestions(Course course);
    Iterable<Question> listQuestionsByType(QuestionType questionType);
    Iterable<Question> listQuestionsByCourseAndType(Course course, QuestionType questionType);
}
