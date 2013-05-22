package tk3.labyrinth.map;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import tk3.labyrinth.core.gameelements.Button;
import tk3.labyrinth.core.gameelements.Door;
import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.gamefield.Room;
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
import tk3.labyrinth.map.grammar.MapGrammarParser.Room_attrContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.TypeContext;

public class MapReader implements MapGrammarListener {

	private Field field;
	
	private Map<String, Door> idToDoor = new HashMap<>();
	
	private Map<String, Button> idToButton = new HashMap<>();
	
	private Map<String, Room> idToRoom = new HashMap<>();
	
	private String roomType;
	
	public Field getResult() {
		return field;
	}

	@Override
	public void enterEveryRule(ParserRuleContext arg0) {

	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {

	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {

	}

	@Override
	public void visitTerminal(TerminalNode arg0) {

	}

	@Override
	public void enterId(IdContext ctx) {

	}

	@Override
	public void exitId(IdContext ctx) {

	}

	@Override
	public void enterActivate(ActivateContext ctx) {

	}

	@Override
	public void exitActivate(ActivateContext ctx) {

	}

	@Override
	public void enterField(FieldContext ctx) {
		field = new Field(ctx.name().STRING().getText());
	}

	@Override
	public void exitField(FieldContext ctx) {

	}

	@Override
	public void enterMax_player(Max_playerContext ctx) {
		roomType = "MAX " + ctx.N();
	}

	@Override
	public void exitMax_player(Max_playerContext ctx) {

	}

	@Override
	public void enterButton(ButtonContext ctx) {
		String id = ctx.id().STRING().getText();
		String activateId = ctx.activate().id().getText();
		idToButton.put(id, new Button());
		if (idToButton.containsKey(activateId)) {
			idToButton.get(id).setReferencedElement(idToDoor.get(activateId));
		}
	}

	@Override
	public void exitButton(ButtonContext ctx) {

	}

	@Override
	public void enterName(NameContext ctx) {

	}

	@Override
	public void exitName(NameContext ctx) {

	}

	@Override
	public void enterContain_buttons(Contain_buttonsContext ctx) {

	}

	@Override
	public void exitContain_buttons(Contain_buttonsContext ctx) {

	}

	@Override
	public void enterDoor(DoorContext ctx) {
		String id = ctx.id().STRING().getText();
		String goalId = ctx.door_goal().id().getText();
		idToDoor.put(id, new Door());
		if (idToDoor.containsKey(goalId)) {
			idToDoor.get(id).setGoal(idToDoor.get(goalId));
			idToDoor.get(goalId).setGoal(idToDoor.get(id));
		}
		
	}

	@Override
	public void exitDoor(DoorContext ctx) {

	}

	@Override
	public void enterContain_doors(Contain_doorsContext ctx) {

	}

	@Override
	public void exitContain_doors(Contain_doorsContext ctx) {

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

	}

	@Override
	public void exitDoor_goal(Door_goalContext ctx) {

	}

	@Override
	public void enterRoom(RoomContext ctx) {
		String id = ctx.id().getText();
		Room room = new Room(id);
		idToRoom.put(id, room);
		
		//TODO Türen hinzufügen
		//TODO Knöpfe hinzufügen
	}

	@Override
	public void exitRoom(RoomContext ctx) {
		String id = ctx.id().getText();
		idToRoom.get(id);
	}

	@Override
	public void enterRoom_attr(Room_attrContext ctx) {

	}

	@Override
	public void exitRoom_attr(Room_attrContext ctx) {

	}
}