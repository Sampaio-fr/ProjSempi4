package eapli.base.examformative.application;

import eapli.base.course.domain.Course;
import eapli.base.enrollment.domain.Enrollment;
import eapli.base.enrollment.domain.EnrollmentState;
import eapli.base.examformative.domain.ExamFormative;
import eapli.base.examformative.grammar.FormativeExamGrammarLexer;
import eapli.base.examformative.grammar.FormativeExamGrammarParser;
import eapli.base.examformative.services.FormativeExamManagemantService;
import eapli.base.student.domain.Student;
import eapli.base.student.service.StudentManagementService;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class TakeFormativeExamController {

    private DisplayFormativeExam displayExam;
    private final StudentManagementService studentManagementService = new StudentManagementService();
    private final FormativeExamManagemantService formativeExamService= new FormativeExamManagemantService();

    @Autowired
    public void setDisplayExam(DisplayFormativeExam displayExam) {
        this.displayExam = displayExam;
    }

    public Iterable<ExamFormative> findFormativeExams() {
        Student student = studentManagementService.findStudentByEmail();

        List<Enrollment> enrollmentList = student.findEnrollments();
        if (enrollmentList.isEmpty()) return null;

        List<ExamFormative> examsList= new ArrayList<>();
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.enrollState().equals(EnrollmentState.ACCEPTED)) {
                Course course = enrollment.course();
                examsList = formativeExamService.findFormativeExams(course);
            }
        }

        if (examsList.isEmpty()){ return null;}

        return examsList;
    }


    public void doFormativeExamEvaluation(ExamFormative exam) {
        FormativeExamGrammarParser parser;

        CharStream input = CharStreams.fromString(exam.examStruct());
        FormativeExamGrammarLexer lexer = new FormativeExamGrammarLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new FormativeExamGrammarParser(tokens);

        ParseTree tree = parser.start();
        FormativeExamEvaluationListener eval = new FormativeExamEvaluationListener(this);
        ParseTreeWalker.DEFAULT.walk(eval, tree);

        showEvaluationResults(eval.gradesList, eval.studentGrades, eval.correctAnswersList,
                eval.studentAnswersList, eval.feedbackList);

        int examGrade = 0;
        for (int grade : eval.gradesList) {
            examGrade += grade;
        }
        float myGrade = 0;
        for (Float grade : eval.studentGrades) {
            myGrade += grade;
        }

        System.out.println("Grade: "+myGrade);
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
