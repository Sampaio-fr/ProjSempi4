package eapli.base.question.applications;

import eapli.base.course.domain.Course;
import eapli.base.question.domain.Question;
import eapli.base.question.service.QuestionManagementService;

import java.io.IOException;

public class CreateQuestionController {

    private final QuestionManagementService questionManagementService = new QuestionManagementService();


    public Iterable<Course> listCourses() {
        return questionManagementService.listCourses();
    }

    public Question createQuestion(Course selectedCourse, String path) throws IOException {
        questionManagementService.validateQuestion(path);
        return questionManagementService.createQuestion(path, selectedCourse);
    }

    public void saveQuestion(Question question) {
        questionManagementService.saveQuestion(question);
    }


}
