package tk3.labyrinth.map;

import java.io.IOException;

import org.antlr.v4.runtime.*;

import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.map.grammar.MapGrammarLexer;
import tk3.labyrinth.map.grammar.MapGrammarParser;

public class MapReader {

	
	public Field readFile(String pathToMapFile) throws IOException, SyntaxException {
		ANTLRInputStream input = new ANTLRFileStream(pathToMapFile);
		MapGrammarLexer lexer = new MapGrammarLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MapGrammarParser parser = new MapGrammarParser(tokens);
		MapListener listener = new MapListener();
		parser.addParseListener(listener);
		parser.setBuildParseTree(true); 
		parser.field();
		if (parser.getNumberOfSyntaxErrors() != 0) {
			throw new SyntaxException(pathToMapFile);
		}
		return listener.getResult();
	}
}