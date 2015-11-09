/*
 * @@author A0121319R
 */

package parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTaskParserTest {

	@Test
	public void testDateToday() throws InvalidInputException {
		String test = "add CS2103 tutorial today";
		String result = EventTaskParser.getEventTask(test);
		String expected = "CS2103 tutorial";
		assertEquals(expected, result);
	}

	@Test
	public void testDateTomorrowWithIndex() throws InvalidInputException {
		String test = "add 1000 CS2101 tutorial tomorrow";
		String result = EventTaskParser.getEventTask(test);
		String expected = "CS2101 tutorial";
		assertEquals(expected, result);
	}

	@Test
	public void testTwoDatesWithInvalidIndexAndTodayTmr() throws InvalidInputException {
		String test = "add -100 CS2100 tutorial from today to tomorrow";
		String result = EventTaskParser.getEventTask(test);
		String expected = "CS2100 tutorial";
		assertEquals(expected, result);
	}

	@Test
	public void testWatchMovieWithToday() throws InvalidInputException {
		String test = "add watch day after tomorrow today 9pm";
		String result = EventTaskParser.getEventTask(test);
		String expected = "watch day after tomorrow";
		assertEquals(expected, result);
	}

	@Test
	public void testWatchMovieWithProperDates() throws InvalidInputException {
		String test = "add watch day after tomorrow 12/12/15 9pm";
		String result = EventTaskParser.getEventTask(test);
		String expected = "watch day after";
		assertEquals(expected, result);
	}

	@Test
	public void testTravelFromPointToPoint() throws InvalidInputException {
		String test = "add drive from clementi to yishun from 12/12/15 9pm to 10pm";
		String result = EventTaskParser.getEventTask(test);
		String expected = "drive from clementi to yishun";
		assertEquals(expected, result);
	}

	@Test
	public void testWithAngleBrackets() throws InvalidInputException {
		String test = "add this event > 10 may";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}

	@Test
	public void testWithIndex() throws InvalidInputException {
		String test = "update 1 meeting today 10am to 11am";
		String result = EventTaskParser.getEventTask(test);
		String expected = "meeting";
		assertEquals(expected, result);
	}

	@Test
	public void testWithoutDateTimeArgs() throws InvalidInputException {
		String test = "add event";
		String result = EventTaskParser.getEventTask(test);
		String expected = "event";
		assertEquals(expected, result);
	}

	@Test(expected = InvalidInputException.class)
	public void testInvalidInput() throws InvalidInputException {
		String test = "add";
		EventTaskParser.getEventTask(test);
	}

	@Test
	public void testProperInputWithKeywords() throws InvalidInputException {
		String test = "add meeting @ NUS tomorrow";
		String result = EventTaskParser.getEventTask(test);
		String expected = "meeting @ NUS";
		assertEquals(expected, result);
	}

	@Test
	public void testProperInputWithoutKeywords() throws InvalidInputException {
		String test = "add meeting 10/10/15 10am";
		String result = EventTaskParser.getEventTask(test);
		String expected = "meeting";
		assertEquals(expected, result);
	}

}
