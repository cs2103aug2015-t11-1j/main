/*
 * @author: Jeston Teo
 * 
 * This class parses an entire string command into its respective <categories>
 * ASSUMPTIONS:
 * 1) Commands are entered in this general format: <command> <event> <date> <time>
 * TODO  
 */

package planit;

import java.util.ArrayList;
import java.util.Arrays;

public class StringParser {

	private String userStringInput;

	private static final String REGEX_WHITESPACES = "[\\s,]+";
	private static final String REGEX_COLON = ":";

	private static final int INDEX_ADD_ONE = 1;

	/*
	 * CONSTRUCTORS
	 */
	public StringParser(String userStringInput) {
		this.userStringInput = userStringInput;
	}

	public ArrayList<String> splitStringIntoArrayDelimSpace(String userStringInput) {
		String[] stringSplitArray = userStringInput.trim().split(REGEX_WHITESPACES);
		return new ArrayList<String>(Arrays.asList(stringSplitArray));
	}

	public ArrayList<String> splitStringIntoArrayDelimColon(String userStringInput) {
		String[] stringSplitArrayDelimColon = userStringInput.trim().split(REGEX_COLON);
		return new ArrayList<String>(Arrays.asList(stringSplitArrayDelimColon));
	}

	public String extractUserCommand(ArrayList<String> stringArray) {
		return stringArray.get(0);
	}

	public String extractUserEventTask(ArrayList<String> stringArray) {
		String commandAndEventTask = stringArray.get(0);
		return commandAndEventTask.substring(commandAndEventTask.indexOf(" ") + INDEX_ADD_ONE).trim();
	}

	/*
	 * ACCESSORS
	 */
	public String getUserStringInput() {
		return userStringInput;
	}
}
