// Generated from QuestionGrammar.g4 by ANTLR 4.12.0
package eapli.base.question.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class QuestionGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, QUESTION_DEFINITION_SYMBOL=11, PERCENTAGE=12, OPEN_BRACKET=13, 
		CLOSING_BRACKET=14, ANSWER_SPACING=15, CORRECT_ANSWER_SYMBOL=16, WRONG_ANSWER_SYMBOL=17, 
		FEEDBACK_SYMBOL=18, END_SYMBOL=19, INT=20, PUNCTUATION=21, OPERATIONS=22, 
		SENTENCE=23, WORD=24, WHITESPACE=25, NEWLINE=26;
	public static final int
		RULE_start = 0, RULE_question = 1, RULE_question_header = 2, RULE_question_grade = 3, 
		RULE_matching_question = 4, RULE_multiple_choice_question = 5, RULE_open_question = 6, 
		RULE_missing_words_question = 7, RULE_true_false_question = 8, RULE_matching_question_definition = 9, 
		RULE_multiple_choice_definition = 10, RULE_open_questions_definition = 11, 
		RULE_missing_words_definition = 12, RULE_true_false_definition = 13, RULE_subquestion = 14, 
		RULE_wrong_answer = 15, RULE_correct_answer = 16, RULE_answer_list = 17, 
		RULE_open_questions_answer = 18, RULE_open_questions_answer_list = 19, 
		RULE_matching_answers = 20, RULE_true_false_answer = 21, RULE_true_false = 22, 
		RULE_feedback = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "question", "question_header", "question_grade", "matching_question", 
			"multiple_choice_question", "open_question", "missing_words_question", 
			"true_false_question", "matching_question_definition", "multiple_choice_definition", 
			"open_questions_definition", "missing_words_definition", "true_false_definition", 
			"subquestion", "wrong_answer", "correct_answer", "answer_list", "open_questions_answer", 
			"open_questions_answer_list", "matching_answers", "true_false_answer", 
			"true_false", "feedback"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'matching'", "'multiple choice'", "'short'", "'numerical'", "'missing words'", 
			"'true/false'", "'T'", "'F'", "'TRUE'", "'FALSE'", null, null, null, 
			"'}'", "'___'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "QUESTION_DEFINITION_SYMBOL", 
			"PERCENTAGE", "OPEN_BRACKET", "CLOSING_BRACKET", "ANSWER_SPACING", "CORRECT_ANSWER_SYMBOL", 
			"WRONG_ANSWER_SYMBOL", "FEEDBACK_SYMBOL", "END_SYMBOL", "INT", "PUNCTUATION", 
			"OPERATIONS", "SENTENCE", "WORD", "WHITESPACE", "NEWLINE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "QuestionGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QuestionGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QuestionGrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			question();
			setState(49);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestionContext extends ParserRuleContext {
		public Matching_questionContext matching_question() {
			return getRuleContext(Matching_questionContext.class,0);
		}
		public Multiple_choice_questionContext multiple_choice_question() {
			return getRuleContext(Multiple_choice_questionContext.class,0);
		}
		public Open_questionContext open_question() {
			return getRuleContext(Open_questionContext.class,0);
		}
		public Missing_words_questionContext missing_words_question() {
			return getRuleContext(Missing_words_questionContext.class,0);
		}
		public True_false_questionContext true_false_question() {
			return getRuleContext(True_false_questionContext.class,0);
		}
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(51);
				matching_question();
				}
				break;
			case 2:
				{
				setState(52);
				multiple_choice_question();
				}
				break;
			case 3:
				{
				setState(53);
				open_question();
				}
				break;
			case 4:
				{
				setState(54);
				missing_words_question();
				}
				break;
			case 5:
				{
				setState(55);
				true_false_question();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Question_headerContext extends ParserRuleContext {
		public TerminalNode SENTENCE() { return getToken(QuestionGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public Question_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterQuestion_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitQuestion_header(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitQuestion_header(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_headerContext question_header() throws RecognitionException {
		Question_headerContext _localctx = new Question_headerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_question_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(SENTENCE);
			setState(59);
			match(END_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Question_gradeContext extends ParserRuleContext {
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(QuestionGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode INT() { return getToken(QuestionGrammarParser.INT, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public Question_gradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterQuestion_grade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitQuestion_grade(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitQuestion_grade(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Question_gradeContext question_grade() throws RecognitionException {
		Question_gradeContext _localctx = new Question_gradeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question_grade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(62);
			match(INT);
			setState(63);
			match(END_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Matching_questionContext extends ParserRuleContext {
		public Matching_question_definitionContext matching_question_definition() {
			return getRuleContext(Matching_question_definitionContext.class,0);
		}
		public Question_gradeContext question_grade() {
			return getRuleContext(Question_gradeContext.class,0);
		}
		public Question_headerContext question_header() {
			return getRuleContext(Question_headerContext.class,0);
		}
		public Matching_answersContext matching_answers() {
			return getRuleContext(Matching_answersContext.class,0);
		}
		public Matching_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterMatching_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitMatching_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitMatching_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_questionContext matching_question() throws RecognitionException {
		Matching_questionContext _localctx = new Matching_questionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_matching_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			matching_question_definition();
			setState(66);
			question_grade();
			setState(67);
			question_header();
			setState(68);
			matching_answers();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiple_choice_questionContext extends ParserRuleContext {
		public Multiple_choice_definitionContext multiple_choice_definition() {
			return getRuleContext(Multiple_choice_definitionContext.class,0);
		}
		public Question_gradeContext question_grade() {
			return getRuleContext(Question_gradeContext.class,0);
		}
		public Question_headerContext question_header() {
			return getRuleContext(Question_headerContext.class,0);
		}
		public Answer_listContext answer_list() {
			return getRuleContext(Answer_listContext.class,0);
		}
		public Multiple_choice_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterMultiple_choice_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitMultiple_choice_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitMultiple_choice_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_questionContext multiple_choice_question() throws RecognitionException {
		Multiple_choice_questionContext _localctx = new Multiple_choice_questionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multiple_choice_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			multiple_choice_definition();
			setState(71);
			question_grade();
			setState(72);
			question_header();
			setState(73);
			answer_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Open_questionContext extends ParserRuleContext {
		public Open_questions_definitionContext open_questions_definition() {
			return getRuleContext(Open_questions_definitionContext.class,0);
		}
		public Question_gradeContext question_grade() {
			return getRuleContext(Question_gradeContext.class,0);
		}
		public Question_headerContext question_header() {
			return getRuleContext(Question_headerContext.class,0);
		}
		public Open_questions_answer_listContext open_questions_answer_list() {
			return getRuleContext(Open_questions_answer_listContext.class,0);
		}
		public Open_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterOpen_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitOpen_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitOpen_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Open_questionContext open_question() throws RecognitionException {
		Open_questionContext _localctx = new Open_questionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_open_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			open_questions_definition();
			setState(76);
			question_grade();
			setState(77);
			question_header();
			setState(78);
			open_questions_answer_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Missing_words_questionContext extends ParserRuleContext {
		public Missing_words_definitionContext missing_words_definition() {
			return getRuleContext(Missing_words_definitionContext.class,0);
		}
		public Question_gradeContext question_grade() {
			return getRuleContext(Question_gradeContext.class,0);
		}
		public Question_headerContext question_header() {
			return getRuleContext(Question_headerContext.class,0);
		}
		public List<SubquestionContext> subquestion() {
			return getRuleContexts(SubquestionContext.class);
		}
		public SubquestionContext subquestion(int i) {
			return getRuleContext(SubquestionContext.class,i);
		}
		public List<Answer_listContext> answer_list() {
			return getRuleContexts(Answer_listContext.class);
		}
		public Answer_listContext answer_list(int i) {
			return getRuleContext(Answer_listContext.class,i);
		}
		public Missing_words_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_words_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterMissing_words_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitMissing_words_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitMissing_words_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Missing_words_questionContext missing_words_question() throws RecognitionException {
		Missing_words_questionContext _localctx = new Missing_words_questionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_missing_words_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			missing_words_definition();
			setState(81);
			question_grade();
			setState(82);
			question_header();
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				subquestion();
				setState(84);
				answer_list();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class True_false_questionContext extends ParserRuleContext {
		public True_false_definitionContext true_false_definition() {
			return getRuleContext(True_false_definitionContext.class,0);
		}
		public Question_gradeContext question_grade() {
			return getRuleContext(Question_gradeContext.class,0);
		}
		public Question_headerContext question_header() {
			return getRuleContext(Question_headerContext.class,0);
		}
		public List<SubquestionContext> subquestion() {
			return getRuleContexts(SubquestionContext.class);
		}
		public SubquestionContext subquestion(int i) {
			return getRuleContext(SubquestionContext.class,i);
		}
		public List<True_false_answerContext> true_false_answer() {
			return getRuleContexts(True_false_answerContext.class);
		}
		public True_false_answerContext true_false_answer(int i) {
			return getRuleContext(True_false_answerContext.class,i);
		}
		public True_false_questionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterTrue_false_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitTrue_false_question(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitTrue_false_question(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_questionContext true_false_question() throws RecognitionException {
		True_false_questionContext _localctx = new True_false_questionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_true_false_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			true_false_definition();
			setState(91);
			question_grade();
			setState(92);
			question_header();
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				subquestion();
				setState(94);
				true_false_answer();
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Matching_question_definitionContext extends ParserRuleContext {
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(QuestionGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public Matching_question_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_question_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterMatching_question_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitMatching_question_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitMatching_question_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_question_definitionContext matching_question_definition() throws RecognitionException {
		Matching_question_definitionContext _localctx = new Matching_question_definitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_matching_question_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(101);
			match(T__0);
			setState(102);
			match(END_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiple_choice_definitionContext extends ParserRuleContext {
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(QuestionGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public Multiple_choice_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterMultiple_choice_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitMultiple_choice_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitMultiple_choice_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_definitionContext multiple_choice_definition() throws RecognitionException {
		Multiple_choice_definitionContext _localctx = new Multiple_choice_definitionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multiple_choice_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(105);
			match(T__1);
			setState(106);
			match(END_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Open_questions_definitionContext extends ParserRuleContext {
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(QuestionGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public Open_questions_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_questions_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterOpen_questions_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitOpen_questions_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitOpen_questions_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Open_questions_definitionContext open_questions_definition() throws RecognitionException {
		Open_questions_definitionContext _localctx = new Open_questions_definitionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_open_questions_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(109);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(110);
			match(END_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Missing_words_definitionContext extends ParserRuleContext {
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(QuestionGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public Missing_words_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_words_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterMissing_words_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitMissing_words_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitMissing_words_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Missing_words_definitionContext missing_words_definition() throws RecognitionException {
		Missing_words_definitionContext _localctx = new Missing_words_definitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_missing_words_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(113);
			match(T__4);
			setState(114);
			match(END_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class True_false_definitionContext extends ParserRuleContext {
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(QuestionGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public True_false_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterTrue_false_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitTrue_false_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitTrue_false_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_definitionContext true_false_definition() throws RecognitionException {
		True_false_definitionContext _localctx = new True_false_definitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_true_false_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(117);
			match(T__5);
			setState(118);
			match(END_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SubquestionContext extends ParserRuleContext {
		public TerminalNode SENTENCE() { return getToken(QuestionGrammarParser.SENTENCE, 0); }
		public TerminalNode ANSWER_SPACING() { return getToken(QuestionGrammarParser.ANSWER_SPACING, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(QuestionGrammarParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(QuestionGrammarParser.WHITESPACE, i);
		}
		public SubquestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterSubquestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitSubquestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitSubquestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubquestionContext subquestion() throws RecognitionException {
		SubquestionContext _localctx = new SubquestionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_subquestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(SENTENCE);
			setState(121);
			match(ANSWER_SPACING);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(122);
				match(WHITESPACE);
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Wrong_answerContext extends ParserRuleContext {
		public TerminalNode WRONG_ANSWER_SYMBOL() { return getToken(QuestionGrammarParser.WRONG_ANSWER_SYMBOL, 0); }
		public TerminalNode SENTENCE() { return getToken(QuestionGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Wrong_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wrong_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterWrong_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitWrong_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitWrong_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wrong_answerContext wrong_answer() throws RecognitionException {
		Wrong_answerContext _localctx = new Wrong_answerContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_wrong_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(WRONG_ANSWER_SYMBOL);
			setState(129);
			match(SENTENCE);
			setState(130);
			match(END_SYMBOL);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(131);
				feedback();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Correct_answerContext extends ParserRuleContext {
		public TerminalNode CORRECT_ANSWER_SYMBOL() { return getToken(QuestionGrammarParser.CORRECT_ANSWER_SYMBOL, 0); }
		public TerminalNode SENTENCE() { return getToken(QuestionGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Correct_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_correct_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterCorrect_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitCorrect_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitCorrect_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Correct_answerContext correct_answer() throws RecognitionException {
		Correct_answerContext _localctx = new Correct_answerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_correct_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(CORRECT_ANSWER_SYMBOL);
			setState(135);
			match(SENTENCE);
			setState(136);
			match(END_SYMBOL);
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(137);
				feedback();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Answer_listContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(QuestionGrammarParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(QuestionGrammarParser.CLOSING_BRACKET, 0); }
		public List<Wrong_answerContext> wrong_answer() {
			return getRuleContexts(Wrong_answerContext.class);
		}
		public Wrong_answerContext wrong_answer(int i) {
			return getRuleContext(Wrong_answerContext.class,i);
		}
		public List<Correct_answerContext> correct_answer() {
			return getRuleContexts(Correct_answerContext.class);
		}
		public Correct_answerContext correct_answer(int i) {
			return getRuleContext(Correct_answerContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(QuestionGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(QuestionGrammarParser.NEWLINE, i);
		}
		public Answer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterAnswer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitAnswer_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitAnswer_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Answer_listContext answer_list() throws RecognitionException {
		Answer_listContext _localctx = new Answer_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_answer_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(OPEN_BRACKET);
			setState(143); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(143);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case WRONG_ANSWER_SYMBOL:
					{
					setState(141);
					wrong_answer();
					}
					break;
				case CORRECT_ANSWER_SYMBOL:
					{
					setState(142);
					correct_answer();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CORRECT_ANSWER_SYMBOL || _la==WRONG_ANSWER_SYMBOL );
			setState(147);
			match(CLOSING_BRACKET);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(148);
					match(NEWLINE);
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Open_questions_answerContext extends ParserRuleContext {
		public TerminalNode CORRECT_ANSWER_SYMBOL() { return getToken(QuestionGrammarParser.CORRECT_ANSWER_SYMBOL, 0); }
		public List<TerminalNode> PERCENTAGE() { return getTokens(QuestionGrammarParser.PERCENTAGE); }
		public TerminalNode PERCENTAGE(int i) {
			return getToken(QuestionGrammarParser.PERCENTAGE, i);
		}
		public TerminalNode INT() { return getToken(QuestionGrammarParser.INT, 0); }
		public TerminalNode SENTENCE() { return getToken(QuestionGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Open_questions_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_questions_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterOpen_questions_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitOpen_questions_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitOpen_questions_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Open_questions_answerContext open_questions_answer() throws RecognitionException {
		Open_questions_answerContext _localctx = new Open_questions_answerContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_open_questions_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(CORRECT_ANSWER_SYMBOL);
			setState(155);
			match(PERCENTAGE);
			setState(156);
			match(INT);
			setState(157);
			match(PERCENTAGE);
			setState(158);
			match(SENTENCE);
			setState(159);
			match(END_SYMBOL);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(160);
				feedback();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Open_questions_answer_listContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(QuestionGrammarParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(QuestionGrammarParser.CLOSING_BRACKET, 0); }
		public List<Open_questions_answerContext> open_questions_answer() {
			return getRuleContexts(Open_questions_answerContext.class);
		}
		public Open_questions_answerContext open_questions_answer(int i) {
			return getRuleContext(Open_questions_answerContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(QuestionGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(QuestionGrammarParser.NEWLINE, i);
		}
		public Open_questions_answer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_questions_answer_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterOpen_questions_answer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitOpen_questions_answer_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitOpen_questions_answer_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Open_questions_answer_listContext open_questions_answer_list() throws RecognitionException {
		Open_questions_answer_listContext _localctx = new Open_questions_answer_listContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_open_questions_answer_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(OPEN_BRACKET);
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				open_questions_answer();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CORRECT_ANSWER_SYMBOL );
			setState(169);
			match(CLOSING_BRACKET);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(170);
					match(NEWLINE);
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Matching_answersContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(QuestionGrammarParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(QuestionGrammarParser.CLOSING_BRACKET, 0); }
		public List<TerminalNode> SENTENCE() { return getTokens(QuestionGrammarParser.SENTENCE); }
		public TerminalNode SENTENCE(int i) {
			return getToken(QuestionGrammarParser.SENTENCE, i);
		}
		public List<TerminalNode> END_SYMBOL() { return getTokens(QuestionGrammarParser.END_SYMBOL); }
		public TerminalNode END_SYMBOL(int i) {
			return getToken(QuestionGrammarParser.END_SYMBOL, i);
		}
		public List<TerminalNode> CORRECT_ANSWER_SYMBOL() { return getTokens(QuestionGrammarParser.CORRECT_ANSWER_SYMBOL); }
		public TerminalNode CORRECT_ANSWER_SYMBOL(int i) {
			return getToken(QuestionGrammarParser.CORRECT_ANSWER_SYMBOL, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(QuestionGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(QuestionGrammarParser.NEWLINE, i);
		}
		public List<FeedbackContext> feedback() {
			return getRuleContexts(FeedbackContext.class);
		}
		public FeedbackContext feedback(int i) {
			return getRuleContext(FeedbackContext.class,i);
		}
		public Matching_answersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_answers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterMatching_answers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitMatching_answers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitMatching_answers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_answersContext matching_answers() throws RecognitionException {
		Matching_answersContext _localctx = new Matching_answersContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_matching_answers);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(OPEN_BRACKET);
			setState(185); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(177);
				match(SENTENCE);
				setState(178);
				match(END_SYMBOL);
				setState(179);
				match(CORRECT_ANSWER_SYMBOL);
				setState(180);
				match(SENTENCE);
				setState(181);
				match(END_SYMBOL);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FEEDBACK_SYMBOL) {
					{
					setState(182);
					feedback();
					}
				}

				}
				}
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			setState(189);
			match(CLOSING_BRACKET);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(190);
					match(NEWLINE);
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class True_false_answerContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACKET() { return getToken(QuestionGrammarParser.OPEN_BRACKET, 0); }
		public True_falseContext true_false() {
			return getRuleContext(True_falseContext.class,0);
		}
		public TerminalNode CLOSING_BRACKET() { return getToken(QuestionGrammarParser.CLOSING_BRACKET, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(QuestionGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(QuestionGrammarParser.NEWLINE, i);
		}
		public True_false_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterTrue_false_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitTrue_false_answer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitTrue_false_answer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_answerContext true_false_answer() throws RecognitionException {
		True_false_answerContext _localctx = new True_false_answerContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_true_false_answer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(OPEN_BRACKET);
			setState(197);
			true_false();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(198);
				feedback();
				}
			}

			setState(201);
			match(CLOSING_BRACKET);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(202);
					match(NEWLINE);
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class True_falseContext extends ParserRuleContext {
		public TerminalNode CORRECT_ANSWER_SYMBOL() { return getToken(QuestionGrammarParser.CORRECT_ANSWER_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public True_falseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterTrue_false(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitTrue_false(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitTrue_false(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_falseContext true_false() throws RecognitionException {
		True_falseContext _localctx = new True_falseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_true_false);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(CORRECT_ANSWER_SYMBOL);
			setState(209);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(210);
			match(END_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FeedbackContext extends ParserRuleContext {
		public TerminalNode FEEDBACK_SYMBOL() { return getToken(QuestionGrammarParser.FEEDBACK_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(QuestionGrammarParser.END_SYMBOL, 0); }
		public List<TerminalNode> SENTENCE() { return getTokens(QuestionGrammarParser.SENTENCE); }
		public TerminalNode SENTENCE(int i) {
			return getToken(QuestionGrammarParser.SENTENCE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(QuestionGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(QuestionGrammarParser.NEWLINE, i);
		}
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QuestionGrammarListener ) ((QuestionGrammarListener)listener).exitFeedback(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QuestionGrammarVisitor ) return ((QuestionGrammarVisitor<? extends T>)visitor).visitFeedback(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_feedback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(FEEDBACK_SYMBOL);
			setState(220); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(213);
				match(SENTENCE);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(214);
					match(NEWLINE);
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			setState(224);
			match(END_SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001a\u00e3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u00019\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0004\u0007W\b\u0007\u000b\u0007\f\u0007X\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0004\ba\b\b\u000b\b\f\bb\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e|\b\u000e\n"+
		"\u000e\f\u000e\u007f\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u0085\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u008b\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0004"+
		"\u0011\u0090\b\u0011\u000b\u0011\f\u0011\u0091\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u0096\b\u0011\n\u0011\f\u0011\u0099\t\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u00a2\b\u0012\u0001\u0013\u0001\u0013\u0004\u0013\u00a6\b\u0013"+
		"\u000b\u0013\f\u0013\u00a7\u0001\u0013\u0001\u0013\u0005\u0013\u00ac\b"+
		"\u0013\n\u0013\f\u0013\u00af\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00b8\b\u0014"+
		"\u0004\u0014\u00ba\b\u0014\u000b\u0014\f\u0014\u00bb\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u00c0\b\u0014\n\u0014\f\u0014\u00c3\t\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u00c8\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0005\u0015\u00cc\b\u0015\n\u0015\f\u0015\u00cf\t\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0005"+
		"\u0017\u00d8\b\u0017\n\u0017\f\u0017\u00db\t\u0017\u0004\u0017\u00dd\b"+
		"\u0017\u000b\u0017\f\u0017\u00de\u0001\u0017\u0001\u0017\u0001\u0017\u0004"+
		"\u0097\u00ad\u00c1\u00cd\u0000\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0002"+
		"\u0001\u0000\u0003\u0004\u0001\u0000\u0007\n\u00e0\u00000\u0001\u0000"+
		"\u0000\u0000\u00028\u0001\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000"+
		"\u0006=\u0001\u0000\u0000\u0000\bA\u0001\u0000\u0000\u0000\nF\u0001\u0000"+
		"\u0000\u0000\fK\u0001\u0000\u0000\u0000\u000eP\u0001\u0000\u0000\u0000"+
		"\u0010Z\u0001\u0000\u0000\u0000\u0012d\u0001\u0000\u0000\u0000\u0014h"+
		"\u0001\u0000\u0000\u0000\u0016l\u0001\u0000\u0000\u0000\u0018p\u0001\u0000"+
		"\u0000\u0000\u001at\u0001\u0000\u0000\u0000\u001cx\u0001\u0000\u0000\u0000"+
		"\u001e\u0080\u0001\u0000\u0000\u0000 \u0086\u0001\u0000\u0000\u0000\""+
		"\u008c\u0001\u0000\u0000\u0000$\u009a\u0001\u0000\u0000\u0000&\u00a3\u0001"+
		"\u0000\u0000\u0000(\u00b0\u0001\u0000\u0000\u0000*\u00c4\u0001\u0000\u0000"+
		"\u0000,\u00d0\u0001\u0000\u0000\u0000.\u00d4\u0001\u0000\u0000\u00000"+
		"1\u0003\u0002\u0001\u000012\u0005\u0000\u0000\u00012\u0001\u0001\u0000"+
		"\u0000\u000039\u0003\b\u0004\u000049\u0003\n\u0005\u000059\u0003\f\u0006"+
		"\u000069\u0003\u000e\u0007\u000079\u0003\u0010\b\u000083\u0001\u0000\u0000"+
		"\u000084\u0001\u0000\u0000\u000085\u0001\u0000\u0000\u000086\u0001\u0000"+
		"\u0000\u000087\u0001\u0000\u0000\u00009\u0003\u0001\u0000\u0000\u0000"+
		":;\u0005\u0017\u0000\u0000;<\u0005\u0013\u0000\u0000<\u0005\u0001\u0000"+
		"\u0000\u0000=>\u0005\u000b\u0000\u0000>?\u0005\u0014\u0000\u0000?@\u0005"+
		"\u0013\u0000\u0000@\u0007\u0001\u0000\u0000\u0000AB\u0003\u0012\t\u0000"+
		"BC\u0003\u0006\u0003\u0000CD\u0003\u0004\u0002\u0000DE\u0003(\u0014\u0000"+
		"E\t\u0001\u0000\u0000\u0000FG\u0003\u0014\n\u0000GH\u0003\u0006\u0003"+
		"\u0000HI\u0003\u0004\u0002\u0000IJ\u0003\"\u0011\u0000J\u000b\u0001\u0000"+
		"\u0000\u0000KL\u0003\u0016\u000b\u0000LM\u0003\u0006\u0003\u0000MN\u0003"+
		"\u0004\u0002\u0000NO\u0003&\u0013\u0000O\r\u0001\u0000\u0000\u0000PQ\u0003"+
		"\u0018\f\u0000QR\u0003\u0006\u0003\u0000RV\u0003\u0004\u0002\u0000ST\u0003"+
		"\u001c\u000e\u0000TU\u0003\"\u0011\u0000UW\u0001\u0000\u0000\u0000VS\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Y\u000f\u0001\u0000\u0000\u0000Z[\u0003\u001a"+
		"\r\u0000[\\\u0003\u0006\u0003\u0000\\`\u0003\u0004\u0002\u0000]^\u0003"+
		"\u001c\u000e\u0000^_\u0003*\u0015\u0000_a\u0001\u0000\u0000\u0000`]\u0001"+
		"\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000c\u0011\u0001\u0000\u0000\u0000de\u0005\u000b"+
		"\u0000\u0000ef\u0005\u0001\u0000\u0000fg\u0005\u0013\u0000\u0000g\u0013"+
		"\u0001\u0000\u0000\u0000hi\u0005\u000b\u0000\u0000ij\u0005\u0002\u0000"+
		"\u0000jk\u0005\u0013\u0000\u0000k\u0015\u0001\u0000\u0000\u0000lm\u0005"+
		"\u000b\u0000\u0000mn\u0007\u0000\u0000\u0000no\u0005\u0013\u0000\u0000"+
		"o\u0017\u0001\u0000\u0000\u0000pq\u0005\u000b\u0000\u0000qr\u0005\u0005"+
		"\u0000\u0000rs\u0005\u0013\u0000\u0000s\u0019\u0001\u0000\u0000\u0000"+
		"tu\u0005\u000b\u0000\u0000uv\u0005\u0006\u0000\u0000vw\u0005\u0013\u0000"+
		"\u0000w\u001b\u0001\u0000\u0000\u0000xy\u0005\u0017\u0000\u0000y}\u0005"+
		"\u000f\u0000\u0000z|\u0005\u0019\u0000\u0000{z\u0001\u0000\u0000\u0000"+
		"|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~\u001d\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0005\u0011\u0000\u0000\u0081\u0082\u0005\u0017\u0000\u0000"+
		"\u0082\u0084\u0005\u0013\u0000\u0000\u0083\u0085\u0003.\u0017\u0000\u0084"+
		"\u0083\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u001f\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0010\u0000\u0000\u0087"+
		"\u0088\u0005\u0017\u0000\u0000\u0088\u008a\u0005\u0013\u0000\u0000\u0089"+
		"\u008b\u0003.\u0017\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0001\u0000\u0000\u0000\u008b!\u0001\u0000\u0000\u0000\u008c\u008f\u0005"+
		"\r\u0000\u0000\u008d\u0090\u0003\u001e\u000f\u0000\u008e\u0090\u0003 "+
		"\u0010\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u008e\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u0097\u0005\u000e\u0000\u0000\u0094\u0096\u0005\u001a"+
		"\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0099\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000"+
		"\u0000\u0000\u0098#\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0005\u0010\u0000\u0000\u009b\u009c\u0005\f\u0000\u0000"+
		"\u009c\u009d\u0005\u0014\u0000\u0000\u009d\u009e\u0005\f\u0000\u0000\u009e"+
		"\u009f\u0005\u0017\u0000\u0000\u009f\u00a1\u0005\u0013\u0000\u0000\u00a0"+
		"\u00a2\u0003.\u0017\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a2%\u0001\u0000\u0000\u0000\u00a3\u00a5\u0005"+
		"\r\u0000\u0000\u00a4\u00a6\u0003$\u0012\u0000\u00a5\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00ad\u0005\u000e\u0000\u0000\u00aa\u00ac\u0005\u001a"+
		"\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ae\'\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b9\u0005\r\u0000\u0000\u00b1\u00b2\u0005\u0017\u0000\u0000"+
		"\u00b2\u00b3\u0005\u0013\u0000\u0000\u00b3\u00b4\u0005\u0010\u0000\u0000"+
		"\u00b4\u00b5\u0005\u0017\u0000\u0000\u00b5\u00b7\u0005\u0013\u0000\u0000"+
		"\u00b6\u00b8\u0003.\u0017\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000\u00b9"+
		"\u00b1\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bd\u00c1\u0005\u000e\u0000\u0000\u00be"+
		"\u00c0\u0005\u001a\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c1"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c2)\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\r\u0000\u0000\u00c5\u00c7\u0003"+
		",\u0016\u0000\u00c6\u00c8\u0003.\u0017\u0000\u00c7\u00c6\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c9\u00cd\u0005\u000e\u0000\u0000\u00ca\u00cc\u0005\u001a\u0000"+
		"\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000"+
		"\u0000\u00ce+\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0005\u0010\u0000\u0000\u00d1\u00d2\u0007\u0001\u0000\u0000"+
		"\u00d2\u00d3\u0005\u0013\u0000\u0000\u00d3-\u0001\u0000\u0000\u0000\u00d4"+
		"\u00dc\u0005\u0012\u0000\u0000\u00d5\u00d9\u0005\u0017\u0000\u0000\u00d6"+
		"\u00d8\u0005\u001a\u0000\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d8"+
		"\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db"+
		"\u00d9\u0001\u0000\u0000\u0000\u00dc\u00d5\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0005\u0013\u0000\u0000\u00e1/\u0001\u0000\u0000\u0000\u00138X"+
		"b}\u0084\u008a\u008f\u0091\u0097\u00a1\u00a7\u00ad\u00b7\u00bb\u00c1\u00c7"+
		"\u00cd\u00d9\u00de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}