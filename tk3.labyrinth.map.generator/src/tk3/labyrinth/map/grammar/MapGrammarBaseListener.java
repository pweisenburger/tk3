// Generated from src/tk3/labyrinth/map/grammar/MapGrammar.g4 by ANTLR 4.0

    package tk3.labyrinth.map.grammar;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class MapGrammarBaseListener implements MapGrammarListener {
	@Override public void enterDoor(MapGrammarParser.DoorContext ctx) { }
	@Override public void exitDoor(MapGrammarParser.DoorContext ctx) { }

	@Override public void enterType(MapGrammarParser.TypeContext ctx) { }
	@Override public void exitType(MapGrammarParser.TypeContext ctx) { }

	@Override public void enterDoor_goal(MapGrammarParser.Door_goalContext ctx) { }
	@Override public void exitDoor_goal(MapGrammarParser.Door_goalContext ctx) { }

	@Override public void enterId(MapGrammarParser.IdContext ctx) { }
	@Override public void exitId(MapGrammarParser.IdContext ctx) { }

	@Override public void enterField(MapGrammarParser.FieldContext ctx) { }
	@Override public void exitField(MapGrammarParser.FieldContext ctx) { }

	@Override public void enterActivate(MapGrammarParser.ActivateContext ctx) { }
	@Override public void exitActivate(MapGrammarParser.ActivateContext ctx) { }

	@Override public void enterMax_player(MapGrammarParser.Max_playerContext ctx) { }
	@Override public void exitMax_player(MapGrammarParser.Max_playerContext ctx) { }

	@Override public void enterFinish(MapGrammarParser.FinishContext ctx) { }
	@Override public void exitFinish(MapGrammarParser.FinishContext ctx) { }

	@Override public void enterButton(MapGrammarParser.ButtonContext ctx) { }
	@Override public void exitButton(MapGrammarParser.ButtonContext ctx) { }

	@Override public void enterRoom_attr(MapGrammarParser.Room_attrContext ctx) { }
	@Override public void exitRoom_attr(MapGrammarParser.Room_attrContext ctx) { }

	@Override public void enterStart(MapGrammarParser.StartContext ctx) { }
	@Override public void exitStart(MapGrammarParser.StartContext ctx) { }

	@Override public void enterName(MapGrammarParser.NameContext ctx) { }
	@Override public void exitName(MapGrammarParser.NameContext ctx) { }

	@Override public void enterContain_buttons(MapGrammarParser.Contain_buttonsContext ctx) { }
	@Override public void exitContain_buttons(MapGrammarParser.Contain_buttonsContext ctx) { }

	@Override public void enterContain_doors(MapGrammarParser.Contain_doorsContext ctx) { }
	@Override public void exitContain_doors(MapGrammarParser.Contain_doorsContext ctx) { }

	@Override public void enterRoom(MapGrammarParser.RoomContext ctx) { }
	@Override public void exitRoom(MapGrammarParser.RoomContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}