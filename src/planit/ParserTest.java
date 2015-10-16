package planit;

import static org.junit.Assert.*;

import java.util.ArrayList;

import planit.Parser.ACTION_TYPE;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {

	ArrayList<ACTION_TYPE> arr = new ArrayList<ACTION_TYPE>();

	@Before
	public void setUp() {
		arr.add(ACTION_TYPE.ADD);
		arr.add(ACTION_TYPE.DELETE);
		arr.add(ACTION_TYPE.SHOW);
		arr.add(ACTION_TYPE.INVALID);
		arr.add(ACTION_TYPE.ADD);
		arr.add(ACTION_TYPE.DELETE);
		arr.add(ACTION_TYPE.SHOW);
		arr.add(ACTION_TYPE.SEARCH);
		arr.add(ACTION_TYPE.DONE);
		arr.add(ACTION_TYPE.DONE);
		arr.add(ACTION_TYPE.UNDO);
		arr.add(ACTION_TYPE.EXIT);
	}

	@Test
	public void testParser() {
		String test[] = { "add", "del", "show", "LOL", "new", "rm", "display", "find", "done", "mark", "undo", "QUIT" };
		for (int i = 0; i < test.length; i++) {
			Parser testParser = new Parser(test[i]);

			ACTION_TYPE result = testParser.getUserAction();
			ACTION_TYPE expected = arr.get(i);
			assertEquals(expected, result);
		}
	}

}
