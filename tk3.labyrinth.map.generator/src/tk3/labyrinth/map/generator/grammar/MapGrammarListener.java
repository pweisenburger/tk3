// Generated from src/tk3/labyrinth/map/generator/grammar/MapGrammar.g4 by ANTLR 4.0

    package tk3.labyrinth.map.generator.grammar;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MapGrammarListener extends ParseTreeListener {
	void enterField(MapGrammarParser.FieldContext ctx);
	void exitField(MapGrammarParser.FieldContext ctx);

	void enterButton(MapGrammarParser.ButtonContext ctx);
	void exitButton(MapGrammarParser.ButtonContext ctx);

	void enterDoor(MapGrammarParser.DoorContext ctx);
	void exitDoor(MapGrammarParser.DoorContext ctx);

	void enterRoom(MapGrammarParser.RoomContext ctx);
	void exitRoom(MapGrammarParser.RoomContext ctx);
}