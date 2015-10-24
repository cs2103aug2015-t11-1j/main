package parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTaskParserTest {

	@Test
	public void testDateToday() throws InvalidInputException {
		String test = "add this event TODAY";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}

	@Test
	public void testWithStartDateOnly() throws InvalidInputException {
		String test = "add this event by MONDAY";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
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
		String test = "update 1 meeting";
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
	public void testEventTaskParser7() throws InvalidInputException {
		String test = "add";
		EventTaskParser.getEventTask(test);
	}

	@Test
	public void testProperInput() throws InvalidInputException {
		String test = "add meeting @ NUS tomorrow";
		String result = EventTaskParser.getEventTask(test);
		String expected = "meeting @ NUS";
		assertEquals(expected, result);
	}
}
