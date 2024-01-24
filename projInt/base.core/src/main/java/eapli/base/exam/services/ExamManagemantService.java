package eapli.base.exam.services;

import eapli.base.course.domain.Course;
import eapli.base.course.repositories.CourseRepository;
import eapli.base.exam.application.ExamGrammarSyntaxErrorListener;
import eapli.base.exam.application.ExamValidationListener;
import eapli.base.exam.builder.ExamBuilder;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.domain.ExamState;
import eapli.base.exam.domain.FeedbackType;
import eapli.base.exam.domain.GradeType;
import eapli.base.exam.grammar.ExamGrammarLexer;
import eapli.base.exam.grammar.ExamGrammarParser;
import eapli.base.exam.repositories.ExamRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.student.domain.Student;
import eapli.base.teacher.domain.Teacher;
import eapli.base.teacher.repositories.TeacherRepository;
import eapli.base.timetable.domain.TimeTable;
import eapli.base.timetable.repositories.TimetableRepository;
import eapli.base.user.domain.ECourseUser;
import eapli.base.user.repositories.ECourseUserRepository;
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
import java.util.Calendar;
import java.util.List;

/**
 * The type Exam managemant service.
 */
public class ExamManagemantService {
    private final AuthorizationService authorizationService;
    private final CourseRepository courseRepository;
    private final ExamRepository examRepository;
    private final TeacherRepository teacherRepository;
    private final ECourseUserRepository eCourseUserRepository;
    private final TimetableRepository timetableRepository;
    private final ExamBuilder examBuilder;
    private Course course;

    /**
     * Instantiates a new Exam managemant service.
     */
    public ExamManagemantService() {
        this.authorizationService = AuthzRegistry.authorizationService();
        this.courseRepository = PersistenceContext.repositories().courseRepository();
        this.examRepository = PersistenceContext.repositories().examRepository();
        this.teacherRepository = PersistenceContext.repositories().teacherRepository();
        this.timetableRepository = PersistenceContext.repositories().timetableRepository();
        this.eCourseUserRepository = PersistenceContext.repositories().eCourseUserRepository();
        this.examBuilder = new ExamBuilder();
    }


    /**
     * List courses iterable.
     *
     * @return the iterable
     */
    public Iterable<Course> listCourses() {
        // Make return only the courses that are with the professor
        //return courseRepository.listCourses();
        SystemUser systemUser = authorizationService.session().get().authenticatedUser();
        Teacher teacher = teacherRepository.findTeacherByEmail(systemUser.email());
        return courseRepository.coursesByTeachers(teacher);
    }


    /**
     * Validate exam.
     *
     * @param path the path
     * @throws IOException the io exception
     */
    public void validateExam(String path) throws IOException {
        ExamGrammarLexer lexer = new ExamGrammarLexer(CharStreams.fromFileName(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExamGrammarParser parser = new ExamGrammarParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ExamGrammarSyntaxErrorListener());

        ParseTree tree = parser.start();
        ExamValidationListener eval = new ExamValidationListener();
        ParseTreeWalker.DEFAULT.walk(eval, tree);
    }

    /**
     * Create exam from path exam.
     *
     * @param path           the path
     * @param selectedCourse the selected course
     * @return the exam
     */
    public Exam createExamFromPath(String path, Course selectedCourse, GradeType gradeType, FeedbackType feedbackType) {
        String examText = readFileToString(path);
        String examTitle = examText.split("::")[1].split(";")[0].trim();

        SystemUser systemUser = authorizationService.session().get().authenticatedUser();
        Teacher teacher = teacherRepository.findTeacherByEmail(systemUser.email());

        return examBuilder.withTitle(examTitle).withExamStruct(examText).withTeacher(teacher).withCourse(selectedCourse).withExamState(ExamState.DRAFT).
                withFeedbackType(feedbackType).withGradeType(gradeType).build();
    }

    /**
     * Save exam.
     *
     * @param selectedCourse the selected course
     * @param examUpdated    the exam updated
     */
    public void saveExam(Course selectedCourse, Exam examUpdated) {
        examUpdated =examRepository.save(examUpdated);
        selectedCourse.addExam(examUpdated);
        courseRepository.save(selectedCourse);
    }

    public void saveUpdatedExamAndStudents(Course course, Exam exam) {
        examRepository.save(exam);
        courseRepository.save(course);

        List<ECourseUser> listUsers = new ArrayList<>();
        for (Student student : course.studentSet()){
            listUsers.add(student.user());
        }
        for (Teacher teacher : course.teachers()){
            listUsers.add(teacher.user());
        }

        saveStudentAndTeachersExam(listUsers, exam);
    }

    private void saveStudentAndTeachersExam(Iterable<ECourseUser> listUsers, Exam exam) {
        TimeTable table;
        for (ECourseUser user : listUsers) {
            table = user.timeTable();
            table.addSchedules(exam);
            timetableRepository.save(table);
            eCourseUserRepository.save(user);
        }
    }

    public String readFileToString(String filePath) {
        return fileReader(filePath);
    }

    static String fileReader(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return stringBuilder.toString();
    }

    public List<Exam> findExams(Course course) {
        SystemUser systemUser = authorizationService.session().get().authenticatedUser();
        Teacher teacher = teacherRepository.findTeacherByEmail(systemUser.email());
        return examRepository.examsByCourseAndTeacher(course, teacher);
    }

    public Exam updateExam(Exam exam, String text, FeedbackType feedbackType, GradeType gradeType) {
        exam.changeExamStruct(text);
        exam.changeExamTitle(text.split("::")[1].split(";")[0].trim());
        exam.changeFeedbackType(feedbackType);
        exam.changeGradeType(gradeType);
        Calendar calendar = Calendar.getInstance();
        exam.changeInitialDate(calendar);
        exam.changeFinalDate(calendar);
        return exam;
    }
}
