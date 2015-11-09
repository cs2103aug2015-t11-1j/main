/*
 * @@author A0121319R
 */

package parser;

import java.util.ArrayList;

import org.joda.time.format.DateTimeFormat;

import logic.AddTask;
import logic.ClearList;
import logic.Command;
import logic.DeleteTask;
import logic.ExitTask;
import logic.HelpTask;
import logic.InvalidTask;
import logic.MarkDoneTask;
import logic.MarkUndoneTask;
import logic.SearchTask;
import logic.SetFilePath;
import logic.ShowFilePath;
import logic.ShowTask;
import logic.UndoTask;
import logic.UpdateTask;
import parser.ActionParser.ACTION_TYPE;

public class Parser {

	/*
	 * Returns the corresponding classes with any arguments present in the
	 * user's input.
	 */
	public static Command setCommand(String str) {
		ACTION_TYPE action = ActionParser.setUserAction(str);

		switch (action) {
		case ADD:
			AddTask add = new AddTask();
			try {
				add.setEventTask(EventTaskParser.getEventTask(str));
				DateTimeParser.getDateTimeArgs(str);
				add.setDate(DateTimeParser.getDateArgs());
				add.setTime(DateTimeParser.getTimeArgs());
			} catch (InvalidInputException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return add;
		case SHOW:
			ShowTask show = new ShowTask();
			try {
				for (String key : ParserConstants.KW_COMMAND_DONE) {
					if (str.contains(key)) {
						show.setShowDone();
					}
				}
				if (str.contains(ParserConstants.KW_FLOAT)) {
					show.setShowFloat();
				}
				DateTimeParser.getDateTimeArgs(str);
				ArrayList<String> tempDateArr = DateTimeParser.getDateArgs();
				if (tempDateArr.get(ParserConstants.INDEX_SECOND).isEmpty()) {
					show.setDate(tempDateArr.get(ParserConstants.INDEX_FIRST));
				} else {
					throw new InvalidInputException();
				}
			} catch (InvalidInputException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return show;
		case SEARCH:
			SearchTask search = new SearchTask();
			try {
				search.setEventTask(EventTaskParser.getEventTask(str));
			} catch (InvalidInputException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return search;
		case UPDATE:
			UpdateTask update = new UpdateTask();
			try {
				update.setIndex(IndexParser.getIndex(str));
				update.setEventTask(EventTaskParser.getEventTask(str));
				DateTimeParser.getDateTimeArgs(str);
				update.setDate(DateTimeParser.getDateArgs());
				update.setTime(DateTimeParser.getTimeArgs());
			} catch (InvalidInputException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return update;
		case DONE:
			MarkDoneTask done = new MarkDoneTask();
			try {
				done.setIndex(IndexParser.getIndex(str));
			} catch (InvalidInputException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return done;
		case UNDONE:
			MarkUndoneTask undone = new MarkUndoneTask();
			try {
				undone.setIndex(IndexParser.getIndex(str));
			} catch (InvalidInputException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return undone;
		case DELETE:
			DeleteTask delete = new DeleteTask();
			try {
				delete.setIndex(IndexParser.getIndex(str));
			} catch (InvalidInputException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
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
		case FP:
			ShowFilePath filePath = new ShowFilePath();
			return filePath;
		case CFP:
			SetFilePath newFilePath = new SetFilePath();
			try {
				newFilePath.setFilePath(FileParser.getFilePath(str));
			} catch (InvalidInputException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return newFilePath;
		case CLEAR:
			ClearList clear = new ClearList();
			return clear;
		default:
			// Returned only if the action argument is invalid
			InvalidTask invalid = new InvalidTask();
			return invalid;
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
	 * Returns the index of the first occurrence of the given elements in arr
	 * contained in the String. Returns -1 if the String does not contain any of
	 * the elements in arr.
	 */
	protected static int indexOf(String[] arr, ArrayList<String> str) {
		ArrayList<String> temp = cloneToLowerCase(str);
		int index = str.size();
		for (String s : arr) {
			if (temp.indexOf(s) < index && temp.indexOf(s) != -1) {
				index = temp.indexOf(s);
			}
		}
		if (index == temp.size()) {
			return -1;
		} else {
			return index;
		}
	}

	/*
	 * Returns the index of the first occurrence of the key in the String, or -1
	 * if it does not contain the element.
	 */
	protected static int indexOf(String key, ArrayList<String> str) {
		ArrayList<String> temp = cloneToLowerCase(str);
		return temp.indexOf(key);
	}

	/*
	 * Returns the index of the last occurrence of the specified element in the
	 * String, or -1 if it does not contain the element.
	 */
	protected static int lastIndexOf(String[] arr, ArrayList<String> str) {
		ArrayList<String> temp = cloneToLowerCase(str);
		int index = -1;
		for (String s : arr) {
			if (temp.lastIndexOf(s) > index && temp.lastIndexOf(s) != -1) {
				index = temp.lastIndexOf(s);
			}
		}
		if (index == -1) {
			return -1;
		} else {
			return index;
		}
	}

	/*
	 * Checks for the relevant arguments in a specified partition. Returns true
	 * if it exists. False if otherwise
	 */
	protected static boolean isPresent(ArrayList<String> partition, String[] format) {
		for (String s1 : partition) {
			for (String s2 : format) {
				try {
					DateTimeFormat.forPattern(s2).parseLocalDateTime(s1);
					return true;
				} catch (NullPointerException | IllegalArgumentException e) {

				}
			}
		}
		return false;
	}

	private static ArrayList<String> cloneToLowerCase(ArrayList<String> str) {
		ArrayList<String> temp = new ArrayList<String>();
		for (int i = 0; i < str.size(); i++) {
			temp.add(str.get(i).toLowerCase());
		}
		return temp;
	}
}
