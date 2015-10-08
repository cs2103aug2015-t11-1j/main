package planit;

import java.util.ArrayList;

public class Cmd {
	public enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID;
	}
	private String userInput;
	private ACTION_TYPE userCommand = null; //Action type
	private String userEventTask = null; // Type of event/task
	
	private ArrayList<String> userDateRange = new ArrayList<String>(); // ArrayList of dates
	private String userDateString = null; // formatted string of date/dates
	private ArrayList<String> userTimeRange = new ArrayList<String>(); // ArrayList of times
	private String userTimeString = null; // formatted string of date/dates
	
	public Cmd(String cmd){
		userInput = cmd;
	}
	
	/********MUTATORS********/
	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}
	
	private void setUserCommand(ACTION_TYPE userCommand) {
		this.userCommand = userCommand;
	}
	
	private void setEventTask(String userEventTask) {
		this.userEventTask = userEventTask;
	}
	
//	private void setUserDate(String userStringInput) {
//		userDateRange = sp.extractUserDate(userStringInput);
//		/*if (userDateRange.isEmpty() && !userTimeRange.isEmpty()) {
//			Date today = Calendar.getInstance().getTime();
//			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
//			userDateRange.add(sdf.format(today));
//		}*/
//	}
//	
//	private void setUserTime(String userStringInput) {
//		userTimeRange = sp.extractUserTime(userStringInput);
//	}
//	
//	public void setUserDateString(String dateString) {
//		userDateString = dateString;
//	}
//	
//	public void setUserTimeString(String timeString) {
//		userTimeString = timeString;
//	}
	
	/********ACCESSORS********/
	public ACTION_TYPE getUserCommand() {
		return userCommand;
	}

	public String getUserEventTask() {
		return userEventTask;
	}

//	public ArrayList<String> getUserDateRange() {
//		return userDateRange;
//	}
//
//	public String getUserDateStart() {
//		return userDateRange.get(INDEX_FIRST);
//	}
//
//	public String getUserDateEnd() {
//		return userDateRange.get(INDEX_SECOND);
//	}
//
//	public ArrayList<String> getUserTimeRange() {
//		return userTimeRange;
//	}
//
//	public String getUserTimeStart() {
//		return userTimeRange.get(INDEX_FIRST);
//	}
//
//	public String getUserTimeEnd() {
//		return userTimeRange.get(INDEX_SECOND);
//	}
//
//	public String getUserStringInput() {
//		return userStringInput;
//	}
//
//	public String getUserDateString() {
//		return userDateString;
//	}
//	
//	public String getUserTimeString() {
//		return userTimeString;
//	}
		
}
