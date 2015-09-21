package planit;

import static org.junit.Assert.*;

import org.junit.Test;

public class GetterMethodsTest {

	@Test
	public void testGetUserCommand() {
		StringParser objectTest = new StringParser();
		String testString = "add"; 
		objectTest.setUserCommand(testString);
		String resultString = objectTest.getUserCommand();
		
		assertTrue(resultString.equals("add"));
	}

	@Test
	public void testGetUserEventTask() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserStartDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserEndDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserStartTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserEndTime() {
		fail("Not yet implemented");
	}

}
