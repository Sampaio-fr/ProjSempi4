// Generated from FormativeExamGrammar.g4 by ANTLR 4.12.0
package eapli.base.examformative.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FormativeExamGrammarParser}.
 */
public interface FormativeExamGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(FormativeExamGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(FormativeExamGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#exam}.
	 * @param ctx the parse tree
	 */
	void enterExam(FormativeExamGrammarParser.ExamContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#exam}.
	 * @param ctx the parse tree
	 */
	void exitExam(FormativeExamGrammarParser.ExamContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#exam_header}.
	 * @param ctx the parse tree
	 */
	void enterExam_header(FormativeExamGrammarParser.Exam_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#exam_header}.
	 * @param ctx the parse tree
	 */
	void exitExam_header(FormativeExamGrammarParser.Exam_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(FormativeExamGrammarParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(FormativeExamGrammarParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(FormativeExamGrammarParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(FormativeExamGrammarParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(FormativeExamGrammarParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(FormativeExamGrammarParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#section_header}.
	 * @param ctx the parse tree
	 */
	void enterSection_header(FormativeExamGrammarParser.Section_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#section_header}.
	 * @param ctx the parse tree
	 */
	void exitSection_header(FormativeExamGrammarParser.Section_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#question_header}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_header(FormativeExamGrammarParser.Question_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#question_header}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_header(FormativeExamGrammarParser.Question_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#question_grade}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_grade(FormativeExamGrammarParser.Question_gradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#question_grade}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_grade(FormativeExamGrammarParser.Question_gradeContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#matching_question}.
	 * @param ctx the parse tree
	 */
	void enterMatching_question(FormativeExamGrammarParser.Matching_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#matching_question}.
	 * @param ctx the parse tree
	 */
	void exitMatching_question(FormativeExamGrammarParser.Matching_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_question(FormativeExamGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_question(FormativeExamGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#open_question}.
	 * @param ctx the parse tree
	 */
	void enterOpen_question(FormativeExamGrammarParser.Open_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#open_question}.
	 * @param ctx the parse tree
	 */
	void exitOpen_question(FormativeExamGrammarParser.Open_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#missing_words_question}.
	 * @param ctx the parse tree
	 */
	void enterMissing_words_question(FormativeExamGrammarParser.Missing_words_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#missing_words_question}.
	 * @param ctx the parse tree
	 */
	void exitMissing_words_question(FormativeExamGrammarParser.Missing_words_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_question(FormativeExamGrammarParser.True_false_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_question(FormativeExamGrammarParser.True_false_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#matching_question_definition}.
	 * @param ctx the parse tree
	 */
	void enterMatching_question_definition(FormativeExamGrammarParser.Matching_question_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#matching_question_definition}.
	 * @param ctx the parse tree
	 */
	void exitMatching_question_definition(FormativeExamGrammarParser.Matching_question_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_definition}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_definition(FormativeExamGrammarParser.Multiple_choice_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#multiple_choice_definition}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_definition(FormativeExamGrammarParser.Multiple_choice_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#open_questions_definition}.
	 * @param ctx the parse tree
	 */
	void enterOpen_questions_definition(FormativeExamGrammarParser.Open_questions_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#open_questions_definition}.
	 * @param ctx the parse tree
	 */
	void exitOpen_questions_definition(FormativeExamGrammarParser.Open_questions_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#missing_words_definition}.
	 * @param ctx the parse tree
	 */
	void enterMissing_words_definition(FormativeExamGrammarParser.Missing_words_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#missing_words_definition}.
	 * @param ctx the parse tree
	 */
	void exitMissing_words_definition(FormativeExamGrammarParser.Missing_words_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#true_false_definition}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_definition(FormativeExamGrammarParser.True_false_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#true_false_definition}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_definition(FormativeExamGrammarParser.True_false_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#subquestion}.
	 * @param ctx the parse tree
	 */
	void enterSubquestion(FormativeExamGrammarParser.SubquestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#subquestion}.
	 * @param ctx the parse tree
	 */
	void exitSubquestion(FormativeExamGrammarParser.SubquestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#wrong_answer}.
	 * @param ctx the parse tree
	 */
	void enterWrong_answer(FormativeExamGrammarParser.Wrong_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#wrong_answer}.
	 * @param ctx the parse tree
	 */
	void exitWrong_answer(FormativeExamGrammarParser.Wrong_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#correct_answer}.
	 * @param ctx the parse tree
	 */
	void enterCorrect_answer(FormativeExamGrammarParser.Correct_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#correct_answer}.
	 * @param ctx the parse tree
	 */
	void exitCorrect_answer(FormativeExamGrammarParser.Correct_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#answer_list}.
	 * @param ctx the parse tree
	 */
	void enterAnswer_list(FormativeExamGrammarParser.Answer_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#answer_list}.
	 * @param ctx the parse tree
	 */
	void exitAnswer_list(FormativeExamGrammarParser.Answer_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#open_questions_answer}.
	 * @param ctx the parse tree
	 */
	void enterOpen_questions_answer(FormativeExamGrammarParser.Open_questions_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#open_questions_answer}.
	 * @param ctx the parse tree
	 */
	void exitOpen_questions_answer(FormativeExamGrammarParser.Open_questions_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#open_questions_answer_list}.
	 * @param ctx the parse tree
	 */
	void enterOpen_questions_answer_list(FormativeExamGrammarParser.Open_questions_answer_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#open_questions_answer_list}.
	 * @param ctx the parse tree
	 */
	void exitOpen_questions_answer_list(FormativeExamGrammarParser.Open_questions_answer_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#matching_answers}.
	 * @param ctx the parse tree
	 */
	void enterMatching_answers(FormativeExamGrammarParser.Matching_answersContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#matching_answers}.
	 * @param ctx the parse tree
	 */
	void exitMatching_answers(FormativeExamGrammarParser.Matching_answersContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_answer(FormativeExamGrammarParser.True_false_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_answer(FormativeExamGrammarParser.True_false_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#true_false}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false(FormativeExamGrammarParser.True_falseContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#true_false}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false(FormativeExamGrammarParser.True_falseContext ctx);
	/**
	 * Enter a parse tree produced by {@link FormativeExamGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void enterFeedback(FormativeExamGrammarParser.FeedbackContext ctx);
	/**
	 * Exit a parse tree produced by {@link FormativeExamGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void exitFeedback(FormativeExamGrammarParser.FeedbackContext ctx);
}