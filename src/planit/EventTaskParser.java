/*
 * This class extracts the string representing the user's event/task
 * ASSUMPTIONS
 * 1) Event/task arguments always comes after the user's command
 * 2) Event/task arguments always comes before any arguments related to time
 */

package planit;

import java.util.ArrayList;

public class EventTaskParser {

	public static String extractEventTask(String str) {
		ArrayList<String> arr = Parser.toArrayList(str.trim());
		int index = Parser.isDateTimePresent(str.trim());
		if (index != -1) {
			for (int i = index; i < arr.size();) {
				arr.remove(i);
			}
			return getEventString(arr).trim();
		} else {
			return getEventString(arr).trim();
		}
	}

	private static String getEventString(ArrayList<String> arr) {
		arr.remove(ParserConstants.INDEX_FIRST);
		String toReturn = "";
		for (int j = 0; j < arr.size(); j++) {
			toReturn = toReturn + ParserConstants.CHAR_SINGLE_WHITESPACE + arr.get(j);
		}
		return toReturn;
	}
}
