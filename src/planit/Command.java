/*
 * Command class allows a Command object to be created. This object holds all the necessary
 * arguments present in the user's input
 * 
 */

package planit;

import java.util.ArrayList;

import planit.StringParser.ACTION_TYPE;

public class Command {

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

	private static final int RANGE_ARRAY_SIZE = 2;

	// private static StringParser sp = new StringParser();

	private String userStringInput = null;
	private String userCommand = null; // Action type
	private ACTION_TYPE userActionType = null;
	private String userEventTask = null; // Type of event/task

	private ArrayList<String> userDateRange = new ArrayList<String>(RANGE_ARRAY_SIZE);
	// ArrayList
	// of
	// dates
	// private String userDateString = null; // formatted string of date/dates

	private ArrayList<String> userTimeRange = new ArrayList<String>(RANGE_ARRAY_SIZE);
	// ArrayList
	// of
	// times
	// private String userTimeString = null; // formatted string of date/dates

	public Command() {
		// this.setUserStringInput(userStringInput);
		// this.executeParsing(userStringInput);
	}

	/*
	 * private void executeParsing(String userStringInput) {
	 * this.setUserCommand(userStringInput);
	 * this.setUserEventTask(userStringInput);
	 * this.setUserDate(userStringInput); this.setUserTime(userStringInput); }
	 */

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
	
	public ACTION_TYPE getActionType() {
		return userActionType;
	}

	public String getUserEventTask() {
		return userEventTask;
	}

	public ArrayList<String> getUserDateRange() {
		return userDateRange;
	}

	public String getUserDateStart() {
		return userDateRange.get(INDEX_FIRST);
	}

	public String getUserDateEnd() {
		return userDateRange.get(INDEX_SECOND);
	}

	public ArrayList<String> getUserTimeRange() {
		return userTimeRange;
	}

	public String getUserTimeStart() {
		return userTimeRange.get(INDEX_FIRST);
	}

	public String getUserTimeEnd() {
		return userTimeRange.get(INDEX_SECOND);
	}

	public String getUserStringInput() {
		return userStringInput;
	}

	/*
	 * public String getUserDateString() { return userDateString; }
	 * 
	 * public String getUserTimeString() { return userTimeString; }
	 */

	/*
	 * MUTATORS
	 * 
	 * Sets the relevant data to the attributes using methods from StringParser
	 * class
	 * 
	 */
	public void setUserStringInput(String str) {
		this.userStringInput = str;
	}

	public void setUserCommand(String str) {
		this.userCommand = str;
	}
	
	public void setUserActionType(ACTION_TYPE action) {
		this.userActionType = action;
	}

	public void setUserEventTask(String str) {
		this.userEventTask = str;
	}

	public void setUserDate(ArrayList<String> strArrayList) {
		this.userDateRange = strArrayList;
		/*
		 * if (userDateRange.isEmpty() && !userTimeRange.isEmpty()) { Date today
		 * = Calendar.getInstance().getTime(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("ddMMyy"); userDateRange.add(sdf.format(today)); }
		 */
	}

	public void setUserTime(ArrayList<String> strArrayList) {
		this.userTimeRange = strArrayList;
	}

	/*
	 * public void setUserDateString(String dateString) { userDateString =
	 * dateString; }
	 * 
	 * public void setUserTimeString(String timeString) { userTimeString =
	 * timeString; }
	 */

}
