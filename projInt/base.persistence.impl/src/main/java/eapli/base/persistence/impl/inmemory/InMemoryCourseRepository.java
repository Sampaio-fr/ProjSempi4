package eapli.base.persistence.impl.inmemory;

import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.student.domain.Student;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryCourseRepository extends
        InMemoryDomainRepository<Course, Code> implements CourseRepository {

    static {
        InMemoryInitializer.init();
    }
    @Override
    public Iterable<Course> coursesByTeachers(Teacher teacher) {
        return null;
    }

    @Override
    public Iterable<Course> coursesByStudent(Student student) {
        return null;
    }

    @Override
    public Iterable<Course> coursesInProgressByTeacher(Teacher teacher){return null;}

    @Override
    public List<Course> listCourses() {
        return null;
    }

    @Override
    public Iterable<Course> findOpen() {
        return null;
    }

    @Override
    public Iterable<Course> findEnrollStateCourses() {
        return null;
    }
    @Override
    public Iterable<Course> findEnrolledAndAvailableCoursesStudent(Student student){
        return null;
    }

    @Override
    public Iterable<Course> findEnrolledCoursesStudent(Student student) {
        return null;
    }

    @Override
    public Iterable<Course> findAvailableCoursesStudent() {
        return null;
    }

    @Override
    public List<Course> getCourseFromCourseID(Code id) {
        return null;
    }
}
