package tk3.labyrinth.map;

import java.io.IOException;

import org.antlr.v4.runtime.*;

import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.map.grammar.MapGrammarLexer;
import tk3.labyrinth.map.grammar.MapGrammarParser;

public class MapReader {

	
	public Field read(String pathToMapFile) throws IOException {
		ANTLRInputStream input = new ANTLRFileStream(pathToMapFile);
		MapGrammarLexer lexer = new MapGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MapGrammarParser parser = new MapGrammarParser(tokens);
		MapListener listener = new MapListener();
		parser.addParseListener(listener);
		parser.setBuildParseTree(true); 
		parser.field();
		return listener.getResult();
	}
	
	public static void main(String... args) throws IOException {
		new MapReader().read("maps/test.map");
	}

}
