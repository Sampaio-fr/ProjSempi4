package eapli.base.exam.application;

import eapli.base.course.domain.Course;
import eapli.base.course.services.ListUserCourseService;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.repositories.ExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

/**
 * The type List course exams controller.
 */
public class ListCourseExamsController {
    private final ExamRepository examRepo;
    private final StudentRepository studentRepository;
    private final ListUserCourseService teacherCourseService;
    private final AuthorizationService authorizationService;

    /**
     * Instantiates a new List course exams controller.
     */
    public ListCourseExamsController() {
        this.teacherCourseService = new ListUserCourseService();
        this.examRepo = PersistenceContext.repositories().examRepository();
        this.studentRepository = PersistenceContext.repositories().studentRepository();
        authorizationService = AuthzRegistry.authorizationService();
        authorizationService.ensureAuthenticatedUserHasAnyOf(BaseRoles.TEACHER);
    }

    /**
     * List courses by user list.
     *
     * @return the list
     */
    public Iterable<Course> listCoursesByUser() {
        EmailAddress email  = authorizationService.session().get().authenticatedUser().email();
        return teacherCourseService.listCoursesByTeacher(email);
    }

    /**
     * Exams by course iterable.
     *
     * @param course the course
     * @return the iterable
     */
    public Iterable<Exam> listExamsByCourse(Course course){
        return examRepo.examsByCourse(course);
    }

}
