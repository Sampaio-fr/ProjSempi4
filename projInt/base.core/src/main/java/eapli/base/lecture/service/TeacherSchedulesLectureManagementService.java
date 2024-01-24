package eapli.base.lecture.service;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.enrollment.services.EnrollmentManagementService;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.lecture.builder.LectureBuilder;
import eapli.base.lecture.domain.Lecture;
import eapli.base.lecture.domain.LectureType;
import eapli.base.lecture.repositories.LecturesRepository;
import eapli.base.schedule.domain.Schedule;
import eapli.base.schedule.repositories.ScheduleRepository;
import eapli.base.student.domain.Student;
import eapli.base.student.repositories.StudentRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.timetable.repositories.TimetableRepository;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.repositories.ECourseUserRepository;
import eapli.framework.general.domain.model.Designation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TeacherSchedulesLectureManagementService {

    private final CourseRepository courseRepo;
    private final TeacherRepository teacherRepo;
    private final LecturesRepository lectureRepo;
    private final ScheduleRepository scheduleRepo;
    private final StudentRepository studentRepo;
    private final LectureBuilder lectureBuilder;
    private final TimetableRepository timetableRepo;
    private final ECourseUserRepository eCourseUserRepository;
    private final EnrollmentManagementService enrollmentManagementService;


    public TeacherSchedulesLectureManagementService() {
        RepositoryFactory rep = PersistenceContext.repositories();
        this.scheduleRepo = rep.scheduleRepository();
        this.lectureRepo = rep.lecturesRepository();
        this.courseRepo = rep.courseRepository();
        this.teacherRepo = rep.teacherRepository();
        this.studentRepo = rep.studentRepository();
        this.lectureBuilder = new LectureBuilder();
        this.timetableRepo = rep.timetableRepository();
        this.eCourseUserRepository = rep.eCourseUserRepository();
        this.enrollmentManagementService = new EnrollmentManagementService();
    }


    //============ SCHEDULE NORMAL CLASSES ===================================================================================================================================
    public boolean tryScheduleClass(Teacher teacher, String title, Course selectedcourse, Calendar day, int duration, int weeks) {

        boolean teacherFlag = true;
        boolean courseFlag = true;

        // verification of availability to schedule the chosen classes
        for (int i = 0; i < weeks; i++) {
            day.add(Calendar.WEEK_OF_YEAR, i);
            Schedule schedule = new Schedule(day, duration);
            if (hasTeacherConflict(teacher, schedule)) {
                teacherFlag = false;
            }
            if (hasCourseConflict(selectedcourse, schedule)) {
                courseFlag = false;
            }
        }
         printLectureStudents(selectedcourse);

        //teacherFlag=true && courseFlag= true -> there aren't overlaps with the schedule and so it's possible to proceed
        Calendar aux2 = day;

        if (teacherFlag && courseFlag) {
            // adicionar lectures ao professor, ao curso e ao aluno
            for (int i = 0; i < weeks; i++) {

                aux2.add(Calendar.WEEK_OF_YEAR, i);

                Lecture lecture = lectureBuilder.withLectureTitle(Designation.valueOf(title)).withLectureType(LectureType.NORMAL).withCourse(selectedcourse).withInitialDate(day).withDuration(duration).build();
                Lecture lecture1 = this.lectureRepo.save(lecture);
                lecture1 = this.scheduleRepo.save(lecture1);


                //course
                selectedcourse.timeTable().addSchedules(lecture1);
                this.timetableRepo.save(selectedcourse.timeTable());
                selectedcourse = this.courseRepo.save(selectedcourse);

                //students
                saveLectureStudents(selectedcourse);

                //teacher
                teacher.user().timeTable().addSchedules(lecture1);
                this.timetableRepo.save(teacher.user().timeTable());
                teacher = this.teacherRepo.save(teacher);

            }
            return true;
        }
        return false;
    }


    public boolean tryScheduleExtraClass(Teacher teacher, String title, Course selectedcourse, List<Student> students, Calendar day, int duration) {

        Schedule s = new Schedule(day, duration);

        boolean flag = hasCourseConflict(selectedcourse, s);
        boolean teacherflag = hasTeacherConflict(teacher, s);

        if (flag) {
            System.out.println("There is a scheduling conflict in course. Please choose a different date and time.");
            return false;
        }
        if (teacherflag) {
            System.out.println("There is a scheduling conflict in your timetable. Please choose a different date and time.");
            return false;
        }

        Lecture toBeScheduled = new Lecture(Designation.valueOf(title), LectureType.EXTRA, day, duration, selectedcourse);
        toBeScheduled = this.lectureRepo.save(toBeScheduled);
        this.scheduleRepo.save(toBeScheduled);

        TimeTable timeTable ;
        timeTable = selectedcourse.timeTable();
        timeTable.addSchedules(toBeScheduled);
        timetableRepo.save(timeTable);
        courseRepo.save(selectedcourse);


        timeTable = teacher.user().timeTable();
        timeTable.addSchedules(toBeScheduled);
        timetableRepo.save(timeTable);
        teacherRepo.save(teacher);
        System.out.println("Extra Lecture was scheduled!!");

        ArrayList<ECourseUser> studentsUser = findEcourseUsersByEmail(students);

        saveExtraLecture(studentsUser,toBeScheduled);


        return true;
    }

    private void saveExtraLecture(ArrayList<ECourseUser> studentsUser, Lecture toBeScheduled) {
        TimeTable timeTable;
        for (ECourseUser user :studentsUser) {
            timeTable = user.timeTable();
            timeTable.addSchedules(toBeScheduled);
            timetableRepo.save(timeTable);
            eCourseUserRepository.save(user);
        }

    }


    public boolean hasCourseConflict(Course course, Schedule schedule) {
        List<Schedule> schedules = course.timeTable().listSchedules();
        for (Schedule sched : schedules) {
            if (doSchedulesOverlap(sched, schedule)) {
                return true; // Overlap found
            }
        }
        return false; // No conflict
    }

    public boolean hasTeacherConflict(Teacher teacher, Schedule scheduleToBe) {
        List<Schedule> schedules = teacher.user().timeTable().listSchedules();

        for (Schedule sched : schedules) {
            if (doSchedulesOverlap(sched, scheduleToBe)) {
                return true; // Overlap found
            }
        }
        return false;
    }

    private boolean doSchedulesOverlap(Schedule schedule1, Schedule schedule2) {
        // Check if the final date of schedule1 is before the initial date of schedule2
        if (schedule1.finalDate().before(schedule2.initialDate())) {
            return false; // No overlap
        }
        // Check if the initial date of schedule1 is after the final date of schedule2
        if (schedule1.initialDate().after(schedule2.finalDate())) {
            return false; // No overlap
        }

        return true; // Overlap found
    }


    private void printLectureStudents(Course course) {
        List<Student> students = course.studentSet();
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void saveLectureStudents(Course course) {
        List<Student> students = course.studentSet();
        ArrayList<ECourseUser> list = findEcourseUsersByEmail(students);
        List<Schedule> listSchedules = course.timeTable().listSchedules();
        for (ECourseUser s :list){
            TimeTable timeTable = s.timeTable();
            for (Schedule schedule:listSchedules) {
                timeTable.addSchedules(schedule);
            }
            timeTable = timetableRepo.save(timeTable);
            s.replaceTimeTable(timeTable);
            eCourseUserRepository.save(s);
        }
    }

    private ArrayList<ECourseUser> findEcourseUsersByEmail(List<Student> students) {
        ArrayList<ECourseUser> list = new ArrayList<ECourseUser>();
        for (Student student: students) {
           list.add( eCourseUserRepository.ofIdentity(student.user().email()).get());
        }
        return list;
    }


    public List<MecanographicNumber> filterStudents(String input) {
        List<MecanographicNumber> filtered = new ArrayList<>();
        String[] studentMecNumbs = input.split(",");

        for (String stdMecNum : studentMecNumbs) {
            MecanographicNumber menN = new MecanographicNumber(stdMecNum.trim());
            filtered.add(menN);
        }
        return filtered;
    }

    public List<Student> findStudentByCourse(Course selectedCourse) {
        return selectedCourse.studentSet();
    }
}
