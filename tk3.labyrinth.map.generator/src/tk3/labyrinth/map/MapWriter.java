package tk3.labyrinth.map;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MapWriter {

	public void  writeMapToFile(String pathToName, String mapAsString) throws IOException, SyntaxException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pathToName)));
		writer.write(mapAsString);
		writer.flush();
		writer.close();
	}
}
