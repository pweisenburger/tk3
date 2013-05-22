// Generated from src/tk3/labyrinth/map/generator/grammar/MapGrammar.g4 by ANTLR 4.0

    package tk3.labyrinth.map.grammar;

import org.antlr.v4.runtime.tree.ParseTreeListener;

public interface MapGrammarListener extends ParseTreeListener {
	void enterId(MapGrammarParser.IdContext ctx);
	void exitId(MapGrammarParser.IdContext ctx);

	void enterActivate(MapGrammarParser.ActivateContext ctx);
	void exitActivate(MapGrammarParser.ActivateContext ctx);

	void enterField(MapGrammarParser.FieldContext ctx);
	void exitField(MapGrammarParser.FieldContext ctx);

	void enterMax_player(MapGrammarParser.Max_playerContext ctx);
	void exitMax_player(MapGrammarParser.Max_playerContext ctx);

	void enterButton(MapGrammarParser.ButtonContext ctx);
	void exitButton(MapGrammarParser.ButtonContext ctx);

	void enterName(MapGrammarParser.NameContext ctx);
	void exitName(MapGrammarParser.NameContext ctx);

	void enterContain_buttons(MapGrammarParser.Contain_buttonsContext ctx);
	void exitContain_buttons(MapGrammarParser.Contain_buttonsContext ctx);

	void enterDoor(MapGrammarParser.DoorContext ctx);
	void exitDoor(MapGrammarParser.DoorContext ctx);

	void enterContain_doors(MapGrammarParser.Contain_doorsContext ctx);
	void exitContain_doors(MapGrammarParser.Contain_doorsContext ctx);

	void enterType(MapGrammarParser.TypeContext ctx);
	void exitType(MapGrammarParser.TypeContext ctx);

	void enterDoor_goal(MapGrammarParser.Door_goalContext ctx);
	void exitDoor_goal(MapGrammarParser.Door_goalContext ctx);

	void enterRoom(MapGrammarParser.RoomContext ctx);
	void exitRoom(MapGrammarParser.RoomContext ctx);
}