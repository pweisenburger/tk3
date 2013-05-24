// Generated from src/tk3/labyrinth/map/grammar/MapGrammar.g4 by ANTLR 4.0

    package tk3.labyrinth.map.grammar;

import java.util.List;

import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MapGrammarParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, TYPE=12, NAME=13, ID=14, START=15, FINISH=16, STRING=17, 
		WS=18;
	public static final String[] tokenNames = {
		"<INVALID>", "'button'", "'door'", "'goal='", "'doors='", "','", "'activate='", 
		"'='", "'max='", "'field'", "'buttons='", "'room'", "'type'", "'name'", 
		"'id'", "'start'", "'finish'", "STRING", "WS"
	};
	public static final int
		RULE_field = 0, RULE_name = 1, RULE_door = 2, RULE_door_goal = 3, RULE_button = 4, 
		RULE_activate = 5, RULE_room = 6, RULE_doors = 7, RULE_buttons = 8, RULE_list = 9, 
		RULE_room_attr = 10, RULE_type = 11, RULE_start = 12, RULE_finish = 13, 
		RULE_max_player = 14, RULE_id = 15;
	public static final String[] ruleNames = {
		"field", "name", "door", "door_goal", "button", "activate", "room", "doors", 
		"buttons", "list", "room_attr", "type", "start", "finish", "max_player", 
		"id"
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
			setState(32); match(9);
			setState(33); name();
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34); door();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==2 );
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(39); button();
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45); room();
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==11 );
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
			setState(50); match(NAME);
			setState(51); match(7);
			setState(52); match(STRING);
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
			setState(54); match(2);
			setState(55); id();
			setState(56); door_goal();
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
		public TerminalNode STRING() { return getToken(MapGrammarParser.STRING, 0); }
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
			setState(58); match(3);
			setState(59); match(STRING);
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
			setState(61); match(1);
			setState(62); id();
			setState(63); activate();
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
		public TerminalNode STRING() { return getToken(MapGrammarParser.STRING, 0); }
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
			setState(65); match(6);
			setState(66); match(STRING);
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
		public DoorsContext doors() {
			return getRuleContext(DoorsContext.class,0);
		}
		public Room_attrContext room_attr() {
			return getRuleContext(Room_attrContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ButtonsContext buttons() {
			return getRuleContext(ButtonsContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(11);
			setState(69); name();
			setState(71);
			_la = _input.LA(1);
			if (_la==8 || _la==TYPE) {
				{
				setState(70); room_attr();
				}
			}

			setState(73); doors();
			setState(75);
			_la = _input.LA(1);
			if (_la==10) {
				{
				setState(74); buttons();
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

	public static class DoorsContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public DoorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterDoors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitDoors(this);
		}
	}

	public final DoorsContext doors() throws RecognitionException {
		DoorsContext _localctx = new DoorsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_doors);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); match(4);
			setState(78); list();
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

	public static class ButtonsContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ButtonsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_buttons; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterButtons(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitButtons(this);
		}
	}

	public final ButtonsContext buttons() throws RecognitionException {
		ButtonsContext _localctx = new ButtonsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_buttons);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(10);
			setState(81); list();
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

	public static class ListContext extends ParserRuleContext {
		public TerminalNode STRING(int i) {
			return getToken(MapGrammarParser.STRING, i);
		}
		public List<TerminalNode> STRING() { return getTokens(MapGrammarParser.STRING); }
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); match(STRING);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==5) {
				{
				{
				setState(84); match(5);
				setState(85); match(STRING);
				}
				}
				setState(90);
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

	public static class Room_attrContext extends ParserRuleContext {
		public Max_playerContext max_player() {
			return getRuleContext(Max_playerContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Room_attrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterRoom_attr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitRoom_attr(this);
		}
	}

	public final Room_attrContext room_attr() throws RecognitionException {
		Room_attrContext _localctx = new Room_attrContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_room_attr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			switch (_input.LA(1)) {
			case TYPE:
				{
				setState(91); type();
				}
				break;
			case 8:
				{
				setState(92); max_player();
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

	public static class TypeContext extends ParserRuleContext {
		public FinishContext finish() {
			return getRuleContext(FinishContext.class,0);
		}
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
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
		enterRule(_localctx, 22, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95); match(TYPE);
			setState(96); match(7);
			setState(99);
			switch (_input.LA(1)) {
			case START:
				{
				setState(97); start();
				}
				break;
			case FINISH:
				{
				setState(98); finish();
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

	public static class StartContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(MapGrammarParser.START, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); match(START);
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

	public static class FinishContext extends ParserRuleContext {
		public TerminalNode FINISH() { return getToken(MapGrammarParser.FINISH, 0); }
		public FinishContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finish; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).enterFinish(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MapGrammarListener ) ((MapGrammarListener)listener).exitFinish(this);
		}
	}

	public final FinishContext finish() throws RecognitionException {
		FinishContext _localctx = new FinishContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_finish);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103); match(FINISH);
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
		public TerminalNode STRING() { return getToken(MapGrammarParser.STRING, 0); }
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
		enterRule(_localctx, 28, RULE_max_player);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); match(8);
			setState(106); match(STRING);
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
		enterRule(_localctx, 30, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108); match(ID);
			setState(109); match(7);
			setState(110); match(STRING);
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
		"\2\3\24s\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t"+
		"\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21"+
		"\t\21\3\2\3\2\3\2\6\2&\n\2\r\2\16\2\'\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2"+
		"\6\2\61\n\2\r\2\16\2\62\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\5\bJ\n\b\3\b\3\b\5\bN\n\b\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\7\13Y\n\13\f\13\16\13\\\13\13\3\f\3"+
		"\f\5\f`\n\f\3\r\3\r\3\r\3\r\5\rf\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \2\2j\2\"\3\2\2\2\4\64\3\2\2\2\68\3\2\2\2\b<\3\2\2\2\n?\3\2\2\2\fC\3"+
		"\2\2\2\16F\3\2\2\2\20O\3\2\2\2\22R\3\2\2\2\24U\3\2\2\2\26_\3\2\2\2\30"+
		"a\3\2\2\2\32g\3\2\2\2\34i\3\2\2\2\36k\3\2\2\2 n\3\2\2\2\"#\7\13\2\2#%"+
		"\5\4\3\2$&\5\6\4\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(,\3\2\2"+
		"\2)+\5\n\6\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\60\3\2\2\2.,\3\2"+
		"\2\2/\61\5\16\b\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2"+
		"\2\63\3\3\2\2\2\64\65\7\17\2\2\65\66\7\t\2\2\66\67\7\23\2\2\67\5\3\2\2"+
		"\289\7\4\2\29:\5 \21\2:;\5\b\5\2;\7\3\2\2\2<=\7\5\2\2=>\7\23\2\2>\t\3"+
		"\2\2\2?@\7\3\2\2@A\5 \21\2AB\5\f\7\2B\13\3\2\2\2CD\7\b\2\2DE\7\23\2\2"+
		"E\r\3\2\2\2FG\7\r\2\2GI\5\4\3\2HJ\5\26\f\2IH\3\2\2\2IJ\3\2\2\2JK\3\2\2"+
		"\2KM\5\20\t\2LN\5\22\n\2ML\3\2\2\2MN\3\2\2\2N\17\3\2\2\2OP\7\6\2\2PQ\5"+
		"\24\13\2Q\21\3\2\2\2RS\7\f\2\2ST\5\24\13\2T\23\3\2\2\2UZ\7\23\2\2VW\7"+
		"\7\2\2WY\7\23\2\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\25\3\2\2\2"+
		"\\Z\3\2\2\2]`\5\30\r\2^`\5\36\20\2_]\3\2\2\2_^\3\2\2\2`\27\3\2\2\2ab\7"+
		"\16\2\2be\7\t\2\2cf\5\32\16\2df\5\34\17\2ec\3\2\2\2ed\3\2\2\2f\31\3\2"+
		"\2\2gh\7\21\2\2h\33\3\2\2\2ij\7\22\2\2j\35\3\2\2\2kl\7\n\2\2lm\7\23\2"+
		"\2m\37\3\2\2\2no\7\20\2\2op\7\t\2\2pq\7\23\2\2q!\3\2\2\2\n\',\62IMZ_e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}