package planit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import planit.StringParser.ACTION_TYPE;

import org.junit.Before;
import org.junit.Test;

import com.sun.media.sound.InvalidFormatException;

public class StringParserTest {
	private StringParser sp;
	private Command cmd;
	private Command expectedCmd;
	ArrayList<String> dateArray;
	ArrayList<String> timeArray;
	
	@Before
	public void setUp() {
		sp = new StringParser();
		cmd = new Command();
		expectedCmd = new Command();
	}
	
	@Test
	public void testCommandObject1() throws InvalidFormatException {
		String test = "add event > 123456 1234 to 654321 4321";
		cmd = sp.parseStringIntoCommand(test);
		
		/*expectedCmd.setUserStringInput(test);
		expectedCmd.setUserCommand("add");
		expectedCmd.setUserActionType(ACTION_TYPE.ADD);
		expectedCmd.setUserEventTask("event");*/
		
		dateArray = new ArrayList<String>(2);
		timeArray = new ArrayList<String>(2);
		
		dateArray.add("123456");
		dateArray.add("654321");
		expectedCmd.setUserDate(dateArray);
		timeArray.add("1234");
		timeArray.add("4321");
		expectedCmd.setUserTime(timeArray);
		
		assertEquals("add", cmd.getUserCommand());
		assertEquals("event", cmd.getUserEventTask());
		assertEquals(dateArray, cmd.getUserDateRange());
		assertEquals(timeArray, cmd.getUserTimeRange());
		assertEquals(ACTION_TYPE.ADD, cmd.getActionType());
	}
}
