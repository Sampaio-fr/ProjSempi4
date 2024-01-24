package eapli.base.enrollment.application;

import eapli.base.course.domain.Course;
import eapli.base.course.services.CourseManagementService;
import eapli.base.enrollment.services.EnrollmentManagementService;
import eapli.base.enrollment.services.ReadCSVFileService;
import eapli.base.student.domain.Student;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.io.FileNotFoundException;


/**
 * The type Student enrollment controller.
 *
 * @author aliceresende (29-04-2022)
 */
public class StudentEnrollmentController {

    private final CourseManagementService listCoursesService = new CourseManagementService();
    private final EnrollmentManagementService enrollmentManagementService = new EnrollmentManagementService();
    private final ReadCSVFileService readCsvService = new ReadCSVFileService();
    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();


    /**
     * All courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> allCoursesToEnroll(){
        return listCoursesService.enrollStateCourses();
    }

    /**
     * Enroll student boolean.
     *
     * @param course the course
     * @return the boolean
     */
    public boolean enrollStudent(Course course){
        EmailAddress emailStudent  = authorizationService.session().get().authenticatedUser().email();
        return enrollmentManagementService.saveEnrollment(emailStudent, course);
    }

    public boolean BulkEnrollmentInCourse(String filePath) throws FileNotFoundException {
        return readCsvService.readCSV(filePath);
    }

    public Iterable<Course> allCourses() {
        return null;
    }
}
