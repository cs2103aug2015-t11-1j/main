package parser;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTaskParserTest {

	@Test
	public void testEventTaskParser1() throws InvalidInputException {
		String test = "add this event from today till tomorrow";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}

	@Test
	public void testEventTaskParser2() throws InvalidInputException {
		String test = "add this event TODAY";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}

	@Test
	public void testEventTaskParser3() throws InvalidInputException {
		String test = "add this event by MONDAY";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}

	@Test
	public void testEventTaskParser4() throws InvalidInputException {
		String test = "add this event > 10 may";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}

	@Test
	public void testEventTaskParser5() throws InvalidInputException {
		String test = "update 1 meeting";
		String result = EventTaskParser.getEventTask(test);
		String expected = "meeting";
		assertEquals(expected, result);
	}

	@Test
	public void testEventTaskParser6() throws InvalidInputException {
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
	public void testEventTaskParser8() throws InvalidInputException {
		String test = "add meeting @ NUS tomorrow";
		String result = EventTaskParser.getEventTask(test);
		String expected = "meeting @ NUS";
		assertEquals(expected, result);
	}
}
