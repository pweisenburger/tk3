package tk3.labyrinth.map;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import tk3.labyrinth.core.gamefield.Field;

public class MapFacade {
	
	private static final String mapExtention = ".map";
	
	private String rootFolder;
	
	private MapReader reader = new MapReader();

	private MapWriter writer = new MapWriter();
	
	public MapFacade(String rootFolder) {
		this.rootFolder = rootFolder;
		File root = new File(rootFolder);
		if (!root.exists()) {
			root.mkdirs();
		}
	}
	
	public MapFacade() {
		this("maps");
	}

	public Field getMap(String mapName) throws IOException, SyntaxException {
		return reader.readMapFromFile(createFile(mapName).getAbsolutePath());
	}
	
	public boolean containsMap(String mapName) {
		return createFile(mapName).exists();
	}
	
	public List<String> getMapList() {
		return Arrays.asList(new File(rootFolder).list());
	}
	
	public Field addMap(String mapAsString) throws IOException, SyntaxException {
			Field field = reader.readMapFromString(mapAsString);
			writer.writeMapToFile(createFile(field.getName()).getAbsolutePath(), mapAsString);
			return field;
	}
	
	public String getMapAsString(String mapName) throws IOException {
		return reader.readStringFromFile(createFile(mapName).getAbsolutePath());
	}
	
	private File createFile(String name) {
		if (!name.endsWith(mapExtention)) {
			name = name + mapExtention;
		}
		return new File(rootFolder + File.separator + name);
	}	
}