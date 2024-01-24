package eapli.base.student.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.course.domain.Course;
import eapli.base.teacher.domain.Acronym;
import eapli.base.teacher.domain.Teacher;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.domain.FullName;
import eapli.base.user.domain.ShortName;
import eapli.base.user.domain.TaxNumber;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    private Grade grade;
    private MecanographicNumber mecNum;
    private Student student;

    @BeforeEach
    void setUp() {
        mecNum = new MecanographicNumber("12345");
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joe").withPassword("Password1").withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser newUser = userBuilder.build();
        ECourseUser eCourseUser = new ECourseUser(newUser.email(),new ShortName("joe"),new FullName("joe","power"), Calendar.getInstance(),new TaxNumber("123456789"),null);
        student = new Student(mecNum, newUser, eCourseUser);
    }

    @Test
    void testGetMecNum() {
        assertEquals(mecNum, student.identity());
    }

    @Test
    void testGetGrades() {
        List<Grade> grades = new ArrayList<>();
        Grade grade = new Grade();
        grades.add(grade);
        student.addGrade(grade);
        assertEquals(grades, student.getGradeList());
    }



}