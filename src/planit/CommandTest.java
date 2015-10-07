package planit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandTest {

	@Test
	public void testCommandObject1() {
		String testString = "add this event > 112233 1122 to 223344 2233";
		Command testCommand = new Command(testString);
		
		String resultUserCommand = testCommand.getUserCommand();
		String resultUserEventTask = testCommand.getUserEventTask();
		String resultUserDateStart = testCommand.getUserDateStart();
		String resultUserDateEnd = testCommand.getUserDateEnd();
		String resultUserTimeStart = testCommand.getUserTimeStart();
		String resultUserTimeEnd = testCommand.getUserTimeEnd();
		
		assertTrue("user command is incorrect", resultUserCommand.equals("add"));
		assertTrue("user event/task is incorrect", resultUserEventTask.equals("this event"));
		assertTrue("user start date is incorrect", resultUserDateStart.equals("112233"));
		assertTrue("user end date is incorrect", resultUserDateEnd.equals("223344"));
		assertTrue("user start time is incorrect", resultUserTimeStart.equals("1122"));
		assertTrue("user end time is incorrect", resultUserTimeEnd.equals("2233"));
	}
	
	@Test
	public void testCommandObject2() {
		String testString = "add this event > 1122 to 2233";
		Command testCommand = new Command(testString);
		
		String resultUserCommand = testCommand.getUserCommand();
		String resultUserEventTask = testCommand.getUserEventTask();
		String resultUserDateStart = testCommand.getUserDateStart();
		String resultUserDateEnd = testCommand.getUserDateEnd();
		String resultUserTimeStart = testCommand.getUserTimeStart();
		String resultUserTimeEnd = testCommand.getUserTimeEnd();
		
		assertTrue("user command is incorrect", resultUserCommand.equals("add"));
		assertTrue("user event/task is incorrect", resultUserEventTask.equals("this event"));
		assertTrue("user start date is incorrect", resultUserDateStart.equals(null));
		assertTrue("user end date is incorrect", resultUserDateEnd.equals(null));
		assertTrue("user start time is incorrect", resultUserTimeStart.equals("1122"));
		assertTrue("user end time is incorrect", resultUserTimeEnd.equals("2233"));
	}

}
