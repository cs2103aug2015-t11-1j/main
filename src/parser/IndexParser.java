/*
 * This class returns the index argument if it is present in the user String input
 * 
 * ASSUMPTIONS
 * 1) Index argument always comes after the Action String
 */

package parser;

import java.util.ArrayList;

public class IndexParser {
	
	protected static int getIndex(String str) {
		ArrayList<String> arr = Parser.toArrayList(str.trim(), ParserConstants.CHAR_SINGLE_WHITESPACE);
		if (Parser.indexPresent(arr)) {
			return Integer.parseInt(arr.get(ParserConstants.INDEX_SECOND));
		}
		else {
			return -1;
		}
	}
}
