package ui;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;

public class JUnitTest {
	
	@Test
	public void testaddMessage() throws IOException {
		
		String addedTask = "meeting tmr";
		
		String actualString = Welcome.printAddedEvent(addedTask);
		String expectedString = "Success! meeting tmr is added to your schedule:)";
		
		assertEquals(expectedString, actualString);
		
		
	}
	
	@Test
	public void testshowMessage() throws IOException {
		
		ArrayList<String> message = new ArrayList<String>();
		message.add("meeting tmr");
		message.add("meeting 221015 from 1900 to 2200");
		message.add("feed the dog");
		message.add("project deadline 251215");
		
		ArrayList<String> actualMessage = Welcome.printShowEvent(message);
		ArrayList<String> expectedMessage = new ArrayList<String>();
		expectedMessage.add("meeting tmr");
		expectedMessage.add("meeting 221015 from 1900 to 2200");
		expectedMessage.add("feed the dog");
		expectedMessage.add("project deadline 251215");
		
		assertEquals(expectedMessage, actualMessage);
		
		
		
	}
}



