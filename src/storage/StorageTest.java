package storage;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import logic.Task;
import logic.State;

public class StorageTest {

	@Test
	public void textfiletest() throws IOException {
		Storage s = new Storage();
		assertEquals("planner.txt", s.getFilePath());
		ArrayList<Task> tl = new ArrayList<Task>();
		tl.add(new Task("12/12/15", "1200", "Meeting with Mrs. Awesome"));
		tl.add(new Task("Buy dog food"));
		tl.add(new Task("13/12/15", "Holiday today"));
		assertEquals("12/12/15 1200 Meeting with Mrs. Awesome", tl.get(0).toString());
		State s1 = new State(tl);
		s.update(s1);
		State s2 = s.extractState();
		assertEquals("12/12/15 1200 Meeting with Mrs. Awesome", s2.getTaskList().get(0).toString());
		assertEquals("Buy dog food", s2.getTaskList().get(1).toString());
		assertEquals("13/12/15 Holiday today", s2.getTaskList().get(2).toString());
	}
}
