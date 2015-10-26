/*
 * TODO Description of class
 */

package parser;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import logic.AddTask;
import logic.Command;
import logic.DeleteTask;
import logic.DoneTask;
import logic.ExitTask;
import logic.HelpTask;
import logic.InvalidTask;
import logic.SearchTask;
import logic.SetFilePathTask;
import logic.ShowFileTask;
import logic.ShowTask;
import logic.UndoTask;
import logic.UpdateTask;
import parser.ActionParser.ACTION_TYPE;

public class Parser {

	public static Command setCommand(String str) {
		ACTION_TYPE action = ActionParser.setUserAction(str);

		switch (action) {
		case ADD:
			AddTask add = new AddTask();
			try {
				add.setEventTask(EventTaskParser.getEventTask(str));
				add.setDate(DateParser.addDateArg(str));
				add.setTime(TimeParser.addTimeArg(str));
			} catch (InvalidInputException | IndexOutOfBoundsException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return add;
		case SHOW:
			ShowTask show = new ShowTask();
			try {
				show.setDate(DateParser.getShowDate(str));
			} catch (NullPointerException | InvalidInputException e) {
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
				update.setDate(DateParser.addDateArg(str));
				update.setTime(TimeParser.addTimeArg(str));
			} catch (InvalidInputException | IndexOutOfBoundsException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return update;
		case DONE:
			DoneTask done = new DoneTask();
			try {
				done.setIndex(IndexParser.getIndex(str));
			} catch (InvalidInputException | IndexOutOfBoundsException e) {
				InvalidTask invalid = new InvalidTask();
				return invalid;
			}
			return done;
		case DELETE:
			DeleteTask delete = new DeleteTask();
			try {
				delete.setIndex(IndexParser.getIndex(str));
			} catch (InvalidInputException | IndexOutOfBoundsException e) {
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
			ShowFileTask filePath = new ShowFileTask();
			return filePath;
		case CFP:
			SetFilePathTask setFilePath = new SetFilePathTask();
			setFilePath.setFilePath(FileParser.getFilePath(str));
			return setFilePath;
		default:
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
	 * Returns the index of the first occurrence of the specified element in the
	 * String, or -1 if it does not contain the element.
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

	/*
	 * Checks if there's an index argument in the String
	 * 
	 * ASSUMPTIONS: 1) The index argument always comes before the event/task
	 * argument and after the action argument
	 */
	protected static boolean indexPresent(ArrayList<String> arr) throws IndexOutOfBoundsException {
		return arr.get(ParserConstants.INDEX_SECOND).matches(".*\\d+/*");
	}

	/*
	 * Extracts the relevant arguments from the specified partition and stores
	 * it in the given ArrayList<String>. Returns true if an argument has been
	 * stored False if otherwise.
	 * 
	 * Unique to DateParser and TimeParser
	 */
	protected static boolean extractArguments(ArrayList<String> arg, boolean argExist, ArrayList<String> partition,
			String[] format, String formatStorage) {
		for (String s1 : partition) {
			LocalDateTime dateTimeArg = null;
			for (String s2 : format) {
				try {
					dateTimeArg = DateTimeFormat.forPattern(s2).parseLocalDateTime(s1);
					arg.add(dateTimeArg.toString(formatStorage));
					argExist = true;
				} catch (NullPointerException | IllegalArgumentException e) {

				}
			}
		}
		return argExist;
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
