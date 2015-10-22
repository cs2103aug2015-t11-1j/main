package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TimeParserTest {

	@Test
	public void testForTwoTimeArgParsed() throws InvalidInputException {
		String test = "add event from 11:00 to 1200";
		ArrayList<String> result = TimeParser.getTimeArg(test);

		ArrayList<String> expected = new ArrayList<String>();
		expected.add("1100");
		expected.add("1200");

		assertEquals(expected, result);
	}

	@Test
	public void testForOneStartTimeArgParsed() throws InvalidInputException {
		String test = "add event at 11.00";
		ArrayList<String> result = TimeParser.getTimeArg(test);

		ArrayList<String> expected = new ArrayList<String>();
		expected.add("1100");
		expected.add("");

		assertEquals(expected, result);
	}

	@Test
	public void testForOneEndTimeArgParsed() throws InvalidInputException {
		String test = "add event by 11.00";
		ArrayList<String> result = TimeParser.getTimeArg(test);

		ArrayList<String> expected = new ArrayList<String>();
		expected.add("");
		expected.add("1100");

		assertEquals(expected, result);
	}

	@Test
	public void testForNoTimeArgParsed() throws InvalidInputException {
		String test = "add event";
		ArrayList<String> result = TimeParser.getTimeArg(test);

		ArrayList<String> expected = new ArrayList<String>();
		expected.add("");
		expected.add("");

		assertEquals(expected, result);
	}

	@Test(expected = InvalidInputException.class)
	public void testForTooManyStartInputs() throws InvalidInputException {
		String test = "add event from 11:00 11:01 to 12:34";
		TimeParser.getTimeArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testForTooManyEndInputs() throws InvalidInputException {
		String test = "add event from 11:00 to 12:34 12:43";
		TimeParser.getTimeArg(test);
	}
	
	@Test(expected = InvalidInputException.class)
	public void testForTooManyTimeInputs() throws InvalidInputException {
		String test = "add event from 11:00 13:45 to 12:34 12:43";
		TimeParser.getTimeArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testForInvalidStartInput() throws InvalidInputException {
		String test = "add event from to 11:00";
		TimeParser.getTimeArg(test);
	}
	
	@Test(expected = InvalidInputException.class)
	public void testForInvalidEndInput() throws InvalidInputException {
		String test = "add event from 11:00 to ";
		TimeParser.getTimeArg(test);
	}

}
