// Generated from FormativeExamGrammar.g4 by ANTLR 4.12.0
package eapli.base.examformative.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class FormativeExamGrammarParser extends Parser {
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
		RULE_section = 5, RULE_section_header = 6, RULE_question_header = 7, RULE_question_grade = 8, 
		RULE_matching_question = 9, RULE_multiple_choice_question = 10, RULE_open_question = 11, 
		RULE_missing_words_question = 12, RULE_true_false_question = 13, RULE_matching_question_definition = 14, 
		RULE_multiple_choice_definition = 15, RULE_open_questions_definition = 16, 
		RULE_missing_words_definition = 17, RULE_true_false_definition = 18, RULE_subquestion = 19, 
		RULE_wrong_answer = 20, RULE_correct_answer = 21, RULE_answer_list = 22, 
		RULE_open_questions_answer = 23, RULE_open_questions_answer_list = 24, 
		RULE_matching_answers = 25, RULE_true_false_answer = 26, RULE_true_false = 27, 
		RULE_feedback = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "exam", "exam_header", "title", "description", "section", "section_header", 
			"question_header", "question_grade", "matching_question", "multiple_choice_question", 
			"open_question", "missing_words_question", "true_false_question", "matching_question_definition", 
			"multiple_choice_definition", "open_questions_definition", "missing_words_definition", 
			"true_false_definition", "subquestion", "wrong_answer", "correct_answer", 
			"answer_list", "open_questions_answer", "open_questions_answer_list", 
			"matching_answers", "true_false_answer", "true_false", "feedback"
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
	public String getGrammarFileName() { return "FormativeExamGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormativeExamGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ExamContext exam() {
			return getRuleContext(ExamContext.class,0);
		}
		public TerminalNode EOF() { return getToken(FormativeExamGrammarParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			exam();
			setState(59);
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
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
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
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterExam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitExam(this);
		}
	}

	public final ExamContext exam() throws RecognitionException {
		ExamContext _localctx = new ExamContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			exam_header();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(62);
				match(NEWLINE);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				section();
				}
				}
				setState(71); 
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
		public List<TerminalNode> EXAM_HEADER_SYMBOL() { return getTokens(FormativeExamGrammarParser.EXAM_HEADER_SYMBOL); }
		public TerminalNode EXAM_HEADER_SYMBOL(int i) {
			return getToken(FormativeExamGrammarParser.EXAM_HEADER_SYMBOL, i);
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
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterExam_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitExam_header(this);
		}
	}

	public final Exam_headerContext exam_header() throws RecognitionException {
		Exam_headerContext _localctx = new Exam_headerContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_exam_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(EXAM_HEADER_SYMBOL);
			setState(74);
			title();
			setState(75);
			match(EXAM_HEADER_SYMBOL);
			setState(76);
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
		public TerminalNode SENTENCE() { return getToken(FormativeExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public TitleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_title; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTitle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTitle(this);
		}
	}

	public final TitleContext title() throws RecognitionException {
		TitleContext _localctx = new TitleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_title);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(SENTENCE);
			setState(79);
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
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public List<TerminalNode> SENTENCE() { return getTokens(FormativeExamGrammarParser.SENTENCE); }
		public TerminalNode SENTENCE(int i) {
			return getToken(FormativeExamGrammarParser.SENTENCE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitDescription(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				match(SENTENCE);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(82);
					match(NEWLINE);
					}
					}
					setState(87);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			setState(92);
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
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public List<Matching_questionContext> matching_question() {
			return getRuleContexts(Matching_questionContext.class);
		}
		public Matching_questionContext matching_question(int i) {
			return getRuleContext(Matching_questionContext.class,i);
		}
		public List<Multiple_choice_questionContext> multiple_choice_question() {
			return getRuleContexts(Multiple_choice_questionContext.class);
		}
		public Multiple_choice_questionContext multiple_choice_question(int i) {
			return getRuleContext(Multiple_choice_questionContext.class,i);
		}
		public List<Open_questionContext> open_question() {
			return getRuleContexts(Open_questionContext.class);
		}
		public Open_questionContext open_question(int i) {
			return getRuleContext(Open_questionContext.class,i);
		}
		public List<Missing_words_questionContext> missing_words_question() {
			return getRuleContexts(Missing_words_questionContext.class);
		}
		public Missing_words_questionContext missing_words_question(int i) {
			return getRuleContext(Missing_words_questionContext.class,i);
		}
		public List<True_false_questionContext> true_false_question() {
			return getRuleContexts(True_false_questionContext.class);
		}
		public True_false_questionContext true_false_question(int i) {
			return getRuleContext(True_false_questionContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitSection(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			section_header();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(95);
				match(NEWLINE);
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(106);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(101);
					matching_question();
					}
					break;
				case 2:
					{
					setState(102);
					multiple_choice_question();
					}
					break;
				case 3:
					{
					setState(103);
					open_question();
					}
					break;
				case 4:
					{
					setState(104);
					missing_words_question();
					}
					break;
				case 5:
					{
					setState(105);
					true_false_question();
					}
					break;
				}
				}
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==QUESTION_DEFINITION_SYMBOL );
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(110);
				match(NEWLINE);
				}
				}
				setState(115);
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
		public List<TerminalNode> SECTION_HEADER_SYMBOL() { return getTokens(FormativeExamGrammarParser.SECTION_HEADER_SYMBOL); }
		public TerminalNode SECTION_HEADER_SYMBOL(int i) {
			return getToken(FormativeExamGrammarParser.SECTION_HEADER_SYMBOL, i);
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
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterSection_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitSection_header(this);
		}
	}

	public final Section_headerContext section_header() throws RecognitionException {
		Section_headerContext _localctx = new Section_headerContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_section_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(SECTION_HEADER_SYMBOL);
			setState(117);
			title();
			setState(118);
			match(SECTION_HEADER_SYMBOL);
			setState(119);
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
	public static class Question_headerContext extends ParserRuleContext {
		public TerminalNode SENTENCE() { return getToken(FormativeExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public Question_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterQuestion_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitQuestion_header(this);
		}
	}

	public final Question_headerContext question_header() throws RecognitionException {
		Question_headerContext _localctx = new Question_headerContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_question_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(SENTENCE);
			setState(122);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(FormativeExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode INT() { return getToken(FormativeExamGrammarParser.INT, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public Question_gradeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question_grade; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterQuestion_grade(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitQuestion_grade(this);
		}
	}

	public final Question_gradeContext question_grade() throws RecognitionException {
		Question_gradeContext _localctx = new Question_gradeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_question_grade);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(125);
			match(INT);
			setState(126);
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
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMatching_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMatching_question(this);
		}
	}

	public final Matching_questionContext matching_question() throws RecognitionException {
		Matching_questionContext _localctx = new Matching_questionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_matching_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			matching_question_definition();
			setState(129);
			question_grade();
			setState(130);
			question_header();
			setState(131);
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
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMultiple_choice_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMultiple_choice_question(this);
		}
	}

	public final Multiple_choice_questionContext multiple_choice_question() throws RecognitionException {
		Multiple_choice_questionContext _localctx = new Multiple_choice_questionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_multiple_choice_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			multiple_choice_definition();
			setState(134);
			question_grade();
			setState(135);
			question_header();
			setState(136);
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
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterOpen_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitOpen_question(this);
		}
	}

	public final Open_questionContext open_question() throws RecognitionException {
		Open_questionContext _localctx = new Open_questionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_open_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			open_questions_definition();
			setState(139);
			question_grade();
			setState(140);
			question_header();
			setState(141);
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
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMissing_words_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMissing_words_question(this);
		}
	}

	public final Missing_words_questionContext missing_words_question() throws RecognitionException {
		Missing_words_questionContext _localctx = new Missing_words_questionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_missing_words_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			missing_words_definition();
			setState(144);
			question_grade();
			setState(145);
			question_header();
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(146);
				subquestion();
				setState(147);
				answer_list();
				}
				}
				setState(151); 
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
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTrue_false_question(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTrue_false_question(this);
		}
	}

	public final True_false_questionContext true_false_question() throws RecognitionException {
		True_false_questionContext _localctx = new True_false_questionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_true_false_question);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			true_false_definition();
			setState(154);
			question_grade();
			setState(155);
			question_header();
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				subquestion();
				setState(157);
				true_false_answer();
				}
				}
				setState(161); 
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(FormativeExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public Matching_question_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_question_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMatching_question_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMatching_question_definition(this);
		}
	}

	public final Matching_question_definitionContext matching_question_definition() throws RecognitionException {
		Matching_question_definitionContext _localctx = new Matching_question_definitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_matching_question_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(164);
			match(T__0);
			setState(165);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(FormativeExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public Multiple_choice_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMultiple_choice_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMultiple_choice_definition(this);
		}
	}

	public final Multiple_choice_definitionContext multiple_choice_definition() throws RecognitionException {
		Multiple_choice_definitionContext _localctx = new Multiple_choice_definitionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multiple_choice_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(168);
			match(T__1);
			setState(169);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(FormativeExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public Open_questions_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_questions_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterOpen_questions_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitOpen_questions_definition(this);
		}
	}

	public final Open_questions_definitionContext open_questions_definition() throws RecognitionException {
		Open_questions_definitionContext _localctx = new Open_questions_definitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_open_questions_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(172);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(173);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(FormativeExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public Missing_words_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_missing_words_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMissing_words_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMissing_words_definition(this);
		}
	}

	public final Missing_words_definitionContext missing_words_definition() throws RecognitionException {
		Missing_words_definitionContext _localctx = new Missing_words_definitionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_missing_words_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(176);
			match(T__4);
			setState(177);
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
		public TerminalNode QUESTION_DEFINITION_SYMBOL() { return getToken(FormativeExamGrammarParser.QUESTION_DEFINITION_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public True_false_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTrue_false_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTrue_false_definition(this);
		}
	}

	public final True_false_definitionContext true_false_definition() throws RecognitionException {
		True_false_definitionContext _localctx = new True_false_definitionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_true_false_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(QUESTION_DEFINITION_SYMBOL);
			setState(180);
			match(T__5);
			setState(181);
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
		public TerminalNode SENTENCE() { return getToken(FormativeExamGrammarParser.SENTENCE, 0); }
		public TerminalNode ANSWER_SPACING() { return getToken(FormativeExamGrammarParser.ANSWER_SPACING, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(FormativeExamGrammarParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(FormativeExamGrammarParser.WHITESPACE, i);
		}
		public SubquestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subquestion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterSubquestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitSubquestion(this);
		}
	}

	public final SubquestionContext subquestion() throws RecognitionException {
		SubquestionContext _localctx = new SubquestionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_subquestion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(SENTENCE);
			setState(184);
			match(ANSWER_SPACING);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(185);
				match(WHITESPACE);
				}
				}
				setState(190);
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
		public TerminalNode WRONG_ANSWER_SYMBOL() { return getToken(FormativeExamGrammarParser.WRONG_ANSWER_SYMBOL, 0); }
		public TerminalNode SENTENCE() { return getToken(FormativeExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Wrong_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wrong_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterWrong_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitWrong_answer(this);
		}
	}

	public final Wrong_answerContext wrong_answer() throws RecognitionException {
		Wrong_answerContext _localctx = new Wrong_answerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_wrong_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(WRONG_ANSWER_SYMBOL);
			setState(192);
			match(SENTENCE);
			setState(193);
			match(END_SYMBOL);
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(194);
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
		public TerminalNode CORRECT_ANSWER_SYMBOL() { return getToken(FormativeExamGrammarParser.CORRECT_ANSWER_SYMBOL, 0); }
		public TerminalNode SENTENCE() { return getToken(FormativeExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Correct_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_correct_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterCorrect_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitCorrect_answer(this);
		}
	}

	public final Correct_answerContext correct_answer() throws RecognitionException {
		Correct_answerContext _localctx = new Correct_answerContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_correct_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(CORRECT_ANSWER_SYMBOL);
			setState(198);
			match(SENTENCE);
			setState(199);
			match(END_SYMBOL);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(200);
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
		public TerminalNode OPEN_BRACKET() { return getToken(FormativeExamGrammarParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(FormativeExamGrammarParser.CLOSING_BRACKET, 0); }
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
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public Answer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_answer_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterAnswer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitAnswer_list(this);
		}
	}

	public final Answer_listContext answer_list() throws RecognitionException {
		Answer_listContext _localctx = new Answer_listContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_answer_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(OPEN_BRACKET);
			setState(206); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(206);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case WRONG_ANSWER_SYMBOL:
					{
					setState(204);
					wrong_answer();
					}
					break;
				case CORRECT_ANSWER_SYMBOL:
					{
					setState(205);
					correct_answer();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(208); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CORRECT_ANSWER_SYMBOL || _la==WRONG_ANSWER_SYMBOL );
			setState(210);
			match(CLOSING_BRACKET);
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(211);
					match(NEWLINE);
					}
					} 
				}
				setState(216);
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
		public TerminalNode CORRECT_ANSWER_SYMBOL() { return getToken(FormativeExamGrammarParser.CORRECT_ANSWER_SYMBOL, 0); }
		public List<TerminalNode> PERCENTAGE() { return getTokens(FormativeExamGrammarParser.PERCENTAGE); }
		public TerminalNode PERCENTAGE(int i) {
			return getToken(FormativeExamGrammarParser.PERCENTAGE, i);
		}
		public TerminalNode INT() { return getToken(FormativeExamGrammarParser.INT, 0); }
		public TerminalNode SENTENCE() { return getToken(FormativeExamGrammarParser.SENTENCE, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public Open_questions_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_questions_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterOpen_questions_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitOpen_questions_answer(this);
		}
	}

	public final Open_questions_answerContext open_questions_answer() throws RecognitionException {
		Open_questions_answerContext _localctx = new Open_questions_answerContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_open_questions_answer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(CORRECT_ANSWER_SYMBOL);
			setState(218);
			match(PERCENTAGE);
			setState(219);
			match(INT);
			setState(220);
			match(PERCENTAGE);
			setState(221);
			match(SENTENCE);
			setState(222);
			match(END_SYMBOL);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(223);
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
		public TerminalNode OPEN_BRACKET() { return getToken(FormativeExamGrammarParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(FormativeExamGrammarParser.CLOSING_BRACKET, 0); }
		public List<Open_questions_answerContext> open_questions_answer() {
			return getRuleContexts(Open_questions_answerContext.class);
		}
		public Open_questions_answerContext open_questions_answer(int i) {
			return getRuleContext(Open_questions_answerContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public Open_questions_answer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_questions_answer_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterOpen_questions_answer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitOpen_questions_answer_list(this);
		}
	}

	public final Open_questions_answer_listContext open_questions_answer_list() throws RecognitionException {
		Open_questions_answer_listContext _localctx = new Open_questions_answer_listContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_open_questions_answer_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(OPEN_BRACKET);
			setState(228); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(227);
				open_questions_answer();
				}
				}
				setState(230); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CORRECT_ANSWER_SYMBOL );
			setState(232);
			match(CLOSING_BRACKET);
			setState(236);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(233);
					match(NEWLINE);
					}
					} 
				}
				setState(238);
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
		public TerminalNode OPEN_BRACKET() { return getToken(FormativeExamGrammarParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSING_BRACKET() { return getToken(FormativeExamGrammarParser.CLOSING_BRACKET, 0); }
		public List<TerminalNode> SENTENCE() { return getTokens(FormativeExamGrammarParser.SENTENCE); }
		public TerminalNode SENTENCE(int i) {
			return getToken(FormativeExamGrammarParser.SENTENCE, i);
		}
		public List<TerminalNode> END_SYMBOL() { return getTokens(FormativeExamGrammarParser.END_SYMBOL); }
		public TerminalNode END_SYMBOL(int i) {
			return getToken(FormativeExamGrammarParser.END_SYMBOL, i);
		}
		public List<TerminalNode> CORRECT_ANSWER_SYMBOL() { return getTokens(FormativeExamGrammarParser.CORRECT_ANSWER_SYMBOL); }
		public TerminalNode CORRECT_ANSWER_SYMBOL(int i) {
			return getToken(FormativeExamGrammarParser.CORRECT_ANSWER_SYMBOL, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
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
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterMatching_answers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitMatching_answers(this);
		}
	}

	public final Matching_answersContext matching_answers() throws RecognitionException {
		Matching_answersContext _localctx = new Matching_answersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_matching_answers);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(OPEN_BRACKET);
			setState(248); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(240);
				match(SENTENCE);
				setState(241);
				match(END_SYMBOL);
				setState(242);
				match(CORRECT_ANSWER_SYMBOL);
				setState(243);
				match(SENTENCE);
				setState(244);
				match(END_SYMBOL);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FEEDBACK_SYMBOL) {
					{
					setState(245);
					feedback();
					}
				}

				}
				}
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			setState(252);
			match(CLOSING_BRACKET);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(253);
					match(NEWLINE);
					}
					} 
				}
				setState(258);
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
		public TerminalNode OPEN_BRACKET() { return getToken(FormativeExamGrammarParser.OPEN_BRACKET, 0); }
		public True_falseContext true_false() {
			return getRuleContext(True_falseContext.class,0);
		}
		public TerminalNode CLOSING_BRACKET() { return getToken(FormativeExamGrammarParser.CLOSING_BRACKET, 0); }
		public FeedbackContext feedback() {
			return getRuleContext(FeedbackContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public True_false_answerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_answer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTrue_false_answer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTrue_false_answer(this);
		}
	}

	public final True_false_answerContext true_false_answer() throws RecognitionException {
		True_false_answerContext _localctx = new True_false_answerContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_true_false_answer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(OPEN_BRACKET);
			setState(260);
			true_false();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FEEDBACK_SYMBOL) {
				{
				setState(261);
				feedback();
				}
			}

			setState(264);
			match(CLOSING_BRACKET);
			setState(268);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(265);
					match(NEWLINE);
					}
					} 
				}
				setState(270);
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
		public TerminalNode CORRECT_ANSWER_SYMBOL() { return getToken(FormativeExamGrammarParser.CORRECT_ANSWER_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public True_falseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterTrue_false(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitTrue_false(this);
		}
	}

	public final True_falseContext true_false() throws RecognitionException {
		True_falseContext _localctx = new True_falseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_true_false);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(CORRECT_ANSWER_SYMBOL);
			setState(272);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1920L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(273);
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
		public TerminalNode FEEDBACK_SYMBOL() { return getToken(FormativeExamGrammarParser.FEEDBACK_SYMBOL, 0); }
		public TerminalNode END_SYMBOL() { return getToken(FormativeExamGrammarParser.END_SYMBOL, 0); }
		public List<TerminalNode> SENTENCE() { return getTokens(FormativeExamGrammarParser.SENTENCE); }
		public TerminalNode SENTENCE(int i) {
			return getToken(FormativeExamGrammarParser.SENTENCE, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormativeExamGrammarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormativeExamGrammarParser.NEWLINE, i);
		}
		public FeedbackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feedback; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).enterFeedback(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormativeExamGrammarListener ) ((FormativeExamGrammarListener)listener).exitFeedback(this);
		}
	}

	public final FeedbackContext feedback() throws RecognitionException {
		FeedbackContext _localctx = new FeedbackContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_feedback);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(FEEDBACK_SYMBOL);
			setState(283); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(276);
				match(SENTENCE);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(277);
					match(NEWLINE);
					}
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(285); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SENTENCE );
			setState(287);
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
		"\u0004\u0001\u001c\u0122\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0005\u0001@\b\u0001\n\u0001\f\u0001C\t\u0001\u0001"+
		"\u0001\u0004\u0001F\b\u0001\u000b\u0001\f\u0001G\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0005\u0004T\b\u0004\n\u0004\f\u0004W\t\u0004"+
		"\u0004\u0004Y\b\u0004\u000b\u0004\f\u0004Z\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0005\u0005a\b\u0005\n\u0005\f\u0005d\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005k\b"+
		"\u0005\u000b\u0005\f\u0005l\u0001\u0005\u0005\u0005p\b\u0005\n\u0005\f"+
		"\u0005s\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u0096\b\f\u000b"+
		"\f\f\f\u0097\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u00a0"+
		"\b\r\u000b\r\f\r\u00a1\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u00bb\b\u0013\n\u0013\f\u0013\u00be\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00c4\b\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00ca\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0004\u0016\u00cf\b\u0016\u000b\u0016\f"+
		"\u0016\u00d0\u0001\u0016\u0001\u0016\u0005\u0016\u00d5\b\u0016\n\u0016"+
		"\f\u0016\u00d8\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00e1\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0004\u0018\u00e5\b\u0018\u000b\u0018\f\u0018\u00e6\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u00eb\b\u0018\n\u0018\f\u0018\u00ee\t\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u00f7\b\u0019\u0004\u0019\u00f9\b\u0019\u000b"+
		"\u0019\f\u0019\u00fa\u0001\u0019\u0001\u0019\u0005\u0019\u00ff\b\u0019"+
		"\n\u0019\f\u0019\u0102\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u0107\b\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u010b\b\u001a"+
		"\n\u001a\f\u001a\u010e\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0117\b\u001c\n"+
		"\u001c\f\u001c\u011a\t\u001c\u0004\u001c\u011c\b\u001c\u000b\u001c\f\u001c"+
		"\u011d\u0001\u001c\u0001\u001c\u0001\u001c\u0004\u00d6\u00ec\u0100\u010c"+
		"\u0000\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468\u0000\u0002\u0001\u0000\u0003\u0004"+
		"\u0001\u0000\u0007\n\u0121\u0000:\u0001\u0000\u0000\u0000\u0002=\u0001"+
		"\u0000\u0000\u0000\u0004I\u0001\u0000\u0000\u0000\u0006N\u0001\u0000\u0000"+
		"\u0000\bX\u0001\u0000\u0000\u0000\n^\u0001\u0000\u0000\u0000\ft\u0001"+
		"\u0000\u0000\u0000\u000ey\u0001\u0000\u0000\u0000\u0010|\u0001\u0000\u0000"+
		"\u0000\u0012\u0080\u0001\u0000\u0000\u0000\u0014\u0085\u0001\u0000\u0000"+
		"\u0000\u0016\u008a\u0001\u0000\u0000\u0000\u0018\u008f\u0001\u0000\u0000"+
		"\u0000\u001a\u0099\u0001\u0000\u0000\u0000\u001c\u00a3\u0001\u0000\u0000"+
		"\u0000\u001e\u00a7\u0001\u0000\u0000\u0000 \u00ab\u0001\u0000\u0000\u0000"+
		"\"\u00af\u0001\u0000\u0000\u0000$\u00b3\u0001\u0000\u0000\u0000&\u00b7"+
		"\u0001\u0000\u0000\u0000(\u00bf\u0001\u0000\u0000\u0000*\u00c5\u0001\u0000"+
		"\u0000\u0000,\u00cb\u0001\u0000\u0000\u0000.\u00d9\u0001\u0000\u0000\u0000"+
		"0\u00e2\u0001\u0000\u0000\u00002\u00ef\u0001\u0000\u0000\u00004\u0103"+
		"\u0001\u0000\u0000\u00006\u010f\u0001\u0000\u0000\u00008\u0113\u0001\u0000"+
		"\u0000\u0000:;\u0003\u0002\u0001\u0000;<\u0005\u0000\u0000\u0001<\u0001"+
		"\u0001\u0000\u0000\u0000=A\u0003\u0004\u0002\u0000>@\u0005\u001c\u0000"+
		"\u0000?>\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001"+
		"\u0000\u0000\u0000DF\u0003\n\u0005\u0000ED\u0001\u0000\u0000\u0000FG\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"H\u0003\u0001\u0000\u0000\u0000IJ\u0005\u000b\u0000\u0000JK\u0003\u0006"+
		"\u0003\u0000KL\u0005\u000b\u0000\u0000LM\u0003\b\u0004\u0000M\u0005\u0001"+
		"\u0000\u0000\u0000NO\u0005\u0019\u0000\u0000OP\u0005\u0015\u0000\u0000"+
		"P\u0007\u0001\u0000\u0000\u0000QU\u0005\u0019\u0000\u0000RT\u0005\u001c"+
		"\u0000\u0000SR\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000"+
		"WU\u0001\u0000\u0000\u0000XQ\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\]\u0005\u0015\u0000\u0000]\t\u0001\u0000\u0000\u0000^b\u0003"+
		"\f\u0006\u0000_a\u0005\u001c\u0000\u0000`_\u0001\u0000\u0000\u0000ad\u0001"+
		"\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"cj\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000ek\u0003\u0012\t\u0000"+
		"fk\u0003\u0014\n\u0000gk\u0003\u0016\u000b\u0000hk\u0003\u0018\f\u0000"+
		"ik\u0003\u001a\r\u0000je\u0001\u0000\u0000\u0000jf\u0001\u0000\u0000\u0000"+
		"jg\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mq\u0001\u0000\u0000\u0000np\u0005\u001c\u0000\u0000on\u0001"+
		"\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000"+
		"qr\u0001\u0000\u0000\u0000r\u000b\u0001\u0000\u0000\u0000sq\u0001\u0000"+
		"\u0000\u0000tu\u0005\f\u0000\u0000uv\u0003\u0006\u0003\u0000vw\u0005\f"+
		"\u0000\u0000wx\u0003\b\u0004\u0000x\r\u0001\u0000\u0000\u0000yz\u0005"+
		"\u0019\u0000\u0000z{\u0005\u0015\u0000\u0000{\u000f\u0001\u0000\u0000"+
		"\u0000|}\u0005\r\u0000\u0000}~\u0005\u0016\u0000\u0000~\u007f\u0005\u0015"+
		"\u0000\u0000\u007f\u0011\u0001\u0000\u0000\u0000\u0080\u0081\u0003\u001c"+
		"\u000e\u0000\u0081\u0082\u0003\u0010\b\u0000\u0082\u0083\u0003\u000e\u0007"+
		"\u0000\u0083\u0084\u00032\u0019\u0000\u0084\u0013\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0003\u001e\u000f\u0000\u0086\u0087\u0003\u0010\b\u0000\u0087"+
		"\u0088\u0003\u000e\u0007\u0000\u0088\u0089\u0003,\u0016\u0000\u0089\u0015"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0003 \u0010\u0000\u008b\u008c\u0003"+
		"\u0010\b\u0000\u008c\u008d\u0003\u000e\u0007\u0000\u008d\u008e\u00030"+
		"\u0018\u0000\u008e\u0017\u0001\u0000\u0000\u0000\u008f\u0090\u0003\"\u0011"+
		"\u0000\u0090\u0091\u0003\u0010\b\u0000\u0091\u0095\u0003\u000e\u0007\u0000"+
		"\u0092\u0093\u0003&\u0013\u0000\u0093\u0094\u0003,\u0016\u0000\u0094\u0096"+
		"\u0001\u0000\u0000\u0000\u0095\u0092\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0001\u0000\u0000\u0000\u0098\u0019\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0003$\u0012\u0000\u009a\u009b\u0003\u0010\b\u0000\u009b\u009f\u0003"+
		"\u000e\u0007\u0000\u009c\u009d\u0003&\u0013\u0000\u009d\u009e\u00034\u001a"+
		"\u0000\u009e\u00a0\u0001\u0000\u0000\u0000\u009f\u009c\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u001b\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0005\r\u0000\u0000\u00a4\u00a5\u0005\u0001\u0000\u0000"+
		"\u00a5\u00a6\u0005\u0015\u0000\u0000\u00a6\u001d\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0005\r\u0000\u0000\u00a8\u00a9\u0005\u0002\u0000\u0000\u00a9"+
		"\u00aa\u0005\u0015\u0000\u0000\u00aa\u001f\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0005\r\u0000\u0000\u00ac\u00ad\u0007\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0005\u0015\u0000\u0000\u00ae!\u0001\u0000\u0000\u0000\u00af\u00b0\u0005"+
		"\r\u0000\u0000\u00b0\u00b1\u0005\u0005\u0000\u0000\u00b1\u00b2\u0005\u0015"+
		"\u0000\u0000\u00b2#\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\r\u0000"+
		"\u0000\u00b4\u00b5\u0005\u0006\u0000\u0000\u00b5\u00b6\u0005\u0015\u0000"+
		"\u0000\u00b6%\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u0019\u0000\u0000"+
		"\u00b8\u00bc\u0005\u0011\u0000\u0000\u00b9\u00bb\u0005\u001b\u0000\u0000"+
		"\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000"+
		"\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bd\'\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0005\u0013\u0000\u0000\u00c0\u00c1\u0005\u0019\u0000\u0000\u00c1"+
		"\u00c3\u0005\u0015\u0000\u0000\u00c2\u00c4\u00038\u001c\u0000\u00c3\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4)\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0005\u0012\u0000\u0000\u00c6\u00c7\u0005"+
		"\u0019\u0000\u0000\u00c7\u00c9\u0005\u0015\u0000\u0000\u00c8\u00ca\u0003"+
		"8\u001c\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ca+\u0001\u0000\u0000\u0000\u00cb\u00ce\u0005\u000f\u0000"+
		"\u0000\u00cc\u00cf\u0003(\u0014\u0000\u00cd\u00cf\u0003*\u0015\u0000\u00ce"+
		"\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d6\u0005\u0010\u0000\u0000\u00d3\u00d5\u0005\u001c\u0000\u0000\u00d4"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7"+
		"-\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0005\u0012\u0000\u0000\u00da\u00db\u0005\u000e\u0000\u0000\u00db\u00dc"+
		"\u0005\u0016\u0000\u0000\u00dc\u00dd\u0005\u000e\u0000\u0000\u00dd\u00de"+
		"\u0005\u0019\u0000\u0000\u00de\u00e0\u0005\u0015\u0000\u0000\u00df\u00e1"+
		"\u00038\u001c\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e1/\u0001\u0000\u0000\u0000\u00e2\u00e4\u0005\u000f"+
		"\u0000\u0000\u00e3\u00e5\u0003.\u0017\u0000\u00e4\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e8\u00ec\u0005\u0010\u0000\u0000\u00e9\u00eb\u0005\u001c\u0000"+
		"\u0000\u00ea\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ec\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ed1\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f8\u0005\u000f\u0000\u0000\u00f0\u00f1\u0005\u0019\u0000\u0000"+
		"\u00f1\u00f2\u0005\u0015\u0000\u0000\u00f2\u00f3\u0005\u0012\u0000\u0000"+
		"\u00f3\u00f4\u0005\u0019\u0000\u0000\u00f4\u00f6\u0005\u0015\u0000\u0000"+
		"\u00f5\u00f7\u00038\u001c\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f9\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f0\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa"+
		"\u00f8\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fc\u0100\u0005\u0010\u0000\u0000\u00fd"+
		"\u00ff\u0005\u001c\u0000\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff"+
		"\u0102\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000\u0100"+
		"\u00fe\u0001\u0000\u0000\u0000\u01013\u0001\u0000\u0000\u0000\u0102\u0100"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u0005\u000f\u0000\u0000\u0104\u0106"+
		"\u00036\u001b\u0000\u0105\u0107\u00038\u001c\u0000\u0106\u0105\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000"+
		"\u0000\u0000\u0108\u010c\u0005\u0010\u0000\u0000\u0109\u010b\u0005\u001c"+
		"\u0000\u0000\u010a\u0109\u0001\u0000\u0000\u0000\u010b\u010e\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010c\u010a\u0001\u0000"+
		"\u0000\u0000\u010d5\u0001\u0000\u0000\u0000\u010e\u010c\u0001\u0000\u0000"+
		"\u0000\u010f\u0110\u0005\u0012\u0000\u0000\u0110\u0111\u0007\u0001\u0000"+
		"\u0000\u0111\u0112\u0005\u0015\u0000\u0000\u01127\u0001\u0000\u0000\u0000"+
		"\u0113\u011b\u0005\u0014\u0000\u0000\u0114\u0118\u0005\u0019\u0000\u0000"+
		"\u0115\u0117\u0005\u001c\u0000\u0000\u0116\u0115\u0001\u0000\u0000\u0000"+
		"\u0117\u011a\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000"+
		"\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u011c\u0001\u0000\u0000\u0000"+
		"\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u0114\u0001\u0000\u0000\u0000"+
		"\u011c\u011d\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000"+
		"\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000"+
		"\u011f\u0120\u0005\u0015\u0000\u0000\u01209\u0001\u0000\u0000\u0000\u001a"+
		"AGUZbjlq\u0097\u00a1\u00bc\u00c3\u00c9\u00ce\u00d0\u00d6\u00e0\u00e6\u00ec"+
		"\u00f6\u00fa\u0100\u0106\u010c\u0118\u011d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}