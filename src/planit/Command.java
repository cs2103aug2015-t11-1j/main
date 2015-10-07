package planit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Command {

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

	private static final int RANGE_ARRAY_SIZE = 2;

	private static StringParser sp = new StringParser();

	private String userStringInput;

	private String userCommand = null; //Action type

	private String userEventTask = null; // Type of event/task

	private String[] userDateRange = new String[RANGE_ARRAY_SIZE]; // Array of dates
	private String userDateString = null; // formatted string of date/dates
	
	private String[] userTimeRange = new String[RANGE_ARRAY_SIZE];
	private String userTimeString = null; // formatted string of date/dates
	
	
	public Command(String userStringInput) {
		this.setUserStringInput(userStringInput);
		this.executeParsing(userStringInput);
	}

	private void executeParsing(String userStringInput) {
		this.setUserCommand(userStringInput);
		this.setUserEventTask(userStringInput);
		this.setUserDate(userStringInput);
		this.setUserTime(userStringInput);		
	}


	/*
	 * ACCESSORS
	 * 
	 * Used by :logic to determine what to do with the <event>, <date> and
	 * <time> inputs
	 * 
	 */
	
	public String getUserCommand() {
		return userCommand;
	}

	public String getUserEventTask() {
		return userEventTask;
	}

	public String[] getUserDateRange() {
		return userDateRange;
	}

	public String getUserDateStart() {
		return userDateRange[INDEX_FIRST];
	}

	public String getUserDateEnd() {
		return userDateRange[INDEX_SECOND];
	}

	public String[] getUserTimeRange() {
		return userTimeRange;
	}

	public String getUserTimeStart() {
		return userTimeRange[INDEX_FIRST];
	}

	public String getUserTimeEnd() {
		return userTimeRange[INDEX_SECOND];
	}

	public String getUserStringInput() {
		return userStringInput;
	}

	public String getUserDateString() {
		return userDateString;
	}
	
	public String getUserTimeString() {
		return userTimeString;
	}
	
	/*
	 * MUTATORS
	 * 
	 * Sets the relevant data to the attributes using methods from StringParser
	 * class
	 * 
	 */
	public void setUserStringInput(String userStringInput) {
		this.userStringInput = userStringInput;
	}
	
	private void setUserCommand(String userStringInput) {
		userCommand = sp.extractUserCommand(userStringInput);
	}
	
	private void setUserEventTask(String userStringInput) {
		userEventTask = sp.extractUserEventTask(userStringInput);
	}
	
	private void setUserDate(String userStringInput) {
		userDateRange = sp.extractUserDate(userStringInput);
		if (userDateRange[INDEX_FIRST].equals(null)) {
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
			userDateRange[INDEX_FIRST] = sdf.format(today);
		}
	}
	
	private void setUserTime(String userStringInput) {
		userTimeRange = sp.extractUserTime(userStringInput);
	}
	
	public void setUserDateString(String dateString) {
		userDateString = dateString;
	}
	
	public void setUserTimeString(String timeString) {
		userTimeString = timeString;
	}
	
}
