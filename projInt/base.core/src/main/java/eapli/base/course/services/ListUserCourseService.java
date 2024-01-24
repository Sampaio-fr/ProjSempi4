package eapli.base.course.services;

import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.base.student.domain.Student;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.List;

/**
 * The type List user courses service.
 */
public class ListUserCourseService {
    private final CourseRepository courseRepo;
    private final TeacherRepository teacherRepo;
    private final StudentRepository studentRepo;

    public ListUserCourseService() {
        RepositoryFactory rep = PersistenceContext.repositories();
        courseRepo = rep.courseRepository();
        teacherRepo = rep.teacherRepository();
        studentRepo = rep.studentRepository();
    }

    /**
     * List course by teacher list.
     *
     * @param mail the EmailAdress
     * @return the list
     */
    public Iterable<Course> listCoursesByTeacher(EmailAddress mail) {
        Teacher teacher = teacherRepo.findTeacherByEmail(mail);
        return courseRepo.coursesByTeachers(teacher);
    }

    public Iterable<Course> listInProgressCoursesByTeacher(EmailAddress mail){
        Teacher teacher = teacherRepo.findTeacherByEmail(mail);
        return courseRepo.coursesByTeachers(teacher);
        //courseRepo.coursesInProgressByTeacher(teacher);
    }

    /**
     * List course by student list.
     *
     * @param mail the Emailadress
     * @return the list
     */
    public Iterable<Course> listCourseByStudent(EmailAddress mail) {
        Student student = studentRepo.findStudentByEmail(mail);
        return courseRepo.findEnrolledCoursesStudent(student);
    }

    /**
     * List course available.
     *
     * @return the list
     */
    public Iterable<Course> listCourseAvailableByStudent() {
        return courseRepo.findAvailableCoursesStudent();
    }

    /**
     * List course list.
     *
     * @return the list
     */
    public Iterable<Course> listCourses() {
        return courseRepo.findAll();
    }
}
