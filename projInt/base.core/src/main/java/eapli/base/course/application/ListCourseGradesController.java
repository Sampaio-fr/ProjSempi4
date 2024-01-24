package eapli.base.course.application;

import eapli.base.course.domain.Course;
import eapli.base.course.services.ListUserCourseService;
import eapli.base.student.domain.Grade;
import eapli.base.student.domain.Student;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

public class ListCourseGradesController {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final ListUserCourseService userCourseService = new ListUserCourseService();

    public Iterable<Course> myCourses(){
        EmailAddress emailAddress = authorizationService.session().get().authenticatedUser().email();
        return userCourseService.listCoursesByTeacher(emailAddress);
    }

    public List<String> courseGrades(Course course){
        List<String> gradesList = new ArrayList<>();

        for (Student student : course.studentSet()){
            for (Grade grade : student.getGradeList()){
                gradesList.add(String.format("Student %s has %f grade from %d total in exam %s from course %s",
                        student.identity(), grade.retrieveStudentGrade(), grade.retrieveExamGrade(),
                        grade.findGradeExams().examTitle(), grade.findGradeCourse().courseTitle()));
            }
        }

        return gradesList;
    }
}
