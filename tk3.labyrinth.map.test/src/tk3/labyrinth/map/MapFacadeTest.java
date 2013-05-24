package tk3.labyrinth.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapFacadeTest {

	private static final String ROOT = "maps";

	private MapFacade facade;

	@BeforeClass
	public static void beforeClass() {
		File file = new File(ROOT);
		if (file.exists()) {
			for (File child : file.listFiles()) {
				child.delete();
			}
			file.delete();
		}
	}

	@Before
	public void setUp() throws Exception {

		facade = new MapFacade();
	}

	@After
	public void tearDown() throws Exception {
		File file = new File(ROOT);
		if (file.exists()) {
			for (File child : file.listFiles()) {
				child.delete();
			}
			file.delete();
		}
	}

	@Test
	public void testMapFacade() {
		assertTrue(new File(ROOT).exists());
	}

	@Test(expected = SyntaxException.class)
	public void testGetMap() throws IOException, SyntaxException {
		new File(ROOT + File.separator + "Test.map").createNewFile();
		assertTrue(facade.containsMap("Test.map"));
		facade.getMap("Test.map");
	}

	@Test
	public void testContainsMap() throws IOException {
		assertFalse(facade.containsMap("Test.map"));
		new File(ROOT + File.separator + "Test.map").createNewFile();
		assertTrue(facade.containsMap("Test.map"));
	}

	@Test
	public void testGetMapList() throws IOException {
		assertTrue(facade.getMapList().isEmpty());
		new File(ROOT + File.separator + "Test.map").createNewFile();
		assertEquals(1, facade.getMapList().size());
		new File(ROOT + File.separator + "Test2.map").createNewFile();
		assertEquals(2, facade.getMapList().size());
	}

	@Test
	public void testGetMapAsString() throws IOException {
		String map = new MapFacade("testdata").getMapAsString("testValid.map");
		assertNotNull(map);
		assertFalse(map.isEmpty());
	}

	@Test
	public void testAddMap() throws IOException, SyntaxException {
		String map = new MapFacade("testdata").getMapAsString("testValid.map");
		facade.addMap(map);
		facade.containsMap("testValid");
	}
}