/* 
 * @author: Ishvinder Singh
 * 
 */

package planit;

import java.io.IOException;
import java.util.ArrayList;

public class Logic {

	public enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID;
	}

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

//	private static final int RANGE_ARRAY_SIZE = 2;
	
	private static Command userCommand;
	
	private static ACTION_TYPE type;
	
	public Logic (Command userCommand) {
		this.userCommand = userCommand;
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
	
	public static void executeCommand(String userInput) throws IOException {
		Storage sto = new Storage();
//		while (!userInput.equals(null)) {
			userCommand = new Command(userInput);
			type = getActionType(userCommand.getUserCommand());
			switch (type) {
			case ADD:
				formatEventDetails(userCommand);
				String addedTask = sto.storeNewEvent(userCommand);
				Welcome.printAddedEvent(addedTask);
				break;
			case SHOW:
				formatEventDetails(userCommand);
				String eventToShow = Storage.searchCommandParam(userCommand.getUserEventTask());
				Welcome.printShowEvent(eventToShow);
				break;
			case SEARCH:
				String searchParam = userCommand.getUserEventTask();
				String searchedEvent = Storage.searchCommandParam(searchParam);
				Welcome.printSearchEvent(searchedEvent);
				break;
			case UPDATE:
				break;
			case DONE:
				break;
			case DELETE:
				String taskToDelete = userCommand.getUserEventTask();
				Storage.deleteTask(taskToDelete);
				Welcome.printDeletedTask(taskToDelete);
				break;
			case UNDO:
				break;
			default:
				break;
			}
		}
		
//	}

	private static void formatEventDetails(Command userCommand) {
		formatDateString(userCommand);
		formatTimeString(userCommand);
	}

	private static void formatTimeString(Command userCommand) {
		ArrayList<String> timeArray = userCommand.getUserTimeRange();
		if (timeArray.size() == 1) {
			String newTimeString = timeToTimeString(timeArray.get(INDEX_FIRST));
			userCommand.setUserTimeString(newTimeString);
		} else {
			String timeString1 = timeToTimeString(timeArray.get(INDEX_FIRST));
			String timeString2 = timeToTimeString(timeArray.get(INDEX_SECOND));
			String newTimeString = timeString1 + "-" + timeString2;
			userCommand.setUserTimeString(newTimeString);
		}
	}

	private static String timeToTimeString(String timeString) {
		String newTimeString = timeString + "HRS";
		return newTimeString;
	}

	private static void formatDateString(Command userCommand) {
		
		ArrayList<String> dateArray = userCommand.getUserDateRange();
		
		if (dateArray.size() == 1) {
			String newDateString = dateToDateString(dateArray.get(INDEX_FIRST));
			userCommand.setUserDateString(newDateString);
		} else {
			String dateString1 = dateToDateString(dateArray.get(INDEX_FIRST));
			String dateString2 = dateToDateString(dateArray.get(INDEX_SECOND));
			String newDateString = dateString1 + "-" + dateString2;
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
