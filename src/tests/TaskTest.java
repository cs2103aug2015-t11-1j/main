//@@author: idawatibustan A0130383N

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import logic.Task;

public class TaskTest {

	@Test
	public void rotatetest() {
		Task t1 = new Task("12/10/15", "", "Hello");
		Task t2 = new Task("", "", "Oh my");
		assertEquals("15/10/12 ", t1.rotateDF());
		System.out.println(t1.get_date() + "|" + t2.get_date() + "|");
		assertEquals("", t2.rotateDF());
	}

}
