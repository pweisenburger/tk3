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
		RULE_room_attr = 9, RULE_type = 10, RULE_start = 11, RULE_finish = 12, 
		RULE_max_player = 13, RULE_id = 14;
	public static final String[] ruleNames = {
		"field", "name", "door", "door_goal", "button", "activate", "room", "contain_doors", 
		"contain_buttons", "room_attr", "type", "start", "finish", "max_player", 
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
			setState(30); match(FIELD);
			setState(31); name();
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOOR) {
				{
				{
				setState(32); door();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BUTTON) {
				{
				{
				setState(38); button();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44); room();
				}
				}
				setState(47); 
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
			setState(49); match(NAME);
			setState(50); match(3);
			setState(51); match(STRING);
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
			setState(53); match(DOOR);
			setState(54); id();
			setState(55); door_goal();
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
			setState(57); match(GOAL);
			setState(58); match(3);
			setState(59); id();
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
			setState(61); match(BUTTON);
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
			setState(65); match(ACTIVATE);
			setState(66); match(3);
			setState(67); id();
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
		public TerminalNode ROOM() { return getToken(MapGrammarParser.ROOM, 0); }
		public Room_attrContext room_attr() {
			return getRuleContext(Room_attrContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Contain_buttonsContext contain_buttons() {
			return getRuleContext(Contain_buttonsContext.class,0);
		}
		public Contain_doorsContext contain_doors() {
			return getRuleContext(Contain_doorsContext.class,0);
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
			setState(69); match(ROOM);
			setState(70); name();
			setState(71); room_attr();
			setState(72); contain_doors();
			setState(73); contain_buttons();
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
			setState(86);
			switch (_input.LA(1)) {
			case DOOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(75); match(DOOR);
				setState(76); match(3);
				setState(77); id();
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(78); match(1);
					setState(79); id();
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85); match(2);
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
			setState(99);
			switch (_input.LA(1)) {
			case BUTTON:
				enterOuterAlt(_localctx, 1);
				{
				setState(88); match(BUTTON);
				setState(89); match(3);
				setState(90); id();
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(91); match(1);
					setState(92); id();
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); match(2);
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
		enterRule(_localctx, 18, RULE_room_attr);
		try {
			setState(104);
			switch (_input.LA(1)) {
			case TYPE:
			case FINISH:
				enterOuterAlt(_localctx, 1);
				{
				setState(101); type();
				}
				break;
			case MAXIMUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(102); max_player();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 3);
				{
				setState(103); match(2);
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
		enterRule(_localctx, 20, RULE_type);
		try {
			setState(110);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(106); match(TYPE);
				setState(107); match(3);
				setState(108); start();
				}
				break;
			case FINISH:
				enterOuterAlt(_localctx, 2);
				{
				setState(109); finish();
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
		enterRule(_localctx, 22, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(START);
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
		enterRule(_localctx, 24, RULE_finish);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114); match(FINISH);
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
		enterRule(_localctx, 26, RULE_max_player);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(MAXIMUM);
			setState(117); match(3);
			setState(118); match(N);
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
		enterRule(_localctx, 28, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(ID);
			setState(121); match(3);
			setState(122); match(STRING);
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
		"\2\3\24\177\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\3\2\3\2\3\2\7\2$\n\2\f\2\16\2\'\13\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2"+
		"\6\2\60\n\2\r\2\16\2\61\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\7\tS\n\t\f\t\16\tV\13\t\3\t\5\tY\n\t\3\n\3\n\3\n\3\n\3\n\7\n"+
		"`\n\n\f\n\16\nc\13\n\3\n\5\nf\n\n\3\13\3\13\3\13\5\13k\n\13\3\f\3\f\3"+
		"\f\3\f\5\fq\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2y\2 \3\2\2\2\4"+
		"\63\3\2\2\2\6\67\3\2\2\2\b;\3\2\2\2\n?\3\2\2\2\fC\3\2\2\2\16G\3\2\2\2"+
		"\20X\3\2\2\2\22e\3\2\2\2\24j\3\2\2\2\26p\3\2\2\2\30r\3\2\2\2\32t\3\2\2"+
		"\2\34v\3\2\2\2\36z\3\2\2\2 !\7\f\2\2!%\5\4\3\2\"$\5\6\4\2#\"\3\2\2\2$"+
		"\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&+\3\2\2\2\'%\3\2\2\2(*\5\n\6\2)(\3\2\2"+
		"\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,/\3\2\2\2-+\3\2\2\2.\60\5\16\b\2/.\3"+
		"\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\3\3\2\2\2\63\64\7\b"+
		"\2\2\64\65\7\5\2\2\65\66\7\22\2\2\66\5\3\2\2\2\678\7\r\2\289\5\36\20\2"+
		"9:\5\b\5\2:\7\3\2\2\2;<\7\13\2\2<=\7\5\2\2=>\5\36\20\2>\t\3\2\2\2?@\7"+
		"\16\2\2@A\5\36\20\2AB\5\f\7\2B\13\3\2\2\2CD\7\n\2\2DE\7\5\2\2EF\5\36\20"+
		"\2F\r\3\2\2\2GH\7\17\2\2HI\5\4\3\2IJ\5\24\13\2JK\5\20\t\2KL\5\22\n\2L"+
		"\17\3\2\2\2MN\7\r\2\2NO\7\5\2\2OT\5\36\20\2PQ\7\3\2\2QS\5\36\20\2RP\3"+
		"\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UY\3\2\2\2VT\3\2\2\2WY\7\4\2\2XM\3"+
		"\2\2\2XW\3\2\2\2Y\21\3\2\2\2Z[\7\16\2\2[\\\7\5\2\2\\a\5\36\20\2]^\7\3"+
		"\2\2^`\5\36\20\2_]\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bf\3\2\2\2ca\3"+
		"\2\2\2df\7\4\2\2eZ\3\2\2\2ed\3\2\2\2f\23\3\2\2\2gk\5\26\f\2hk\5\34\17"+
		"\2ik\7\4\2\2jg\3\2\2\2jh\3\2\2\2ji\3\2\2\2k\25\3\2\2\2lm\7\6\2\2mn\7\5"+
		"\2\2nq\5\30\r\2oq\5\32\16\2pl\3\2\2\2po\3\2\2\2q\27\3\2\2\2rs\7\20\2\2"+
		"s\31\3\2\2\2tu\7\21\2\2u\33\3\2\2\2vw\7\7\2\2wx\7\5\2\2xy\7\23\2\2y\35"+
		"\3\2\2\2z{\7\t\2\2{|\7\5\2\2|}\7\22\2\2}\37\3\2\2\2\13%+\61TXaejp";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}