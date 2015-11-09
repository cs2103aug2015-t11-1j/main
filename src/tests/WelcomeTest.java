// @@author A0125273L

package tests;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

import storage.Output;
import ui.Welcome;

public class WelcomeTest {

	@Test
	public void testPassAddMessage() throws IOException {

		Output op = new Output(true, "meeting", "add");
		String actualString = Welcome.printMessage(op);
		String expectedString = "meeting " + "is added to your schedule:)" + "\n" + "\n";

		assertEquals(expectedString, actualString);

	}

	@Test
	public void testFailAddMessage() throws IOException {

		Output op = new Output(false, "meeting", "add");
		String actualString = Welcome.printMessage(op);
		String expectedString = "Sorry but we are unable to add this event please check the input and try again!" + "\n"
				+ "\n";

		assertEquals(expectedString, actualString);
	}

	@Test
	public void testPassCFPMessage() throws IOException {

		Output op = new Output(true, "Planner.txt", "cfp");
		String actualString = Welcome.printMessage(op);
		String expectedString = "Planner.txt is your new file path!" + "\n" + "\n";

		assertEquals(expectedString, actualString);
	}

	@Test
	public void testFailCFPMessage() throws IOException {

		Output op = new Output(false, "Planner", "cfp");
		String actualString = Welcome.printMessage(op);
		String expectedString = "Your request has failed. Please check the name of your file path" + "\n" + "\n";

		assertEquals(expectedString, actualString);
	}

	@Test
	public void testPassDeleteMessage() throws IOException {

		Output op = new Output(true, "meeting", "delete");
		String actualString = Welcome.printMessage(op);
		String expectedString = "meeting is deleted from your schedule!" + "\n" + "\n";

		assertEquals(expectedString, actualString);

	}

	@Test
	public void testFailedDeleteMessage() throws IOException {

		Output op = new Output(false, "Index Out Of Bounds", "delete");

		String actualString = Welcome.printMessage(op);
		String expectedString = "Error! Index Out Of Bounds! Sadly there is no such event to delete!" + "\n" + "\n";

		assertEquals(expectedString, actualString);
	}

	@Test
	public void testDoneMessage() throws IOException {

		Output op = new Output(true, "meeting", "done");
		String actualString = Welcome.printMessage(op);
		String expectedString = "Well done you completed this task!" + "\n" + "\n";

		assertEquals(expectedString, actualString);
	}

	@Test
	public void testPassFPMessage() throws IOException {

		Output op = new Output(true, "Hello.txt", "fp");
		String actualString = Welcome.printMessage(op);
		String expectedString = "Hello.txt is your file path." + "\n" + "\n";

		assertEquals(expectedString, actualString);
	}

	// @Test
	// public void testFailFPMessage() throws IOException {

	// Output op = new Output(false, )
	// }

	@Test
	public void testHelpMessage() throws IOException {

		Output op = new Output(true, "Help", "help");
		String actualString = Welcome.printMessage(op);
		String expectedString = "The commands that can be used are: " + "\n" + "add <event/task>" + "\n"
				+ "cfp <change file path>" + "\n" + "clear <clears the display>" + "\n" + "delete <index>" + "\n"
				+ "mark <index>" + "\n" + "exit <shut down program>" + "\n" + "fp <show file path>" + "\n"
				+ "help <list of commands>" + "\n" + "search <event/task>" + "\n" + "show <date/today/done>" + "\n"
				+ "undo <cancel last action>" + "\n" + "update <index>" + "\n" + "unmark <index>" + "\n" + "\n";

		assertEquals(expectedString, actualString);
	}

	@Test
	public void testPassUpdateMessage() throws IOException {

		Output op = new Output(true, "meeting", "update");
		String actualString = Welcome.printMessage(op);
		String expectedString = "meeting Your event has been successfully updated!" + "\n" + "\n";

		assertEquals(expectedString, actualString);

	}

	@Test
	public void testFailUpdateMessage() throws IOException {

		Output op = new Output(false, "meeting", "update");
		String actualString = Welcome.printMessage(op);
		String expectedString = "Update failed!" + "\n" + "\n";

		assertEquals(expectedString, actualString);
	}
	
	@Test 
	public void testUndoneMessage() throws IOException {
		
		Output op = new Output(true, "meeting", "undone");
		String actualString = Welcome.printMessage(op);
		String expectedString = "Event/task is now incomplete" + "\n" + "\n";
		
		assertEquals(expectedString, actualString);
	}
}
