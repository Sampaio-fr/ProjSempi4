package eapli.base.app.student.console.presentation.exams;

import eapli.base.exam.application.DefaultQuestionPrinter;
import eapli.base.exam.application.DisplayExam;
import eapli.base.utils.SelectWidgetNoExit;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DisplayExamImpl implements DisplayExam {

    public boolean validateAnswer(String answer) {
        String selectedAnswer;
        final SelectWidgetNoExit<String> selector;
        if (answer == null) {
            selector = new SelectWidgetNoExit<>("Are you sure you don't want to answer the question", new ArrayList<>(Arrays.asList("yes", "no")), new DefaultQuestionPrinter());
        } else {
            selector = new SelectWidgetNoExit<>(String.format("Do you confirm your answer (%s):", answer), new ArrayList<>(Arrays.asList("yes", "no")), new DefaultQuestionPrinter());
        }
        selector.show();
        selectedAnswer = selector.selectedElement();

        return selectedAnswer.equals("yes");
    }

    public boolean validateAnswerList(List<String> answerList) {
        String selectedAnswer;
        final SelectWidgetNoExit<String> selector;
        if (answerList.isEmpty()) {
            selector = new SelectWidgetNoExit<>("Are you sure you don't want to answer the question", new ArrayList<>(Arrays.asList("yes", "no")), new DefaultQuestionPrinter());
        } else {
            selector = new SelectWidgetNoExit<>(String.format("Do you confirm your answer (%s):", answerList), new ArrayList<>(Arrays.asList("yes", "no")), new DefaultQuestionPrinter());
        }
        selector.show();
        selectedAnswer = selector.selectedElement();

        return selectedAnswer.equals("yes");
    }

    public boolean validateMatchingAnswer(String leftAnswer, String rightAnswer) {
        String selectedAnswer;
        final SelectWidgetNoExit<String> selector;
        if (leftAnswer == null || rightAnswer == null) {
            selector = new SelectWidgetNoExit<>("Are you sure you don't want to answer the question", new ArrayList<>(Arrays.asList("yes", "no")), new DefaultQuestionPrinter());
        } else {
            selector = new SelectWidgetNoExit<>(String.format("Do you confirm your answer (%s -> %s):", leftAnswer, rightAnswer), new ArrayList<>(Arrays.asList("yes", "no")), new DefaultQuestionPrinter());
        }
        selector.show();
        selectedAnswer = selector.selectedElement();

        return selectedAnswer.equals("yes");
    }

    public String showOptions(String displayHeader, Collection<String> optionsList) {
        SelectWidget<String> selector = new SelectWidget<>(displayHeader, optionsList, new DefaultQuestionPrinter());
        selector.show();

        return selector.selectedElement();
    }

    public void showEvaluationResults(List<Integer> gradesList, List<Float> studentGrades,
                                       List<List<String>> correctAnswersList, List<List<String>> studentAnswersList,
                                       List<List<String>> feedbackList) {

        int totalGrade = 0;
        float totalStudentGrade = 0;
        System.out.println("\nExam Evaluation: \n");
        for (int i = 0; i < gradesList.size(); i++) {
            System.out.printf("%nThe total question grade is: %s%n", gradesList.get(i));
            System.out.printf("Your question grade is: %s%n%n", studentGrades.get(i));
            System.out.printf("The correct answer was: %s%n", correctAnswersList.get(i));
            totalGrade += gradesList.get(i);
            System.out.printf("Your answer was: %s%n", studentAnswersList.get(i));
            totalStudentGrade += studentGrades.get(i);
            System.out.println("Feedback:\n");
            for (int j = 0; j < feedbackList.get(i).size(); j++) {
                System.out.println(feedbackList.get(i).get(j));
            }
        }
        System.out.println();
        System.out.printf("The total exam grade is %d%n", totalGrade);
        System.out.printf("Your grade is %f%n", totalStudentGrade);
    }
}
