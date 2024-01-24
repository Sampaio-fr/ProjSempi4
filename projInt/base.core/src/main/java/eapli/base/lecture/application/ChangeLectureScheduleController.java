package eapli.base.lecture.application;

import eapli.base.course.domain.Course;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.lecture.domain.Lecture;
import eapli.base.lecture.repositories.LecturesRepository;
import eapli.base.lecture.service.ListLecturesService;
import eapli.base.schedule.domain.Schedule;
import eapli.base.schedule.repositories.ScheduleRepository;
import eapli.base.student.domain.Student;
import eapli.base.teacher.domain.Teacher;
import eapli.base.user.domain.ECourseUser;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * The type Change lecture schedule controller.
 */
public class ChangeLectureScheduleController {

    private final ListLecturesService svc = new ListLecturesService();
    private final ScheduleRepository scheduleRepository = PersistenceContext.repositories().scheduleRepository();
    private final LecturesRepository lecturesRepository = PersistenceContext.repositories().lecturesRepository();
    private final AuthorizationService auth = AuthzRegistry.authorizationService();

    /**
     * Change lecture schedule lecture.
     *
     * @param lecture the lecture
     * @return the lecture
     */
    public Lecture changeLectureSchedule(final Lecture lecture, final Calendar dateTime, final int duration) {
        auth.ensureAuthenticatedUserHasAnyOf(BaseRoles.TEACHER);
        if (lecture == null | dateTime == null || duration < 0) {
            throw new IllegalArgumentException("You inserted invalid data");
        }

        Schedule newSchedule = new Schedule(dateTime, duration);
        Teacher teacher = myDetails().iterator().next();

        if (!verifyMyTimeTable(newSchedule, teacher.user())) {
            throw new IllegalArgumentException("There's a lecture in your schedule in conflict");
        }

        Course course = lecture.course();
        if (!verifyCourseTimeTable(newSchedule, course)) {
            throw new IllegalArgumentException("There's a lecture in the course schedule in conflict");
        }

        List<Student> studentList = course.studentSet();
        for (Student student : studentList){
            if (!verifyMyTimeTable(newSchedule, student.user())) {
                System.out.printf("WARNING - There's a conflict in student %s timetable%n", student.identity());
            }
        }

        lecture.changeInitialDate(dateTime);
        lecture.changeDurationAndFinalDate(duration);
        lecturesRepository.save(lecture);

        return scheduleRepository.save(lecture);
    }

    private boolean verifyMyTimeTable(final Schedule newSchedule, final ECourseUser user) {
        Iterable<Schedule> myTimeTable = myTimeTable(user);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String newInitialDate = dateFormat.format(newSchedule.initialDate().getTime());
        String newFinalDate = dateFormat.format(newSchedule.finalDate().getTime());

        for (Schedule schedule : myTimeTable) {

            String initialDate = dateFormat.format(schedule.initialDate().getTime());
            String finalDate = dateFormat.format(schedule.finalDate().getTime());

            if (initialDate.equals(newInitialDate) || initialDate.equals(newFinalDate)
                    || finalDate.equals(newInitialDate) || finalDate.equals(newFinalDate)) {
                if ((schedule.initialDate().before(newSchedule.initialDate()) && schedule.finalDate().after(newSchedule.initialDate()))
                        || (schedule.initialDate().before(newSchedule.finalDate()) && schedule.finalDate().after(newSchedule.finalDate()))
                        || (schedule.initialDate().equals(newSchedule.initialDate()) || schedule.finalDate().equals(newSchedule.initialDate()))
                        || (schedule.initialDate().equals(newSchedule.finalDate()) || schedule.finalDate().equals(newSchedule.finalDate()))) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean verifyCourseTimeTable(final Schedule newSchedule, final Course course) {
        Iterable<Schedule> courseSchedule = course.timeTable().listSchedules();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String newInitialDate = dateFormat.format(newSchedule.initialDate().getTime());
        String newFinalDate = dateFormat.format(newSchedule.finalDate().getTime());

        for (Schedule schedule : courseSchedule) {
            String initialDate = dateFormat.format(schedule.initialDate().getTime());
            String finalDate = dateFormat.format(schedule.finalDate().getTime());

            if (initialDate.equals(newInitialDate) || initialDate.equals(newFinalDate)
                    || finalDate.equals(newInitialDate) || finalDate.equals(newFinalDate)) {
                if ((schedule.initialDate().before(newSchedule.initialDate()) && schedule.finalDate().after(newSchedule.initialDate()))
                        || (schedule.initialDate().before(newSchedule.finalDate()) && schedule.finalDate().after(newSchedule.finalDate()))
                        || (schedule.initialDate().equals(newSchedule.initialDate()) || schedule.finalDate().equals(newSchedule.initialDate()))
                        || (schedule.initialDate().equals(newSchedule.finalDate()) || schedule.finalDate().equals(newSchedule.finalDate()))) {
                    return false;
                }
            }
        }

        return true;
    }

    public Iterable<Lecture> myLectures() {
        Teacher teacher = myDetails().iterator().next();
        ECourseUser user = teacher.user();

        return svc.myLectures(user);
    }

    public Iterable<Schedule> myTimeTable(ECourseUser user) {

        return user.timeTable().listSchedules();
    }

    /**
     * My lectures iterable.
     *
     * @return the iterable
     */
    public Iterable<Teacher> myDetails() {

        return this.svc.myDetails();
    }
}
