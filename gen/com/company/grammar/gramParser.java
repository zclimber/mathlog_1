// Generated from C:/Users/MY/IdeaProjects/mathlog_1/src\gram.g4 by ANTLR 4.7
package com.company.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TERMINATOR=1, WS=2, NAME=3, COMMA=4, TARGET=5, MEANS=6, OR=7, AND=8, NOT=9, 
		LPAREN=10, RPAREN=11;
	public static final int
		RULE_file = 0, RULE_header = 1, RULE_rootExpression = 2, RULE_expression = 3, 
		RULE_disj = 4, RULE_conj = 5, RULE_neg = 6;
	public static final String[] ruleNames = {
		"file", "header", "rootExpression", "expression", "disj", "conj", "neg"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, "','", "'|-'", "'->'", "'|'", "'&'", "'!'", "'('", 
		"')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "TERMINATOR", "WS", "NAME", "COMMA", "TARGET", "MEANS", "OR", "AND", 
		"NOT", "LPAREN", "RPAREN"
	};
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
	public String getGrammarFileName() { return "gram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public gramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FileContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<TerminalNode> TERMINATOR() { return getTokens(gramParser.TERMINATOR); }
		public TerminalNode TERMINATOR(int i) {
			return getToken(gramParser.TERMINATOR, i);
		}
		public List<RootExpressionContext> rootExpression() {
			return getRuleContexts(RootExpressionContext.class);
		}
		public RootExpressionContext rootExpression(int i) {
			return getRuleContext(RootExpressionContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitFile(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			header();
			setState(15);
			match(TERMINATOR);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << NOT) | (1L << LPAREN))) != 0)) {
				{
				{
				setState(16);
				rootExpression();
				setState(17);
				match(TERMINATOR);
				}
				}
				setState(23);
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

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode TARGET() { return getToken(gramParser.TARGET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(gramParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(gramParser.COMMA, i);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << NOT) | (1L << LPAREN))) != 0)) {
				{
				setState(24);
				expression();
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(25);
					match(COMMA);
					setState(26);
					expression();
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(34);
			match(TARGET);
			setState(35);
			expression();
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

	public static class RootExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RootExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterRootExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitRootExpression(this);
		}
	}

	public final RootExpressionContext rootExpression() throws RecognitionException {
		RootExpressionContext _localctx = new RootExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rootExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			expression();
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

	public static class ExpressionContext extends ParserRuleContext {
		public DisjContext disj() {
			return getRuleContext(DisjContext.class,0);
		}
		public TerminalNode MEANS() { return getToken(gramParser.MEANS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		try {
			setState(44);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				disj(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(40);
				disj(0);
				setState(41);
				match(MEANS);
				setState(42);
				expression();
				}
				}
				break;
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

	public static class DisjContext extends ParserRuleContext {
		public ConjContext conj() {
			return getRuleContext(ConjContext.class,0);
		}
		public DisjContext disj() {
			return getRuleContext(DisjContext.class,0);
		}
		public TerminalNode OR() { return getToken(gramParser.OR, 0); }
		public DisjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterDisj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitDisj(this);
		}
	}

	public final DisjContext disj() throws RecognitionException {
		return disj(0);
	}

	private DisjContext disj(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DisjContext _localctx = new DisjContext(_ctx, _parentState);
		DisjContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_disj, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(47);
			conj(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DisjContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_disj);
					setState(49);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(50);
					match(OR);
					setState(51);
					conj(0);
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConjContext extends ParserRuleContext {
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public ConjContext conj() {
			return getRuleContext(ConjContext.class,0);
		}
		public TerminalNode AND() { return getToken(gramParser.AND, 0); }
		public ConjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterConj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitConj(this);
		}
	}

	public final ConjContext conj() throws RecognitionException {
		return conj(0);
	}

	private ConjContext conj(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConjContext _localctx = new ConjContext(_ctx, _parentState);
		ConjContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_conj, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(58);
			neg();
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConjContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conj);
					setState(60);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(61);
					match(AND);
					setState(62);
					neg();
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NegContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(gramParser.NAME, 0); }
		public TerminalNode NOT() { return getToken(gramParser.NOT, 0); }
		public NegContext neg() {
			return getRuleContext(NegContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(gramParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(gramParser.RPAREN, 0); }
		public NegContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_neg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).enterNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof gramListener ) ((gramListener)listener).exitNeg(this);
		}
	}

	public final NegContext neg() throws RecognitionException {
		NegContext _localctx = new NegContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_neg);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(NAME);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				match(NOT);
				setState(70);
				neg();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				match(LPAREN);
				setState(72);
				expression();
				setState(73);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return disj_sempred((DisjContext)_localctx, predIndex);
		case 5:
			return conj_sempred((ConjContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean disj_sempred(DisjContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conj_sempred(ConjContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rP\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\3\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\5\3#\n\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\5\5/\n\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\7\6\67\n\6\f\6\16\6:\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7B\n\7\f\7\16\7"+
		"E\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bN\n\b\3\b\2\4\n\f\t\2\4\6\b\n\f"+
		"\16\2\2\2P\2\20\3\2\2\2\4\"\3\2\2\2\6\'\3\2\2\2\b.\3\2\2\2\n\60\3\2\2"+
		"\2\f;\3\2\2\2\16M\3\2\2\2\20\21\5\4\3\2\21\27\7\3\2\2\22\23\5\6\4\2\23"+
		"\24\7\3\2\2\24\26\3\2\2\2\25\22\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27"+
		"\30\3\2\2\2\30\3\3\2\2\2\31\27\3\2\2\2\32\37\5\b\5\2\33\34\7\6\2\2\34"+
		"\36\5\b\5\2\35\33\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 #\3\2"+
		"\2\2!\37\3\2\2\2\"\32\3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\7\7\2\2%&\5\b\5\2"+
		"&\5\3\2\2\2\'(\5\b\5\2(\7\3\2\2\2)/\5\n\6\2*+\5\n\6\2+,\7\b\2\2,-\5\b"+
		"\5\2-/\3\2\2\2.)\3\2\2\2.*\3\2\2\2/\t\3\2\2\2\60\61\b\6\1\2\61\62\5\f"+
		"\7\2\628\3\2\2\2\63\64\f\3\2\2\64\65\7\t\2\2\65\67\5\f\7\2\66\63\3\2\2"+
		"\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\13\3\2\2\2:8\3\2\2\2;<\b\7\1\2<"+
		"=\5\16\b\2=C\3\2\2\2>?\f\3\2\2?@\7\n\2\2@B\5\16\b\2A>\3\2\2\2BE\3\2\2"+
		"\2CA\3\2\2\2CD\3\2\2\2D\r\3\2\2\2EC\3\2\2\2FN\7\5\2\2GH\7\13\2\2HN\5\16"+
		"\b\2IJ\7\f\2\2JK\5\b\5\2KL\7\r\2\2LN\3\2\2\2MF\3\2\2\2MG\3\2\2\2MI\3\2"+
		"\2\2N\17\3\2\2\2\t\27\37\".8CM";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}