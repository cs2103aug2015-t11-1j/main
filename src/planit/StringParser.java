/*
 * Author: Jeston Teo
 * 
 * This class parses an entire string command into its respective <categories>
 * ASSUMPTIONS:
 * 1) Commands are entered in this general format: <command> <event> <date> <time>
 * TODO  
 */

package planit;

public class StringParser {
	/*
	 * ATTRIBUTES
	 */
	private static String userStringInput;
	private static String userCommand = null;
	private static String userEventTask = null;
	private static String userDate = null;
	private static String userStartDate = null;
	private static String userEndDate = null;
	private static String userTime = null;
	private static String userStartTime = null;
	private static String userEndTime = null;
	
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
}
