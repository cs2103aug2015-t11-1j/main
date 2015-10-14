package planit;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import planit.StringParser.ACTION_TYPE;

import org.junit.Before;
import org.junit.Test;

import com.sun.media.sound.InvalidFormatException;

public class StringParserTest {
	private StringParser sp;
	private Command cmd;
	private String todayDate;
	ArrayList<String> dateArray;
	ArrayList<String> timeArray;
	
	@Before
	public void setUp() {
		sp = new StringParser();
		cmd = new Command();
		//expectedCmd = new Command();
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		todayDate = sdf.format(today);
	}
	
	@Test
	public void testCommandObject1() throws InvalidFormatException {
		String test = "add event > 123456 1234 to 654321 4321";
		cmd = sp.parseStringIntoCommand(test);
		
		dateArray = new ArrayList<String>(2);
		timeArray = new ArrayList<String>(2);
		
		dateArray.add("123456");
		dateArray.add("654321");
		timeArray.add("1234");
		timeArray.add("4321");
		
		assertEquals("add", cmd.getUserCommand());
		assertEquals("event", cmd.getUserEventTask());
		assertEquals(dateArray, cmd.getUserDateRange());
		assertEquals(timeArray, cmd.getUserTimeRange());
		assertEquals(ACTION_TYPE.ADD, cmd.getActionType());
	}
	
	@Test
	public void testCommandObject2() throws InvalidFormatException {
		String test = "add event > 1234 to 4321";
		cmd = sp.parseStringIntoCommand(test);
		
		dateArray = new ArrayList<String>(2);
		timeArray = new ArrayList<String>(2);
		
		dateArray.add(todayDate);
		dateArray.add("??????");
		timeArray.add("1234");
		timeArray.add("4321");
		
		assertEquals("add", cmd.getUserCommand());
		assertEquals("event", cmd.getUserEventTask());
		assertEquals(dateArray, cmd.getUserDateRange());
		assertEquals(timeArray, cmd.getUserTimeRange());
		assertEquals(ACTION_TYPE.ADD, cmd.getActionType());
	}
	
	@Test
	public void testCommandObject3() throws InvalidFormatException {
		String test = "add floating event";
		cmd = sp.parseStringIntoCommand(test);
		
		dateArray = new ArrayList<String>(2);
		timeArray = new ArrayList<String>(2);
		
		dateArray.add("??????");
		dateArray.add("??????");
		
		assertEquals("add", cmd.getUserCommand());
		assertEquals("floating event", cmd.getUserEventTask());
		assertEquals(dateArray, cmd.getUserDateRange());
		assertTrue("timeArray is not empty", cmd.getUserTimeRange().isEmpty());
		assertEquals(ACTION_TYPE.ADD, cmd.getActionType());
	}
}
