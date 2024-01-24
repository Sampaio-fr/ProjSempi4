// Generated from QuestionGrammar.g4 by ANTLR 4.12.0
package eapli.base.question.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QuestionGrammarParser}.
 */
public interface QuestionGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(QuestionGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(QuestionGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QuestionGrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QuestionGrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#question_header}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_header(QuestionGrammarParser.Question_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#question_header}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_header(QuestionGrammarParser.Question_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#question_grade}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_grade(QuestionGrammarParser.Question_gradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#question_grade}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_grade(QuestionGrammarParser.Question_gradeContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#matching_question}.
	 * @param ctx the parse tree
	 */
	void enterMatching_question(QuestionGrammarParser.Matching_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#matching_question}.
	 * @param ctx the parse tree
	 */
	void exitMatching_question(QuestionGrammarParser.Matching_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_question(QuestionGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_question(QuestionGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#open_question}.
	 * @param ctx the parse tree
	 */
	void enterOpen_question(QuestionGrammarParser.Open_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#open_question}.
	 * @param ctx the parse tree
	 */
	void exitOpen_question(QuestionGrammarParser.Open_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#missing_words_question}.
	 * @param ctx the parse tree
	 */
	void enterMissing_words_question(QuestionGrammarParser.Missing_words_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#missing_words_question}.
	 * @param ctx the parse tree
	 */
	void exitMissing_words_question(QuestionGrammarParser.Missing_words_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_question(QuestionGrammarParser.True_false_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_question(QuestionGrammarParser.True_false_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#matching_question_definition}.
	 * @param ctx the parse tree
	 */
	void enterMatching_question_definition(QuestionGrammarParser.Matching_question_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#matching_question_definition}.
	 * @param ctx the parse tree
	 */
	void exitMatching_question_definition(QuestionGrammarParser.Matching_question_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#multiple_choice_definition}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_definition(QuestionGrammarParser.Multiple_choice_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_definition}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_definition(QuestionGrammarParser.Multiple_choice_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#open_questions_definition}.
	 * @param ctx the parse tree
	 */
	void enterOpen_questions_definition(QuestionGrammarParser.Open_questions_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#open_questions_definition}.
	 * @param ctx the parse tree
	 */
	void exitOpen_questions_definition(QuestionGrammarParser.Open_questions_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#missing_words_definition}.
	 * @param ctx the parse tree
	 */
	void enterMissing_words_definition(QuestionGrammarParser.Missing_words_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#missing_words_definition}.
	 * @param ctx the parse tree
	 */
	void exitMissing_words_definition(QuestionGrammarParser.Missing_words_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#true_false_definition}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_definition(QuestionGrammarParser.True_false_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#true_false_definition}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_definition(QuestionGrammarParser.True_false_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#subquestion}.
	 * @param ctx the parse tree
	 */
	void enterSubquestion(QuestionGrammarParser.SubquestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#subquestion}.
	 * @param ctx the parse tree
	 */
	void exitSubquestion(QuestionGrammarParser.SubquestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#wrong_answer}.
	 * @param ctx the parse tree
	 */
	void enterWrong_answer(QuestionGrammarParser.Wrong_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#wrong_answer}.
	 * @param ctx the parse tree
	 */
	void exitWrong_answer(QuestionGrammarParser.Wrong_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#correct_answer}.
	 * @param ctx the parse tree
	 */
	void enterCorrect_answer(QuestionGrammarParser.Correct_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#correct_answer}.
	 * @param ctx the parse tree
	 */
	void exitCorrect_answer(QuestionGrammarParser.Correct_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#answer_list}.
	 * @param ctx the parse tree
	 */
	void enterAnswer_list(QuestionGrammarParser.Answer_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#answer_list}.
	 * @param ctx the parse tree
	 */
	void exitAnswer_list(QuestionGrammarParser.Answer_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#open_questions_answer}.
	 * @param ctx the parse tree
	 */
	void enterOpen_questions_answer(QuestionGrammarParser.Open_questions_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#open_questions_answer}.
	 * @param ctx the parse tree
	 */
	void exitOpen_questions_answer(QuestionGrammarParser.Open_questions_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#open_questions_answer_list}.
	 * @param ctx the parse tree
	 */
	void enterOpen_questions_answer_list(QuestionGrammarParser.Open_questions_answer_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#open_questions_answer_list}.
	 * @param ctx the parse tree
	 */
	void exitOpen_questions_answer_list(QuestionGrammarParser.Open_questions_answer_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#matching_answers}.
	 * @param ctx the parse tree
	 */
	void enterMatching_answers(QuestionGrammarParser.Matching_answersContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#matching_answers}.
	 * @param ctx the parse tree
	 */
	void exitMatching_answers(QuestionGrammarParser.Matching_answersContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_answer(QuestionGrammarParser.True_false_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_answer(QuestionGrammarParser.True_false_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#true_false}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false(QuestionGrammarParser.True_falseContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#true_false}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false(QuestionGrammarParser.True_falseContext ctx);
	/**
	 * Enter a parse tree produced by {@link QuestionGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void enterFeedback(QuestionGrammarParser.FeedbackContext ctx);
	/**
	 * Exit a parse tree produced by {@link QuestionGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void exitFeedback(QuestionGrammarParser.FeedbackContext ctx);
}