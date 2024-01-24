package eapli.base.exam.application;

import eapli.base.course.domain.Course;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.domain.FeedbackType;
import eapli.base.exam.domain.GradeType;
import eapli.base.exam.services.ExamManagemantService;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * The type Update exam controller.
 */
public class UpdateExamController {

    private ExamManagemantService examManagemantService = new ExamManagemantService();

    /**
     * Find courses list.
     *
     * @return the list
     */
    public Iterable<Course> findCourses() {
        return examManagemantService.listCourses();
    }

    /**
     * Find exams list.
     *
     * @param course the course
     * @return the list
     */
    public List<Exam> findExams(Course course) {
        return examManagemantService.findExams(course);
    }


    /**
     * Save updated exam.
     *
     * @param examUpdated the exam updated
     * @throws IOException the io exception
     */
    public void saveUpdatedExam(Course course, Exam examUpdated) throws IOException {
        examManagemantService.saveUpdatedExamAndStudents(course, examUpdated);
    }

    private void validateExam(String path) throws IOException {
        examManagemantService.validateExam(path);
    }

    /**
     * Update exam exam.
     *
     * @param exam the exam
     * @param path the path
     * @return the exam
     * @throws IOException the io exception
     */
    public Exam updateExam(Exam exam, String path, FeedbackType feedbackType, GradeType gradeType) throws IOException {
        validateExam(path);
        String text = examManagemantService.readFileToString(path);
        return examManagemantService.updateExam(exam, text, feedbackType, gradeType);
    }
}
