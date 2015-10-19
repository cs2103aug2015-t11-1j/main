/* 
 * @author: Ishvinder Singh
 * 
 */

package logic;

import java.io.IOException;
import java.util.ArrayList;

import parser.StringParser;
import parser.StringParser.ACTION_TYPE;
import storage.Storage;
import ui.Welcome;

public class Logic {

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

	private static Command userCommand;

	public Logic() {
		
	}


	/*
	 * Operations
	 */

	public static void executeCommand(String userInput) throws IOException {
		Storage sto = new Storage();
		StringParser sp = new StringParser();
		userCommand = sp.parseStringIntoCommand(userInput);
		ACTION_TYPE type = userCommand.getActionType();
		switch (type) {
		case ADD:
			formatEventDetails(userCommand);
			String addedTask = sto.storeNewEvent(userCommand);
			Welcome.printAddedEvent(addedTask);
			break;
		case SHOW:
			formatEventDetails(userCommand);
			ArrayList<String> eventToShow = sto.showDateEvents(userCommand.getUserDateStart());
			Welcome.printShowEvent(eventToShow);
			break;
		case SEARCH:
			String searchKey = userCommand.getUserEventTask();
			ArrayList<String> searchedEvent = sto.searchCommandKey(searchKey);
			Welcome.printSearchEvent(searchedEvent);
			break;
		case UPDATE:
			String eventToUpdate = userCommand.getUserEventTask();
			ArrayList<String> updatedEvent = sto.updateEvent(eventToUpdate);
			Welcome.printUpdatedEvent(updatedEvent);
			break;
		case DONE:
			String completeTask = userCommand.getUserEventTask();
			ArrayList<String> completedTask = sto.markDone(completeTask);
			Welcome.printCompletedTask(completedTask);
			break;
		case DELETE:
			String taskToDelete = userCommand.getUserEventTask();
			ArrayList<String> deletedTask = sto.deleteTask(taskToDelete);
			Welcome.printDeletedTask(deletedTask);
			break;
		case HELP:
			Welcome.printHelp();
			break;
		case UNDO:
			break;
		default:
			break;
		}
	}

	private static void formatEventDetails(Command userCommand) {
		formatDateString(userCommand);
		formatTimeString(userCommand);
	}

	private static void formatTimeString(Command userCommand) {
		ArrayList<String> timeArray = userCommand.getUserTimeRange();
		if (timeArray.size() == 1) {
			timeArray.set(0, timeToTimeString(timeArray.get(INDEX_FIRST)));
			userCommand.setUserTime(timeArray);
		} else {
			timeArray.set(0, timeToTimeString(timeArray.get(INDEX_FIRST)));
			timeArray.set(1, timeToTimeString(timeArray.get(INDEX_SECOND)));
			userCommand.setUserTime(timeArray);
		} 
	}

	private static String timeToTimeString(String timeString) {
		String newTimeString = timeString + "HRS";
		return newTimeString;
	}

	private static void formatDateString(Command userCommand) {

		ArrayList<String> dateArray = userCommand.getUserDateRange();

		if (dateArray.size() == 1) {
			dateArray.set(0, dateToDateString(dateArray.get(INDEX_FIRST)));
			userCommand.setUserDate(dateArray);
		} else {
			dateArray.set(0, dateToDateString(dateArray.get(INDEX_FIRST)));
			dateArray.set(1, dateToDateString(dateArray.get(INDEX_SECOND)));
			userCommand.setUserDate(dateArray);
		}
	}

	private static String dateToDateString(String dateString) {
		String dateDay = dateString.substring(0, 2);
		String dateMonth = dateString.substring(2, 4);
		String dateYear = dateString.substring(4);
		String newDateString = dateDay + "/" + dateMonth + "/" + dateYear;
		return newDateString;
	}

}
