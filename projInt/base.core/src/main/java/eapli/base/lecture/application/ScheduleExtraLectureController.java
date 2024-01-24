package eapli.base.lecture.application;

import eapli.base.course.domain.Course;
import eapli.base.course.services.ListUserCourseService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.lecture.service.TeacherSchedulesLectureManagementService;
import eapli.base.student.domain.Student;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ScheduleExtraLectureController {
    private final TeacherSchedulesLectureManagementService classScheduleService ;
    private final ListUserCourseService teacherCourseService;
    private final TeacherRepository teacherRepo;
    private final AuthorizationService authorizationService ;

    public ScheduleExtraLectureController(){
        this.classScheduleService = new TeacherSchedulesLectureManagementService();
        this.teacherCourseService = new ListUserCourseService();
        RepositoryFactory rep = PersistenceContext.repositories();
        this.teacherRepo= rep.teacherRepository();

        authorizationService = AuthzRegistry.authorizationService();
        authorizationService.ensureAuthenticatedUserHasAnyOf(BaseRoles.TEACHER);
    }

    public Iterable<Course> listInProgressCoursesByTeacher() {
        EmailAddress email  = authorizationService.session().get().authenticatedUser().email();
        return teacherCourseService.listInProgressCoursesByTeacher(email);
    }


    public void scheduleExtraClass(String title, Course course,List<Student> students, Calendar day,int duration){
        Teacher t = teacherRepo.findTeacherByEmail(authorizationService.session().get().authenticatedUser().email());
        classScheduleService.tryScheduleExtraClass(t,title,course,students,day,duration);
    }


    public List<Student> findStudentsByCourse(Course selectedCourse) {
        return classScheduleService.findStudentByCourse(selectedCourse);
    }
}
