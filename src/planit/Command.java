/*
 * Command class allows a Command object to be created. This object holds all the necessary
 * arguments present in the user's input
 * 
 * userStringInput: the entire string input by the user
 * userCommand: the string representing the intended command of the user. Always the first word of userStringInput
 * userActionType: the ACTION_TYPE representing the intended command of the user
 * userEventTask: the event/task specified by the user in userStringInput
 * userUpdateEventTask: the event/task which the user wants updated to
 * userDateRange: an array list containing the date frame specified by the user. 1st index is the start date, 2nd index is the end date
 * userTimeRange: an array list containing the time frame specified by the user. 1st index is the start time, 2nd index is the end time
 * 
 */

package planit;

import java.util.ArrayList;

import planit.StringParser.ACTION_TYPE;

public class Command {

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

	private static final int RANGE_ARRAY_SIZE = 2;

	private String userStringInput = null;
	private String userCommand = null; // Action type
	private ACTION_TYPE userActionType = null;
	private String userEventTask = null; // Type of event/task
	private String userUpdateEventTask = null;

	private ArrayList<String> userDateRange = new ArrayList<String>(RANGE_ARRAY_SIZE);
	private ArrayList<String> userTimeRange = new ArrayList<String>(RANGE_ARRAY_SIZE);

	/*****CONSTRUCTOR*****/
	public Command() {

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
	
	public ACTION_TYPE getActionType() {
		return userActionType;
	}

	public String getUserEventTask() {
		return userEventTask;
	}
	
	public String getUserUpdateEventTask() {
		return userUpdateEventTask;
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
	
	//return date range in String form
	public String getDateString() {
		return userDateRange.get(INDEX_FIRST) + userDateRange.get(INDEX_SECOND);
	}
	
	//return time range in String form
	public String getTimeString() {
		return userTimeRange.get(INDEX_FIRST) + userTimeRange.get(INDEX_SECOND);
	}

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
	
	public void setUserUpdateEventTask(String str) {
		this.userUpdateEventTask = str;
	}

	public void setUserDate(ArrayList<String> strArrayList) {
		this.userDateRange = strArrayList;
	}

	public void setUserTime(ArrayList<String> strArrayList) {
		this.userTimeRange = strArrayList;
	}

}
