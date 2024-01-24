package eapli.base.exam.repositories;

import eapli.base.course.domain.Course;
import eapli.base.exam.domain.Exam;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

/**
 * The interface Exam repository.
 */
public interface ExamRepository extends DomainRepository<Long, Exam> {
    /**
     * Exams by course iterable.
     *
     * @param course the course
     * @return the iterable
     */
    Iterable<Exam> examsByCourse(Course course);

    List<Exam> examsByCourseAndTeacher(Course course, Teacher teacher);

}
