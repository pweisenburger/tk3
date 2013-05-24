package tk3.labyrinth.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MapWriterTest {

	private MapWriter writer;

	@Before
	public void setUp() throws Exception {
		writer = new MapWriter();

		File file = new File("testdata" + File.separator + "temp.map");
		if (file.exists()) {
			file.delete();
		}
	}

	@After
	public void tearDown() throws Exception {
		File file = new File("testdata" + File.separator + "temp.map");
		if (file.exists()) {
			file.delete();
		}
	}

	@Test
	public void testWriteFile() throws IOException, SyntaxException {
		File toRead = new File("testdata" + File.separator + "testValid.map");
		String map = new MapReader().readStringFromFile(toRead
				.getAbsolutePath());

		assertFalse(new File("testdata" + File.separator + "temp.map").exists());
		writer.writeMapToFile("testdata" + File.separator + "temp.map", map);
		assertTrue(new File("testdata" + File.separator + "temp.map").exists());

		File written = new File("testdata" + File.separator + "temp.map");
		String writtenMap = new MapReader().readStringFromFile(written
				.getAbsolutePath());

		assertEquals(map, writtenMap);
	}
}
