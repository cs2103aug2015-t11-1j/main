/*
 * @@author A0121319R
 */

package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import parser.ActionParser.ACTION_TYPE;

public class ActionParserTest {

	private static ArrayList<ACTION_TYPE> arr = new ArrayList<ACTION_TYPE>();

	@Before
	public void setUp() {
		arr.add(ACTION_TYPE.ADD);
		arr.add(ACTION_TYPE.ADD);
		arr.add(ACTION_TYPE.DELETE);
		arr.add(ACTION_TYPE.DELETE);
		arr.add(ACTION_TYPE.DELETE);
		arr.add(ACTION_TYPE.SHOW);
		arr.add(ACTION_TYPE.SHOW);
		arr.add(ACTION_TYPE.SEARCH);
		arr.add(ACTION_TYPE.SEARCH);
		arr.add(ACTION_TYPE.UPDATE);
		arr.add(ACTION_TYPE.UPDATE);
		arr.add(ACTION_TYPE.UPDATE);
		arr.add(ACTION_TYPE.DONE);
		arr.add(ACTION_TYPE.DONE);
		arr.add(ACTION_TYPE.UNDO);
		arr.add(ACTION_TYPE.EXIT);
		arr.add(ACTION_TYPE.EXIT);
		arr.add(ACTION_TYPE.INVALID);
	}

	@Test
	public void testActionParser() {
		String test[] = { "ADD", "new", "DELETE", "rm", "dEl", "Show", "disPLAY", "search", "fInd", "edit", "CHANGE",
				"update", "done", "MarK", "undo", "exit", "quit", "LOL" };
		for (int i = 0; i < test.length; i++) {
			ACTION_TYPE result = ActionParser.setUserAction(test[i]);
			ACTION_TYPE expected = arr.get(i);
			assertEquals(expected, result);
		}
	}

}
