package logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class StateTest {

	@Test
	public void testAddSort() {
		ArrayList<Task> tl = new ArrayList<Task>();
		State s2 = new State(tl);
		s2.add(new Task("12/12/15", "1200", "Meeting with Mrs. Awesome"));
		s2.add(new Task("Buy dog food"));
		s2.add(new Task("13/11/15", "1100", "Holiday today"));
		s2.add(new Task("13/11/15", "0900", "Finish work"));
		assertEquals("12/12/15 1200 Meeting with Mrs. Awesome", s2.getTaskList().get(0).toString());
		assertEquals("Buy dog food", s2.getTaskList().get(1).toString());
		assertEquals("13/11/15 1100 Holiday today", s2.getTaskList().get(2).toString());
		assertEquals("13/11/15 0900 Finish work", s2.getTaskList().get(3).toString());
		s2.sort();
		assertEquals("Buy dog food", s2.getTaskList().get(0).toString());
		assertEquals("12/12/15 1200 Meeting with Mrs. Awesome", s2.getTaskList().get(3).toString());
		assertEquals("13/11/15 0900 Finish work", s2.getTaskList().get(1).toString());
		assertEquals("13/11/15 1100 Holiday today", s2.getTaskList().get(2).toString());
	}

}
