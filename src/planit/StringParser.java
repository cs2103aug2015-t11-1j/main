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
 * 
 * TODO: consider parse(String) from Calendar api
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
		}
		else {
			timeArray.addAll(null);
			return timeArray;
		}
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
