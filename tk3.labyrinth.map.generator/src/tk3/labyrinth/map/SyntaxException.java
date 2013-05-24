package tk3.labyrinth.map;

public class SyntaxException extends Exception {

	private static final long serialVersionUID = 1L;
	private String pathToMapFile;

	public SyntaxException(String pathToMapFile) {
		this.pathToMapFile = pathToMapFile;
	}

	public String getMessage() {
		return "File " + pathToMapFile + " contains syntax erros";
	}
}
