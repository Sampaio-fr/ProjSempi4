package eapli.base.enrollment.services;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.course.domain.Code;
import eapli.base.course.domain.Course;
import eapli.base.student.domain.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ReadCSVFileService {

    private final EnrollmentManagementService enrollmentManagementService = new EnrollmentManagementService();

    public boolean readCSV(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        if (!f.isFile()){
            System.out.println("invalid FilePath");
            return false;
        }
        Scanner read = new Scanner(new File(filePath));
        read.nextLine();
        int i=0;
        while (read.hasNext()){
            String[] line = read.nextLine().split(",");
            MecanographicNumber mecNum = new MecanographicNumber(line[0]);
            Code courseID = new Code(line[1]);
            //get course from courseID
            List<Course> courses = enrollmentManagementService.getCourseFromCourseID(courseID);
            //get student from MecanographicNumber
            List<Student> s = enrollmentManagementService.getStudentFromMecNumber(mecNum);
            if (s.size() < 1){
                System.out.println("Student with Mecanographic Number: " + mecNum + " is not registered in the system");
            }else if(courses.size() < 1){
                System.out.println("Course with ID: " + courseID + " is not registered in the system or is not open for Enrollments");
            }else {
                //saves enrollment
                enrollmentManagementService.saveEnrollment(s.get(i).systemUser().email(), courses.get(i));
            }
            i++;
        }
        return true;
    }

}
