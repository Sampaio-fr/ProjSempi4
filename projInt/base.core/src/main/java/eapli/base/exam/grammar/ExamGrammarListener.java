// Generated from ExamGrammar.g4 by ANTLR 4.12.0
package eapli.base.exam.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExamGrammarParser}.
 */
public interface ExamGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExamGrammarParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExamGrammarParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#exam}.
	 * @param ctx the parse tree
	 */
	void enterExam(ExamGrammarParser.ExamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#exam}.
	 * @param ctx the parse tree
	 */
	void exitExam(ExamGrammarParser.ExamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#exam_header}.
	 * @param ctx the parse tree
	 */
	void enterExam_header(ExamGrammarParser.Exam_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#exam_header}.
	 * @param ctx the parse tree
	 */
	void exitExam_header(ExamGrammarParser.Exam_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void enterTitle(ExamGrammarParser.TitleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#title}.
	 * @param ctx the parse tree
	 */
	void exitTitle(ExamGrammarParser.TitleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(ExamGrammarParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(ExamGrammarParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(ExamGrammarParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(ExamGrammarParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#section_header}.
	 * @param ctx the parse tree
	 */
	void enterSection_header(ExamGrammarParser.Section_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#section_header}.
	 * @param ctx the parse tree
	 */
	void exitSection_header(ExamGrammarParser.Section_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(ExamGrammarParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(ExamGrammarParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#question_header}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_header(ExamGrammarParser.Question_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#question_header}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_header(ExamGrammarParser.Question_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#question_grade}.
	 * @param ctx the parse tree
	 */
	void enterQuestion_grade(ExamGrammarParser.Question_gradeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#question_grade}.
	 * @param ctx the parse tree
	 */
	void exitQuestion_grade(ExamGrammarParser.Question_gradeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#matching_question}.
	 * @param ctx the parse tree
	 */
	void enterMatching_question(ExamGrammarParser.Matching_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#matching_question}.
	 * @param ctx the parse tree
	 */
	void exitMatching_question(ExamGrammarParser.Matching_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_question(ExamGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#multiple_choice_question}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_question(ExamGrammarParser.Multiple_choice_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#open_question}.
	 * @param ctx the parse tree
	 */
	void enterOpen_question(ExamGrammarParser.Open_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#open_question}.
	 * @param ctx the parse tree
	 */
	void exitOpen_question(ExamGrammarParser.Open_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#missing_words_question}.
	 * @param ctx the parse tree
	 */
	void enterMissing_words_question(ExamGrammarParser.Missing_words_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#missing_words_question}.
	 * @param ctx the parse tree
	 */
	void exitMissing_words_question(ExamGrammarParser.Missing_words_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_question(ExamGrammarParser.True_false_questionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#true_false_question}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_question(ExamGrammarParser.True_false_questionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#matching_question_definition}.
	 * @param ctx the parse tree
	 */
	void enterMatching_question_definition(ExamGrammarParser.Matching_question_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#matching_question_definition}.
	 * @param ctx the parse tree
	 */
	void exitMatching_question_definition(ExamGrammarParser.Matching_question_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#multiple_choice_definition}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_definition(ExamGrammarParser.Multiple_choice_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#multiple_choice_definition}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_definition(ExamGrammarParser.Multiple_choice_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#open_questions_definition}.
	 * @param ctx the parse tree
	 */
	void enterOpen_questions_definition(ExamGrammarParser.Open_questions_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#open_questions_definition}.
	 * @param ctx the parse tree
	 */
	void exitOpen_questions_definition(ExamGrammarParser.Open_questions_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#missing_words_definition}.
	 * @param ctx the parse tree
	 */
	void enterMissing_words_definition(ExamGrammarParser.Missing_words_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#missing_words_definition}.
	 * @param ctx the parse tree
	 */
	void exitMissing_words_definition(ExamGrammarParser.Missing_words_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#true_false_definition}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_definition(ExamGrammarParser.True_false_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#true_false_definition}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_definition(ExamGrammarParser.True_false_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#subquestion}.
	 * @param ctx the parse tree
	 */
	void enterSubquestion(ExamGrammarParser.SubquestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#subquestion}.
	 * @param ctx the parse tree
	 */
	void exitSubquestion(ExamGrammarParser.SubquestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#wrong_answer}.
	 * @param ctx the parse tree
	 */
	void enterWrong_answer(ExamGrammarParser.Wrong_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#wrong_answer}.
	 * @param ctx the parse tree
	 */
	void exitWrong_answer(ExamGrammarParser.Wrong_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#correct_answer}.
	 * @param ctx the parse tree
	 */
	void enterCorrect_answer(ExamGrammarParser.Correct_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#correct_answer}.
	 * @param ctx the parse tree
	 */
	void exitCorrect_answer(ExamGrammarParser.Correct_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#answer_list}.
	 * @param ctx the parse tree
	 */
	void enterAnswer_list(ExamGrammarParser.Answer_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#answer_list}.
	 * @param ctx the parse tree
	 */
	void exitAnswer_list(ExamGrammarParser.Answer_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#open_questions_answer}.
	 * @param ctx the parse tree
	 */
	void enterOpen_questions_answer(ExamGrammarParser.Open_questions_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#open_questions_answer}.
	 * @param ctx the parse tree
	 */
	void exitOpen_questions_answer(ExamGrammarParser.Open_questions_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#open_questions_answer_list}.
	 * @param ctx the parse tree
	 */
	void enterOpen_questions_answer_list(ExamGrammarParser.Open_questions_answer_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#open_questions_answer_list}.
	 * @param ctx the parse tree
	 */
	void exitOpen_questions_answer_list(ExamGrammarParser.Open_questions_answer_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#matching_answers}.
	 * @param ctx the parse tree
	 */
	void enterMatching_answers(ExamGrammarParser.Matching_answersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#matching_answers}.
	 * @param ctx the parse tree
	 */
	void exitMatching_answers(ExamGrammarParser.Matching_answersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_answer(ExamGrammarParser.True_false_answerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#true_false_answer}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_answer(ExamGrammarParser.True_false_answerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#true_false}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false(ExamGrammarParser.True_falseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#true_false}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false(ExamGrammarParser.True_falseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void enterFeedback(ExamGrammarParser.FeedbackContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamGrammarParser#feedback}.
	 * @param ctx the parse tree
	 */
	void exitFeedback(ExamGrammarParser.FeedbackContext ctx);
}