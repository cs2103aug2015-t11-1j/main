/*
 * @author: Jeston Teo
 * 
 * This class parses an entire string command into its respective <categories>
 * ASSUMPTIONS:
 * 1) Commands are entered in the correct supported format.
 * TODO  
 */

package planit;

import java.util.ArrayList;
import java.util.Arrays;

public class StringParser {

	private static final String REGEX_WHITESPACES = "[\\s,]+";

	private static final String STRING_WHITESPACE = " ";
	private static final String STRING_RIGHT_ANGLE_BRACKETS = ">";
	private static final String STRING_HYPHEN = "-";

	private static final int INDEX_FIRST = 0;
	private static final int INDEX_SECOND = 1;

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
		ArrayList<String> stringArray = splitStringIntoArrayDelimSpace(userStringInput);
		return stringArray.get(INDEX_FIRST);
	}

	public String extractUserEventTask(String userStringInput) {
		ArrayList<String> stringArray = splitStringIntoArrayDelimAngleBrackets(userStringInput);
		return stringArray.get(INDEX_FIRST)
				.substring(stringArray.get(INDEX_FIRST).indexOf(STRING_WHITESPACE) + INDEX_ADD_ONE).trim();
	}

	public String extractUserDate(ArrayList<String> stringArray) {
		return stringArray.get(INDEX_FIRST);
	}

	public String extractUserTime(ArrayList<String> stringArray) {
		return stringArray.get(INDEX_SECOND);
	}

	public String[] extractUserDateRange(ArrayList<String> stringArray) {
	}

	public String[] extractUserTimeRange(ArrayList<String> stringArray) {

	}

	public ArrayList<String> splitStringIntoArrayDelimSpace(String userStringInput) {
		String[] stringSplitArrayDelimSpace = userStringInput.trim().split(REGEX_WHITESPACES);
		return new ArrayList<String>(Arrays.asList(stringSplitArrayDelimSpace));
	}

	public ArrayList<String> splitStringIntoArrayDelimAngleBrackets(String userStringInput) {
		String[] stringSplitArrayDelimColon = userStringInput.trim().split(STRING_RIGHT_ANGLE_BRACKETS);
		return new ArrayList<String>(Arrays.asList(stringSplitArrayDelimColon));
	}

	public ArrayList<String> splitStringIntoArrayDelimHyphen(String userStringInput) {
		String[] stringSplitArrayDelimHyphen = userStringInput.trim().split(STRING_HYPHEN);
		return new ArrayList<String>(Arrays.asList(stringSplitArrayDelimHyphen));
	}
}
