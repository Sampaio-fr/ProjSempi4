package eapli.base.teacher.domain;

import eapli.base.course.domain.Course;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.domain.FullName;
import eapli.base.user.domain.ShortName;
import eapli.base.user.domain.TaxNumber;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.base.usermanagement.domain.UserBuilderHelper;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {
    private Acronym acronym;
    private Teacher teacher;

    @BeforeEach
    void setUp() {
        acronym = new Acronym("ABC");
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joe").withPassword("Password1").withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser newUser = userBuilder.build();
        ECourseUser eCourseUser = new ECourseUser(newUser.email(),new ShortName("joe"),new FullName("joe","power"), Calendar.getInstance(),new TaxNumber("123456789"),null);
        teacher = new Teacher(acronym, newUser, eCourseUser);
    }

    @Test
    void testGetAcronym() {
        assertEquals(acronym, teacher.acronym());
    }

    @Test
    void testSetAcronym() {
        Acronym newAcronym = new Acronym("XYZ");
        teacher.changeAcronym(newAcronym);
        assertEquals(newAcronym, teacher.acronym());
    }



}