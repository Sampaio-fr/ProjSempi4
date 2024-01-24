package eapli.base.exam.application;

import java.util.Collection;
import java.util.List;

public interface DisplayExam {
    boolean validateAnswer(String answer);

    boolean validateAnswerList(List<String> answerList);

    boolean validateMatchingAnswer(String leftAnswer, String rightAnswer);

    String showOptions(String displayHeader, Collection<String> optionsList);

    void showEvaluationResults(List<Integer> gradesList, List<Float> studentGrades,
                                List<List<String>> correctAnswersList, List<List<String>> studentAnswersList,
                                List<List<String>> feedbackList);
}
