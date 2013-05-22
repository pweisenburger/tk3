// Generated from src/tk3/labyrinth/map/generator/grammar/MapGrammar.g4 by ANTLR 4.0

    package tk3.labyrinth.map.generator.grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapGrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, TYPE=4, MAXIMUM=5, NAME=6, ID=7, ACTIVATE=8, GOAL=9, 
		FIELD=10, DOOR=11, BUTTON=12, ROOM=13, START=14, FINISH=15, STRING=16, 
		N=17, WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"','", "''", "'='", "'type'", "'max'", "'name'", "'id'", "'activate'", 
		"'goal'", "'field'", "'door'", "'button'", "'room'", "'start'", "'finish'", 
		"STRING", "N", "WS"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "TYPE", "MAXIMUM", "NAME", "ID", "ACTIVATE", "GOAL", 
		"FIELD", "DOOR", "BUTTON", "ROOM", "START", "FINISH", "STRING", "N", "WS"
	};


	public MapGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MapGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 17: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\24\u0082\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\3\2\3\2\3\3\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\21\6\21q\n\21\r\21\16\21r\3\22\3\22\7\22w\n\22\f\22\16\22z\13\22\3\23"+
		"\6\23}\n\23\r\23\16\23~\3\23\3\23\2\24\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1"+
		"\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37"+
		"\21\1!\22\1#\23\1%\24\2\3\2\6\5\62;c|~~\3\63;\3\62;\5\13\f\17\17\"\"\u0083"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7*\3\2\2\2\t,\3\2\2\2\13\61\3\2"+
		"\2\2\r\65\3\2\2\2\17:\3\2\2\2\21=\3\2\2\2\23F\3\2\2\2\25K\3\2\2\2\27Q"+
		"\3\2\2\2\31V\3\2\2\2\33]\3\2\2\2\35b\3\2\2\2\37h\3\2\2\2!p\3\2\2\2#t\3"+
		"\2\2\2%|\3\2\2\2\'(\7.\2\2(\4\3\2\2\2*+\7?\2\2+\b\3\2\2\2,-\7v\2\2-.\7"+
		"{\2\2./\7r\2\2/\60\7g\2\2\60\n\3\2\2\2\61\62\7o\2\2\62\63\7c\2\2\63\64"+
		"\7z\2\2\64\f\3\2\2\2\65\66\7p\2\2\66\67\7c\2\2\678\7o\2\289\7g\2\29\16"+
		"\3\2\2\2:;\7k\2\2;<\7f\2\2<\20\3\2\2\2=>\7c\2\2>?\7e\2\2?@\7v\2\2@A\7"+
		"k\2\2AB\7x\2\2BC\7c\2\2CD\7v\2\2DE\7g\2\2E\22\3\2\2\2FG\7i\2\2GH\7q\2"+
		"\2HI\7c\2\2IJ\7n\2\2J\24\3\2\2\2KL\7h\2\2LM\7k\2\2MN\7g\2\2NO\7n\2\2O"+
		"P\7f\2\2P\26\3\2\2\2QR\7f\2\2RS\7q\2\2ST\7q\2\2TU\7t\2\2U\30\3\2\2\2V"+
		"W\7d\2\2WX\7w\2\2XY\7v\2\2YZ\7v\2\2Z[\7q\2\2[\\\7p\2\2\\\32\3\2\2\2]^"+
		"\7t\2\2^_\7q\2\2_`\7q\2\2`a\7o\2\2a\34\3\2\2\2bc\7u\2\2cd\7v\2\2de\7c"+
		"\2\2ef\7t\2\2fg\7v\2\2g\36\3\2\2\2hi\7h\2\2ij\7k\2\2jk\7p\2\2kl\7k\2\2"+
		"lm\7u\2\2mn\7j\2\2n \3\2\2\2oq\t\2\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2r"+
		"s\3\2\2\2s\"\3\2\2\2tx\t\3\2\2uw\t\4\2\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2"+
		"xy\3\2\2\2y$\3\2\2\2zx\3\2\2\2{}\t\5\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2"+
		"~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\b\23\2\2\u0081&\3\2\2\2\6"+
		"\2rx~";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}