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
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, ID=16, N=17, WS=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'button'", "'door'", "','", "'activate='", "'start'", "'field'", "'finish'", 
		"'room'", "'id='", "'name='", "'door='", "'goal='", "''", "'button='", 
		"'max='", "ID", "N", "WS"
	};
	public static final String[] ruleNames = {
		"T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", 
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "ID", "N", "WS"
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
		"\2\4\24\u008e\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\6\21}\n\21\r\21\16\21"+
		"~\3\22\3\22\7\22\u0083\n\22\f\22\16\22\u0086\13\22\3\23\6\23\u0089\n\23"+
		"\r\23\16\23\u008a\3\23\3\23\2\24\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1"+
		"\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!"+
		"\22\1#\23\1%\24\2\3\2\6\5\62;c|~~\3\63;\3\62;\5\13\f\17\17\"\"\u008f\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\3\'\3\2\2\2\5.\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2\13?\3\2"+
		"\2\2\rE\3\2\2\2\17K\3\2\2\2\21R\3\2\2\2\23W\3\2\2\2\25[\3\2\2\2\27a\3"+
		"\2\2\2\31g\3\2\2\2\33m\3\2\2\2\35n\3\2\2\2\37v\3\2\2\2!|\3\2\2\2#\u0080"+
		"\3\2\2\2%\u0088\3\2\2\2\'(\7d\2\2()\7w\2\2)*\7v\2\2*+\7v\2\2+,\7q\2\2"+
		",-\7p\2\2-\4\3\2\2\2./\7f\2\2/\60\7q\2\2\60\61\7q\2\2\61\62\7t\2\2\62"+
		"\6\3\2\2\2\63\64\7.\2\2\64\b\3\2\2\2\65\66\7c\2\2\66\67\7e\2\2\678\7v"+
		"\2\289\7k\2\29:\7x\2\2:;\7c\2\2;<\7v\2\2<=\7g\2\2=>\7?\2\2>\n\3\2\2\2"+
		"?@\7u\2\2@A\7v\2\2AB\7c\2\2BC\7t\2\2CD\7v\2\2D\f\3\2\2\2EF\7h\2\2FG\7"+
		"k\2\2GH\7g\2\2HI\7n\2\2IJ\7f\2\2J\16\3\2\2\2KL\7h\2\2LM\7k\2\2MN\7p\2"+
		"\2NO\7k\2\2OP\7u\2\2PQ\7j\2\2Q\20\3\2\2\2RS\7t\2\2ST\7q\2\2TU\7q\2\2U"+
		"V\7o\2\2V\22\3\2\2\2WX\7k\2\2XY\7f\2\2YZ\7?\2\2Z\24\3\2\2\2[\\\7p\2\2"+
		"\\]\7c\2\2]^\7o\2\2^_\7g\2\2_`\7?\2\2`\26\3\2\2\2ab\7f\2\2bc\7q\2\2cd"+
		"\7q\2\2de\7t\2\2ef\7?\2\2f\30\3\2\2\2gh\7i\2\2hi\7q\2\2ij\7c\2\2jk\7n"+
		"\2\2kl\7?\2\2l\32\3\2\2\2no\7d\2\2op\7w\2\2pq\7v\2\2qr\7v\2\2rs\7q\2\2"+
		"st\7p\2\2tu\7?\2\2u\36\3\2\2\2vw\7o\2\2wx\7c\2\2xy\7z\2\2yz\7?\2\2z \3"+
		"\2\2\2{}\t\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\"\3\2"+
		"\2\2\u0080\u0084\t\3\2\2\u0081\u0083\t\4\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085$\3\2\2\2"+
		"\u0086\u0084\3\2\2\2\u0087\u0089\t\5\2\2\u0088\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\b\23\2\2\u008d&\3\2\2\2\6\2~\u0084\u008a";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}