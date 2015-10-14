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

import com.sun.media.sound.InvalidFormatException;

public class StringParser {

	private static final String REGEX_WHITESPACES = "[\\s,]+";

	private static final String STRING_WHITESPACE = " ";
	private static final String STRING_RIGHT_ANGLE_BRACKETS = ">";

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

	private static final int DATE_LENGTH = 6;
	private static final int TIME_LENGTH = 4;

	private static final int ARRAY_SIZE = 2;

	private static final int INDEX_ADD_ONE = 1;

	private String userStringInput;
	private Command command;
	private String todayDate;
	private ArrayList<String> dateArray;

	enum ACTION_TYPE {
		ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO, INVALID;
	}

	/*
	 * CONSTRUCTORS
	 */
	public StringParser() {
		todayDate = getTodayDate();
		dateArray = new ArrayList<String>(ARRAY_SIZE);
		dateArray.add("??????");
		dateArray.add("??????");
		
	}

	private ACTION_TYPE getUserActionType() {
		String userAction = extractUserCommand(userStringInput);
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
	public Command parseStringIntoCommand(String userStringInput) throws InvalidFormatException {
		this.userStringInput = userStringInput;
		command = new Command(); // so i can use setter methods
									// in Command class
		command.setUserStringInput(userStringInput);
		ACTION_TYPE actionType = this.getUserActionType();

		switch (actionType) {
		case ADD:
			command.setUserActionType(actionType);
			if (timeArgumentExist(userStringInput)) {
				command.setUserCommand(extractUserCommand(userStringInput));
				command.setUserEventTask(extractUserEventTask(userStringInput));
				command.setUserDate(extractUserDate(userStringInput));
				command.setUserTime(extractUserTime(userStringInput));
			} else {
				command.setUserCommand(extractUserCommand(userStringInput));
				command.setUserEventTask(extractUserEventTask(userStringInput));
				command.setUserDate(dateArray);
			}
			break;
		case SHOW:
			command.setUserActionType(actionType);
			if (timeArgumentExist(userStringInput)) {
				command.setUserCommand(extractUserCommand(userStringInput));
				command.setUserDate(extractUserDate(userStringInput));
			} else {
				command.setUserCommand(extractUserCommand(userStringInput));
			}
			break;
		case SEARCH:
			try {
				command.setUserActionType(actionType);
				if (timeArgumentExist(userStringInput)) {
					throw new InvalidFormatException("invalid format for search function");
				} else {
					command.setUserCommand(extractUserCommand(userStringInput));
					command.setUserEventTask(extractUserEventTask(userStringInput));
				}
			} catch (InvalidFormatException e) {
				System.err.println("InvalidFormatException: " + e.getMessage());
			}
			break;
		case UPDATE:
			/*
			 * command.setUserActionType(actionType); if
			 * (timeArgumentExist(userStringInput)) {
			 * command.setUserCommand(extractUserCommand(userStringInput));
			 * command.setUserEventTask(extractUserEventTask(userStringInput));
			 * command.setUserDate(extractUserDate(userStringInput));
			 * command.setUserTime(extractUserTime(userStringInput)); } else {
			 * 
			 * } break;
			 */
		case DONE:
			try {
				command.setUserActionType(actionType);
				if (timeArgumentExist(userStringInput)) {
					throw new InvalidFormatException("invalid format for done function");
				} else {
					command.setUserCommand(extractUserCommand(userStringInput));
					command.setUserEventTask(extractUserEventTask(userStringInput));
				}
			} catch (InvalidFormatException e) {
				System.err.println("InvalidFormatException: " + e.getMessage());
			}
			break;
		case DELETE:
			try {
				command.setUserActionType(actionType);
				if (timeArgumentExist(userStringInput)) {
					throw new InvalidFormatException("invalid format for delete function");
				} else {
					command.setUserCommand(extractUserCommand(userStringInput));
					command.setUserEventTask(extractUserEventTask(userStringInput));
				}
			} catch (InvalidFormatException e) {
				System.err.println("InvalidFormatException: " + e.getMessage());
			}
			break;
		case UNDO:
			command.setUserActionType(actionType);
			command.setUserCommand(extractUserCommand(userStringInput));
			break;
		case INVALID:
			command.setUserActionType(actionType);
			command.setUserCommand(extractUserCommand(userStringInput));
			break;
		}

		return command;

	}

	private String extractUserCommand(String userStringInput) {
		ArrayList<String> stringArray = splitStringIntoArrayDelimSpace(userStringInput.trim());
		return stringArray.get(INDEX_FIRST);
	}

	private String extractUserEventTask(String userStringInput) {
		ArrayList<String> stringArray = splitStringIntoArrayDelimAngleBrackets(userStringInput.trim());
		return stringArray.get(INDEX_FIRST)
				.substring(stringArray.get(INDEX_FIRST).indexOf(STRING_WHITESPACE) + INDEX_ADD_ONE).trim();
	}

	private ArrayList<String> extractUserDate(String userStringInput) {
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
		if (userDate.isEmpty() && containsTimeInput) {
			userDate.add(todayDate);
			userDate.add("??????");
		}
		return userDate;
	}

	private ArrayList<String> extractUserTime(String userStringInput) {
		ArrayList<String> timeArray = extractTimeArguments(userStringInput);
		ArrayList<String> userTime = new ArrayList<String>();
		for (String time : timeArray) {
			if (time.length() == TIME_LENGTH) {
				userTime.add(time);
			}
		}
		/*if (userTime.isEmpty()) {
			userTime.add(null);
			userTime.add(null);
		}*/
		return userTime;
	}

	private ArrayList<String> extractTimeArguments(String userStringInput) {
		ArrayList<String> stringArray = splitStringIntoArrayDelimAngleBrackets(userStringInput.trim());
		ArrayList<String> timeArray = splitStringIntoArrayDelimSpace(stringArray.get(INDEX_SECOND).trim());
		return timeArray;
	}

	/*
	 * Checks if any date/time arguments are specified by the user in the input
	 * Returns true if present and false if otherwise
	 */
	private boolean timeArgumentExist(String userStringInput) {
		return userStringInput.contains(STRING_RIGHT_ANGLE_BRACKETS);
	}
	
	/*
	 * Returns today's date as a String type in the format DDMMYY
	 */
	private String getTodayDate() {
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyy");
		String todayDate = sdf.format(today);
		return todayDate;
	}

	/*
	 * STRING SPLITTERS
	 */
	private static ArrayList<String> splitStringIntoArrayDelimSpace(String userStringInput) {
		String[] stringSplitArrayDelimSpace = userStringInput.trim().split(REGEX_WHITESPACES);
		return new ArrayList<String>(Arrays.asList(stringSplitArrayDelimSpace));
	}

	private static ArrayList<String> splitStringIntoArrayDelimAngleBrackets(String userStringInput) {
		String[] stringSplitArrayDelimAngleBrackets = userStringInput.trim().split(STRING_RIGHT_ANGLE_BRACKETS);
		return new ArrayList<String>(Arrays.asList(stringSplitArrayDelimAngleBrackets));
	}
}
