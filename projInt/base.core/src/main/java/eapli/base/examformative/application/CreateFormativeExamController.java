package eapli.base.examformative.application;

import eapli.base.course.domain.Course;
import eapli.base.examformative.domain.ExamFormative;
import eapli.base.examformative.services.FormativeExamManagemantService;
import eapli.base.question.domain.Question;
import eapli.base.question.domain.QuestionType;
import eapli.framework.general.domain.model.Description;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * The type Create exam controller.
 */
public class CreateFormativeExamController {
    private FormativeExamManagemantService examManagementService = new FormativeExamManagemantService();
    private final String FILE_PATH = "base.core/src/main/java/eapli/base/examformative/grammar/";
    private final String FILE_EXTENSION = ".txt";
    /**
     * List courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> listCourses() {
        return examManagementService.listCourses();
    }
    /**
     * Validate exam.
     *
     * @param path the path
     * @throws IOException the io exception
     */
    public void validateFormativeExam(String path) throws IOException {
        examManagementService.validateExam(path);
    }

    public String createQuestionnaireTextFile(String questionnaireName){
        File questionnaire = null;
        try{
            questionnaire = new File(FILE_PATH + questionnaireName + FILE_EXTENSION);
            questionnaire.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return questionnaire.getPath();
    }

    public void writeQuestionnaireTextFile(String information, String filePath){
        if(!filePath.isEmpty()) {
            try {
                FileWriter fileWriter = new FileWriter(filePath, true);
                PrintWriter questionnaireWriter = new PrintWriter(fileWriter);
                questionnaireWriter.append(information);
                questionnaireWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public Question selectedQuestion(QuestionType questionType,Set<Question> selectedQuestions){
        return examManagementService.getRandomQuestionByType(questionType,selectedQuestions);
    }
    public ExamFormative saveFormativeExam(String examTitle, String examStructure, Course selectedCourse) {
        return examManagementService.saveExamFormative(examTitle,examStructure,selectedCourse);
    }

}
