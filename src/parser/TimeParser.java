/*
 * ADD SUPPORT FOR AM, PM INPUTS
 */

package parser;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

public class TimeParser {

	private static ArrayList<String> getTimeArray(String str) {
		ArrayList<String> arr = Parser.toArrayList(str, ParserConstants.CHAR_SINGLE_WHITESPACE);
		ArrayList<String> timeArr = new ArrayList<String>(2);
		for (String str1 : arr) {
			LocalDateTime time = null;
			for (String str2 : ParserConstants.FORMAT_TIME) {
				try {
					time = DateTimeFormat.forPattern(str2).parseLocalDateTime(str1);
					timeArr.add(time.toString(ParserConstants.FORMAT_TIME_STORAGE));
				} catch (NullPointerException e) {

				} catch (IllegalArgumentException e) {

				}
			}
		}
		return timeArr;
	}
	
	protected static String getStartTime(String str) {
		ArrayList<String> timeArr = new ArrayList<String>(2);
		timeArr = getTimeArray(str);
		try {
			return timeArr.get(0);
		} catch (NullPointerException e) {
			return "";
		} catch (IndexOutOfBoundsException e) {
			return "";
		}
	}
	
	protected static String getEndTime(String str) {
		ArrayList<String> timeArr = new ArrayList<String>(2);
		timeArr = getTimeArray(str);
		try {
			return timeArr.get(1);
		} catch (NullPointerException e) {
			return "";
		} catch (IndexOutOfBoundsException e) {
			return "";
		}
	}
}
