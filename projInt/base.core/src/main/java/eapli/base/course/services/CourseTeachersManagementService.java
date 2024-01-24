package eapli.base.course.services;

import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacherInCharge.domain.TeacherInCharge;
import eapli.base.teacherInCharge.repositories.TeacherInChargeRepository;

import java.util.ArrayList;

public class CourseTeachersManagementService {

    private final CourseRepository courseRepo;
    private final TeacherInChargeRepository tchargeRepo;

    public CourseTeachersManagementService() {
        RepositoryFactory rep = PersistenceContext.repositories();
        courseRepo = rep.courseRepository();
        tchargeRepo = rep.teacherInChargeRepository();

    }

    public ArrayList<Teacher> filterTeachers(String input, ArrayList<Teacher> allTeachers){
        ArrayList<Teacher> filtered = new ArrayList<>();
        String[] selectedIndexs = input.split(",");

        for (String selectedIndex : selectedIndexs) {
            int aux = Integer.parseInt(selectedIndex)-1;
            Teacher t = allTeachers.get(aux);
            filtered.add(t);
        }

        return filtered;
    }
    public boolean setTeachersToSelectedCourse(Course selectedCourse, ArrayList<Teacher> selectedTeachers, int chargeTeacherIndex){
        chargeTeacherIndex -=1;
        Teacher teacherInCharge = selectedTeachers.get(chargeTeacherIndex);

        boolean charge = hasTeacherInCharge(selectedCourse);
        boolean teachers = hasTeachers(selectedCourse);

        if(!charge && !teachers){
            addTeachers(selectedCourse,selectedTeachers,teacherInCharge);
            //this.courseRepo.save(selectedCourse);
            return true;
        }
        return false;
    }

    private void addTeachers(Course selectedCourse,  ArrayList<Teacher> selectedTeachers,Teacher teacherInCharge) {

        selectedCourse=saveTeacherInCharge(teacherInCharge,selectedCourse);

        for(Teacher t: selectedTeachers) {
            selectedCourse.addTeacher(t);
            selectedCourse = this.courseRepo.save(selectedCourse);
        }
    }


    private Course saveTeacherInCharge(Teacher teacher, Course course){
        TeacherInCharge charge = new TeacherInCharge(teacher);
        charge = this.tchargeRepo.save(charge);
        course.changeTeacherInCharge(charge);
        return this.courseRepo.save(course);
    }

    private boolean hasTeachers(Course course){
        return course.teachers().size() > 0;
    }

    private boolean hasTeacherInCharge(Course course){
        return course.teacherInCharge() != null;
    }
}
