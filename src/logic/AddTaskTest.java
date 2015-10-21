package logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import storage.Output;

public class AddTaskTest {
	
	@Test
	public void testAddTask() {
		AddTask at = new AddTask();
		
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		date.add("21/10/15");
		time.add("1200HRS");
		time.add("1400HRS");
		
		at.setEventTask("meeting");
		at.setDate(date);
		at.setTime(time);
		
		Output expectedOP = new Output(true, "21/10/15 1200 meeting");
		Output resultOP = at.execute();
		
		assertEquals(expectedOP, resultOP);
		
	}

}
