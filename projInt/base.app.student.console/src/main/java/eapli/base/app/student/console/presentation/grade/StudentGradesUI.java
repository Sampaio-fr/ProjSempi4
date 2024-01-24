package eapli.base.app.student.console.presentation.grade;

import eapli.base.course.application.ListCoursesController;
import eapli.base.course.domain.Course;
import eapli.base.student.application.StudentGradeController;
import eapli.base.student.domain.Grade;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class StudentGradesUI extends AbstractUI {

    private final StudentGradeController listGrades = new StudentGradeController();

    @Override
    protected boolean doShow() {

        List<Grade> gradeList = listGrades.listStudentGrades();

        if (gradeList.isEmpty()) {
            System.out.println("Doesn't exists grades!");
            return false;
        }
        for (Grade g: gradeList){
            System.out.println("Course Title -> " + g.findGradeCourse().courseTitle());
            System.out.println("Exam Title -> " +g.findGradeExams().examTitle());
            System.out.println("Exam Total Value -> " + g.retrieveExamGrade());
            System.out.println("Exam Grade ->" + g.retrieveStudentGrade());
        }

        return true;
    }

    @Override
    public String headline() {return "List of Grades";}
}
