package parser;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logic.AddTask;
import logic.Command;

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
		expectedTime.add(null);
		expectedTime.add(null);

		assertEquals(expected, add.getEventTask());
		assertEquals(expectedDate, add.getDate());
		assertEquals(expectedTime, add.getTime());
	}

}
