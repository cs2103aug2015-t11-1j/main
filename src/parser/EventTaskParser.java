/*
 * This class extracts the string representing the user's event/task
 * ASSUMPTIONS
 * 1) Event/task arguments always comes after the action and index argument
 * 2) Event/task arguments always comes before any arguments related to time
 * 
 * If a String representing event/task could not be found, throws an exception
 * 
 * <action> <index> <event/task> *KEYWORD* <DATE/TIME>
 */

package parser;

import java.util.ArrayList;

public class EventTaskParser {

	protected static String getEventTask(String str) throws InvalidInputException {

		// Converts the string into an ArrayList for simpler manipulation. Split
		// using *spaces*
		ArrayList<String> arr = Parser.toArrayList(str.trim(), ParserConstants.CHAR_SINGLE_WHITESPACE);

		// Checks for the presence of an index argument. Removes it from the
		// second index if it exists
		try {
			if (Parser.indexPresent(arr)) {
				arr.remove(ParserConstants.INDEX_SECOND);
			}
		} catch (IndexOutOfBoundsException e) {

		}

		// Checks for the presence of any date/time arguments which only comes
		// after keywords contained in KW_START. Removes all the indexes after
		// the first occurrence of the keyword
		int index = Parser.indexOf(ParserConstants.KW_START, arr);
		if (index != -1) {
			for (int i = index; i < arr.size();) {
				arr.remove(i);
			}
		}
		int endIndex = Parser.indexOf(ParserConstants.KW_END, arr);
		if (endIndex != -1) {
			for (int i = endIndex; i < arr.size();) {
				arr.remove(i);
			}
		}

		// Removes the first index which contains the action argument
		arr.remove(ParserConstants.INDEX_FIRST);

		// Checks for an empty string. Throws an exception if it's empty.
		// Returns the String if it is not
		String toReturn = Parser.toString(arr).trim();
		if (toReturn.equals(ParserConstants.CHAR_SINGLE_BLANK)) {
			throw new InvalidInputException("Invalid event/task argument");
		} else {
			return toReturn;
		}
	}
}
