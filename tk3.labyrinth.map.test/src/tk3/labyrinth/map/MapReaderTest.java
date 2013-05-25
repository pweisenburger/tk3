package tk3.labyrinth.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import tk3.labyrinth.core.gameelements.Button;
import tk3.labyrinth.core.gameelements.Finish;
import tk3.labyrinth.core.gameelements.Start;
import tk3.labyrinth.core.gamefield.Field;
import tk3.labyrinth.core.gamefield.Room;

public class MapReaderTest {

	private MapReader reader;

	@Before
	public void setUp() throws Exception {
		reader = new MapReader();
	}

	@Test
	public void testReadValidFile() throws IOException, SyntaxException {
		Field field = reader.readMapFromFile("testdata" + File.separator
				+ "testValid.map");
		assertEquals(2, field.getRooms().size());
		for (Room room : field.getRooms()) {
			switch (room.getId()) {
			case "1":
				assertEquals(6, room.getHeight()); // door
				assertEquals(6, room.getWidth()); // button, start
				assertTrue(check(room, Start.class));
				assertTrue(check(room, Button.class));
				assertFalse(check(room, Finish.class));
				break;
			case "2":
				assertEquals(6, room.getHeight()); // door
				assertEquals(5, room.getWidth()); // button, start
				assertFalse(check(room, Start.class));
				assertFalse(check(room, Button.class));
				assertTrue(check(room, Finish.class));
				break;
			default:
				fail(room.getId() + " does not match");
			}
		}
	}

	private <T> boolean check(Room room, Class<T> c) {
		for (int i = 0; i < room.getWidth(); i++) {
			for (int j = 0; j < room.getHeight(); j++) {
				if (c.isInstance(room.getGameElement(i, j))) {
					return true;
				}
			}
		}
		return false;
	}

	@Test
	public void testReadValidFile2Rooms1ID() throws IOException,
			SyntaxException {
		Field field = reader.readMapFromFile("testdata" + File.separator
				+ "testValid2Rooms1ID.map");
		assertEquals(1, field.getRooms().size());
	}

	@Test(expected = IOException.class)
	public void testReadExpectIOException() throws IOException, SyntaxException {
		reader.readMapFromFile("testdata" + File.separator + "empty.map");
	}

	@Test(expected = SyntaxException.class)
	public void testReadExpectSyntaxException() throws IOException,
			SyntaxException {
		reader.readMapFromFile("testdata" + File.separator + "testNotValid.map");
	}

	@Test
	public void validate() throws IOException, SyntaxException {
	 reader.readMapFromFile("testdata" + File.separator
				+ "gaga.map");
	}
}
