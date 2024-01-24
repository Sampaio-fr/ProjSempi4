package eapli.base.examformative.repositories;

import eapli.base.course.domain.Course;
import eapli.base.examformative.domain.ExamFormative;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ExamFormativeRepository extends DomainRepository<Long, ExamFormative> {
    List<ExamFormative> examsByCourse(Course course);

    List<ExamFormative> examsByCourseAndTeacher(Course course, Teacher teacher);
}
