package planit;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTaskParserTest {
	
	@Test
	public void testEventTaskParser1() {
		String test = "add this event from today till tomorrow";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}
	
	@Test
	public void testEventTaskParser2() {
		String test = "add this event TODAY";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}
	
	@Test
	public void testEventTaskParser3() {
		String test = "add this event next week";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}
	
	@Test
	public void testEventTaskParser4() {
		String test = "add this event > 10 may";
		String result = EventTaskParser.getEventTask(test);
		String expected = "this event";
		assertEquals(expected, result);
	}

}
