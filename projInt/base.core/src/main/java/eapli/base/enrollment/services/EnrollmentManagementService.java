package eapli.base.enrollment.services;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollment.repositories.EnrollmentRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.student.domain.Student;
import eapli.base.student.repositories.StudentRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.List;

/**
 * The type Enrollment management service.
 */
public class EnrollmentManagementService {

    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentManagementService() {
        RepositoryFactory rep = PersistenceContext.repositories();
        studentRepository = rep.studentRepository();
        enrollmentRepository = rep.enrollmentRepository();
        courseRepository = rep.courseRepository();
    }

    /**
     * Save enrollment boolean.
     *
     * @param emailAddress the system user
     * @param course       the course
     * @return the boolean
     */
    public boolean saveEnrollment(EmailAddress emailAddress, Course course) {
        try {
            Student student = this.studentRepository.findStudentByEmail(emailAddress);
            Enrollment enrollment = enrollmentRepository.save(new Enrollment(student, course));
            student.addEnrollment(enrollment);
            studentRepository.save(student);

            return true;
        } catch (Exception e) {
            System.out.println("Error finding Student " + emailAddress);
            System.out.println(e.getMessage());
            throw new UnsupportedOperationException("Something went wrong saving enrollment");
        }
    }

    /**
     * Update enrollment boolean.
     *
     * @param enrollment the enrollment
     * @param answer     the answer
     * @return the boolean
     */
    public Enrollment updateEnrollment(Enrollment enrollment, boolean answer) {
        if (answer) {
            enrollment.accept();
        } else {
            enrollment.deny();
        }
        try {
            enrollmentRepository.save(enrollment);
            return enrollment;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Something went wrong updating enrollment");
        }
    }

    public List<Student> getStudentFromMecNumber(MecanographicNumber mecNum) {
        return studentRepository.getStudentFromMecNumber(mecNum);
    }

    public List<Course> getCourseFromCourseID(Code Id) {
        return courseRepository.getCourseFromCourseID(Id);
    }


}
