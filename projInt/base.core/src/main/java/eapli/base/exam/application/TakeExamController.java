package eapli.base.exam.application;

import eapli.base.course.domain.Course;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollment.domain.EnrollmentState;
import eapli.base.exam.domain.Exam;
import eapli.base.exam.domain.ExamState;
import eapli.base.exam.grammar.ExamGrammarLexer;
import eapli.base.exam.grammar.ExamGrammarParser;
import eapli.base.exam.services.ListExamsManagementService;
import eapli.base.student.domain.Grade;
import eapli.base.student.domain.Student;
import eapli.base.student.service.GradeManagementService;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Controller
public class TakeExamController {

    private DisplayExam displayExam;
    private final ListExamsManagementService service = new ListExamsManagementService();
    private final GradeManagementService gradeSvc = new GradeManagementService();


    public Iterable<Exam> findActiveExams() {
        Student student = service.findStudentByEmail();

        List<Enrollment> enrollmentList = student.findEnrollments();

        if (enrollmentList.isEmpty()) return null;

        List<Exam> activeExamsList = new ArrayList<>();
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.enrollState().equals(EnrollmentState.ACCEPTED)) {
                Course course = enrollment.course();
                List<Exam> examListByCourse = course.findExamList();

                if (!examListByCourse.isEmpty()) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(LocalDate.now().getYear(), LocalDate.now().getMonthValue() - 1, LocalDate.now().getDayOfMonth(),
                            LocalTime.now().getHour(), LocalTime.now().getMinute());

                    boolean flag = false;
                    for (Exam exam : examListByCourse) {
                        if (exam.initialDate().before(calendar) &&
                                exam.finalDate().after(calendar) &&
                                exam.examState().equals(ExamState.PUBLISHED)) {

                            for (Grade grade : student.getGradeList()) {
                                if (grade.findGradeExams().equals(exam)){
                                    flag = true;
                                    break;
                                }
                            }

                            if (!flag) activeExamsList.add(exam);
                        }
                    }
                }
            }
        }

        if (activeExamsList.isEmpty()) return null;

        return activeExamsList;
    }

    public void doExamEvaluation(Exam exam) {
        Student student = service.findStudentByEmail();
        ExamGrammarParser parser;

        CharStream input = CharStreams.fromString(exam.examStruct());
        ExamGrammarLexer lexer = new ExamGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new ExamGrammarParser(tokens);

        ParseTree tree = parser.start();
        ExamEvaluationListener eval = new ExamEvaluationListener(this);
        ParseTreeWalker.DEFAULT.walk(eval, tree);

        showEvaluationResults(eval.gradesList, eval.studentGrades, eval.correctAnswersList,
                eval.studentAnswersList, eval.feedbackList);

        Course course = exam.course();
        int examGrade = 0;
        for (int grade : eval.gradesList) {
            examGrade += grade;
        }
        float myGrade = 0;
        for (Float grade : eval.studentGrades) {
            myGrade += grade;
        }

        gradeSvc.saveNewGrade(student, course, exam, examGrade, myGrade);
    }

    @Autowired
    public void setDisplayExam(DisplayExam displayExam) {
        this.displayExam = displayExam;
    }

    public boolean validateAnswer(String answer) {
        return displayExam.validateAnswer(answer);
    }

    public boolean validateAnswerList(List<String> answerList) {
        return displayExam.validateAnswerList(answerList);
    }

    public boolean validateMatchingAnswer(String leftAnswer, String rightAnswer) {
        return displayExam.validateMatchingAnswer(leftAnswer, rightAnswer);
    }

    public String showOptions(String displayHeader, Collection<String> optionsList) {
        return displayExam.showOptions(displayHeader, optionsList);
    }

    public void showEvaluationResults(List<Integer> gradesList, List<Float> studentGrades,
                                      List<List<String>> correctAnswersList, List<List<String>> studentAnswersList,
                                      List<List<String>> feedbackList) {
        displayExam.showEvaluationResults(gradesList, studentGrades, correctAnswersList, studentAnswersList, feedbackList);
    }
}
