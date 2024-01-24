package eapli.base.persistence.impl.inmemory;

import eapli.base.course.domain.Course;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.repositories.ExamRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryExamRepository  extends InMemoryDomainRepository<Exam, Long> implements ExamRepository {

    @Override
    public Iterable<Exam> examsByCourse(Course course) {
        return match(e -> e.course().equals(course));
    }

    @Override
    public List<Exam> examsByCourseAndTeacher(Course course, Teacher teacher) {
        return null;
    }
}
