/*
 * @@author A0121319R
 */

package parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class IndexParserTest {

	@Test
	public void testGetIndexForDeleteAction() throws InvalidInputException {
		String test = "delete 1";
		int result = IndexParser.getIndex(test);
		int expected = 1;
		assertEquals(expected, result);
	}

	@Test(expected = InvalidInputException.class)
	public void testFailedGetIndexForDeleteAction() throws InvalidInputException {
		String test = "delete ";
		IndexParser.getIndex(test);
	}

	@Test
	public void testGetIndexForUpdateAction() throws InvalidInputException {
		String test = "update 2 event > 10am";
		int result = IndexParser.getIndex(test);
		int expected = 2;
		assertEquals(expected, result);
	}

	@Test(expected = InvalidInputException.class)
	public void testFailedGetIndexForUpdateAction() throws InvalidInputException {
		String test = "update event > 10am";
		IndexParser.getIndex(test);
	}

	@Test
	public void testGetIndexForDoneAction() throws InvalidInputException {
		String test = "mark 100";
		int result = IndexParser.getIndex(test);
		int expected = 100;
		assertEquals(expected, result);
	}

	@Test(expected = InvalidInputException.class)
	public void testGetIndexForUndoneAction() throws InvalidInputException {
		String test = "unmark -1";
		int result = IndexParser.getIndex(test);
		int expected = -1;
		assertEquals(expected, result);
	}
}
