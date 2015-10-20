package parser;

import java.util.ArrayList;

import logic.AddTask;
import logic.Command;
import logic.DeleteTask;
import logic.DoneTask;
import logic.ExitTask;
import logic.HelpTask;
import logic.InvalidTask;
import logic.SearchTask;
import logic.ShowTask;
import logic.UndoTask;
import logic.UpdateTask;
import parser.ActionParser.ACTION_TYPE;

public class Parser {

	public static Command setCommand(String str) {
		ACTION_TYPE action = ActionParser.setUserAction(str);
		
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> time = new ArrayList<String>();
		
		switch (action) {
		case ADD:
			AddTask add = new AddTask();
			add.setEventTask(EventTaskParser.getEventTask(str));
			date.add(DateParser.getStartDate(str));
			date.add(DateParser.getEndDate(str));
			time.add(TimeParser.getStartTime(str));
			time.add(TimeParser.getEndTime(str));
			add.setDate(date);
			add.setTime(time);
			return add;
		case SHOW:
			ShowTask show = new ShowTask();
			show.setDate(DateParser.getStartDate(str));
			return show;
		case SEARCH:
			SearchTask search = new SearchTask();
			search.setEventTask(EventTaskParser.getEventTask(str));
			return search;
		case UPDATE:
			// TODO Changes to EventTaskParser: using index to update the
			// relevant event/tasks. Additional argument before updated
			// EventTask String
			UpdateTask update = new UpdateTask();
			update.setIndex(IndexParser.getIndex(str));
			update.setEventTask(EventTaskParser.getEventTask(str));
			date.add(DateParser.getStartDate(str));
			date.add(DateParser.getEndDate(str));
			time.add(TimeParser.getStartTime(str));
			time.add(TimeParser.getEndTime(str));
			update.setDate(date);
			update.setTime(time);
			return update;
		case DONE:
			// TODO Changes to EventTaskParser: using index to update the
			// relevant event/tasks. Additional argument before updated
			// EventTask String
			DoneTask done = new DoneTask();
			done.setIndex(IndexParser.getIndex(str));
			return done;
		case DELETE:
			// TODO Changes to EventTaskParser: using index to update the
			// relevant event/tasks. Additional argument before updated
			// EventTask String
			DeleteTask delete = new DeleteTask();
			delete.setIndex(IndexParser.getIndex(str));
			return delete;
		case UNDO:
			UndoTask undo = new UndoTask();
			return undo;
		case EXIT:
			ExitTask exit = new ExitTask();
			return exit;
		case HELP:
			HelpTask help = new HelpTask();
			return help;
		case INVALID:
			InvalidTask invalid = new InvalidTask();
			return invalid;
		default:
			return null;
		}
	}

	/*
	 * Takes a String input and return it as an ArrayList with the specified
	 * String as the delimiter
	 */
	protected static ArrayList<String> toArrayList(String str, String delim) {
		String[] strArr = str.split(delim);
		ArrayList<String> strArrList = new ArrayList<String>();
		for (String strTransfer : strArr) {
			strArrList.add(strTransfer);
		}
		return strArrList;
	}

	/*
	 * Takes an ArrayList and appends its elements into a String and returns it
	 */
	protected static String toString(ArrayList<String> arr) {
		String toReturn = "";
		for (int i = 0; i < arr.size(); i++) {
			toReturn = toReturn + ParserConstants.CHAR_SINGLE_WHITESPACE + arr.get(i);
		}
		return toReturn;
	}

	/*
	 * Returns the index of the first occurrence of the specified element in the
	 * String, or -1 if it does not contain the element.
	 */
	protected static int indexOf(String[] arr, ArrayList<String> str) {
		// ArrayList<String> strArr = toArrayList(str.trim().toLowerCase(),
		// ParserConstants.CHAR_SINGLE_WHITESPACE);
		int index = str.size();
		for (String s : arr) {
			if (str.indexOf(s) < index && str.indexOf(s) != -1) {
				index = str.indexOf(s);
			}
		}
		if (index == str.size()) {
			return -1;
		} else {
			return index;
		}
	}

	/*
	 * Returns the index of the last occurrence of the specified element in the
	 * String, or -1 if it does not contain the element.
	 */
	protected static int lastIndexOf(String[] arr, ArrayList<String> str) {
		// ArrayList<String> strArr = toArrayList(str.trim().toLowerCase(),
		// ParserConstants.CHAR_SINGLE_WHITESPACE);
		int index = -1;
		for (String s : arr) {
			if (str.lastIndexOf(s) > index && str.lastIndexOf(s) != -1) {
				index = str.lastIndexOf(s);
			}
		}
		if (index == -1) {
			return -1;
		} else {
			return index;
		}
	}

	/*
	 * Checks if the elements in an Array exist within the String input Returns
	 * true if it is, false if otherwise
	 */
	protected static boolean isPresent(String[] arr, String str) {
		ArrayList<String> strArr = toArrayList(str.trim().toLowerCase(), ParserConstants.CHAR_SINGLE_WHITESPACE);
		for (String s : arr) {
			if (strArr.contains(s)) {
				return true;
			}
		}
		return false;
	}
}
