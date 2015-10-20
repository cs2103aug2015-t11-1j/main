/*
 * This class extracts the string representing the user's event/task
 * ASSUMPTIONS
 * 1) Event/task arguments always comes after the action and index argument
 * 2) Event/task arguments always comes before any arguments related to time
 * 
 * <action> <index> <event/task> *KEYWORD* <DATE/TIME>
 */

package parser;

import java.util.ArrayList;

public class EventTaskParser {

	protected static String getEventTask(String str) {
		ArrayList<String> arr = Parser.toArrayList(str.trim().toLowerCase(), ParserConstants.CHAR_SINGLE_WHITESPACE);
		if (Parser.indexPresent(arr)) {
			arr.remove(ParserConstants.INDEX_SECOND);
		}
		int index = Parser.indexOf(ParserConstants.KW_START, arr);
		if (index != -1) {
			for (int i = index; i < arr.size();) {
				arr.remove(i);
			}
			arr.remove(ParserConstants.INDEX_FIRST);
			return Parser.toString(arr).trim();
		} else {
			arr.remove(ParserConstants.INDEX_FIRST);
			return Parser.toString(arr).trim();
		}
	}
}
