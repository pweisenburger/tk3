// Generated from src/tk3/labyrinth/map/generator/grammar/MapGrammar.g4 by ANTLR 4.0

    package tk3.labyrinth.map.generator.grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__14=1, T__13=2, T__12=3, T__11=4, T__10=5, T__9=6, T__8=7, T__7=8, T__6=9, 
		T__5=10, T__4=11, T__3=12, T__2=13, T__1=14, T__0=15, ID=16, N=17, WS=18;
	public static final String[] tokenNames = {
		"<INVALID>", "'button'", "'door'", "','", "'activate='", "'start'", "'field'", 
		"'finish'", "'room'", "'id='", "'name='", "'door='", "'goal='", "''", 
		"'button='", "'max='", "ID", "N", "WS"
	};
	public static final int
		RULE_field = 0, RULE_room = 1, RULE_door = 2, RULE_button = 3;
	public static final String[] ruleNames = {
		"field", "room", "door", "button"
	};

	@Override
	public String getGrammarFileName() { return "MapGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public MapGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FieldContext extends ParserRuleContext {
		public RoomContext room(int i) {
			return getRuleContext(RoomContext.class,i);
		}
		public List<ButtonContext> button() {
			return getRuleContexts(ButtonContext.class);
		}
		public TerminalNode ID() { return getToken(MapGrammarParser.ID, 0); }
		public List<DoorContext> door() {
			return getRuleContexts(DoorContext.class);
		}
		public DoorContext door(int i) {
			return getRuleContext(DoorContext.class,i);
		}
		public ButtonContext button(int i) {
			return getRuleContext(ButtonContext.class,i);
		}
		public List<RoomContext> room() {
			return getRuleContexts(RoomContext.class);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8); match(6);
			setState(9); match(10);
			setState(10); match(ID);
			setState(14);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==2) {
				{
				{
				setState(11); door();
				}
				}
				setState(16);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(17); button();
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23); room();
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(24); match(3);
				setState(25); room();
				}
				}
				setState(30);
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

	public static class RoomContext extends ParserRuleContext {
		public TerminalNode ID(int i) {
			return getToken(MapGrammarParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(MapGrammarParser.ID); }
		public TerminalNode N() { return getToken(MapGrammarParser.N, 0); }
		public RoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterRoom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitRoom(this);
		}
	}

	public final RoomContext room() throws RecognitionException {
		RoomContext _localctx = new RoomContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_room);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31); match(8);
			setState(32); match(9);
			setState(33); match(ID);
			setState(39);
			switch (_input.LA(1)) {
			case 5:
				{
				setState(34); match(5);
				}
				break;
			case 7:
				{
				setState(35); match(7);
				}
				break;
			case 15:
				{
				setState(36); match(15);
				setState(37); match(N);
				}
				break;
			case 13:
				{
				setState(38); match(13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(51);
			switch (_input.LA(1)) {
			case 11:
				{
				setState(41); match(11);
				setState(42); match(ID);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(43); match(3);
					setState(44); match(ID);
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 13:
				{
				setState(50); match(13);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(63);
			switch (_input.LA(1)) {
			case 14:
				{
				setState(53); match(14);
				setState(54); match(ID);
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(55); match(3);
						setState(56); match(ID);
						}
						} 
					}
					setState(61);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				}
				break;
			case 13:
				{
				setState(62); match(13);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class DoorContext extends ParserRuleContext {
		public TerminalNode ID(int i) {
			return getToken(MapGrammarParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(MapGrammarParser.ID); }
		public DoorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_door; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterDoor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitDoor(this);
		}
	}

	public final DoorContext door() throws RecognitionException {
		DoorContext _localctx = new DoorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_door);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(2);
			setState(66); match(9);
			setState(67); match(ID);
			setState(68); match(12);
			setState(69); match(ID);
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

	public static class ButtonContext extends ParserRuleContext {
		public TerminalNode ID(int i) {
			return getToken(MapGrammarParser.ID, i);
		}
		public List<TerminalNode> ID() { return getTokens(MapGrammarParser.ID); }
		public ButtonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_button; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterButton(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitButton(this);
		}
	}

	public final ButtonContext button() throws RecognitionException {
		ButtonContext _localctx = new ButtonContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_button);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); match(1);
			setState(72); match(9);
			setState(73); match(ID);
			setState(74); match(4);
			setState(75); match(ID);
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
		"\2\3\24P\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\7\2\17\n\2\f"+
		"\2\16\2\22\13\2\3\2\7\2\25\n\2\f\2\16\2\30\13\2\3\2\3\2\3\2\7\2\35\n\2"+
		"\f\2\16\2 \13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3*\n\3\3\3\3\3\3\3\3"+
		"\3\7\3\60\n\3\f\3\16\3\63\13\3\3\3\5\3\66\n\3\3\3\3\3\3\3\3\3\7\3<\n\3"+
		"\f\3\16\3?\13\3\3\3\5\3B\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\2\6\2\4\6\b\2\2U\2\n\3\2\2\2\4!\3\2\2\2\6C\3\2\2\2\bI\3\2\2"+
		"\2\n\13\7\b\2\2\13\f\7\f\2\2\f\20\7\22\2\2\r\17\5\6\4\2\16\r\3\2\2\2\17"+
		"\22\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\26\3\2\2\2\22\20\3\2\2\2\23"+
		"\25\5\b\5\2\24\23\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27"+
		"\31\3\2\2\2\30\26\3\2\2\2\31\36\5\4\3\2\32\33\7\5\2\2\33\35\5\4\3\2\34"+
		"\32\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\3\3\2\2\2 \36\3"+
		"\2\2\2!\"\7\n\2\2\"#\7\13\2\2#)\7\22\2\2$*\7\7\2\2%*\7\t\2\2&\'\7\21\2"+
		"\2\'*\7\23\2\2(*\7\17\2\2)$\3\2\2\2)%\3\2\2\2)&\3\2\2\2)(\3\2\2\2*\65"+
		"\3\2\2\2+,\7\r\2\2,\61\7\22\2\2-.\7\5\2\2.\60\7\22\2\2/-\3\2\2\2\60\63"+
		"\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\66\3\2\2\2\63\61\3\2\2\2\64\66\7"+
		"\17\2\2\65+\3\2\2\2\65\64\3\2\2\2\66A\3\2\2\2\678\7\20\2\28=\7\22\2\2"+
		"9:\7\5\2\2:<\7\22\2\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>B\3\2\2"+
		"\2?=\3\2\2\2@B\7\17\2\2A\67\3\2\2\2A@\3\2\2\2B\5\3\2\2\2CD\7\4\2\2DE\7"+
		"\13\2\2EF\7\22\2\2FG\7\16\2\2GH\7\22\2\2H\7\3\2\2\2IJ\7\3\2\2JK\7\13\2"+
		"\2KL\7\22\2\2LM\7\6\2\2MN\7\22\2\2N\t\3\2\2\2\n\20\26\36)\61\65=A";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}