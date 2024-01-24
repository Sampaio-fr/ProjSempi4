package eapli.base.question.service;

import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.question.applications.QuestionGrammarSyntaxErrorListener;
import eapli.base.question.applications.QuestionValidationListener;
import eapli.base.question.builder.QuestionBuilder;
import eapli.base.question.domain.Question;
import eapli.base.question.domain.QuestionType;
import eapli.base.question.grammar.QuestionGrammarLexer;
import eapli.base.question.grammar.QuestionGrammarParser;
import eapli.base.question.repositories.QuestionRepository;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Question management service.
 */
public class QuestionManagementService {

    private final AuthorizationService authorizationService = AuthzRegistry.authorizationService();
    private final CourseRepository courseRepository = PersistenceContext.repositories().courseRepository();
    private final QuestionRepository questionRepository = PersistenceContext.repositories().questionRepository();
    private final TeacherRepository teacherRepository = PersistenceContext.repositories().teacherRepository();
    private final QuestionBuilder questionBuilder = new QuestionBuilder();

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

    /**
     * Validate question.
     *
     * @param path the path
     * @throws IOException the io exception
     */
    public void validateQuestion(String path) throws IOException {
        QuestionGrammarLexer lexer = new QuestionGrammarLexer(CharStreams.fromFileName(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        QuestionGrammarParser parser = new QuestionGrammarParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new QuestionGrammarSyntaxErrorListener());

        ParseTree tree = parser.start();
        QuestionValidationListener eval = new QuestionValidationListener();
        ParseTreeWalker.DEFAULT.walk(eval, tree);
    }

    /**
     * Create question question.
     *
     * @param path           the path
     * @param selectedCourse the selected course
     * @return the question
     */
    public Question createQuestion(String path, Course selectedCourse) {
        List<String> question = readFileToString(path);
        System.out.println(question.get(0));
        return questionBuilder.withCourse(selectedCourse).withQuestionType(QuestionType.defineFromString(question.get(0).split(";")[0].trim())).withQuestion(question.get(1)).build();
    }

    /**
     * Save question.
     *
     * @param question the question
     */
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }


    /**
     * Read file to string list.
     *
     * @param filePath the file path
     * @return the list
     */
    public List<String> readFileToString(String filePath) {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String title = br.readLine().trim(); // Read the first line as the title
            StringBuilder content = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

            String restOfFile = content.toString();
            lines.add(title);
            lines.add(title + "\n" + restOfFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;

    }

    /**
     * List questions iterable.
     *
     * @param course the course
     * @return the iterable
     */
    public Iterable<Question> listQuestions(Course course) {
        return questionRepository.listQuestions(course);
    }

    /**
     * Update question question.
     *
     * @param question the question
     * @param path     the path
     * @return the question
     */
    public Question updateQuestion(Question question, String path) {
        List<String> list = readFileToString(path);
        question.changeQuestion(list.get(1));
        question.defineQuestionType(list.get(0).split(";")[0].trim());
        return question;
    }
}
