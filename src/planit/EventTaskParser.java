/*
 * This class extracts the string representing the user's event/task
 * ASSUMPTIONS
 * 1) Event/task arguments always comes after the user's command
 * 2) Event/task arguments always comes before any arguments related to time
 */

package planit;

import java.util.ArrayList;

public class EventTaskParser {

	public static String getEventTask(String str) {
		ArrayList<String> arr = Parser.toArrayList(str.trim().toLowerCase(), ParserConstants.CHAR_SINGLE_WHITESPACE);
		int index = Parser.indexOf(ParserConstants.KW_START, arr);
		if (index != -1) {
			for (int i = index; i < arr.size();) {
				arr.remove(i);
			}
			arr.remove(0);
			return Parser.toString(arr).trim();
		} else {
			arr.remove(0);
			return Parser.toString(arr).trim();
		}
	}
}
