package eapli.base.course.domain;

import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CourseTest {

    Course c1,c2_open,c3_inprogress,c4_hasStudents;

    @BeforeEach
    void setUp() throws Exception {
        c1 = new Course(Designation.valueOf("Java"), Description.valueOf("Java - avancado"),null, Code.valueOf("Edicao 1"), 10, 20,null);
        c2_open = new Course(Designation.valueOf("Javadoc"), Description.valueOf("Javadoc - intermedio"),null , Code.valueOf("Edicao 1"), 10, 20,null);
        c2_open.openCourse();

        c3_inprogress = new Course(Designation.valueOf("JavaScript"), Description.valueOf("JavaScript - introducao"),null , Code.valueOf("Edicao 1"), 10, 20,null);
        c3_inprogress.openCourse();
        c3_inprogress.openEnrollment();
        c3_inprogress.closeEnrollment();
        c4_hasStudents = new Course(Designation.valueOf("HTML"), Description.valueOf("HTML - introducao"),null , Code.valueOf("Edicao 1"), 1, 20,null);
        c4_hasStudents.openCourse();
        c4_hasStudents.openEnrollment();
    }
    @Test
    void testCreateCourse() {
        // Assert
        Assertions.assertNotNull(c1);
        Assertions.assertEquals(Designation.valueOf("Java"), c1.courseTitle());
        Assertions.assertEquals(Description.valueOf("Java - avancado"), c1.courseDescription());
        Assertions.assertEquals(10, c1.minimumCapacity());
        Assertions.assertEquals(20, c1.maximumCapacity());

        //Assertions.assertNotNull(c1.teachersSet());
        Assertions.assertNotNull(c1.studentSet());
        Assertions.assertNotNull(c1.findExamList());
        Assertions.assertTrue(c1.findExamList().isEmpty());
    }
    @Test
    public void ensureIsNotPossibleToOpenCourseThatStatusIsNotClose(){
        CourseState before = c2_open.courseState();
        c2_open.openCourse();
        Assertions.assertEquals(before,c2_open.courseState());
    }

    @Test
    public void ensureIsPossibleToOpenCourseThatStatusIsClose(){
        c1.openCourse();
        Assertions.assertEquals(CourseState.OPEN,c1.courseState());
    }

    @Test
    public void ensureIsPossibleToCloseCourseThatDoesNotHaveSufficientStudents(){
        c2_open.closeCourse();
        Assertions.assertEquals(CourseState.CLOSED,c2_open.courseState());
    }
   /* @Test
    public void ensureIsNotPossibleToCloseCourseThatStatusIsNotInProgress(){
        CourseState before = c2_open.courseState();
        c2_open.closeCourse();
        Assertions.assertEquals(before,c2_open.courseState());
    }
*/
    @Test
    public void ensureIsPossibleToCloseCourseThatStatusIsInProgress(){
        c3_inprogress.closeCourse();
        Assertions.assertEquals(CourseState.CLOSED,c3_inprogress.courseState());
    }

    @Test
    public void ensureItIsPossibleToAddTeacherInCharge(){

    }

    @Test
    public void ensureItIsPossibleToAddTeachers(){

    }


    @Test
    void testOpenEnrollment() {
        // Assert
        Assertions.assertEquals(CourseState.CLOSE, c1.courseState());

        // Act
        c1.openEnrollment();

        // Assert
        Assertions.assertEquals(CourseState.ENROLL, c1.courseState());
    }
    @Test
    void testCloseEnrollment() {
        // Assert
        Assertions.assertEquals(CourseState.CLOSE, c1.courseState());

        // Act
        c1.closeEnrollment();

        // Assert
        Assertions.assertEquals(CourseState.INPROGRESS, c1.courseState());
    }


}
