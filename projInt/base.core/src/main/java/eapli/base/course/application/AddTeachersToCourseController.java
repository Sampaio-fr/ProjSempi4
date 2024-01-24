package eapli.base.course.application;

import eapli.base.course.domain.Course;
import eapli.base.course.services.CourseManagementService;
import eapli.base.course.services.CourseTeachersManagementService;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.service.TeacherManagementService;

import java.util.ArrayList;

public class AddTeachersToCourseController {
    private final CourseManagementService courseService;
    private final TeacherManagementService teacherService;
    private final CourseTeachersManagementService courseTeachersService;

    public AddTeachersToCourseController(){
        this.courseService = new CourseManagementService();
        this.teacherService  = new TeacherManagementService();
        this.courseTeachersService = new CourseTeachersManagementService();
    }

    /**
     * Open courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> listOpenCourses() {
        return this.courseService.openCourses();
    }
    public ArrayList<Teacher> listTeachers(){
        return (ArrayList<Teacher>) this.teacherService.allTeachers();
    }

    public ArrayList<Teacher> selectedTeachers(ArrayList<Teacher> allTeachers, String input){
        return courseTeachersService.filterTeachers(input,allTeachers);
    }
    public boolean setTeachersToSelectedCourse(Course selectedCourse,ArrayList<Teacher> selectedTeachers, int chargeTeacher){
       return this.courseTeachersService.setTeachersToSelectedCourse(selectedCourse,selectedTeachers, chargeTeacher);
    }

}
