package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DateTimeParserTest {
	
	private ArrayList<String> resultTime = new ArrayList<String>();
	private ArrayList<String> resultDate = new ArrayList<String>();
	private ArrayList<String> expectedTime = new ArrayList<String>();
	private ArrayList<String> expectedDate = new ArrayList<String>();
	
	@Test
	public void testForTwoDateAndTimeArgs() throws InvalidInputException {
		String test = "add event from 10-10-15 11:00 to 11/10/15 1200";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("1100");
		expectedTime.add("1200");
		expectedDate.add("10/10/15");
		expectedDate.add("11/10/15");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test
	public void testForOneStartDateAndTime() throws InvalidInputException {
		String test = "add event at 10/10/15 11.00";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("1100");
		expectedTime.add("");
		expectedDate.add("10/10/15");
		expectedDate.add("");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test
	public void testForOneEndDateAndTime() throws InvalidInputException {
		String test = "add event by 10/10/15 11.00";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("");
		expectedTime.add("1100");
		expectedDate.add("");
		expectedDate.add("10/10/15");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test(expected = InvalidInputException.class)
	public void testForOneEndTimeWithOneStartDate() throws InvalidInputException {
		String test = "add event from 10/10/15 to 11.00";
		TimeParser.addTimeArg(test);
	}
	
	@Test
	public void testForOneEndTimeArgWithTwoDateArgs() throws InvalidInputException {
		String test = "add event from 10/10/15 to 11/10/15 11:00";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("");
		expectedTime.add("1100");
		expectedDate.add("10/10/15");
		expectedDate.add("11/10/15");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test
	public void testForNoTimeArgParsed() throws InvalidInputException {
		String test = "add event";
		ArrayList<String> result = TimeParser.addTimeArg(test);

		ArrayList<String> expected = new ArrayList<String>();
		expected.add("");
		expected.add("");

		assertEquals(expected, result);
	}

	@Test
	public void testForNoTimeArgParsedWithDateArgs() throws InvalidInputException {
		String test = "add event from 12/10/15 to 13/10/15";
		ArrayList<String> result = TimeParser.addTimeArg(test);

		ArrayList<String> expected = new ArrayList<String>();
		expected.add("");
		expected.add("");

		assertEquals(expected, result);
	}

	@Test(expected = InvalidInputException.class)
	public void testForTooManyStartInputs() throws InvalidInputException {
		String test = "add event from 11:00 11:01 to 12:34";
		TimeParser.addTimeArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testForTooManyEndInputs() throws InvalidInputException {
		String test = "add event from 11:00 to 12:34 12:43";
		TimeParser.addTimeArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testForTooManyTimeInputs() throws InvalidInputException {
		String test = "add event from 11:00 13:45 to 12:34 12:43";
		TimeParser.addTimeArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testForInvalidStartInput() throws InvalidInputException {
		String test = "add event from to 11:00";
		TimeParser.addTimeArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testForInvalidEndInput() throws InvalidInputException {
		String test = "add event from 11:00 to ";
		TimeParser.addTimeArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testForInvalidTimeInput() throws InvalidInputException {
		String test = "add event from to ";
		TimeParser.addTimeArg(test);
	}

}
