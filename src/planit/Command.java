package planit;

public class Command {
	
	public enum actionType{
		ADD, SHOW, SEARCH, UPDATE, DONE, UNDO;
	}
	
	private actionType type;
	private StringParser sp;
	
	private String userStringInput;
	
	private String userCommand = null;
	
	private String userEventTask = null;
	
	private String userDate = null;
	private String[] userDateRange = new String[2];
	
	private String userTime = null;
	private String[] userTimeRange = new String[2];
	
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
		return userDateRange[0];
	}
	
	public String getUserDateEnd() {
		return userDateRange[1];
	}
	
	public String getUserTime() {
		return userTime;
	}
	
	public String getUserTimeStart() {
		return userTimeRange[0];
	}
	
	public String getUserTimeEnd() {
		return userTimeRange[1];
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
		userEventTask = sp.extractEventTask(sp.splitStringIntoArrayDelimColon(userStringInput));
	}
}
