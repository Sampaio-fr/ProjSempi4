package eapli.base.exam.application;

import eapli.base.course.domain.Course;
import eapli.base.course.services.ListUserCourseService;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.domain.ExamState;
import eapli.base.exam.services.ExamManagemantService;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.Calendar;

public class PublishExamController {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();;
    private final ListUserCourseService userCourseService = new ListUserCourseService();
    private final ExamManagemantService examManagemantService = new ExamManagemantService();

    public Iterable<Course> myCourses(){
        EmailAddress emailAddress = authorizationService.session().get().authenticatedUser().email();
        return userCourseService.listCoursesByTeacher(emailAddress);
    }

    public void publishExam(Course course, Exam exam, Calendar calendar, int duration){
        exam.changeInitialDate(calendar);
        exam.changeDurationAndFinalDate(duration);
        exam.changeExamState(ExamState.PUBLISHED);
        examManagemantService.saveUpdatedExamAndStudents(course, exam);
    }
}
