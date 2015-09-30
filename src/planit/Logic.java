/* 
 * @author: Ishvinder Singh
 * 
 */

package planit;

public class Logic {

	public enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID;
	}

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

	private static final int RANGE_ARRAY_SIZE = 2;
	
	private static Command userCommand;
	
	private static ACTION_TYPE type;
	
	public Logic (Command userCommand) {
		this.userCommand = userCommand;
	}
	
	public static void main(String[] args) {
		Welcome.welcomeMessage();
		String userInput = Welcome.requestInput();
		executeCommand(userInput);
	}

	private static ACTION_TYPE getActionType(String userAction) {
		if (userAction.equalsIgnoreCase("add")) {
			return ACTION_TYPE.ADD;
		} else if (userAction.equalsIgnoreCase("show")) {
			return ACTION_TYPE.SHOW;
		} else if (userAction.equalsIgnoreCase("search")) {
			return ACTION_TYPE.SEARCH;
		} else if (userAction.equalsIgnoreCase("update")) {
			return ACTION_TYPE.UPDATE;
		} else if (userAction.equalsIgnoreCase("done")) {
			return ACTION_TYPE.DONE;
		} else if (userAction.equalsIgnoreCase("delete")) {
			return ACTION_TYPE.DELETE;
		} else if (userAction.equalsIgnoreCase("undo")) {
			return ACTION_TYPE.UNDO;
		} else {
			return ACTION_TYPE.INVALID;
		}
	}
	
	/*
	 * Operations
	 */
	
	private static void executeCommand(String userInput) {
		userCommand = new Command(userInput);
		type = getActionType(userInput);
		switch (type) {
		case ADD:
			formatDateString(userCommand);
			formatTimeString(userCommand);
			Storage.storeNewEvent(userCommand);
			break;
		case SHOW:
			break;
		case SEARCH:
			break;
		case UPDATE:
			break;
		case DONE:
			break;
		case DELETE:
			break;
		case UNDO:
			break;
		default:
			break;
		}
		
	}

	private static void formatTimeString(Command userCommand) {
		String[] timeArray = userCommand.getUserTimeRange();
		if (timeArray.length == 1) {
			String newTimeString = timeToTimeString(timeArray[INDEX_FIRST]);
			userCommand.setUserTimeString(newTimeString);
		} else {
			String timeString1 = timeToTimeString(timeArray[INDEX_FIRST]);
			String timeString2 = timeToTimeString(timeArray[INDEX_SECOND]);
			String newTimeString = timeString1 + " to " + timeString2;
			userCommand.setUserTimeString(newTimeString);
		}
	}

	private static String timeToTimeString(String timeString) {
		String newTimeString = timeString + " HRS";
		return newTimeString;
	}

	private static void formatDateString(Command userCommand) {
		String[] dateArray = userCommand.getUserDateRange();
		if (dateArray.length == 1) {
			String newDateString = dateToDateString(dateArray[INDEX_FIRST]);
			userCommand.setUserDateString(newDateString);
		} else {
			String dateString1 = dateToDateString(dateArray[INDEX_FIRST]);
			String dateString2 = dateToDateString(dateArray[INDEX_SECOND]);
			String newDateString = dateString1 + " to " + dateString2;
			userCommand.setUserDateString(newDateString);
		}
	}

	private static String dateToDateString(String dateString) {
		String dateDay = dateString.substring(0, 2);
		String dateMonth = dateString.substring(2,4);
		String dateYear = dateString.substring(4);
		String newDateString = dateDay + "/" + dateMonth + "/" + dateYear;
		return newDateString;
	}

}
