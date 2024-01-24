// Generated from ExamGrammar.g4 by ANTLR 4.12.0
package eapli.base.exam.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExamGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, EXAM_HEADER_SYMBOL=11, SECTION_HEADER_SYMBOL=12, QUESTION_DEFINITION_SYMBOL=13, 
		PERCENTAGE=14, OPEN_BRACKET=15, CLOSING_BRACKET=16, ANSWER_SPACING=17, 
		CORRECT_ANSWER_SYMBOL=18, WRONG_ANSWER_SYMBOL=19, FEEDBACK_SYMBOL=20, 
		END_SYMBOL=21, INT=22, PUNCTUATION=23, OPERATIONS=24, SENTENCE=25, WORD=26, 
		WHITESPACE=27, NEWLINE=28;
	public static final int
		RULE_start = 0, RULE_exam = 1, RULE_exam_header = 2, RULE_title = 3, RULE_description = 4, 
		RULE_section = 5, RULE_section_header = 6, RULE_question = 7, RULE_question_header = 8, 
		RULE_question_grade = 9, RULE_matching_question = 10, RULE_multiple_choice_question = 11, 
		RULE_open_question = 12, RULE_missing_words_question = 13, RULE_true_false_question = 14, 
		RULE_matching_question_definition = 15, RULE_multiple_choice_definition = 16, 
		RULE_open_questions_definition = 17, RULE_missing_words_definition = 18, 
		RULE_true_false_definition = 19, RULE_subquestion = 20, RULE_wrong_answer = 21, 
		RULE_correct_answer = 22, RULE_answer_list = 23, RULE_open_questions_answer = 24, 
		RULE_open_questions_answer_list = 25, RULE_matching_answers = 26, RULE_true_false_answer = 27, 
		RULE_true_false = 28, RULE_feedback = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "exam", "exam_header", "title", "description", "section", "section_header", 
			"question", "question_header", "question_grade", "matching_question", 
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
			null, null, "'}'", "'___'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "EXAM_HEADER_SYMBOL", 
			"SECTION_HEADER_SYMBOL", "QUESTION_DEFINITION_SYMBOL", "PERCENTAGE", 
			"OPEN_BRACKET", "CLOSING_BRACKET", "ANSWER_SPACING", "CORRECT_ANSWER_SYMBOL", 
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
	public String getGrammarFileName() { return "ExamGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExamGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ExamContext exam() {
			return getRuleContext(ExamContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ExamGrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			exam();
			setState(61);
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
	public static class ExamContext extends ParserRuleContext {
		public Exam_headerContext exam_header() {
			return getRuleContext(Exam_headerContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public ExamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterExam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitExam(this);
		}
	}

	public final ExamContext exam() throws RecognitionException {
		ExamContext _localctx = new ExamContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			exam_header();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(64);
				match(NEWLINE);
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				section();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SECTION_HEADER_SYMBOL );
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
	public static class Exam_headerContext extends ParserRuleContext {
		public List<TerminalNode> EXAM_HEADER_SYMBOL() { return getTokens(ExamGrammarParser.EXAM_HEADER_SYMBOL); }
		public TerminalNode EXAM_HEADER_SYMBOL(int i) {
			return getToken(ExamGrammarParser.EXAM_HEADER_SYMBOL, i);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Exam_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exam_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterExam_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitExam_header(this);
		}
	}

	public final Exam_headerContext exam_header() throws RecognitionException {
		Exam_headerContext _localctx = new Exam_headerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exam_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(EXAM_HEADER_SYMBOL);
			setState(76);
			title();
			setState(77);
			match(EXAM_HEADER_SYMBOL);
			setState(78);
			description();
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
	public static class TitleContext extends ParserRuleContext {
		public TerminalNode SENTENCE() { return getToken(ExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(SENTENCE);
			setState(81);
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
	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public List<TerminalNode> SENTENCE() { return getTokens(ExamGrammarParser.SENTENCE); }
		public TerminalNode SENTENCE(int i) {
			return getToken(ExamGrammarParser.SENTENCE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitDescription(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				match(SENTENCE);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(84);
					match(NEWLINE);
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			setState(94);
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
	public static class SectionContext extends ParserRuleContext {
		public Section_headerContext section_header() {
			return getRuleContext(Section_headerContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitSection(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			section_header();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(97);
				match(NEWLINE);
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				question();
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUESTION_DEFINITION_SYMBOL );
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(108);
				match(NEWLINE);
				}
				}
				setState(113);
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
	public static class Section_headerContext extends ParserRuleContext {
		public List<TerminalNode> SECTION_HEADER_SYMBOL() { return getTokens(ExamGrammarParser.SECTION_HEADER_SYMBOL); }
		public TerminalNode SECTION_HEADER_SYMBOL(int i) {
			return getToken(ExamGrammarParser.SECTION_HEADER_SYMBOL, i);
		}
		public TitleContext title() {
			return getRuleContext(TitleContext.class,0);
		}
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public Section_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterSection_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitSection_header(this);
		}
	}

	public final Section_headerContext section_header() throws RecognitionException {
		Section_headerContext _localctx = new Section_headerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_section_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(SECTION_HEADER_SYMBOL);
			setState(115);
			title();
			setState(116);
			match(SECTION_HEADER_SYMBOL);
			setState(117);
			description();
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitQuestion(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(119);
				matching_question();
				}
				break;
			case 2:
				{
				setState(120);
				multiple_choice_question();
				}
				break;
			case 3:
				{
				setState(121);
				open_question();
				}
				break;
			case 4:
				{
				setState(122);
				missing_words_question();
				}
				break;
			case 5:
				{
				setState(123);
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
		public TerminalNode SENTENCE() { return getToken(ExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public Question_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterQuestion_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitQuestion_header(this);
		}
	}

	public final Question_headerContext question_header() throws RecognitionException {
		Question_headerContext _localctx = new Question_headerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_question_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(SENTENCE);
			setState(127);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(ExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode INT() { return getToken(ExamGrammarParser.INT, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public Question_gradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterQuestion_grade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitQuestion_grade(this);
		}
	}

	public final Question_gradeContext question_grade() throws RecognitionException {
		Question_gradeContext _localctx = new Question_gradeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_question_grade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(130);
			match(INT);
			setState(131);
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMatching_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMatching_question(this);
		}
	}

	public final Matching_questionContext matching_question() throws RecognitionException {
		Matching_questionContext _localctx = new Matching_questionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_matching_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			matching_question_definition();
			setState(134);
			question_grade();
			setState(135);
			question_header();
			setState(136);
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMultiple_choice_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMultiple_choice_question(this);
		}
	}

	public final Multiple_choice_questionContext multiple_choice_question() throws RecognitionException {
		Multiple_choice_questionContext _localctx = new Multiple_choice_questionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_multiple_choice_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			multiple_choice_definition();
			setState(139);
			question_grade();
			setState(140);
			question_header();
			setState(141);
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterOpen_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitOpen_question(this);
		}
	}

	public final Open_questionContext open_question() throws RecognitionException {
		Open_questionContext _localctx = new Open_questionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_open_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			open_questions_definition();
			setState(144);
			question_grade();
			setState(145);
			question_header();
			setState(146);
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMissing_words_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMissing_words_question(this);
		}
	}

	public final Missing_words_questionContext missing_words_question() throws RecognitionException {
		Missing_words_questionContext _localctx = new Missing_words_questionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_missing_words_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			missing_words_definition();
			setState(149);
			question_grade();
			setState(150);
			question_header();
			setState(154); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(151);
				subquestion();
				setState(152);
				answer_list();
				}
				}
				setState(156); 
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTrue_false_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTrue_false_question(this);
		}
	}

	public final True_false_questionContext true_false_question() throws RecognitionException {
		True_false_questionContext _localctx = new True_false_questionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_true_false_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			true_false_definition();
			setState(159);
			question_grade();
			setState(160);
			question_header();
			setState(164); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(161);
				subquestion();
				setState(162);
				true_false_answer();
				}
				}
				setState(166); 
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(ExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public Matching_question_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_question_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMatching_question_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMatching_question_definition(this);
		}
	}

	public final Matching_question_definitionContext matching_question_definition() throws RecognitionException {
		Matching_question_definitionContext _localctx = new Matching_question_definitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_matching_question_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(169);
			match(T__0);
			setState(170);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(ExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public Multiple_choice_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMultiple_choice_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMultiple_choice_definition(this);
		}
	}

	public final Multiple_choice_definitionContext multiple_choice_definition() throws RecognitionException {
		Multiple_choice_definitionContext _localctx = new Multiple_choice_definitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_multiple_choice_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(173);
			match(T__1);
			setState(174);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(ExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public Open_questions_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_questions_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterOpen_questions_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitOpen_questions_definition(this);
		}
	}

	public final Open_questions_definitionContext open_questions_definition() throws RecognitionException {
		Open_questions_definitionContext _localctx = new Open_questions_definitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_open_questions_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(177);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(178);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(ExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public Missing_words_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_words_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMissing_words_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMissing_words_definition(this);
		}
	}

	public final Missing_words_definitionContext missing_words_definition() throws RecognitionException {
		Missing_words_definitionContext _localctx = new Missing_words_definitionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_missing_words_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(181);
			match(T__4);
			setState(182);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(ExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public True_false_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTrue_false_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTrue_false_definition(this);
		}
	}

	public final True_false_definitionContext true_false_definition() throws RecognitionException {
		True_false_definitionContext _localctx = new True_false_definitionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_true_false_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(185);
			match(T__5);
			setState(186);
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
		public TerminalNode SENTENCE() { return getToken(ExamGrammarParser.SENTENCE, 0); }
		public TerminalNode ANSWER_SPACING() { return getToken(ExamGrammarParser.ANSWER_SPACING, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(ExamGrammarParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(ExamGrammarParser.WHITESPACE, i);
		}
		public SubquestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterSubquestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitSubquestion(this);
		}
	}

	public final SubquestionContext subquestion() throws RecognitionException {
		SubquestionContext _localctx = new SubquestionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_subquestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(SENTENCE);
			setState(189);
			match(ANSWER_SPACING);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(190);
				match(WHITESPACE);
				}
				}
				setState(195);
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
		public TerminalNode WRONG_ANSWER_SYMBOL() { return getToken(ExamGrammarParser.WRONG_ANSWER_SYMBOL, 0); }
		public TerminalNode SENTENCE() { return getToken(ExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Wrong_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wrong_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterWrong_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitWrong_answer(this);
		}
	}

	public final Wrong_answerContext wrong_answer() throws RecognitionException {
		Wrong_answerContext _localctx = new Wrong_answerContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_wrong_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(WRONG_ANSWER_SYMBOL);
			setState(197);
			match(SENTENCE);
			setState(198);
			match(END_SYMBOL);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(199);
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
		public TerminalNode CORRECT_ANSWER_SYMBOL() { return getToken(ExamGrammarParser.CORRECT_ANSWER_SYMBOL, 0); }
		public TerminalNode SENTENCE() { return getToken(ExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Correct_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_correct_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterCorrect_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitCorrect_answer(this);
		}
	}

	public final Correct_answerContext correct_answer() throws RecognitionException {
		Correct_answerContext _localctx = new Correct_answerContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_correct_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(CORRECT_ANSWER_SYMBOL);
			setState(203);
			match(SENTENCE);
			setState(204);
			match(END_SYMBOL);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(205);
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
		public TerminalNode OPEN_BRACKET() { return getToken(ExamGrammarParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(ExamGrammarParser.CLOSING_BRACKET, 0); }
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
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public Answer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterAnswer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitAnswer_list(this);
		}
	}

	public final Answer_listContext answer_list() throws RecognitionException {
		Answer_listContext _localctx = new Answer_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_answer_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(OPEN_BRACKET);
			setState(211); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(211);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case WRONG_ANSWER_SYMBOL:
					{
					setState(209);
					wrong_answer();
					}
					break;
				case CORRECT_ANSWER_SYMBOL:
					{
					setState(210);
					correct_answer();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(213); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CORRECT_ANSWER_SYMBOL || _la==WRONG_ANSWER_SYMBOL );
			setState(215);
			match(CLOSING_BRACKET);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(216);
					match(NEWLINE);
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		public TerminalNode CORRECT_ANSWER_SYMBOL() { return getToken(ExamGrammarParser.CORRECT_ANSWER_SYMBOL, 0); }
		public List<TerminalNode> PERCENTAGE() { return getTokens(ExamGrammarParser.PERCENTAGE); }
		public TerminalNode PERCENTAGE(int i) {
			return getToken(ExamGrammarParser.PERCENTAGE, i);
		}
		public TerminalNode INT() { return getToken(ExamGrammarParser.INT, 0); }
		public TerminalNode SENTENCE() { return getToken(ExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Open_questions_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_questions_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterOpen_questions_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitOpen_questions_answer(this);
		}
	}

	public final Open_questions_answerContext open_questions_answer() throws RecognitionException {
		Open_questions_answerContext _localctx = new Open_questions_answerContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_open_questions_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(CORRECT_ANSWER_SYMBOL);
			setState(223);
			match(PERCENTAGE);
			setState(224);
			match(INT);
			setState(225);
			match(PERCENTAGE);
			setState(226);
			match(SENTENCE);
			setState(227);
			match(END_SYMBOL);
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(228);
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
		public TerminalNode OPEN_BRACKET() { return getToken(ExamGrammarParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(ExamGrammarParser.CLOSING_BRACKET, 0); }
		public List<Open_questions_answerContext> open_questions_answer() {
			return getRuleContexts(Open_questions_answerContext.class);
		}
		public Open_questions_answerContext open_questions_answer(int i) {
			return getRuleContext(Open_questions_answerContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public Open_questions_answer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_questions_answer_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterOpen_questions_answer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitOpen_questions_answer_list(this);
		}
	}

	public final Open_questions_answer_listContext open_questions_answer_list() throws RecognitionException {
		Open_questions_answer_listContext _localctx = new Open_questions_answer_listContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_open_questions_answer_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(OPEN_BRACKET);
			setState(233); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(232);
				open_questions_answer();
				}
				}
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CORRECT_ANSWER_SYMBOL );
			setState(237);
			match(CLOSING_BRACKET);
			setState(241);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(238);
					match(NEWLINE);
					}
					} 
				}
				setState(243);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		public TerminalNode OPEN_BRACKET() { return getToken(ExamGrammarParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(ExamGrammarParser.CLOSING_BRACKET, 0); }
		public List<TerminalNode> SENTENCE() { return getTokens(ExamGrammarParser.SENTENCE); }
		public TerminalNode SENTENCE(int i) {
			return getToken(ExamGrammarParser.SENTENCE, i);
		}
		public List<TerminalNode> END_SYMBOL() { return getTokens(ExamGrammarParser.END_SYMBOL); }
		public TerminalNode END_SYMBOL(int i) {
			return getToken(ExamGrammarParser.END_SYMBOL, i);
		}
		public List<TerminalNode> CORRECT_ANSWER_SYMBOL() { return getTokens(ExamGrammarParser.CORRECT_ANSWER_SYMBOL); }
		public TerminalNode CORRECT_ANSWER_SYMBOL(int i) {
			return getToken(ExamGrammarParser.CORRECT_ANSWER_SYMBOL, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
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
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterMatching_answers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitMatching_answers(this);
		}
	}

	public final Matching_answersContext matching_answers() throws RecognitionException {
		Matching_answersContext _localctx = new Matching_answersContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_matching_answers);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(OPEN_BRACKET);
			setState(253); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(245);
				match(SENTENCE);
				setState(246);
				match(END_SYMBOL);
				setState(247);
				match(CORRECT_ANSWER_SYMBOL);
				setState(248);
				match(SENTENCE);
				setState(249);
				match(END_SYMBOL);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FEEDBACK_SYMBOL) {
					{
					setState(250);
					feedback();
					}
				}

				}
				}
				setState(255); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			setState(257);
			match(CLOSING_BRACKET);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(258);
					match(NEWLINE);
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		public TerminalNode OPEN_BRACKET() { return getToken(ExamGrammarParser.OPEN_BRACKET, 0); }
		public True_falseContext true_false() {
			return getRuleContext(True_falseContext.class,0);
		}
		public TerminalNode CLOSING_BRACKET() { return getToken(ExamGrammarParser.CLOSING_BRACKET, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public True_false_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTrue_false_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTrue_false_answer(this);
		}
	}

	public final True_false_answerContext true_false_answer() throws RecognitionException {
		True_false_answerContext _localctx = new True_false_answerContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_true_false_answer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(OPEN_BRACKET);
			setState(265);
			true_false();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(266);
				feedback();
				}
			}

			setState(269);
			match(CLOSING_BRACKET);
			setState(273);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(270);
					match(NEWLINE);
					}
					} 
				}
				setState(275);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		public TerminalNode CORRECT_ANSWER_SYMBOL() { return getToken(ExamGrammarParser.CORRECT_ANSWER_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public True_falseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterTrue_false(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitTrue_false(this);
		}
	}

	public final True_falseContext true_false() throws RecognitionException {
		True_falseContext _localctx = new True_falseContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_true_false);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(CORRECT_ANSWER_SYMBOL);
			setState(277);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(278);
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
		public TerminalNode FEEDBACK_SYMBOL() { return getToken(ExamGrammarParser.FEEDBACK_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(ExamGrammarParser.END_SYMBOL, 0); }
		public List<TerminalNode> SENTENCE() { return getTokens(ExamGrammarParser.SENTENCE); }
		public TerminalNode SENTENCE(int i) {
			return getToken(ExamGrammarParser.SENTENCE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamGrammarParser.NEWLINE, i);
		}
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamGrammarListener ) ((ExamGrammarListener)listener).exitFeedback(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_feedback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(FEEDBACK_SYMBOL);
			setState(288); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(281);
				match(SENTENCE);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(282);
					match(NEWLINE);
					}
					}
					setState(287);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(290); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			setState(292);
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
		"\u0004\u0001\u001c\u0127\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001B\b\u0001\n\u0001"+
		"\f\u0001E\t\u0001\u0001\u0001\u0004\u0001H\b\u0001\u000b\u0001\f\u0001"+
		"I\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004V\b\u0004"+
		"\n\u0004\f\u0004Y\t\u0004\u0004\u0004[\b\u0004\u000b\u0004\f\u0004\\\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0005\u0005c\b\u0005\n\u0005"+
		"\f\u0005f\t\u0005\u0001\u0005\u0004\u0005i\b\u0005\u000b\u0005\f\u0005"+
		"j\u0001\u0005\u0005\u0005n\b\u0005\n\u0005\f\u0005q\t\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007}\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0004\r\u009b\b\r\u000b\r\f\r\u009c\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u00a5"+
		"\b\u000e\u000b\u000e\f\u000e\u00a6\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u00c0\b\u0014\n\u0014\f\u0014\u00c3"+
		"\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00c9"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00cf"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0004\u0017\u00d4\b\u0017"+
		"\u000b\u0017\f\u0017\u00d5\u0001\u0017\u0001\u0017\u0005\u0017\u00da\b"+
		"\u0017\n\u0017\f\u0017\u00dd\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u00e6\b\u0018"+
		"\u0001\u0019\u0001\u0019\u0004\u0019\u00ea\b\u0019\u000b\u0019\f\u0019"+
		"\u00eb\u0001\u0019\u0001\u0019\u0005\u0019\u00f0\b\u0019\n\u0019\f\u0019"+
		"\u00f3\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0003\u001a\u00fc\b\u001a\u0004\u001a\u00fe\b"+
		"\u001a\u000b\u001a\f\u001a\u00ff\u0001\u001a\u0001\u001a\u0005\u001a\u0104"+
		"\b\u001a\n\u001a\f\u001a\u0107\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0003\u001b\u010c\b\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0110\b"+
		"\u001b\n\u001b\f\u001b\u0113\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u011c\b\u001d"+
		"\n\u001d\f\u001d\u011f\t\u001d\u0004\u001d\u0121\b\u001d\u000b\u001d\f"+
		"\u001d\u0122\u0001\u001d\u0001\u001d\u0001\u001d\u0004\u00db\u00f1\u0105"+
		"\u0111\u0000\u001e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:\u0000\u0002\u0001\u0000"+
		"\u0003\u0004\u0001\u0000\u0007\n\u0125\u0000<\u0001\u0000\u0000\u0000"+
		"\u0002?\u0001\u0000\u0000\u0000\u0004K\u0001\u0000\u0000\u0000\u0006P"+
		"\u0001\u0000\u0000\u0000\bZ\u0001\u0000\u0000\u0000\n`\u0001\u0000\u0000"+
		"\u0000\fr\u0001\u0000\u0000\u0000\u000e|\u0001\u0000\u0000\u0000\u0010"+
		"~\u0001\u0000\u0000\u0000\u0012\u0081\u0001\u0000\u0000\u0000\u0014\u0085"+
		"\u0001\u0000\u0000\u0000\u0016\u008a\u0001\u0000\u0000\u0000\u0018\u008f"+
		"\u0001\u0000\u0000\u0000\u001a\u0094\u0001\u0000\u0000\u0000\u001c\u009e"+
		"\u0001\u0000\u0000\u0000\u001e\u00a8\u0001\u0000\u0000\u0000 \u00ac\u0001"+
		"\u0000\u0000\u0000\"\u00b0\u0001\u0000\u0000\u0000$\u00b4\u0001\u0000"+
		"\u0000\u0000&\u00b8\u0001\u0000\u0000\u0000(\u00bc\u0001\u0000\u0000\u0000"+
		"*\u00c4\u0001\u0000\u0000\u0000,\u00ca\u0001\u0000\u0000\u0000.\u00d0"+
		"\u0001\u0000\u0000\u00000\u00de\u0001\u0000\u0000\u00002\u00e7\u0001\u0000"+
		"\u0000\u00004\u00f4\u0001\u0000\u0000\u00006\u0108\u0001\u0000\u0000\u0000"+
		"8\u0114\u0001\u0000\u0000\u0000:\u0118\u0001\u0000\u0000\u0000<=\u0003"+
		"\u0002\u0001\u0000=>\u0005\u0000\u0000\u0001>\u0001\u0001\u0000\u0000"+
		"\u0000?C\u0003\u0004\u0002\u0000@B\u0005\u001c\u0000\u0000A@\u0001\u0000"+
		"\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001"+
		"\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000"+
		"FH\u0003\n\u0005\u0000GF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\u0003\u0001\u0000"+
		"\u0000\u0000KL\u0005\u000b\u0000\u0000LM\u0003\u0006\u0003\u0000MN\u0005"+
		"\u000b\u0000\u0000NO\u0003\b\u0004\u0000O\u0005\u0001\u0000\u0000\u0000"+
		"PQ\u0005\u0019\u0000\u0000QR\u0005\u0015\u0000\u0000R\u0007\u0001\u0000"+
		"\u0000\u0000SW\u0005\u0019\u0000\u0000TV\u0005\u001c\u0000\u0000UT\u0001"+
		"\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000"+
		"\u0000ZS\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000"+
		"\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0005"+
		"\u0015\u0000\u0000_\t\u0001\u0000\u0000\u0000`d\u0003\f\u0006\u0000ac"+
		"\u0005\u001c\u0000\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eh\u0001\u0000"+
		"\u0000\u0000fd\u0001\u0000\u0000\u0000gi\u0003\u000e\u0007\u0000hg\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"jk\u0001\u0000\u0000\u0000ko\u0001\u0000\u0000\u0000ln\u0005\u001c\u0000"+
		"\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000p\u000b\u0001\u0000\u0000\u0000"+
		"qo\u0001\u0000\u0000\u0000rs\u0005\f\u0000\u0000st\u0003\u0006\u0003\u0000"+
		"tu\u0005\f\u0000\u0000uv\u0003\b\u0004\u0000v\r\u0001\u0000\u0000\u0000"+
		"w}\u0003\u0014\n\u0000x}\u0003\u0016\u000b\u0000y}\u0003\u0018\f\u0000"+
		"z}\u0003\u001a\r\u0000{}\u0003\u001c\u000e\u0000|w\u0001\u0000\u0000\u0000"+
		"|x\u0001\u0000\u0000\u0000|y\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000"+
		"\u0000|{\u0001\u0000\u0000\u0000}\u000f\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005\u0019\u0000\u0000\u007f\u0080\u0005\u0015\u0000\u0000\u0080\u0011"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0005\r\u0000\u0000\u0082\u0083\u0005"+
		"\u0016\u0000\u0000\u0083\u0084\u0005\u0015\u0000\u0000\u0084\u0013\u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0003\u001e\u000f\u0000\u0086\u0087\u0003"+
		"\u0012\t\u0000\u0087\u0088\u0003\u0010\b\u0000\u0088\u0089\u00034\u001a"+
		"\u0000\u0089\u0015\u0001\u0000\u0000\u0000\u008a\u008b\u0003 \u0010\u0000"+
		"\u008b\u008c\u0003\u0012\t\u0000\u008c\u008d\u0003\u0010\b\u0000\u008d"+
		"\u008e\u0003.\u0017\u0000\u008e\u0017\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0003\"\u0011\u0000\u0090\u0091\u0003\u0012\t\u0000\u0091\u0092\u0003"+
		"\u0010\b\u0000\u0092\u0093\u00032\u0019\u0000\u0093\u0019\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0003$\u0012\u0000\u0095\u0096\u0003\u0012\t"+
		"\u0000\u0096\u009a\u0003\u0010\b\u0000\u0097\u0098\u0003(\u0014\u0000"+
		"\u0098\u0099\u0003.\u0017\u0000\u0099\u009b\u0001\u0000\u0000\u0000\u009a"+
		"\u0097\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d"+
		"\u001b\u0001\u0000\u0000\u0000\u009e\u009f\u0003&\u0013\u0000\u009f\u00a0"+
		"\u0003\u0012\t\u0000\u00a0\u00a4\u0003\u0010\b\u0000\u00a1\u00a2\u0003"+
		"(\u0014\u0000\u00a2\u00a3\u00036\u001b\u0000\u00a3\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a1\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a7\u001d\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\r\u0000\u0000"+
		"\u00a9\u00aa\u0005\u0001\u0000\u0000\u00aa\u00ab\u0005\u0015\u0000\u0000"+
		"\u00ab\u001f\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\r\u0000\u0000\u00ad"+
		"\u00ae\u0005\u0002\u0000\u0000\u00ae\u00af\u0005\u0015\u0000\u0000\u00af"+
		"!\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\r\u0000\u0000\u00b1\u00b2"+
		"\u0007\u0000\u0000\u0000\u00b2\u00b3\u0005\u0015\u0000\u0000\u00b3#\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0005\r\u0000\u0000\u00b5\u00b6\u0005\u0005"+
		"\u0000\u0000\u00b6\u00b7\u0005\u0015\u0000\u0000\u00b7%\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b9\u0005\r\u0000\u0000\u00b9\u00ba\u0005\u0006\u0000\u0000"+
		"\u00ba\u00bb\u0005\u0015\u0000\u0000\u00bb\'\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0005\u0019\u0000\u0000\u00bd\u00c1\u0005\u0011\u0000\u0000\u00be"+
		"\u00c0\u0005\u001b\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2)\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0013\u0000\u0000\u00c5\u00c6"+
		"\u0005\u0019\u0000\u0000\u00c6\u00c8\u0005\u0015\u0000\u0000\u00c7\u00c9"+
		"\u0003:\u001d\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c9+\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005\u0012"+
		"\u0000\u0000\u00cb\u00cc\u0005\u0019\u0000\u0000\u00cc\u00ce\u0005\u0015"+
		"\u0000\u0000\u00cd\u00cf\u0003:\u001d\u0000\u00ce\u00cd\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf-\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d3\u0005\u000f\u0000\u0000\u00d1\u00d4\u0003*\u0015\u0000\u00d2"+
		"\u00d4\u0003,\u0016\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d7\u00db\u0005\u0010\u0000\u0000\u00d8\u00da"+
		"\u0005\u001c\u0000\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u00dd"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00db\u00d9"+
		"\u0001\u0000\u0000\u0000\u00dc/\u0001\u0000\u0000\u0000\u00dd\u00db\u0001"+
		"\u0000\u0000\u0000\u00de\u00df\u0005\u0012\u0000\u0000\u00df\u00e0\u0005"+
		"\u000e\u0000\u0000\u00e0\u00e1\u0005\u0016\u0000\u0000\u00e1\u00e2\u0005"+
		"\u000e\u0000\u0000\u00e2\u00e3\u0005\u0019\u0000\u0000\u00e3\u00e5\u0005"+
		"\u0015\u0000\u0000\u00e4\u00e6\u0003:\u001d\u0000\u00e5\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e61\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e9\u0005\u000f\u0000\u0000\u00e8\u00ea\u00030\u0018\u0000"+
		"\u00e9\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000"+
		"\u00eb\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00f1\u0005\u0010\u0000\u0000"+
		"\u00ee\u00f0\u0005\u001c\u0000\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f3\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000"+
		"\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f23\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f4\u00fd\u0005\u000f\u0000\u0000\u00f5"+
		"\u00f6\u0005\u0019\u0000\u0000\u00f6\u00f7\u0005\u0015\u0000\u0000\u00f7"+
		"\u00f8\u0005\u0012\u0000\u0000\u00f8\u00f9\u0005\u0019\u0000\u0000\u00f9"+
		"\u00fb\u0005\u0015\u0000\u0000\u00fa\u00fc\u0003:\u001d\u0000\u00fb\u00fa"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u00fe"+
		"\u0001\u0000\u0000\u0000\u00fd\u00f5\u0001\u0000\u0000\u0000\u00fe\u00ff"+
		"\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100"+
		"\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0101\u0105"+
		"\u0005\u0010\u0000\u0000\u0102\u0104\u0005\u001c\u0000\u0000\u0103\u0102"+
		"\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u01065\u0001"+
		"\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u0109\u0005"+
		"\u000f\u0000\u0000\u0109\u010b\u00038\u001c\u0000\u010a\u010c\u0003:\u001d"+
		"\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000"+
		"\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u0111\u0005\u0010\u0000"+
		"\u0000\u010e\u0110\u0005\u001c\u0000\u0000\u010f\u010e\u0001\u0000\u0000"+
		"\u0000\u0110\u0113\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000"+
		"\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u01127\u0001\u0000\u0000\u0000"+
		"\u0113\u0111\u0001\u0000\u0000\u0000\u0114\u0115\u0005\u0012\u0000\u0000"+
		"\u0115\u0116\u0007\u0001\u0000\u0000\u0116\u0117\u0005\u0015\u0000\u0000"+
		"\u01179\u0001\u0000\u0000\u0000\u0118\u0120\u0005\u0014\u0000\u0000\u0119"+
		"\u011d\u0005\u0019\u0000\u0000\u011a\u011c\u0005\u001c\u0000\u0000\u011b"+
		"\u011a\u0001\u0000\u0000\u0000\u011c\u011f\u0001\u0000\u0000\u0000\u011d"+
		"\u011b\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e"+
		"\u0121\u0001\u0000\u0000\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u0120"+
		"\u0119\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122"+
		"\u0120\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u0001\u0000\u0000\u0000\u0124\u0125\u0005\u0015\u0000\u0000\u0125"+
		";\u0001\u0000\u0000\u0000\u001aCIW\\djo|\u009c\u00a6\u00c1\u00c8\u00ce"+
		"\u00d3\u00d5\u00db\u00e5\u00eb\u00f1\u00fb\u00ff\u0105\u010b\u0111\u011d"+
		"\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}