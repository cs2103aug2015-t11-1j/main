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

	@Test
	public void testForOneEndDateAndTwoTimeArgs() throws InvalidInputException {
		String test = "add event from 10:00 to 10/10/15 10:00";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("1000");
		expectedTime.add("1000");
		expectedDate.add(DateParser.getDate(0));
		expectedDate.add("10/10/15");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test
	public void testForTodayAndEndTime() throws InvalidInputException {
		String test = "add event by 11.00";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("");
		expectedTime.add("1100");
		expectedDate.add("");
		expectedDate.add(DateParser.getDate(0));
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test(expected = InvalidInputException.class)
	public void testForOneEndTimeWithOneStartDate() throws InvalidInputException {
		String test = "add event from 10/10/15 to 11.00";
		TimeParser.addTimeArg(test);
		DateParser.addDateArg(test);
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
	public void testForNoDateOrTimeArg() throws InvalidInputException {
		String test = "add event";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("");
		expectedTime.add("");
		expectedDate.add("");
		expectedDate.add("");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test
	public void testForTodayDate() throws InvalidInputException {
		String test = "add event toDaY at 1100";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("1100");
		expectedTime.add("");
		expectedDate.add(DateParser.getDate(0));
		expectedDate.add("");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test
	public void testForTomorrowDate() throws InvalidInputException {
		String test = "add event tMr at 1200";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("1200");
		expectedTime.add("");
		expectedDate.add(DateParser.getDate(1));
		expectedDate.add("");
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test // expected to fail - same with tomorrow
	public void testForDeadlineTodayWithTime() throws InvalidInputException {
		String test = "add event by TOday";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("");
		expectedTime.add("");
		expectedDate.add("");
		expectedDate.add(DateParser.getDate(0));
		assertEquals(expectedTime, resultTime);
		assertEquals(expectedDate, resultDate);
	}

	@Test
	public void testForNoTimeArgWithDateArgs() throws InvalidInputException {
		String test = "add event from 12/10/15 to 13/10/15";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("");
		expectedTime.add("");
		expectedDate.add("12/10/15");
		expectedDate.add("13/10/15");
		assertEquals(expectedDate, resultDate);
		assertEquals(expectedTime, resultTime);
	}

	@Test
	public void testForNoDateArgWithTimeArgs() throws InvalidInputException {
		String test = "add event from 11:00 to 1200";
		resultTime = TimeParser.addTimeArg(test);
		resultDate = DateParser.addDateArg(test);
		expectedTime.add("1100");
		expectedTime.add("1200");
		expectedDate.add(DateParser.getDate(0));
		expectedDate.add(DateParser.getDate(0));
		assertEquals(expectedDate, resultDate);
		assertEquals(expectedTime, resultTime);
	}

	@Test(expected = InvalidInputException.class)
	public void testForTooManyStartInputs() throws InvalidInputException {
		String test = "add event from 10/10/15 11:00 11:01 to 11/10/15 12:34";
		TimeParser.addTimeArg(test);
		DateParser.addDateArg(test);
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

	@Test(expected = InvalidInputException.class)
	public void testTooManyStartDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from 23/10/15 22/10/15 to 24/10/15";
		DateParser.addDateArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testTooManyEndDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from 23/10/15 to 24/10/15 22/10/15";
		DateParser.addDateArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testInvalidEndDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from 23/10/15 to ";
		DateParser.addDateArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testInvalidStartDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from to 24/10/15 ";
		DateParser.addDateArg(test);
	}

	@Test(expected = InvalidInputException.class)
	public void testInvalidDateInput() throws NullPointerException, InvalidInputException {
		String test = "add event from to ";
		DateParser.addDateArg(test);
	}

}
