package planit;

import java.util.ArrayList;

public class Command {
	
	public enum actionType{
		ADD, SHOW, SEARCH, UPDATE, DONE, UNDO;
	}
	
	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;
	
	private static final int RANGE_ARRAY_SIZE = 2;
	
	private actionType type;
	private StringParser sp;
	
	private String userStringInput;
	
	private String userCommand = null;
	
	private String userEventTask = null;
	
	private String userDate = null;
	private String[] userDateRange = new String[RANGE_ARRAY_SIZE];
	
	private String userTime = null;
	private String[] userTimeRange = new String[RANGE_ARRAY_SIZE];
	
	public Command(String userStringInput) {
		this.userStringInput = userStringInput;
		sp = new StringParser(userStringInput);
	}
	
	/*
	 * ACCESSORS
	 * 
	 * Used by :logic to determine what to do with the <event>, <date>
	 * and <time> inputs
	 * 
	 */
	public String getUserCommand() {
		return userCommand;
	}
	
	public String getUserEventTask() {
		return userEventTask;
	}
	
	public String getUserDate() {
		return userDate;
	}
	
	public String getUserDateStart() {
		return userDateRange[INDEX_FIRST];
	}
	
	public String getUserDateEnd() {
		return userDateRange[INDEX_SECOND];
	}
	
	public String getUserTime() {
		return userTime;
	}
	
	public String getUserTimeStart() {
		return userTimeRange[INDEX_FIRST];
	}
	
	public String getUserTimeEnd() {
		return userTimeRange[INDEX_SECOND];
	}
	
	/*
	 * MUTATORS
	 * 
	 * Sets the relevant data to the attributes using methods from
	 * StringParser class
	 * 
	 */
	public void setUserCommand() {
		userCommand = sp.extractUserCommand(sp.splitStringIntoArrayDelimSpace(userStringInput));
	}
	
	public void setUserEventTask() {
		userEventTask = sp.extractUserEventTask(sp.splitStringIntoArrayDelimColon(userStringInput));
	}
	
	public void setUserDate() {
		ArrayList<String> stringArray = sp.splitStringIntoArrayDelimColon(userStringInput);
		userDate = sp.extractUserDate(sp.splitStringIntoArrayDelimSpace(stringArray.get(INDEX_SECOND)));
	}
	
	public void setUserTime() {
		
	}
	
	public void setUserDateRange() {
		
	}
	
	public void setUserTimeRange() {
		
	}
}
