package eapli.base.examformative.services;

import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.examformative.domain.ExamFormative;
import eapli.base.examformative.grammar.FormativeExamGrammarLexer;
import eapli.base.examformative.grammar.FormativeExamGrammarParser;
import eapli.base.examformative.repositories.ExamFormativeRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.question.domain.Question;
import eapli.base.question.domain.QuestionType;
import eapli.base.question.repositories.QuestionRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.springframework.transaction.annotation.Transactional;


import java.io.*;
import java.util.*;


/**
 * The type Exam managemant service.
 */
@Transactional
public class FormativeExamManagemantService {
    private final AuthorizationService authorizationService;
    private final CourseRepository courseRepository;
    private final ExamFormativeRepository examFormativeRepository;
    private final TeacherRepository teacherRepository;
    private final QuestionRepository questionRepository;

    /**
     * Instantiates a new Exam managemant service.
     */
    public FormativeExamManagemantService() {
        this.authorizationService = AuthzRegistry.authorizationService();
        this.courseRepository = PersistenceContext.repositories().courseRepository();
        this.examFormativeRepository = PersistenceContext.repositories().examFormativeRepository();
        this.teacherRepository = PersistenceContext.repositories().teacherRepository();
        this.questionRepository = PersistenceContext.repositories().questionRepository();
    }
    /**
     * List courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> listCourses() {
        SystemUser systemUser = authorizationService.session().get().authenticatedUser();
        Teacher teacher = teacherRepository.findTeacherByEmail(systemUser.email());
        return courseRepository.coursesByTeachers(teacher);

    }
    public Question getRandomQuestionByType(QuestionType questionType, Set<Question> selectedQuestions) {
        List<Question> availableQuestions = new ArrayList<>();

        // Filter out questions that have already been selected
        for (Question question : questionRepository.listQuestionsByType(questionType)) {
            if (!selectedQuestions.contains(question)) {
                availableQuestions.add(question);
            }
        }

        if (availableQuestions.isEmpty()) {
            return null; // No more available questions of the given type
        }

        Random random = new Random();
        int index = random.nextInt(availableQuestions.size());
        Question randomQuestion = availableQuestions.get(index);
        return randomQuestion;
    }

    /**
     * Validate exam.
     *
     * @param path the path
     * @throws IOException the io exception
     */
    public void validateExam(String path) throws IOException {
        FormativeExamGrammarLexer lexer = new FormativeExamGrammarLexer(CharStreams.fromFileName(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FormativeExamGrammarParser parser = new FormativeExamGrammarParser(tokens);
        parser.start();
    }


    private ExamFormative createFormativeExam(String examTitle, String examStructure, Course selectedCourse) {
        SystemUser systemUser = authorizationService.session().get().authenticatedUser();
        Teacher teacher = teacherRepository.findTeacherByEmail(systemUser.email());
        return new ExamFormative(examTitle,examStructure,selectedCourse,teacher);
    }

    /**
     * Save exam.
     *
     * @param selectedCourse the selected course
     */
    public ExamFormative saveExamFormative(String examTitle, String examStructure, Course selectedCourse) {
        ExamFormative createdExam = createFormativeExam(examTitle,examStructure,selectedCourse);
        ExamFormative savedExam = examFormativeRepository.save(createdExam);
        courseRepository.save(selectedCourse);
        return savedExam;
    }

    public List<ExamFormative> findFormativeExams(Course course){
        return examFormativeRepository.examsByCourse(course);
    }

    public void saveUpdatedExam(String struct, ExamFormative exam){
        exam.updateExamStruct(struct);
        this.examFormativeRepository.save(exam);
    }

}
