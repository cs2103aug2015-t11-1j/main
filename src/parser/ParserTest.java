package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logic.AddTask;
import logic.DeleteTask;
import logic.DoneTask;
import logic.InvalidTask;
import logic.SearchTask;
import logic.UpdateTask;

public class ParserTest {

	ArrayList<String> expectedDate = new ArrayList<String>();
	ArrayList<String> expectedTime = new ArrayList<String>();

	@Test
	public void testSetCommandWithTimeOnly() {
		String test = "add event from 11:00 to 12:00";
		assertTrue(Parser.setCommand(test) instanceof AddTask);
		AddTask add = (AddTask) Parser.setCommand(test);
		
		String expected = "event";
		expectedDate.add(DateParser.getDate(0));
		expectedDate.add(DateParser.getDate(0));
		expectedTime.add("1100");
		expectedTime.add("1200");
		
		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}
	
	@Test
	public void testSetCommandWithDateOnly() {
		String test = "add event from 21/10/15 to 22/10/15";
		assertTrue(Parser.setCommand(test) instanceof AddTask);
		AddTask add = (AddTask) Parser.setCommand(test);
		
		String expected = "event";
		expectedDate.add("21/10/15");
		expectedDate.add("22/10/15");
		expectedTime.add("");
		expectedTime.add("");
		
		assertTrue(Parser.setCommand(test) instanceof AddTask);
		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}
	
	@Test
	public void testSetCommandWithBothDateAndTime() {
		String test = "add event from 21-10-15 1100 to 22.10.15 12.00";
		assertTrue(Parser.setCommand(test) instanceof AddTask);
		AddTask add = (AddTask) Parser.setCommand(test);
		
		String expected = "event";
		expectedDate.add("21/10/15");
		expectedDate.add("22/10/15");
		expectedTime.add("1100");
		expectedTime.add("1200");
		
		assertTrue(Parser.setCommand(test) instanceof AddTask);
		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}
	
	@Test
	public void testSetCommandWithInvalidTimeInputs() {
		String test = "new event from 11:00 12:00 to 12:00";
		assertTrue(Parser.setCommand(test) instanceof InvalidTask);
	}
	
	@Test
	public void testForSearchAction() {
		String test = "seArch this event";
		assertTrue(Parser.setCommand(test) instanceof SearchTask);
		SearchTask search = (SearchTask) Parser.setCommand(test);
		
		String expected = "this event";
		assertEquals(expected, search.getEventTask());
	}
	
	@Test
	public void testForFailedSearchActionNoEventTaskArg() {
		String test = "search ";
		assertTrue(Parser.setCommand(test) instanceof InvalidTask);
	}
	
	@Test
	public void testUpdateAction() {
		String test = "update 1 new event name from 10/10/15 1100 to 11/10/15 12.00";
		assertTrue(Parser.setCommand(test) instanceof UpdateTask);
		UpdateTask update = (UpdateTask) Parser.setCommand(test);
		
		String expectedEvent = "new event name";
		int expectedIndex = 1;
		assertEquals(expectedEvent, update.getEventTask());
		expectedDate.add("10/10/15");
		expectedDate.add("11/10/15");
		expectedTime.add("1100");
		expectedTime.add("1200");
		assertEquals(expectedDate, update.getDate());
		assertEquals(expectedTime, update.getTime());
		assertEquals(expectedIndex, update.getIndex());
	}
	
	@Test
	public void testDoneAction() {
		String test = "done 2";
		assertTrue(Parser.setCommand(test) instanceof DoneTask);
		DoneTask done = (DoneTask) Parser.setCommand(test);
		
		int expected = 2;
		assertEquals(expected, done.getIndex());
	}
	
	@Test
	public void testFailedDoneAction() {
		String test = "done";
		assertTrue(Parser.setCommand(test) instanceof InvalidTask);
	}
	
	@Test
	public void testDeleteAction() {
		String test = "deL 2";
		assertTrue(Parser.setCommand(test) instanceof DeleteTask);
		DeleteTask delete = (DeleteTask) Parser.setCommand(test);
		
		int expected = 2;
		assertEquals(expected, delete.getIndex());
	}
	
	@Test
	public void testFailedDeleteAction() {
		String test = "delete ";
		assertTrue(Parser.setCommand(test) instanceof InvalidTask);
	}
	
	/*@Test
	public void testSetCommand1() {
		String test = "add event from 211015 to 221015";
		AddTask add = (AddTask) Parser.setCommand(test);

		String expected = "event";
		expectedDate.add("21/10/15");
		expectedDate.add("22/10/15");
		//expectedTime.add("");
		//expectedTime.add("");

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
		//expectedTime.add("");
		//expectedTime.add("");

		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}
	
	@Test
	public void testSetCommand3() {
		String test = "add event today";
		AddTask add = (AddTask) Parser.setCommand(test);

		String expected = "event";
		expectedDate.add("22/10/15");
		expectedDate.add("");
		//expectedTime.add("");
		//expectedTime.add("");

		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}
	
	@Test
	public void testSetCommand4() {
		String test = "add event today 10:00 to 11:00";
		AddTask add = (AddTask) Parser.setCommand(test);

		String expected = "event";
		expectedDate.add("22/10/15");
		expectedDate.add("");
		expectedTime.add("1000");
		expectedTime.add("1100");

		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}*/
}
