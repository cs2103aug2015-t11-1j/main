package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logic.AddTask;

public class ParserTest {

	ArrayList<String> expectedDate = new ArrayList<String>();
	ArrayList<String> expectedTime = new ArrayList<String>();

	@Test
	public void testSetCommand1() {
		String test = "add event from 211015 to 221015";
		AddTask add = (AddTask) Parser.setCommand(test);

		String expected = "event";
		expectedDate.add("21/10/15");
		expectedDate.add("22/10/15");
		expectedTime.add("");
		expectedTime.add("");

		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}
	
	@Test
	public void testSetCommand2() {
		String test = "add event from 211015 111115 to 221015";
		AddTask add = (AddTask) Parser.setCommand(test);

		String expected = "event";
		expectedDate.add("21/10/15");
		expectedDate.add("22/10/15");
		expectedTime.add("");
		expectedTime.add("");

		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}
	
	@Test
	public void testSetCommand3() {
		String test = "add event today";
		AddTask add = (AddTask) Parser.setCommand(test);

		String expected = "event";
		expectedDate.add("21/10/15");
		expectedDate.add(null);
		expectedTime.add("");
		expectedTime.add("");

		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}
	
	@Test
	public void testSetCommand4() {
		String test = "add event today 10:00 to 11:00";
		AddTask add = (AddTask) Parser.setCommand(test);

		String expected = "event";
		expectedDate.add("21/10/15");
		expectedDate.add(null);
		expectedTime.add("1000");
		expectedTime.add("1100");

		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}

}
