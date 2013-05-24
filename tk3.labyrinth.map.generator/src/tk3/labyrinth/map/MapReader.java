package tk3.labyrinth.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.map.grammar.MapGrammarLexer;
import tk3.labyrinth.map.grammar.MapGrammarParser;

public class MapReader {

	public Field readMapFromFile(String pathToMapFile) throws IOException,
			SyntaxException {
		try {
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
		} catch (NullPointerException e) {
			throw new SyntaxException(pathToMapFile);
		}
	}

	public Field readMapFromString(String mapAsString) throws IOException,
			SyntaxException {
		try {
			ANTLRInputStream input = new ANTLRInputStream(mapAsString);
			MapGrammarLexer lexer = new MapGrammarLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			MapGrammarParser parser = new MapGrammarParser(tokens);
			MapListener listener = new MapListener();
			parser.addParseListener(listener);
			parser.setBuildParseTree(true);
			parser.field();
			if (parser.getNumberOfSyntaxErrors() != 0) {
				throw new SyntaxException(mapAsString);
			}
			return listener.getResult();
		} catch (NullPointerException e) {
			throw new SyntaxException(mapAsString);
		}
	}

	public String readStringFromFile(String pathToMapFile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				pathToMapFile)));
		StringBuffer buffer = new StringBuffer();
		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(" ");
		}
		return buffer.toString().trim();
	}
}