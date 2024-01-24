package eapli.base.exam.application;

import eapli.base.course.domain.Course;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollment.domain.EnrollmentState;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.domain.ExamState;
import eapli.base.exam.services.ListExamsManagementService;
import eapli.base.student.domain.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ListStudentExamsController {

    private final ListExamsManagementService service = new ListExamsManagementService();

    public Iterable<Exam> listMyExams() {

        List<Exam> examList = new ArrayList<>();
        Student s = service.findStudentByEmail();

        if (s == null) {
            return null;
        }

        List<Enrollment> enrollmentList = s.findEnrollments();

        if (enrollmentList.isEmpty()) {
            return null;
        }

        for (int i = 0; i < enrollmentList.size(); i++) {
            Enrollment enrollment = enrollmentList.get(i);

            if (enrollment.enrollState().equals(EnrollmentState.ACCEPTED)) {
                Course course = enrollment.course();
                List<Exam> examListByCourse = course.findExamList();

                if (!examListByCourse.isEmpty()) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(LocalDate.now().getYear(), LocalDate.now().getMonthValue() - 1, LocalDate.now().getDayOfMonth(),
                            LocalTime.now().getHour(), LocalTime.now().getMinute());

                    for (Exam exam : examListByCourse) {
                        if (exam.initialDate().after(calendar) &&
                                exam.examState().equals(ExamState.PUBLISHED)) {
                            examList.add(exam);
                        }
                    }
                }
            }
        }

        if (examList.isEmpty()) return null;

        return examList;
    }
}
