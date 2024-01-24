package eapli.base.question.applications;

import eapli.base.course.domain.Course;
import eapli.base.question.domain.Question;
import eapli.base.question.service.QuestionManagementService;


/**
 * The type Update exam controller.
 */
public class UpdateQuestionController {

        private QuestionManagementService questionManagementService = new QuestionManagementService();


    /**
     * List courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> listCourses() {
            return questionManagementService.listCourses();
        }

    /**
     * List questions iterable.
     *
     * @return the iterable
     */
    public Iterable<Question> listQuestions(Course course) {
            return questionManagementService.listQuestions(course);
        }

    /**
     * Save question.
     *
     * @param updateQuestion the update question
     */
    public void saveQuestion(Question updateQuestion) {
            questionManagementService.saveQuestion(updateQuestion);
        }

    /**
     * Update question question.
     *
     * @param question the question
     * @param path     the path
     * @return the question
     */
    public Question updateQuestion(Question question, String path) {
            return questionManagementService.updateQuestion(question, path);
        }
    }


