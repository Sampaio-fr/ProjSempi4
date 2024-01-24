package eapli.base.app.backoffice.console.presentation.courses;

import eapli.base.course.application.CreateCourseController;
import eapli.base.course.domain.Code;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 * The type Create course ui.
 */
public class CreateCourseUI extends AbstractUI {

    private final CreateCourseController createCourseController = new CreateCourseController();


    /**
     * Do show boolean.
     *
     * @return the boolean
     */
    @Override
    protected boolean doShow() {
        boolean flag;
        do {
            System.out.println("Creation of the course");
            flag = true;
            // requests data
            final String courseTitle = Console.readLine("Enter course Title:");
            final String courseDescription = Console.readLine("Enter course description:");
            final String edition = Console.readLine("Enter course unique code :");
            final int minimumCapacity = Console.readInteger("Course minimum number of  students:");
            final int maximumCapacity = Console.readInteger("Course maximum number of  students:");

            if (minimumCapacity <= maximumCapacity){

            System.out.println();
            System.out.println("Data introduced:");
            System.out.println("________________________________");
            System.out.println("Course title: " + courseTitle);
            System.out.println("Course unique edition: " + edition);
            System.out.println("Course  description: " + courseDescription);
            System.out.println("Course minimum number of  students: " + minimumCapacity);
            System.out.println("Course maximum number of  students: " + maximumCapacity);
            System.out.println();


            try {
                // positive response, so the course is effectively created and saved
                createCourseController.createCourses(Designation.valueOf(courseTitle), Description.valueOf(courseDescription), new Code(edition), minimumCapacity, maximumCapacity);
                System.out.println();
                System.out.println("Course -> " + edition);
            } catch (IllegalArgumentException e) {
                flag = false;
                System.out.println("Unsuccessful operation!");
                System.out.println(e.getMessage());
            }
            }else {
                flag = false;
                System.out.println("Maximum capacity cannot be less than minimum capacity");
            }

        } while (!flag);


        return false;
    }


    @Override
    public String headline() {
        return "Create Course of Ecourses";
    }


}









