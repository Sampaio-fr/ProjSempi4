package eapli.base.enrollment.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.student.domain.Student;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.domain.FullName;
import eapli.base.user.domain.ShortName;
import eapli.base.user.domain.TaxNumber;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnrollmentTest {
    private Student student;
    private Course course;

    @BeforeEach
    void setUp() {
        // Create a student
        MecanographicNumber mecanographicNumber = new MecanographicNumber("121199");
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joe").withPassword("Password1").withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser newUser = userBuilder.build();
        ECourseUser eCourseUser = new ECourseUser(newUser.email(),new ShortName("joe"),new FullName("joe","power"), Calendar.getInstance(),new TaxNumber("123456789"),null);
        student = new Student(mecanographicNumber, newUser, eCourseUser);
  course = new Course(Designation.valueOf("Java"), Description.valueOf("Java - avancado"),null, Code.valueOf("Edicao 1"), 10, 20,null);

    }

    @Test
    void createEnrollment() {
        Enrollment enrollment = new Enrollment(student, course);
        assertNotNull(enrollment);
        assertEquals(EnrollmentState.WAITING, enrollment.enrollState());
        assertEquals(student, enrollment.student());
        assertEquals(course, enrollment.course());
    }

    @Test
    void acceptEnrollment() {
        Enrollment enrollment = new Enrollment(student, course);
        enrollment.accept();
        assertEquals(EnrollmentState.ACCEPTED, enrollment.enrollState());
    }

    @Test
    void denyEnrollment() {
        Enrollment enrollment = new Enrollment(student, course);
        enrollment.deny();
        assertEquals(EnrollmentState.DENIED, enrollment.enrollState());
    }
}
