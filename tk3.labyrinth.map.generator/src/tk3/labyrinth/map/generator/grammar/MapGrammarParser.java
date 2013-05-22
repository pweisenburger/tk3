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
		T__2=1, T__1=2, T__0=3, TYPE=4, MAXIMUM=5, NAME=6, ID=7, ACTIVATE=8, GOAL=9, 
		FIELD=10, DOOR=11, BUTTON=12, ROOM=13, START=14, FINISH=15, STRING=16, 
		N=17, WS=18;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "''", "'='", "'type'", "'max'", "'name'", "'id'", 
		"'activate'", "'goal'", "'field'", "'door'", "'button'", "'room'", "'start'", 
		"'finish'", "STRING", "N", "WS"
	};
	public static final int
		RULE_field = 0, RULE_name = 1, RULE_door = 2, RULE_door_goal = 3, RULE_button = 4, 
		RULE_activate = 5, RULE_room = 6, RULE_contain_doors = 7, RULE_contain_buttons = 8, 
		RULE_type = 9, RULE_max_player = 10, RULE_id = 11;
	public static final String[] ruleNames = {
		"field", "name", "door", "door_goal", "button", "activate", "room", "contain_doors", 
		"contain_buttons", "type", "max_player", "id"
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
		public TerminalNode FIELD() { return getToken(MapGrammarParser.FIELD, 0); }
		public RoomContext room(int i) {
			return getRuleContext(RoomContext.class,i);
		}
		public List<ButtonContext> button() {
			return getRuleContexts(ButtonContext.class);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public List<DoorContext> door() {
			return getRuleContexts(DoorContext.class);
		}
		public DoorContext door(int i) {
			return getRuleContext(DoorContext.class,i);
		}
		public List<RoomContext> room() {
			return getRuleContexts(RoomContext.class);
		}
		public ButtonContext button(int i) {
			return getRuleContext(ButtonContext.class,i);
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
			setState(24); match(FIELD);
			setState(25); name();
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOOR) {
				{
				{
				setState(26); door();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BUTTON) {
				{
				{
				setState(32); button();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38); room();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ROOM );
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(MapGrammarParser.NAME, 0); }
		public TerminalNode STRING() { return getToken(MapGrammarParser.STRING, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); match(NAME);
			setState(44); match(3);
			setState(45); match(STRING);
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
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode DOOR() { return getToken(MapGrammarParser.DOOR, 0); }
		public Door_goalContext door_goal() {
			return getRuleContext(Door_goalContext.class,0);
		}
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
			setState(47); match(DOOR);
			setState(48); id();
			setState(49); door_goal();
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

	public static class Door_goalContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode GOAL() { return getToken(MapGrammarParser.GOAL, 0); }
		public Door_goalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_door_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterDoor_goal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitDoor_goal(this);
		}
	}

	public final Door_goalContext door_goal() throws RecognitionException {
		Door_goalContext _localctx = new Door_goalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_door_goal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(GOAL);
			setState(52); match(3);
			setState(53); id();
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
		public ActivateContext activate() {
			return getRuleContext(ActivateContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode BUTTON() { return getToken(MapGrammarParser.BUTTON, 0); }
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
		enterRule(_localctx, 8, RULE_button);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); match(BUTTON);
			setState(56); id();
			setState(57); activate();
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

	public static class ActivateContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode ACTIVATE() { return getToken(MapGrammarParser.ACTIVATE, 0); }
		public ActivateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_activate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterActivate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitActivate(this);
		}
	}

	public final ActivateContext activate() throws RecognitionException {
		ActivateContext _localctx = new ActivateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_activate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(ACTIVATE);
			setState(60); match(3);
			setState(61); id();
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
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode ROOM() { return getToken(MapGrammarParser.ROOM, 0); }
		public Contain_buttonsContext contain_buttons() {
			return getRuleContext(Contain_buttonsContext.class,0);
		}
		public Contain_doorsContext contain_doors() {
			return getRuleContext(Contain_doorsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_room);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); match(ROOM);
			setState(64); id();
			setState(65); type();
			setState(66); contain_doors();
			setState(67); contain_buttons();
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

	public static class Contain_doorsContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public TerminalNode DOOR() { return getToken(MapGrammarParser.DOOR, 0); }
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Contain_doorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contain_doors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterContain_doors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitContain_doors(this);
		}
	}

	public final Contain_doorsContext contain_doors() throws RecognitionException {
		Contain_doorsContext _localctx = new Contain_doorsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_contain_doors);
		int _la;
		try {
			setState(80);
			switch (_input.LA(1)) {
			case DOOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(69); match(DOOR);
				setState(70); match(3);
				setState(71); id();
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(72); match(1);
					setState(73); id();
					}
					}
					setState(78);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(79); match(2);
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

	public static class Contain_buttonsContext extends ParserRuleContext {
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public TerminalNode BUTTON() { return getToken(MapGrammarParser.BUTTON, 0); }
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Contain_buttonsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contain_buttons; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterContain_buttons(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitContain_buttons(this);
		}
	}

	public final Contain_buttonsContext contain_buttons() throws RecognitionException {
		Contain_buttonsContext _localctx = new Contain_buttonsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_contain_buttons);
		int _la;
		try {
			setState(93);
			switch (_input.LA(1)) {
			case BUTTON:
				enterOuterAlt(_localctx, 1);
				{
				setState(82); match(BUTTON);
				setState(83); match(3);
				setState(84); id();
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(85); match(1);
					setState(86); id();
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92); match(2);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode FINISH() { return getToken(MapGrammarParser.FINISH, 0); }
		public Max_playerContext max_player() {
			return getRuleContext(Max_playerContext.class,0);
		}
		public TerminalNode START() { return getToken(MapGrammarParser.START, 0); }
		public TerminalNode TYPE() { return getToken(MapGrammarParser.TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(95); match(TYPE);
				setState(96); match(3);
				setState(97);
				_la = _input.LA(1);
				if ( !(_la==START || _la==FINISH) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case MAXIMUM:
				{
				setState(98); max_player();
				}
				break;
			case 2:
				{
				setState(99); match(2);
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

	public static class Max_playerContext extends ParserRuleContext {
		public TerminalNode MAXIMUM() { return getToken(MapGrammarParser.MAXIMUM, 0); }
		public TerminalNode N() { return getToken(MapGrammarParser.N, 0); }
		public Max_playerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_max_player; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterMax_player(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitMax_player(this);
		}
	}

	public final Max_playerContext max_player() throws RecognitionException {
		Max_playerContext _localctx = new Max_playerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_max_player);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(MAXIMUM);
			setState(103); match(3);
			setState(104); match(N);
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MapGrammarParser.ID, 0); }
		public TerminalNode STRING() { return getToken(MapGrammarParser.STRING, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(ID);
			setState(107); match(3);
			setState(108); match(STRING);
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
		"\2\3\24q\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\7\2\36\n\2\f\2\16\2!"+
		"\13\2\3\2\7\2$\n\2\f\2\16\2\'\13\2\3\2\6\2*\n\2\r\2\16\2+\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tM\n\t\f\t\16\tP\13\t\3\t"+
		"\5\tS\n\t\3\n\3\n\3\n\3\n\3\n\7\nZ\n\n\f\n\16\n]\13\n\3\n\5\n`\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\5\13g\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\2"+
		"\16\2\4\6\b\n\f\16\20\22\24\26\30\2\3\3\20\21m\2\32\3\2\2\2\4-\3\2\2\2"+
		"\6\61\3\2\2\2\b\65\3\2\2\2\n9\3\2\2\2\f=\3\2\2\2\16A\3\2\2\2\20R\3\2\2"+
		"\2\22_\3\2\2\2\24f\3\2\2\2\26h\3\2\2\2\30l\3\2\2\2\32\33\7\f\2\2\33\37"+
		"\5\4\3\2\34\36\5\6\4\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2"+
		"\2\2 %\3\2\2\2!\37\3\2\2\2\"$\5\n\6\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2"+
		"%&\3\2\2\2&)\3\2\2\2\'%\3\2\2\2(*\5\16\b\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2"+
		"\2+,\3\2\2\2,\3\3\2\2\2-.\7\b\2\2./\7\5\2\2/\60\7\22\2\2\60\5\3\2\2\2"+
		"\61\62\7\r\2\2\62\63\5\30\r\2\63\64\5\b\5\2\64\7\3\2\2\2\65\66\7\13\2"+
		"\2\66\67\7\5\2\2\678\5\30\r\28\t\3\2\2\29:\7\16\2\2:;\5\30\r\2;<\5\f\7"+
		"\2<\13\3\2\2\2=>\7\n\2\2>?\7\5\2\2?@\5\30\r\2@\r\3\2\2\2AB\7\17\2\2BC"+
		"\5\30\r\2CD\5\24\13\2DE\5\20\t\2EF\5\22\n\2F\17\3\2\2\2GH\7\r\2\2HI\7"+
		"\5\2\2IN\5\30\r\2JK\7\3\2\2KM\5\30\r\2LJ\3\2\2\2MP\3\2\2\2NL\3\2\2\2N"+
		"O\3\2\2\2OS\3\2\2\2PN\3\2\2\2QS\7\4\2\2RG\3\2\2\2RQ\3\2\2\2S\21\3\2\2"+
		"\2TU\7\16\2\2UV\7\5\2\2V[\5\30\r\2WX\7\3\2\2XZ\5\30\r\2YW\3\2\2\2Z]\3"+
		"\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\`\3\2\2\2][\3\2\2\2^`\7\4\2\2_T\3\2\2\2_"+
		"^\3\2\2\2`\23\3\2\2\2ab\7\6\2\2bc\7\5\2\2cg\t\2\2\2dg\5\26\f\2eg\7\4\2"+
		"\2fa\3\2\2\2fd\3\2\2\2fe\3\2\2\2g\25\3\2\2\2hi\7\7\2\2ij\7\5\2\2jk\7\23"+
		"\2\2k\27\3\2\2\2lm\7\t\2\2mn\7\5\2\2no\7\22\2\2o\31\3\2\2\2\n\37%+NR["+
		"_f";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}