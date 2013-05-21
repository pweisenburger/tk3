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
		T__3=1, T__2=2, T__1=3, T__0=4, ID=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'button'", "'door'", "'field'", "'room'", "ID"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "ID"
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

	public static final String _serializedATN =
		"\2\4\7)\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\6\6&\n\6\r\6\16\6\'\2\7\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\3\2\3"+
		"\5\62;c|~~)\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\3\r\3\2\2\2\5\24\3\2\2\2\7\31\3\2\2\2\t\37\3\2\2\2\13%\3\2\2\2\r\16"+
		"\7d\2\2\16\17\7w\2\2\17\20\7v\2\2\20\21\7v\2\2\21\22\7q\2\2\22\23\7p\2"+
		"\2\23\4\3\2\2\2\24\25\7f\2\2\25\26\7q\2\2\26\27\7q\2\2\27\30\7t\2\2\30"+
		"\6\3\2\2\2\31\32\7h\2\2\32\33\7k\2\2\33\34\7g\2\2\34\35\7n\2\2\35\36\7"+
		"f\2\2\36\b\3\2\2\2\37 \7t\2\2 !\7q\2\2!\"\7q\2\2\"#\7o\2\2#\n\3\2\2\2"+
		"$&\t\2\2\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\f\3\2\2\2\4\2\'";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}