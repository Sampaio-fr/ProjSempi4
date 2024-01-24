package eapli.base.exam.application;

import eapli.base.exam.grammar.ExamGrammarBaseListener;
import eapli.base.exam.grammar.ExamGrammarParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class ExamValidationListener extends ExamGrammarBaseListener {
    @Override
    public void enterMultiple_choice_question(ExamGrammarParser.Multiple_choice_questionContext ctx) {
        ExamGrammarParser.Answer_listContext answerListContext = ctx.answer_list();
        Token token = ctx.getStart();
        int lineNumber = token.getLine();

        List<ExamGrammarParser.Correct_answerContext> correctAnswerList = answerListContext.correct_answer();
        List<ExamGrammarParser.Wrong_answerContext> wrongAnswerList = answerListContext.wrong_answer();

        if (correctAnswerList.size() < 1) {
            throw new RuntimeException(String.format("The multiple choice question on line %d must have at least one correct answer", lineNumber));
        } else if (wrongAnswerList.size() < 1) {
            throw new RuntimeException(String.format("The multiple choice question on line %d must have at least one wrong answer", lineNumber));
        }
    }

    @Override
    public void enterOpen_question(ExamGrammarParser.Open_questionContext ctx) {
        ExamGrammarParser.Open_questions_answer_listContext answerList = ctx.open_questions_answer_list();
        int fullScoreAnswer = 0;
        Token token = ctx.getStart();
        int lineNumber = token.getLine();

        for (ParseTree child : answerList.open_questions_answer()) {
            int score = Integer.parseInt(child.getChild(2).getText());
            if (score == 100) {
                fullScoreAnswer++;
            }
        }

        if (fullScoreAnswer < 1) {
            throw new RuntimeException(String.format("The open question on line %d must have at least one answer scored to 100", lineNumber));
        }
    }

    @Override
    public void enterMissing_words_question(ExamGrammarParser.Missing_words_questionContext ctx) {
        List<ExamGrammarParser.Answer_listContext> answerListContextList = ctx.answer_list();
        Token token = ctx.getStart();
        int lineNumber = token.getLine();

        for (ExamGrammarParser.Answer_listContext answerListContext : answerListContextList) {

            List<ExamGrammarParser.Correct_answerContext> correctAnswerList = answerListContext.correct_answer();
            List<ExamGrammarParser.Wrong_answerContext> wrongAnswerList = answerListContext.wrong_answer();

            if (correctAnswerList.size() < 1) {
                throw new RuntimeException(String.format("The missing words question on line %d must have at least one correct answer", lineNumber));
            } else if (correctAnswerList.size() > 1) {
                throw new RuntimeException(String.format("The missing words question on line %d can only have one correct answer", lineNumber));
            } else if (wrongAnswerList.size() < 1) {
                throw new RuntimeException(String.format("The missing words question on line %d must have at least one wrong answer", lineNumber));
            }
        }
    }
}
