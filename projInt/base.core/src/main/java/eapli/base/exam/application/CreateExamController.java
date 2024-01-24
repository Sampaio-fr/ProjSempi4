package eapli.base.exam.application;

import eapli.base.course.domain.Course;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.domain.FeedbackType;
import eapli.base.exam.domain.GradeType;
import eapli.base.exam.services.ExamManagemantService;

import java.io.IOException;

/**
 * The type Create exam controller.
 */
public class CreateExamController {
    private final ExamManagemantService examManagemantService = new ExamManagemantService();

    /**
     * List courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> listCourses() {
        return examManagemantService.listCourses();
    }

    /**
     * Validate exam.
     *
     * @param path the path
     * @throws IOException the io exception
     */
    public void validateExam(String path) throws IOException {
        examManagemantService.validateExam(path);
    }

    /**
     * Save exam.
     *
     * @param selectedCourse the selected course
     * @param examUpdated    the exam updated
     */
    public void saveExam(Course selectedCourse, Exam examUpdated) {
        examManagemantService.saveExam(selectedCourse, examUpdated);
    }

    /**
     * Create exam from path exam.
     *
     * @param path           the path
     * @param selectedCourse the selected course
     * @return the exam
     */
    public Exam createExamFromPath(String path, Course selectedCourse, GradeType gradeType, FeedbackType feedbackType) {
        return examManagemantService.createExamFromPath(path, selectedCourse, gradeType, feedbackType);
    }
}
