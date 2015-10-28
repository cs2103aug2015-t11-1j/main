package ui;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;

import com.sun.javafx.tk.Toolkit.Task;

import logic.AddTask;
import logic.Command;
import storage.Output;

public class JUnitTest {

	@Test
	public void testSearchMessage() throws IOException {

		ArrayList<Task> eventTasks = new ArrayList<Task>();
		ArrayList<Task> list = new ArrayList<Task>();
		 
		Output op = new Output(true, "meeting tmr", "search");
		String actualString = Welcome.printMessage(op);
		String expectedString = "Success! meeting tmr "
				+ "is found in your schedule!";

		assertEquals(expectedString, actualString);

	}

}
