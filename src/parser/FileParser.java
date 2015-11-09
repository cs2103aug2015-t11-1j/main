/*
 * @@author A0121319R
 */

package parser;

import java.util.ArrayList;

public class FileParser {

	/*
	 * This method parses for the file path specified by the user
	 * 
	 * Assumptions: 1)There are no spaces in the specified file path
	 */
	protected static String getFilePath(String str) throws InvalidInputException {
		ArrayList<String> arr = Parser.toArrayList(str.trim(), ParserConstants.CHAR_SINGLE_WHITESPACE);
		if (arr.size() > 2) {
			throw new InvalidInputException("Invalid input: Please enter a valid file path");
		} else {
			arr.remove(ParserConstants.INDEX_FIRST);
			String toReturn = Parser.toString(arr).trim();
			if (toReturn.equals(ParserConstants.CHAR_SINGLE_BLANK)) {
				throw new InvalidInputException("Invalid input: Please enter a valid file path");
			} else {
				return toReturn;
			}
		}
	}
}
