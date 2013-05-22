package tk3.labyrinth.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import tk3.labyrinth.core.gameelements.Button;
import tk3.labyrinth.core.gameelements.Door;
import tk3.labyrinth.core.gameelements.Finish;
import tk3.labyrinth.core.gameelements.GameElement;
import tk3.labyrinth.core.gameelements.Start;
import tk3.labyrinth.core.gameelements.Wall;
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

	private List<Door> currentDoors = new ArrayList<>();

	private List<Button> currentAddtional = new ArrayList<>();

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

	}

	@Override
	public void exitField(FieldContext ctx) {
		field = new Field(idToRoom.values());
	}

	@Override
	public void enterMax_player(Max_playerContext ctx) {
		
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
			idToButton.get(id).initReferencedElement(idToDoor.get(activateId));
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
		currentAddtional.clear();
		for (IdContext id : ctx.id()) {
			currentAddtional.add(idToButton.get(id));
		}
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
			idToDoor.get(id).initDoor(idToDoor.get(goalId));
			idToDoor.get(goalId).initDoor(idToDoor.get(id));
		}

	}

	@Override
	public void exitDoor(DoorContext ctx) {

	}

	@Override
	public void enterContain_doors(Contain_doorsContext ctx) {
		currentDoors.clear();
		for (IdContext id : ctx.id()) {
			currentDoors.add(idToDoor.get(id));
		}
	}

	@Override
	public void exitContain_doors(Contain_doorsContext ctx) {

	}

	@Override
	public void enterType(TypeContext ctx) {
		
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
		
	}

	@Override
	public void exitRoom(RoomContext ctx) {
		String id = ctx.id().getText();
		GameElement[][] elementMatrix = createRoom();
		placeDoors(elementMatrix, currentDoors);
		placeElements(elementMatrix, currentAddtional);
		
		 Room room = new Room(elementMatrix);
		 room.setId(id);
		 idToRoom.put(id, room);
	}

	@Override
	public void enterRoom_attr(Room_attrContext ctx) {

	}

	@Override
	public void exitRoom_attr(Room_attrContext ctx) {

	}

	private GameElement[][] createRoom() {
		int x = 2 + currentDoors.size();
		int y = 2 + currentAddtional.size();

		GameElement[][] elementMatrix = new GameElement[x][y];
		for (int i = 0; i < x; i++) {
			elementMatrix[i][0] = new Wall();
			elementMatrix[i][y] = new Wall();
		}
		for (int i = 0; i < y; i++) {
			elementMatrix[0][i] = new Wall();
			elementMatrix[x][i] = new Wall();
		}
		return elementMatrix;
	}

	private void placeDoors(GameElement[][] elementMatrix,
			List<Door> currentDoors2) {
		Random random = new Random();
		for (Door door : currentDoors) {
			int x;
			int y;
			do {
				if (random.nextBoolean()) {
					x = random.nextBoolean() ? 0 : elementMatrix.length - 1;
					y = random.nextInt(elementMatrix[0].length - 1);
				} else {
					x = random.nextInt(elementMatrix.length - 1);
					y = random.nextBoolean() ? 0 : elementMatrix[0].length - 1;
				}
			} while (!Door.class.isInstance(elementMatrix[x][y]));
			elementMatrix[x][y] = door;
		}
	}

	private void placeElements(GameElement[][] elementMatrix,
			List<? extends GameElement> elementsToAdd) {
		Random random = new Random();
		for (GameElement element : elementsToAdd) {
			int x;
			int y;
			do {
				x = random.nextInt(elementMatrix.length - 1);
				y = random.nextInt(elementMatrix[0].length - 1);
			} while (x == 0 || y == 0 || elementMatrix[x][y] != null);
			elementMatrix[x][y] = element;
		}
	}
}