/*
 * This class returns the index argument if it is present in the user String input
 * 
 * ASSUMPTIONS
 * 1) Index argument always comes after the Action String (Second index in an ArrayList)
 */

package parser;

import java.util.ArrayList;

public class IndexParser {

	protected static int getIndex(String str) throws InvalidInputException {
		ArrayList<String> arr = Parser.toArrayList(str.trim(), ParserConstants.CHAR_SINGLE_WHITESPACE);
		if (Parser.indexPresent(arr)) {
			return Integer.parseInt(arr.get(ParserConstants.INDEX_SECOND));
		} else {
			throw new InvalidInputException();
		}
	}
}
