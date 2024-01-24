package eapli.base.enrollmentapproval.services;

import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollment.domain.EnrollmentState;
import eapli.base.enrollment.repositories.EnrollmentRepository;
import eapli.base.enrollmentapproval.domain.EnrollmentApproval;
import eapli.base.enrollmentapproval.repositories.EnrollmentApprovalRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.student.domain.Student;
import eapli.base.student.repositories.StudentRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Enrollment approval service.
 */
public class EnrollmentApprovalService {

    private final AuthorizationService authorizationService;
    private final CourseRepository courseRepository;
    private EnrollmentRepository enrollmentRepository;

    private final EnrollmentApprovalRepository enrollmentApprovalRepository;
    private final StudentRepository studentRepository;



    /**
     * Instantiates a new Enrollment approval service.
     */
    public EnrollmentApprovalService() {
        this.authorizationService = AuthzRegistry.authorizationService();
        this.courseRepository = PersistenceContext.repositories().courseRepository();
        this.enrollmentRepository = PersistenceContext.repositories().enrollmentRepository();
        this.enrollmentApprovalRepository = PersistenceContext.repositories().enrollmentApprovalRepository();
        this.studentRepository = PersistenceContext.repositories().studentRepository();

    }


    /**
     * Find enrollment application list.
     *
     * @return the list
     */
    public List<Enrollment> findEnrollmentApplication() {
        List<Enrollment> list = (List<Enrollment>) enrollmentRepository.findEnrollmentApplicationToEvaluate();
        List<Enrollment> enrollmentList = new ArrayList<>();
        for (Enrollment c: list) {
            if (c.enrollState() == EnrollmentState.WAITING){
                enrollmentList.add(c);
            }
        }
        return enrollmentList;
    }


    /**
     * Save enrollment approval enrollment approval.
     *
     * @param enrollmentApproval the enrollment approval
     * @param enrollment1
     */
    public void saveEnrollmentApproved(EnrollmentApproval enrollmentApproval, Enrollment enrollment1){
        Student student = enrollmentApproval.enrollment().student();
        Course course = enrollmentApproval.enrollment().course();
        try{
            course.addStudent(enrollment1.student());
            this.studentRepository.save(student);
            this.courseRepository.save(course);
            this.enrollmentApprovalRepository.save(enrollmentApproval);
        }catch (Exception e){
            System.out.println("Error finding Student " + student.identity() + "or Error finding Course " + course.identity());
            System.out.println(e.getMessage());
        }
    }

    /**
     * Save enrollment denied.
     *
     * @param enrollmentApproval the enrollment approval
     */
    public void saveEnrollmentDenied(EnrollmentApproval enrollmentApproval){
        try{
            this.enrollmentApprovalRepository.save(enrollmentApproval);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }




}
