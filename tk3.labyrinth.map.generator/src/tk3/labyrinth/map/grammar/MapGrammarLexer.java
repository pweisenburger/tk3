// Generated from src/tk3/labyrinth/map/grammar/MapGrammar.g4 by ANTLR 4.0

    package tk3.labyrinth.map.grammar;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapGrammarLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, TYPE=11, MAXIMUM=12, NAME=13, ID=14, START=15, FINISH=16, STRING=17, 
		N=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'button'", "'door'", "'goal='", "'doors='", "','", "'activate='", "'='", 
		"'field'", "'buttons='", "'room'", "'type'", "'max'", "'name'", "'id'", 
		"'start'", "'finish'", "STRING", "N", "WS"
	};
	public static final String[] ruleNames = {
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "TYPE", "MAXIMUM", "NAME", "ID", "START", "FINISH", "STRING", 
		"N", "WS"
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
		case 18: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\25\u0095\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\6\22\u0084\n\22\r\22\16\22\u0085\3\23\3\23\7\23\u008a"+
		"\n\23\f\23\16\23\u008d\13\23\3\24\6\24\u0090\n\24\r\24\16\24\u0091\3\24"+
		"\3\24\2\25\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1"+
		"\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25"+
		"\2\3\2\6\5\62;c|~~\3\63;\3\62;\5\13\f\17\17\"\"\u0097\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\3)\3\2\2\2\5\60\3\2\2\2\7\65\3\2\2\2\t;\3\2\2\2\13B\3\2\2\2"+
		"\rD\3\2\2\2\17N\3\2\2\2\21P\3\2\2\2\23V\3\2\2\2\25_\3\2\2\2\27d\3\2\2"+
		"\2\31i\3\2\2\2\33m\3\2\2\2\35r\3\2\2\2\37u\3\2\2\2!{\3\2\2\2#\u0083\3"+
		"\2\2\2%\u0087\3\2\2\2\'\u008f\3\2\2\2)*\7d\2\2*+\7w\2\2+,\7v\2\2,-\7v"+
		"\2\2-.\7q\2\2./\7p\2\2/\4\3\2\2\2\60\61\7f\2\2\61\62\7q\2\2\62\63\7q\2"+
		"\2\63\64\7t\2\2\64\6\3\2\2\2\65\66\7i\2\2\66\67\7q\2\2\678\7c\2\289\7"+
		"n\2\29:\7?\2\2:\b\3\2\2\2;<\7f\2\2<=\7q\2\2=>\7q\2\2>?\7t\2\2?@\7u\2\2"+
		"@A\7?\2\2A\n\3\2\2\2BC\7.\2\2C\f\3\2\2\2DE\7c\2\2EF\7e\2\2FG\7v\2\2GH"+
		"\7k\2\2HI\7x\2\2IJ\7c\2\2JK\7v\2\2KL\7g\2\2LM\7?\2\2M\16\3\2\2\2NO\7?"+
		"\2\2O\20\3\2\2\2PQ\7h\2\2QR\7k\2\2RS\7g\2\2ST\7n\2\2TU\7f\2\2U\22\3\2"+
		"\2\2VW\7d\2\2WX\7w\2\2XY\7v\2\2YZ\7v\2\2Z[\7q\2\2[\\\7p\2\2\\]\7u\2\2"+
		"]^\7?\2\2^\24\3\2\2\2_`\7t\2\2`a\7q\2\2ab\7q\2\2bc\7o\2\2c\26\3\2\2\2"+
		"de\7v\2\2ef\7{\2\2fg\7r\2\2gh\7g\2\2h\30\3\2\2\2ij\7o\2\2jk\7c\2\2kl\7"+
		"z\2\2l\32\3\2\2\2mn\7p\2\2no\7c\2\2op\7o\2\2pq\7g\2\2q\34\3\2\2\2rs\7"+
		"k\2\2st\7f\2\2t\36\3\2\2\2uv\7u\2\2vw\7v\2\2wx\7c\2\2xy\7t\2\2yz\7v\2"+
		"\2z \3\2\2\2{|\7h\2\2|}\7k\2\2}~\7p\2\2~\177\7k\2\2\177\u0080\7u\2\2\u0080"+
		"\u0081\7j\2\2\u0081\"\3\2\2\2\u0082\u0084\t\2\2\2\u0083\u0082\3\2\2\2"+
		"\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086$\3"+
		"\2\2\2\u0087\u008b\t\3\2\2\u0088\u008a\t\4\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c&\3\2\2\2"+
		"\u008d\u008b\3\2\2\2\u008e\u0090\t\5\2\2\u008f\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\u0094\b\24\2\2\u0094(\3\2\2\2\6\2\u0085\u008b\u0091";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}