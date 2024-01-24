// Generated from QuestionGrammar.g4 by ANTLR 4.12.0
package eapli.base.question.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QuestionGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QuestionGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(QuestionGrammarParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QuestionGrammarParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#question_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_header(QuestionGrammarParser.Question_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#question_grade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_grade(QuestionGrammarParser.Question_gradeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#matching_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_question(QuestionGrammarParser.Matching_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_question(QuestionGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#open_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen_question(QuestionGrammarParser.Open_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#missing_words_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_words_question(QuestionGrammarParser.Missing_words_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_question(QuestionGrammarParser.True_false_questionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#matching_question_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_question_definition(QuestionGrammarParser.Matching_question_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#multiple_choice_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_definition(QuestionGrammarParser.Multiple_choice_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#open_questions_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen_questions_definition(QuestionGrammarParser.Open_questions_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#missing_words_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMissing_words_definition(QuestionGrammarParser.Missing_words_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#true_false_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_definition(QuestionGrammarParser.True_false_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#subquestion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubquestion(QuestionGrammarParser.SubquestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#wrong_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrong_answer(QuestionGrammarParser.Wrong_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#correct_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorrect_answer(QuestionGrammarParser.Correct_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#answer_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer_list(QuestionGrammarParser.Answer_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#open_questions_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen_questions_answer(QuestionGrammarParser.Open_questions_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#open_questions_answer_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpen_questions_answer_list(QuestionGrammarParser.Open_questions_answer_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#matching_answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_answers(QuestionGrammarParser.Matching_answersContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_answer(QuestionGrammarParser.True_false_answerContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#true_false}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false(QuestionGrammarParser.True_falseContext ctx);
	/**
	 * Visit a parse tree produced by {@link QuestionGrammarParser#feedback}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeedback(QuestionGrammarParser.FeedbackContext ctx);
}