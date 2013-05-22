package tk3.labyrinth.map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import tk3.labyrinth.map.grammar.MapGrammarListener;
import tk3.labyrinth.map.grammar.MapGrammarParser.ActivateContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.ButtonContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.Contain_buttonsContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.Contain_doorsContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.DoorContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.Door_goalContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.FieldContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.IdContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.Max_playerContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.NameContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.RoomContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.TypeContext;

public class MapReader implements MapGrammarListener {

	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterId(IdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitId(IdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterActivate(ActivateContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitActivate(ActivateContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterField(FieldContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitField(FieldContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterMax_player(Max_playerContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitMax_player(Max_playerContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterButton(ButtonContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitButton(ButtonContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterName(NameContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitName(NameContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterContain_buttons(Contain_buttonsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitContain_buttons(Contain_buttonsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDoor(DoorContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitDoor(DoorContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterContain_doors(Contain_doorsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitContain_doors(Contain_doorsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterType(TypeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitType(TypeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDoor_goal(Door_goalContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitDoor_goal(Door_goalContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterRoom(RoomContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitRoom(RoomContext ctx) {
		// TODO Auto-generated method stub

	}
}