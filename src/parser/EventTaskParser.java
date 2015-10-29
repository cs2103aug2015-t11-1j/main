/*
 * @author: Jeston Teo
 * 
 * This class extracts the string representing the user's event/task
 * 
 */

package parser;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

public class EventTaskParser {

	/*
	 * This method returns a String representing the event/task argument. An
	 * InvalidInputException is thrown when the resulting String extracted is
	 * empty.
	 * 
	 * Assumptions: 1) The String comes between the action argument and any
	 * date/time arguments. 2) The String may contain words related to
	 * date/time, but a strict format ">" must be used to separate event/task
	 * and date/time arguments.
	 */
	protected static String getEventTask(String str) throws InvalidInputException {

		ArrayList<String> arr = Parser.toArrayList(str.trim(), ParserConstants.CHAR_SINGLE_WHITESPACE);

		// Checks for the presence of an index argument. Removes it from the
		// second index if it exists
		try {
			if (IndexParser.getIndex(str) > 0) {
				arr.remove(ParserConstants.INDEX_SECOND);
			}
		} catch (InvalidInputException e) {

		}
		
		// Removes the action argument
		arr.remove(ParserConstants.INDEX_FIRST);

		/** Partitioning **/
		ArrayList<String> arrToScan;
		int strictIndex = Parser.indexOf(ParserConstants.CHAR_RIGHT_ANGLE_BRACKET, arr);
		if (strictIndex == -1) {
			
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

		// Removes any date/time arguments which came before any keywords
		ArrayList<String> temp = new ArrayList<String>();
		for (String transfer : arr) {
			temp.add(transfer);
		}
		for (String s1 : temp) {
			LocalDateTime tempDateTime = null;
			for (String s2 : ParserConstants.FORMAT_DATE_WITH_YEAR) {
				try {
					tempDateTime = DateTimeFormat.forPattern(s2).parseLocalDateTime(s1);
					arr.remove(arr.indexOf(s1));
				} catch (IllegalArgumentException | NullPointerException | IndexOutOfBoundsException e) {

				}
			}
			for (String s2 : ParserConstants.FORMAT_DATE_WITHOUT_YEAR) {
				try {
					tempDateTime = DateTimeFormat.forPattern(s2).parseLocalDateTime(s1);
					arr.remove(arr.indexOf(s1));
				} catch (IllegalArgumentException | NullPointerException | IndexOutOfBoundsException e) {

				}
			}
			for (String s2 : ParserConstants.FORMAT_TIME) {
				try {
					tempDateTime = DateTimeFormat.forPattern(s2).parseLocalDateTime(s1);
					arr.remove(arr.indexOf(s1));
				} catch (IllegalArgumentException | NullPointerException | IndexOutOfBoundsException e) {

				}
			}
		}

		// Checks for an empty string. Throws an exception if it's empty.
		// Returns the String if it is not
		String toReturn = Parser.toString(arr).trim();
		if (toReturn.equals(ParserConstants.CHAR_SINGLE_BLANK))

		{
			throw new InvalidInputException("Invalid event/task argument");
		} else

		{
			return toReturn;
		}
	}
}
