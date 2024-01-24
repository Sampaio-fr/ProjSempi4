package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.enrollment.application.StudentEnrollmentController;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollmentapproval.application.EnrollmentApprovalController;
import eapli.base.enrollmentapproval.domain.EnrollmentApproval;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * The type Enrollment approval ui.
 */
public class BulkEnrollmentUI extends AbstractUI {

    private final StudentEnrollmentController studentEnrollmentController = new StudentEnrollmentController();
    @Override
    protected boolean doShow() {
        boolean flag;
        String filePath = Console.readLine("Insert the file path: ");
        try {
             flag = studentEnrollmentController.BulkEnrollmentInCourse(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(flag){
            System.out.println("Enrollments done!");
            return flag;
        }else{
            System.out.println("Enrollments fail!");
            return flag;
        }


    }

    @Override
    public String headline() {
        return "Bulk Enrollment";
    }
}
