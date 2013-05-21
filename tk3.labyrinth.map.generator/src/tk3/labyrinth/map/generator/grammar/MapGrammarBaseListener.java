// Generated from src/tk3/labyrinth/map/generator/grammar/MapGrammar.g4 by ANTLR 4.0

    package tk3.labyrinth.map.generator.grammar;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class MapGrammarBaseListener implements MapGrammarListener {
	@Override public void enterField(MapGrammarParser.FieldContext ctx) { }
	@Override public void exitField(MapGrammarParser.FieldContext ctx) { }

	@Override public void enterButton(MapGrammarParser.ButtonContext ctx) { }
	@Override public void exitButton(MapGrammarParser.ButtonContext ctx) { }

	@Override public void enterDoor(MapGrammarParser.DoorContext ctx) { }
	@Override public void exitDoor(MapGrammarParser.DoorContext ctx) { }

	@Override public void enterRoom(MapGrammarParser.RoomContext ctx) { }
	@Override public void exitRoom(MapGrammarParser.RoomContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}