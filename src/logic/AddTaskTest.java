package logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import storage.Output;

public class AddTaskTest {
	
	@Test
	public void singleDateTest() {
		AddTask at = new AddTask();
		
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		date.add("21/10/15");
		time.add("1200");
		time.add("1400");
		
		at.setEventTask("meeting");
		at.setDate(date);
		at.setTime(time);
		
		Output expectedOP = new Output(true, "1 21/10/15 1200-1400 meeting", "add");
		Output resultOP = at.execute();
		
		assertEquals(expectedOP.getEntry(), resultOP.getEntry());
		assertEquals(expectedOP.getCmdType(), resultOP.getCmdType());
		
//		assertTrue(expectedOP.equals(resultOP));
		
//		assertEquals(expectedOP, resultOP);
		
	}

	@Test
	public void doubleDateTimeTest() {
		AddTask at = new AddTask();
		
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		date.add("21/10/15");
		date.add("22/10/15");
		time.add("0900");
		time.add("1400");
		
		at.setEventTask("meeting");
		at.setDate(date);
		at.setTime(time);
		
		Output expectedOP = new Output(true, "1 21/10/15-22/10/15 0900-1400 meeting", "add");
		Output resultOP = at.execute();
		
		assertEquals(expectedOP.getEntry(), resultOP.getEntry());
		assertEquals(expectedOP.getCmdType(), resultOP.getCmdType());
		
//		assertEquals(expectedOP, resultOP);
		
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void absentTimeTest() {
		AddTask at = new AddTask();
		
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		date.add("23/10/15");
		date.add("24/10/15");
		
		at.setEventTask("holiday");
		at.setDate(date);
		at.setTime(time);
		
		Output expectedOP = new Output(true, "23/10/15-24/10/15 holiday", "add");
		Output resultOP = at.execute();
		
		assertEquals(expectedOP.getEntry(), resultOP.getEntry());
		assertEquals(expectedOP.getCmdType(), resultOP.getCmdType());
		
//		assertEquals(expectedOP, resultOP);
		
	}

}
