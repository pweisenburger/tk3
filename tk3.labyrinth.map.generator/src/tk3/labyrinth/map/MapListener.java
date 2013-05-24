package tk3.labyrinth.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import tk3.labyrinth.map.grammar.MapGrammarParser.ButtonsContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.DoorContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.Door_goalContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.DoorsContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.FieldContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.FinishContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.IdContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.ListContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.Max_playerContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.NameContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.RoomContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.Room_attrContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.StartContext;
import tk3.labyrinth.map.grammar.MapGrammarParser.TypeContext;

public class MapListener implements MapGrammarListener {
	
	private static Logger logger = LoggerFactory.getLogger(MapListener.class);

	private static final long seed = 1;

	private Random random = new Random(seed);

	private Field field;

	private Map<String, Door> idToDoor = new HashMap<>();

	private Map<String, Button> idToButton = new HashMap<>();

	private Map<String, Room> idToRoom = new HashMap<>();

	private List<Door> currentDoors = new ArrayList<>();

	private List<GameElement> currentAddtional = new ArrayList<>();

	private int maxPlayer = -1;

	private List<String> ids = new ArrayList<>();

	private Start start = null;

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
		String name = ctx.name().STRING().getText();
		field = new Field(name, idToRoom.values());
		field.setStart(start);
	}

	@Override
	public void enterMax_player(Max_playerContext ctx) {

	}

	@Override
	public void exitMax_player(Max_playerContext ctx) {
		maxPlayer = Integer.parseInt(ctx.getText().replaceAll("[\\D]", ""));
	}

	@Override
	public void enterButton(ButtonContext ctx) {

	}

	@Override
	public void exitButton(ButtonContext ctx) {
		String id = ctx.id().STRING().getText();
		String activateId = ctx.activate().STRING().getText();
		idToButton.put(id, new Button());
		if (idToButton.containsKey(activateId)) {
			idToButton.get(id).initReferencedElement(idToDoor.get(activateId));
		}
	}

	@Override
	public void enterName(NameContext ctx) {

	}

	@Override
	public void exitName(NameContext ctx) {

	}

	@Override
	public void enterButtons(ButtonsContext ctx) {
		ids.clear();
	}

	@Override
	public void exitButtons(ButtonsContext ctx) {
		for (String id : ids) {
			if (idToDoor.get(id) != null) {
				currentAddtional.add(idToButton.get(id));
			}
		}
	}

	@Override
	public void enterDoor(DoorContext ctx) {

	}

	@Override
	public void exitDoor(DoorContext ctx) {
		String id = ctx.id().STRING().getText();
		String goalId = ctx.door_goal().STRING().getText();
		idToDoor.put(id, new Door());
		if (idToDoor.containsKey(goalId)) {
			idToDoor.get(id).initDoor(idToDoor.get(goalId));
			idToDoor.get(goalId).initDoor(idToDoor.get(id));
		}
	}

	@Override
	public void enterDoors(DoorsContext ctx) {
		ids.clear();
	}

	@Override
	public void exitDoors(DoorsContext ctx) {
		for (String id : ids) {
			if (idToDoor.get(id) != null) {
				currentDoors.add(idToDoor.get(id));
			}
		}
	}

	@Override
	public void enterType(TypeContext ctx) {

	}

	@Override
	public void exitType(TypeContext ctx) {

	}

	@Override
	public void enterDoor_goal(Door_goalContext ctx) {

	}

	@Override
	public void exitDoor_goal(Door_goalContext ctx) {

	}

	@Override
	public void enterRoom(RoomContext ctx) {
		currentAddtional.clear();
		currentDoors.clear();
		maxPlayer = -1;
	}

	@Override
	public void exitRoom(RoomContext ctx) {
		String name = ctx.name().STRING().getText();
		GameElement[][] elementMatrix = createRoom();
		placeDoors(elementMatrix, currentDoors);
		placeElements(elementMatrix, currentAddtional);

		Room room = new Room(elementMatrix);
		room.setId(name);
		room.setMaxPlayer(maxPlayer);
		idToRoom.put(name, room);
	}

	@Override
	public void enterRoom_attr(Room_attrContext ctx) {

	}

	@Override
	public void exitRoom_attr(Room_attrContext ctx) {

	}

	private GameElement[][] createRoom() {
		int x = 4 + currentDoors.size();
		int y = 4 + currentAddtional.size();

		GameElement[][] elementMatrix = new GameElement[x][y];
		for (int i = 0; i < x; i++) {
			elementMatrix[i][0] = new Wall();
			elementMatrix[i][y - 1] = new Wall();
		}
		for (int i = 1; i < y -1; i++) {
			elementMatrix[0][i] = new Wall();
			elementMatrix[x - 1][i] = new Wall();
		}
		return elementMatrix;
	}

	private void placeDoors(GameElement[][] elementMatrix,
			List<Door> currentDoors2) {
		for (Door door : currentDoors) {
			int x;
			int y;
			do {
				if (random.nextBoolean()) {
					x = random.nextBoolean() ? 0 : elementMatrix.length - 1;
					y = 1 + random.nextInt(elementMatrix[0].length - 3);
				} else {
					x = 1 + random.nextInt(elementMatrix.length - 3);
					y = random.nextBoolean() ? 0 : elementMatrix[0].length - 1;
				}
			} while (Door.class.isInstance(elementMatrix[x][y]));
			logger.debug("place door on x={} and y={}", x,y);
			elementMatrix[x][y] = door;
		}
	}

	private void placeElements(GameElement[][] elementMatrix,
			List<? extends GameElement> elementsToAdd) {
		for (GameElement element : elementsToAdd) {
			int x;
			int y;
			do {
				x = random.nextInt(elementMatrix.length - 1);
				y = random.nextInt(elementMatrix[0].length - 1);
			} while (x == 0 || y == 0 || elementMatrix[x][y] != null);
			elementMatrix[x][y] = element;
			logger.debug("place element on x={} and y={}", x,y);
		}
	}

	@Override
	public void enterFinish(FinishContext ctx) {

	}

	@Override
	public void exitFinish(FinishContext ctx) {
		currentAddtional.add(new Finish());
	}

	@Override
	public void enterStart(StartContext ctx) {

	}

	@Override
	public void exitStart(StartContext ctx) {
		this.start  = new Start();
		currentAddtional.add(start);
		
	}

	@Override
	public void enterList(ListContext ctx) {

	}

	@Override
	public void exitList(ListContext ctx) {
		for (int i = 0; i < ctx.getChildCount(); i++) {
			ids.add(ctx.getChild(i).getText());
		}
	}
}