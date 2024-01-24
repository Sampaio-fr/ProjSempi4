package eapli.base.course.repositories;

import eapli.base.course.domain.Course;
import eapli.base.course.domain.Code;
import eapli.base.student.domain.Student;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

/**
 * The interface Course repository.
 *
 * @author aliceresende (29-04-2022)
 */
public interface CourseRepository extends DomainRepository<Code, Course> {

    /**
     * Courses by teacher Iterable.
     *
     * @param teacher the teacher
     * @return the list
     */
    Iterable<Course> coursesByTeachers(final Teacher teacher);

    Iterable<Course> coursesInProgressByTeacher(final Teacher teacher);

    /**
     * Courses by student list.
     *
     * @param student the student
     * @return the list
     */
    Iterable<Course> coursesByStudent(final Student student);

    /**
     * List courses list.
     *
     * @return the list
     */
    List<Course> listCourses();

    /**
     * Find open iterable.
     *
     * @return the iterable
     */
    Iterable<Course> findOpen();

    /**
     * Find enroll state courses iterable.
     *
     * @return the iterable
     */
    Iterable<Course> findEnrollStateCourses();

    Iterable<Course> findEnrolledAndAvailableCoursesStudent(Student student);

    Iterable<Course> findEnrolledCoursesStudent(Student student);

    Iterable<Course> findAvailableCoursesStudent();

    List<Course> getCourseFromCourseID(Code id);
}
