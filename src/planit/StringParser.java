/*
 * @author: Jeston Teo
 * 
 * This class parses an entire string command into its respective <categories>
 * ASSUMPTIONS:
 * 1) Commands are entered in the correct supported format.
 * 2) <action> includes: ADD, SHOW, SEARCH, UPDATE, DONE, DELETE, UNDO
 * 3) <date> is entered as DDMMYY
 * 4) <time> is in 24hr format
 * 5) ">" character always comes before date/time arguments
 * 7) There will always be a white space between <date> and <time>
 */

package planit;

import java.util.*;

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

	/*
	 * CONSTRUCTORS
	 */
	public StringParser() {

	}

	/*
	 * METHODS
	 */
	public String extractUserCommand(String userStringInput) {
		ArrayList<String> stringArray = splitStringIntoArrayDelimSpace(userStringInput.trim());
		return stringArray.get(INDEX_FIRST);
	}

	public String extractUserEventTask(String userStringInput) {
		ArrayList<String> stringArray = splitStringIntoArrayDelimAngleBrackets(userStringInput.trim());
		return stringArray.get(INDEX_FIRST)
				.substring(stringArray.get(INDEX_FIRST).indexOf(STRING_WHITESPACE) + INDEX_ADD_ONE).trim();
	}

	public String[] extractUserDate(String userStringInput) {
		ArrayList<String> timeArray = extractTimeArguments(userStringInput);
		ArrayList<String> userDate = new ArrayList<String>();
		for (String date : timeArray) {
			if (date.length() == DATE_LENGTH) {
				userDate.add(date);
			}
		}
		String[] resultString = userDate.toArray(new String[ARRAY_SIZE]);
		return resultString;
	}

	public String[] extractUserTime(String userStringInput) {
		ArrayList<String> timeArray = extractTimeArguments(userStringInput);
		ArrayList<String> userTime = new ArrayList<String>();
		for (String time : timeArray) {
			if (time.length() == TIME_LENGTH) {
				userTime.add(time);
			}
		}
		String[] resultString = userTime.toArray(new String[ARRAY_SIZE]);
		return resultString;
	}

	private ArrayList<String> extractTimeArguments(String userStringInput) {
		ArrayList<String> stringArray = splitStringIntoArrayDelimAngleBrackets(userStringInput.trim());
		ArrayList<String> timeArray = splitStringIntoArrayDelimSpace(stringArray.get(INDEX_SECOND).trim());
		return timeArray;
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
