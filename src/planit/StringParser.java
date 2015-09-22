/*
 * Author: Jeston Teo
 * 
 * This class parses an entire string command into its respective <categories>
 * ASSUMPTIONS:
 * 1) Commands are entered in this general format: <command> <event> <date> <time>
 * TODO  
 */

package planit;

import java.util.ArrayList;

public class StringParser {
	/*
	 * ATTRIBUTES
	 */
	private String userStringInput;
	private ArrayList<String> stringArray = new ArrayList<String>(); 
	private String userCommand = null;
	private String userEventTask = null;
	private String userDate = null;
	private String userStartDate = null;
	private String userEndDate = null;
	private String userTime = null;
	private String userStartTime = null;
	private String userEndTime = null;
	
	/*
	 * CONSTRUCTORS
	 */
	public StringParser() {
		
	}
	
	public StringParser(String userStringInput) {
		this.userStringInput = userStringInput;
	}
	
	/*
	 * ACCESSORS
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
	
	public String getUserStartDate() {
		return userStartDate;
	}
	
	public String getUserEndDate() {
		return userEndDate;
	}
	
	public String getUserTime() {
		return userTime;
	}
	
	public String getUserStartTime() {
		return userStartTime;
	}
	
	public String getUserEndTime() {
		return userEndTime;
	}
	
	/*
	 * MUTATORS
	 */
	public String setUserCommand(String string) {
		userCommand = string;
		return userCommand;
	}
	
	public String setUserEventTask(String string) {
		userEventTask = string;
		return userEventTask;
	}
	
	public String setUserDate(String string) {
		userDate = string;
		return userDate;
	}
	
	public String setUserStartDate(String string) {
		userStartDate = string;
		return userStartDate;
	}
	
	public String setUserEndDate(String string) {
		userEndDate = string;
		return userEndDate;
	}
	
	public String setUserTime(String string) {
		userTime = string;
		return userTime;
	}
	
	public String setUserStartTime(String string) {
		userStartTime = string;
		return userStartTime;
	}
	
	public String setUserEndTime(String string) {
		userEndTime = string;
		return userEndTime;
	}
	
	/*
	 * METHODS
	 */
	public ArrayList<String> splitStringIntoArray(String userStringInput) {
		String[] stringSplitArray = userStringInput.trim().split("\\s+");
		for (String string : stringSplitArray) {
			stringArray.add(string);
		}
		return stringArray;
	}
	
	public String extractUserCommand(ArrayList<String> stringArray) {
		return stringArray.get(0);
	}
}
