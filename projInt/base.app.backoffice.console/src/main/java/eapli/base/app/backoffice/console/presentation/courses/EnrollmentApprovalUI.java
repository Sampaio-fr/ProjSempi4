package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollmentapproval.application.EnrollmentApprovalController;
import eapli.base.enrollmentapproval.domain.EnrollmentApproval;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

/**
 * The type Enrollment approval ui.
 */
public class EnrollmentApprovalUI extends AbstractUI {

    private final EnrollmentApprovalController enrollmentApprovalController = new EnrollmentApprovalController();
    @Override
    protected boolean doShow() {
        List<Enrollment> applications = enrollmentApprovalController.findEnrollmentApplication();
        if(!applications.isEmpty()){
            printMethod(applications);
            int choice = Console.readInteger("Choose your option:");
            boolean answer = Console.readBoolean("Want to approve ? y or n");
            String explanation = Console.readLine("Explanation:");

            EnrollmentApproval enrollmentApproval = enrollmentApprovalController.createEnrollmentApproval(applications.get(choice-1),answer,explanation);
            System.out.println("The enrollment approval:");
            System.out.println("--------------------------------");
            System.out.println(enrollmentApproval.enrollment());
            System.out.println("--------------------------------");

        }else{
            System.out.println("There no enrollment applications available.");
            return false;
        }
        return false;
    }

    private void printMethod(List<Enrollment> applications){
        int i=1;
        for (Enrollment app: applications) {
            System.out.println("Position " + i);
            System.out.println(app);
            i++;
        }

    }
    @Override
    public String headline() {
        return "Enrollment Approval Decision";
    }
}
