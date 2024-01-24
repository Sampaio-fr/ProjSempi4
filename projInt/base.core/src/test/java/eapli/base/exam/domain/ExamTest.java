package eapli.base.exam.domain;

import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.teacher.domain.Acronym;
import eapli.base.teacher.domain.Teacher;
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

public class ExamTest {

    private Exam exam;

    @BeforeEach
    public void setup() {
        // Create a sample course and teacher
        Course c1 = new Course(Designation.valueOf("Java"), Description.valueOf("Java - avancado"),null, Code.valueOf("Edicao 1"), 10, 20,null);
        Acronym acronym = new Acronym("ABC");
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joe").withPassword("Password1").withName("joe", "power")
                .withEmail("joe@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser newUser = userBuilder.build();
        ECourseUser eCourseUser = new ECourseUser(newUser.email(),new ShortName("joe"),new FullName("joe","power"), Calendar.getInstance(),new TaxNumber("123456789"),null);
        Teacher teacher = new Teacher(acronym, newUser, eCourseUser);

        // Create a sample exam
        Calendar initialDate = Calendar.getInstance();
        int duration = 120; // 2 hours
        ExamState examState = ExamState.DRAFT;
        String examStruct = "Sample Exam Structure";
        FeedbackType feedbackType = FeedbackType.NONE;
        GradeType gradeType = GradeType.NONE;

        exam = new Exam(ExamState.DRAFT,"titulo",examStruct,c1,teacher,FeedbackType.ON_SUBMISSION,GradeType.ON_SUBMISSION);
    }

    @Test
    public void testChangeExamState() {
        // Change the exam state
        exam.changeExamState(ExamState.DRAFT);

        // Verify that the exam state has been changed
        assertEquals(ExamState.DRAFT, exam.examState());
    }

    @Test
    public void testChangeExamStruct() {
        // Change the exam structor
        String newExamStruct = "New Exam Structure";
        exam.changeExamStruct(newExamStruct);

        // Verify that the exam structor has been changed
        assertEquals(newExamStruct, exam.examStruct());
    }

    @Test
    public void testChangeCourse() {
        // Create a new course
        Course newCourse = new Course(Designation.valueOf("Java"), Description.valueOf("Java - new"),null, Code.valueOf("Edicao 2"), 10, 20,null);

        // Change the course of the exam
        exam.changeCourse(newCourse);

        // Verify that the course has been changed
        assertEquals(newCourse, exam.course());
    }

    @Test
    public void testChangeTeacher() {
        // Create a new teacher
        Acronym acronym = new Acronym("ABC");
        final SystemUserBuilder userBuilder = UserBuilderHelper.builder();
        userBuilder.withUsername("joana").withPassword("Password1").withName("joana", "power")
                .withEmail("joana@email.org").withRoles(BaseRoles.STUDENT);
        final SystemUser newUser = userBuilder.build();
        ECourseUser eCourseUser = new ECourseUser(newUser.email(),new ShortName("joana"),new FullName("joana","power"), Calendar.getInstance(),new TaxNumber("123456789"),null);
        Teacher newTeacher = new Teacher(acronym, newUser, eCourseUser);

        // Change the teacher of the exam
        exam.changeTeacher(newTeacher);

        // Verify that the teacher has been changed
        assertEquals(newTeacher, exam.teacher());
    }
    
}
