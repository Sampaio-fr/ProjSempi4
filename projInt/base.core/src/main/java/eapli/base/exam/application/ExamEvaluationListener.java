package eapli.base.exam.application;


import eapli.base.exam.grammar.ExamGrammarBaseListener;
import eapli.base.exam.grammar.ExamGrammarParser;
import eapli.framework.io.util.Console;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class ExamEvaluationListener extends ExamGrammarBaseListener {

    private TakeExamController controller;
    public List<Integer> gradesList;
    public List<Float> studentGrades;
    public List<List<String>> feedbackList;
    public List<List<String>> studentAnswersList;
    public List<List<String>> correctAnswersList;
    public List<String> auxFeedbackList;

    public ExamEvaluationListener(TakeExamController controller) {
        this.controller = controller;
    }

    @Override
    public void enterStart(ExamGrammarParser.StartContext ctx) {
        gradesList = new ArrayList<>();
        studentGrades = new ArrayList<>();
        feedbackList = new ArrayList<>();
        studentAnswersList = new ArrayList<>();
        correctAnswersList = new ArrayList<>();
    }

    @Override
    public void enterTitle(ExamGrammarParser.TitleContext ctx) {
        System.out.println(ctx.SENTENCE().getText().trim());
    }

    @Override
    public void enterDescription(ExamGrammarParser.DescriptionContext ctx) {
        System.out.println();
        for (TerminalNode sentence : ctx.SENTENCE()) {
            System.out.println(sentence.getText().trim());
        }
        System.out.println();
    }

    @Override
    public void enterMultiple_choice_question(ExamGrammarParser.Multiple_choice_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        List<String> correctAnswers = new ArrayList<>();
        List<String> answersList;
        auxFeedbackList = new ArrayList<>();
        float studentGrade;

        List<String> questionList = new ArrayList<>();

        for (ExamGrammarParser.Correct_answerContext question : ctx.answer_list().correct_answer()) {
            questionList.add(question.SENTENCE().getText().trim());
        }
        for (ExamGrammarParser.Wrong_answerContext question : ctx.answer_list().wrong_answer()) {
            questionList.add(question.SENTENCE().getText().trim());
        }

        boolean flag;
        if (ctx.answer_list().correct_answer().size() == 1) {
            String selectedAnswer;
            do {
                selectedAnswer = controller.showOptions("Multiple choice question:", questionList);
                flag = validateAnswer(selectedAnswer);
            } while (!flag);

            String correctAnswer = ctx.answer_list().correct_answer().get(0).SENTENCE().getText();

            if (selectedAnswer == null) {
                studentGrade = 0;
                auxFeedbackList.add("You didn't answer the question!");
                selectedAnswer = "No answer!";
            } else {
                if (correctAnswer.equalsIgnoreCase(selectedAnswer)) {
                    ExamGrammarParser.FeedbackContext feedback = ctx.answer_list().correct_answer().get(0).feedback();
                    saveFeedback(feedback);
                    studentGrade = grade;
                } else {
                    for (ExamGrammarParser.Wrong_answerContext wrongAnswer : ctx.answer_list().wrong_answer()) {
                        if (selectedAnswer.equalsIgnoreCase(wrongAnswer.SENTENCE().getText())) {
                            ExamGrammarParser.FeedbackContext feedback = wrongAnswer.feedback();
                            saveFeedback(feedback);
                        }
                    }
                    studentGrade = 0;
                }
            }
            answersList = new ArrayList<>();
            answersList.add(selectedAnswer);
            correctAnswers.add(correctAnswer);
        } else {
            System.out.println("Select all the correct options");
            Set<String> auxQuestionList = new HashSet<>();
            do {
                auxQuestionList.addAll(questionList);
                answersList = new ArrayList<>();
                String selectedAnswer;
                do {
                    selectedAnswer = controller.showOptions("Options:", auxQuestionList);
                    if (selectedAnswer != null) {
                        answersList.add(selectedAnswer);
                        auxQuestionList.remove(selectedAnswer);
                    }
                } while (selectedAnswer != null && auxQuestionList.size() > 0);
                flag = validateAnswerList(answersList);
            } while (!flag);

            for (ExamGrammarParser.Correct_answerContext correctAnswer : ctx.answer_list().correct_answer()) {
                correctAnswers.add(correctAnswer.SENTENCE().getText().trim());
            }

            int nCorrectAnswers = 0;
            for (String answer : answersList) {
                if (correctAnswers.contains(answer)) {
                    nCorrectAnswers++;
                } else nCorrectAnswers--; // One wrong answer discounts one correct answer
            }

            if (nCorrectAnswers <= 0) {
                studentGrade = 0;
            } else if (ctx.answer_list().correct_answer().size() == nCorrectAnswers) {
                studentGrade = grade;
            } else {
                studentGrade = grade * ((float) nCorrectAnswers / ctx.answer_list().correct_answer().size());
            }

            if (answersList.isEmpty()) auxFeedbackList.add("You didn't answer the question!");
            else {
                for (String answer : answersList) {
                    for (ExamGrammarParser.Wrong_answerContext wrongAnswer : ctx.answer_list().wrong_answer()) {
                        if (wrongAnswer.SENTENCE().getText().equalsIgnoreCase(answer)) {
                            ExamGrammarParser.FeedbackContext feedback = wrongAnswer.feedback();
                            saveFeedback(feedback);
                        }
                    }
                    for (ExamGrammarParser.Correct_answerContext correctAnswer : ctx.answer_list().correct_answer()) {
                        if (correctAnswer.SENTENCE().getText().equalsIgnoreCase(answer)) {
                            ExamGrammarParser.FeedbackContext feedback = correctAnswer.feedback();
                            saveFeedback(feedback);
                        }
                    }
                }
            }
        }
        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        studentAnswersList.add(answersList);
        correctAnswersList.add(correctAnswers);
    }

    @Override
    public void enterOpen_question(ExamGrammarParser.Open_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        float studentGrade = 0;

        List<ExamGrammarParser.Open_questions_answerContext> correctAnswers = ctx.open_questions_answer_list().open_questions_answer();
        auxFeedbackList = new ArrayList<>();
        List<String> auxCorrectAnswers = new ArrayList<>();

        boolean flag;
        String answer;
        do {
            answer = Console.readLine("Please write your answer");
            flag = validateAnswer(answer);
        } while (!flag);

        if (answer.isEmpty()) {
            answer = "No answer";
            auxFeedbackList.add("You didn't answer the question!");
        } else {
            for (ExamGrammarParser.Open_questions_answerContext correctAnswer : correctAnswers) {
                int gradePercentage = Integer.parseInt(correctAnswer.INT().getText());

                if (gradePercentage == 100) {
                    auxCorrectAnswers.add(correctAnswer.SENTENCE().getText().trim());
                }

                if (correctAnswer.SENTENCE().getText().trim().equalsIgnoreCase(answer)) {
                    studentGrade = (float) gradePercentage / 100 * grade;

                    ExamGrammarParser.FeedbackContext feedback = correctAnswer.feedback();
                    saveFeedback(feedback);
                }
            }
        }

        if (auxFeedbackList.isEmpty()) auxFeedbackList.add("Your answer has no feedback!");

        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        correctAnswersList.add(auxCorrectAnswers);
        studentAnswersList.add(Arrays.asList(answer.trim()));
    }

    @Override
    public void enterMissing_words_question(ExamGrammarParser.Missing_words_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        float studentGrade;
        List<String> allCorrectAnswers = new ArrayList<>();
        List<String> allStudentAnswers = new ArrayList<>();
        auxFeedbackList = new ArrayList<>();
        String selectedAnswer;
        boolean flag;

        for (int i = 0; i < ctx.subquestion().size(); i++) {
            System.out.println(ctx.subquestion(i).getText());
            Set<String> answersList = new HashSet<>();
            ExamGrammarParser.Answer_listContext allAnswers = ctx.answer_list(i);

            for (ExamGrammarParser.Correct_answerContext correctAnswer : allAnswers.correct_answer()) {
                answersList.add(correctAnswer.SENTENCE().getText());
                allCorrectAnswers.add(correctAnswer.SENTENCE().getText());
            }
            for (ExamGrammarParser.Wrong_answerContext wrongAnswer : allAnswers.wrong_answer()) {
                answersList.add(wrongAnswer.SENTENCE().getText());
            }
            do {
                selectedAnswer = controller.showOptions("Options:", answersList);
                flag = validateAnswer(selectedAnswer);
            } while (!flag);
            allStudentAnswers.add(selectedAnswer);
        }

        int nCorrectAnswers = 0;
        for (int i = 0; i < allCorrectAnswers.size(); i++) {
            if (allCorrectAnswers.get(i).equals(allStudentAnswers.get(i))) nCorrectAnswers++;
        }

        if (nCorrectAnswers == 0) studentGrade = 0;
        else studentGrade = ((float) nCorrectAnswers / allCorrectAnswers.size()) * grade;

        for (int i = 0; i < ctx.answer_list().size(); i++) {
            String answer = allStudentAnswers.get(i);
            for (ExamGrammarParser.Wrong_answerContext wrongAnswer : ctx.answer_list().get(i).wrong_answer()) {
                if (wrongAnswer.SENTENCE().getText().equalsIgnoreCase(answer)) {
                    ExamGrammarParser.FeedbackContext feedback = wrongAnswer.feedback();
                    saveFeedback(feedback);
                }
            }
            for (ExamGrammarParser.Correct_answerContext correctAnswer : ctx.answer_list().get(i).correct_answer()) {
                if (correctAnswer.SENTENCE().getText().equalsIgnoreCase(answer)) {
                    ExamGrammarParser.FeedbackContext feedback = correctAnswer.feedback();
                    saveFeedback(feedback);
                }
            }
        }

        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        correctAnswersList.add(allCorrectAnswers);
        studentAnswersList.add(allStudentAnswers);
    }

    @Override
    public void enterTrue_false_question(ExamGrammarParser.True_false_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        List<String> allCorrectAnswers = new ArrayList<>();
        List<String> allStudentAnswers = new ArrayList<>();
        String selectedAnswer;
        boolean flag;

        for (int i = 0; i < ctx.subquestion().size(); i++) {
            allCorrectAnswers.add(ctx.true_false_answer(i).true_false().getText().replaceAll("[;=]", "").trim());
            System.out.println(ctx.subquestion(i).getText());
            do {
                selectedAnswer = controller.showOptions("Options:", new ArrayList<>(Arrays.asList("true", "false")));
                flag = validateAnswer(selectedAnswer);
            } while (!flag);
            allStudentAnswers.add(selectedAnswer);
        }

        int nCorrectAnswers = 0;
        for (int i = 0; i < allCorrectAnswers.size(); i++) {
            if (allCorrectAnswers.get(i).equalsIgnoreCase("t") || allCorrectAnswers.get(i).equalsIgnoreCase("true")) {
                String correctAnswer = "true";
                if (correctAnswer.equalsIgnoreCase(allStudentAnswers.get(i))) {
                    nCorrectAnswers++;
                }
            } else if (allCorrectAnswers.get(i).equalsIgnoreCase("f") || allCorrectAnswers.get(i).equalsIgnoreCase("false")) {
                String correctAnswer = "false";
                if (correctAnswer.equalsIgnoreCase(allStudentAnswers.get(i))) {
                    nCorrectAnswers++;
                }
            }
        }

        auxFeedbackList = new ArrayList<>();
        for (ExamGrammarParser.True_false_answerContext answer : ctx.true_false_answer()) {
            ExamGrammarParser.FeedbackContext feedback = answer.feedback();
            saveFeedback(feedback);
        }
        float studentGrade = ((float) nCorrectAnswers / allCorrectAnswers.size()) * grade;

        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        correctAnswersList.add(allCorrectAnswers);
        studentAnswersList.add(allStudentAnswers);
    }

    @Override
    public void enterMatching_question(ExamGrammarParser.Matching_questionContext ctx) {
        System.out.println(ctx.question_header().getChild(0).getText());
        int grade = Integer.parseInt(ctx.question_grade().getChild(1).getText());
        float studentGrade;
        Map<String, String> correctAnswers = new HashMap<>();
        Map<String, String> studentAnswers = new HashMap<>();
        List<String> allCorrectAnswers = new ArrayList<>();
        List<String> allStudentAnswers = new ArrayList<>();
        List<String> leftOptions = new ArrayList<>();
        List<String> rightOptions = new ArrayList<>();


        for (int i = 0; i < ctx.matching_answers().SENTENCE().size(); i += 2) {
            correctAnswers.put(ctx.matching_answers().SENTENCE(i).getText(), ctx.matching_answers().SENTENCE(i + 1).getText());
            leftOptions.add(ctx.matching_answers().SENTENCE(i).getText());
            rightOptions.add(ctx.matching_answers().SENTENCE(i + 1).getText());
        }

        Collections.shuffle(leftOptions);
        Collections.shuffle(rightOptions);

        System.out.println("Please match the following sentences");
        for (int i = 0; i < leftOptions.size(); i++) {
            System.out.printf("%-50s%-50s\n", leftOptions.get(i), rightOptions.get(i));
        }

        boolean flag;
        String selectedLeftAnswer, selectedRightAnswer;
        do {
            do {
                selectedLeftAnswer = controller.showOptions("Left Options:", leftOptions);
                selectedRightAnswer = controller.showOptions("Right Options:", rightOptions);
                flag = validateMatchingAnswer(selectedLeftAnswer, selectedRightAnswer);
            } while (!flag);

            if (selectedLeftAnswer != null && selectedRightAnswer != null) {
                leftOptions.remove(selectedLeftAnswer);
                rightOptions.remove(selectedRightAnswer);
                studentAnswers.put(selectedLeftAnswer, selectedRightAnswer);
            } else break;
        } while (leftOptions.size() > 0);

        for (Map.Entry<String, String> entry : correctAnswers.entrySet()) {
            allCorrectAnswers.add(String.format("%s -> %s", entry.getKey(), entry.getValue()));
        }

        if (selectedLeftAnswer == null || selectedRightAnswer == null) {
            studentGrade = 0;
            allStudentAnswers.add("No answer");
            auxFeedbackList.add("You didn't answer the question!");
        } else {
            int nCorrentAnswers = 0;
            for (Map.Entry<String, String> studentMapEntry : studentAnswers.entrySet()) {
                allStudentAnswers.add(String.format("%s -> %s", studentMapEntry.getKey(), studentMapEntry.getValue()));
                for (Map.Entry<String, String> entry : correctAnswers.entrySet()) {
                    if (studentMapEntry.getKey().equals(entry.getKey()) && studentMapEntry.getValue().equals(entry.getValue()))
                        nCorrentAnswers++;
                }
            }
            studentGrade = ((float) nCorrentAnswers / correctAnswers.size()) * grade;

            auxFeedbackList = new ArrayList<>();
            List<ExamGrammarParser.FeedbackContext> allFeedbackList = ctx.matching_answers().feedback();
            if (feedbackList != null) {
                for (ExamGrammarParser.FeedbackContext feedback : allFeedbackList) {
                    saveFeedback(feedback);
                }
            }
        }

        if (auxFeedbackList.isEmpty()) auxFeedbackList.add("No feedback by the teacher!");
        studentGrades.add(studentGrade);
        gradesList.add(grade);
        feedbackList.add(auxFeedbackList);
        correctAnswersList.add(allCorrectAnswers);
        studentAnswersList.add(allStudentAnswers);
    }

    private boolean validateAnswer(String answer) {
        return controller.validateAnswer(answer);
    }

    private boolean validateAnswerList(List<String> answerList) {
        return controller.validateAnswerList(answerList);
    }

    private boolean validateMatchingAnswer(String leftAnswer, String rightAnswer) {
        return controller.validateMatchingAnswer(leftAnswer, rightAnswer);
    }

    private void saveFeedback(ExamGrammarParser.FeedbackContext feedback) {
        StringBuilder fullFeedback = new StringBuilder();
        if (feedback != null) {
            List<TerminalNode> questionFeedback = feedback.SENTENCE();
            if (!questionFeedback.isEmpty()) {
                for (int j = 0; j < questionFeedback.size(); j++) {
                    if (j == 0) fullFeedback.append(questionFeedback.get(j).getText());
                    else fullFeedback.append(" ").append(questionFeedback.get(j).getText());
                }
                auxFeedbackList.add(fullFeedback.toString().trim());
            }
        } else auxFeedbackList.add("No inserted feedback");
    }

}
