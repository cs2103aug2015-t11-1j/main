/*
 * @@author A0121319R
 */

package parser;

import java.util.ArrayList;

import org.joda.time.format.DateTimeFormat;

public class EventTaskParser {

	/*
	 * This method returns a String representing the event/task argument. An
	 * InvalidInputException is thrown when the resulting String extracted is
	 * empty.
	 */
	protected static String getEventTask(String str) throws InvalidInputException {
		ArrayList<String> arr = Parser.toArrayList(str.trim(), ParserConstants.CHAR_SINGLE_WHITESPACE);
		assert (arr.size() >= 2);
		// Checks for the presence of any integer which represents an index
		// argument. Removes it from the
		// second index if it exists
		try {
			if (arr.get(ParserConstants.INDEX_SECOND).matches("^[+-]?\\d+")) {
				arr.remove(ParserConstants.INDEX_SECOND);
			}
		} catch (IndexOutOfBoundsException e) {

		}
		// Removes the action argument
		arr.remove(ParserConstants.INDEX_FIRST);

		int strictIndex = Parser.indexOf(ParserConstants.CHAR_RIGHT_ANGLE_BRACKET, arr);
		if (strictIndex == ParserConstants.INT_NEG_ONE) {
			/*
			 * Order of removal 1) Remove any date/time arguments 2) Remove all
			 * elements after the last instance of a 'end' keyword 3) Remove all
			 * elements after the last instance of a 'start' keyword 4) Remove
			 * all elements after the last instance of any 'time' keyword
			 */
			ArrayList<String> temp = new ArrayList<String>();
			for (String transfer : arr) {
				temp.add(transfer);
			}
			for (String targetString : temp) {
				removeElements(targetString, arr, ParserConstants.FORMAT_DATE_WITH_YEAR);
				removeElements(targetString, arr, ParserConstants.FORMAT_DATE_WITHOUT_YEAR);
				removeElements(targetString, arr, ParserConstants.FORMAT_TIME);
			}
			int endIndex = Parser.lastIndexOf(ParserConstants.KW_END, arr);
			removeElementsStartingFromIndex(endIndex, arr);
			int startIndex = Parser.lastIndexOf(ParserConstants.KW_START, arr);
			removeElementsStartingFromIndex(startIndex, arr);
			int timeIndex = Parser.lastIndexOf(ParserConstants.KW_TIME, arr);
			removeElementsStartingFromIndex(timeIndex, arr);
			return returnString(arr);
		} else {
			for (int i = strictIndex; i < arr.size();) {
				arr.remove(i);
			}
			return returnString(arr);
		}
	}

	/*
	 * Converts the resulting ArrayList into a String and checks for the
	 * validity of the event/task argument.
	 * 
	 * Returns the String if it's valid. Throws an InvalidInputException if it's
	 * not.
	 */
	private static String returnString(ArrayList<String> arr) throws InvalidInputException {
		String toReturn = Parser.toString(arr).trim();
		if (toReturn.equals(ParserConstants.CHAR_SINGLE_BLANK)) {
			throw new InvalidInputException("Invalid input: Please enter an event/task name");
		} else {
			return toReturn;
		}
	}

	private static void removeElements(String targetString, ArrayList<String> arr, String[] format) {
		for (String formatString : format) {
			try {
				DateTimeFormat.forPattern(formatString).parseLocalDateTime(targetString);
				arr.remove(arr.indexOf(targetString));
			} catch (IllegalArgumentException | NullPointerException | IndexOutOfBoundsException e) {

			}
		}
	}

	private static void removeElementsStartingFromIndex(int index, ArrayList<String> arr) {
		if (index != ParserConstants.INT_NEG_ONE) {
			for (int i = index; i < arr.size();) {
				arr.remove(i);
			}
		}
	}
}
