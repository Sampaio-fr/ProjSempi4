package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.course.domain.CourseState;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.student.domain.Student;
import eapli.base.teacher.domain.Teacher;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


public class JpaCourseRepository extends JpaAutoTxRepository<Course, Code, Code>
        implements CourseRepository {
    public JpaCourseRepository(final TransactionalContext autoTx) {
        super(autoTx, "id");
    }

    public JpaCourseRepository(final String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(),
                "id");
    }

    @Override
    public Iterable<Course> coursesByTeachers(Teacher teacher) {
        final TypedQuery<Course> query = entityManager().createQuery(
                "SELECT c FROM Course c JOIN c.teachers t WHERE t = :teacher",
                Course.class);
        query.setParameter("teacher", teacher);
        return query.getResultList();
    }

    @Override
    public Iterable<Course> coursesInProgressByTeacher(Teacher teacher){
        final TypedQuery<Course> query = entityManager().createQuery(
                "SELECT c FROM Course c JOIN c.teachers t  WHERE t = :teacher AND c.courseState = :courseState ",
                Course.class);
        query.setParameter("teacher", teacher);
        query.setParameter("courseState", CourseState.INPROGRESS);
        return query.getResultList();
    }

    @Override
    public Iterable<Course> coursesByStudent(Student student) {
        Query query = super.createQuery("SELECT c from Course c where :student = c.student", Course.class);
        query.setParameter("student", student);
        return query.getResultList();
    }

    @Override
    public List<Course> listCourses() {
        Query query = super.createQuery("SELECT c from Course c", Course.class);
        return query.getResultList();
    }

    @Override
    public Iterable<Course> findOpen() {
        final TypedQuery<Course> query = entityManager().createQuery(
                "SELECT c FROM Course c WHERE c.courseState = 'OPEN'",
                Course.class);

        return query.getResultList();
    }

    @Override
    public Iterable<Course> findEnrollStateCourses() {
        final TypedQuery<Course> query = entityManager().createQuery(
                "SELECT c FROM Course c WHERE c.courseState = 'ENROLL'",
                Course.class);

        return query.getResultList();
    }

    @Override
    public Iterable<Course> findEnrolledAndAvailableCoursesStudent(Student student) {
        return null;
    }


    @Override
    public Iterable<Course> findEnrolledCoursesStudent(Student student) {
        final TypedQuery<Course> query = entityManager().createQuery(
                  "SELECT e.course FROM Enrollment e where e.student = :student AND e.enrollState = 'ACCEPTED' ",
                Course.class);
        query.setParameter("student", student);

        return query.getResultList();
    }


    @Override
    public Iterable<Course> findAvailableCoursesStudent() {
        final TypedQuery<Course> query = entityManager().createQuery(
                "SELECT c1 FROM Course c1 WHERE courseState = 'OPEN'",
                Course.class);

        return query.getResultList();
    }

    @Override
    public List<Course> getCourseFromCourseID(Code id) {
        final TypedQuery<Course> query = entityManager().createQuery(
                "SELECT c1 FROM Course c1 WHERE c1.id = :id AND c1.courseState = 'ENROLL'",
                Course.class);
        query.setParameter("id", id);

        return query.getResultList();
    }
    
}
