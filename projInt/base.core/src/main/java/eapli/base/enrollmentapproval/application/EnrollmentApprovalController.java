package eapli.base.enrollmentapproval.application;

import eapli.base.course.domain.Course;
import eapli.base.course.domain.Id;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollment.domain.EnrollmentState;
import eapli.base.enrollment.repositories.EnrollmentRepository;
import eapli.base.enrollment.services.EnrollmentManagementService;
import eapli.base.enrollmentapproval.builder.EnrollmentApprovalBuilder;
import eapli.base.enrollmentapproval.domain.Decision;
import eapli.base.enrollmentapproval.domain.EnrollmentApproval;
import eapli.base.enrollmentapproval.repositories.EnrollmentApprovalRepository;
import eapli.base.enrollmentapproval.services.EnrollmentApprovalService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.student.domain.Student;
import eapli.base.student.repositories.StudentRepository;
import eapli.framework.general.domain.model.Description;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Enrollment approval controller.
 */
public class EnrollmentApprovalController {

    private EnrollmentRepository enrollmentRepository;
    private EnrollmentApprovalService enrollmentApprovalService;
    private EnrollmentManagementService enrollmentManagementService;
    private EnrollmentApprovalBuilder enrollmentApprovalBuilder;


    /**
     * Instantiates a new Enrollment approval controller.
     */
    public EnrollmentApprovalController() {
        this.enrollmentRepository = PersistenceContext.repositories().enrollmentRepository();
        this.enrollmentApprovalService = new EnrollmentApprovalService();
        this.enrollmentManagementService = new EnrollmentManagementService();
        this.enrollmentApprovalBuilder = new EnrollmentApprovalBuilder();
    }

    /**
     * Find enrollment application list.
     *
     * @return the list
     */
    public List<Enrollment> findEnrollmentApplication() {
        return enrollmentApprovalService.findEnrollmentApplication();
    }


    /**
     * Create enrollment approval enrollment approval.
     *
     * @param enrollment  the enrollment
     * @param answer      the answer
     * @param explanation the explanation
     * @return the enrollment approval
     */
    public EnrollmentApproval createEnrollmentApproval(Enrollment enrollment, boolean answer, String explanation) {
        Enrollment enrollment1 = this.enrollmentManagementService.updateEnrollment(enrollment,answer);
        EnrollmentApproval enrollmentApproval = this.enrollmentApprovalBuilder.withExplanation(explanation).withEnrollment(enrollment1).withDecision(answer).build();
        try {
            if (answer) {
                this.enrollmentApprovalService.saveEnrollmentApproved(enrollmentApproval,enrollment1);
            } else {
                this.enrollmentApprovalService.saveEnrollmentDenied(enrollmentApproval);
            }
            return enrollmentApproval;

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }




    }



}
