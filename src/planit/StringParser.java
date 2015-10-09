/*
 * @author: Jeston Teo
 * 
 * This class parses an entire string into its respective <categories> and returns a command object
 * ASSUMPTIONS:
 * 1) Strings are entered in the correct supported format.
 * 2) <action> includes: ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO
 * 3) <date> is entered as DDMMYY
 * 4) <time> is in 24hr format
 * 5) ">" character always comes before any date/time arguments.
 * 7) There will always be a white space between <date> and <time>
 * 
 */

package planit;

import java.text.SimpleDateFormat;
import java.util.*;

public class StringParser {

	private static final String REGEX_WHITESPACES = "[\\s,]+";

	private static final String STRING_WHITESPACE = " ";
	private static final String STRING_RIGHT_ANGLE_BRACKETS = ">";

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

	private static final int DATE_LENGTH = 6;
	private static final int TIME_LENGTH = 4;

	// private static final int ARRAY_SIZE = 2;

	private static final int INDEX_ADD_ONE = 1;

	private String userStringInput;
	private Command command;

	enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID;
	}

	/*
	 * CONSTRUCTORS
	 */
	public StringParser() {

	}

	private ACTION_TYPE getUserActionType() {
		String userAction = this.extractUserCommand(userStringInput);
		if (userAction.equalsIgnoreCase("add")) {
			return ACTION_TYPE.ADD;
		} else if (userAction.equalsIgnoreCase("display")) {
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
	 * METHODS
	 */
	public Command parseStringIntoCommand(String userStringInput) {
		this.userStringInput = userStringInput;
		command = new Command(userStringInput); // so i can use setter methods
												// in Command class
		ACTION_TYPE actionType = this.getUserActionType();

		switch (actionType) {
		case ADD:
			if (this.timeArgumentExist()) {
				// TODO scan for both event and time arguments
			} else {
				// TODO scan for event only
			}
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
		case INVALID:
			break;
		}

		return command;
	}

	public String extractUserCommand(String userStringInput) {
		ArrayList<String> stringArray = splitStringIntoArrayDelimSpace(userStringInput.trim());
		return stringArray.get(INDEX_FIRST);
	}

	public String extractUserEventTask(String userStringInput) {
		ArrayList<String> stringArray = splitStringIntoArrayDelimAngleBrackets(userStringInput.trim());
		return stringArray.get(INDEX_FIRST)
				.substring(stringArray.get(INDEX_FIRST).indexOf(STRING_WHITESPACE) + INDEX_ADD_ONE).trim();
	}

	public ArrayList<String> extractUserDate(String userStringInput) {
		boolean containsTimeInput = false;
		ArrayList<String> timeArray = extractTimeArguments(userStringInput);
		ArrayList<String> userDate = new ArrayList<String>();
		for (String date : timeArray) {
			if (date.length() == DATE_LENGTH) {
				userDate.add(date);
			}
			if (date.length() == TIME_LENGTH) {
				containsTimeInput = true;
			}
		}
		if (userDate.isEmpty() && containsTimeInput == true) {
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
			userDate.add(sdf.format(today));
		}
		// String[] resultString = userDate.toArray(new String[ARRAY_SIZE]);
		return userDate;
	}

	public ArrayList<String> extractUserTime(String userStringInput) {
		ArrayList<String> timeArray = extractTimeArguments(userStringInput);
		ArrayList<String> userTime = new ArrayList<String>();
		for (String time : timeArray) {
			if (time.length() == TIME_LENGTH) {
				userTime.add(time);
			}
		}
		if (userTime.isEmpty()) {
			userTime.add("???");
			userTime.add("???");
		}
		// String[] resultString = userTime.toArray(new String[ARRAY_SIZE]);
		return userTime;
	}

	private ArrayList<String> extractTimeArguments(String userStringInput) {
		ArrayList<String> timeArray = new ArrayList<String>();
		if (userStringInput.contains(STRING_RIGHT_ANGLE_BRACKETS)) {
			ArrayList<String> stringArray = splitStringIntoArrayDelimAngleBrackets(userStringInput.trim());
			timeArray = splitStringIntoArrayDelimSpace(stringArray.get(INDEX_SECOND).trim());
			return timeArray;
		} else {
			timeArray.addAll(null);
			return timeArray;
		}
	}
	
	/*
	 * Checks if any date/time arguments are specified by the user in the input
	 * Returns true if present and false if otherwise
	 */
	private boolean timeArgumentExist() {
		return userStringInput.contains(STRING_RIGHT_ANGLE_BRACKETS);
	}

	/*
	 * STRING SPLITTERS
	 */
	private ArrayList<String> splitStringIntoArrayDelimSpace(String userStringInput) {
		String[] stringSplitArrayDelimSpace = userStringInput.trim().split(REGEX_WHITESPACES);
		return new ArrayList<String>(Arrays.asList(stringSplitArrayDelimSpace));
	}

	private ArrayList<String> splitStringIntoArrayDelimAngleBrackets(String userStringInput) {
		String[] stringSplitArrayDelimAngleBrackets = userStringInput.trim().split(STRING_RIGHT_ANGLE_BRACKETS);
		return new ArrayList<String>(Arrays.asList(stringSplitArrayDelimAngleBrackets));
	}
}
