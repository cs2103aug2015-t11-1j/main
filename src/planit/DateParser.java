/*
 * REFACTORING REQUIRED
 * TWEAKING REQUIRED
 * 
 * ADD SUPPORT FOR "DD MMMM YY" KIND OF FORMAT
 */

package planit;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

public class DateParser {

	enum TYPES {
		TODAY, TOMORROW, OTHERS;
	}

	private static TYPES getType(String str) {
		if (Parser.isPresent(ParserConstants.KW_TODAY, str)) {
			return TYPES.TODAY;
		} else if (Parser.isPresent(ParserConstants.KW_TOMORROW, str)) {
			return TYPES.TOMORROW;
		} else {
			return TYPES.OTHERS;
		}
	}

	public static String getStartDate(String str) {
		ArrayList<String> arr = Parser.toArrayList(str.trim().toLowerCase(), ParserConstants.CHAR_SINGLE_WHITESPACE);
		int index = Parser.indexOf(ParserConstants.KW_START, arr);
		if (index != -1) {
			TYPES type = getType(arr.get(index));
			switch (type) {
			case TODAY:
				return getDate(0);
			case TOMORROW:
				return getDate(1);
			case OTHERS:
				// Removing elements before keyword
				for (int i = 0; i < index + 1; i++) {
					arr.remove(0);
				}
				ArrayList<String> dateArr = new ArrayList<String>(2);
				for (String s1 : arr) {
					LocalDateTime date = null;
					for (String s2 : ParserConstants.FORMAT_DATE) {
						try {
							date = DateTimeFormat.forPattern(s2).parseLocalDateTime(s1);
							dateArr.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
						} catch (NullPointerException e) {

						} catch (IllegalArgumentException e) {

						}
					}
				}
				return dateArr.get(0);
			default:
				return null;
			}
		} else {
			return null;
		}
	}

	public static String getEndDate(String str) {
		ArrayList<String> arr = Parser.toArrayList(str.trim().toLowerCase(), ParserConstants.CHAR_SINGLE_WHITESPACE);
		int index = Parser.lastIndexOf(ParserConstants.KW_END, arr);
		if (index != -1) {
			TYPES type = getType(arr.get(index));
			switch (type) {
			case TODAY:
				return getDate(0);
			case TOMORROW:
				return getDate(1);
			case OTHERS:
				for (int i = 0; i < index + 1; i++) {
					arr.remove(0);
				}
				ArrayList<String> dateArr = new ArrayList<String>(2);
				for (String s1 : arr) {
					LocalDateTime date = null;
					for (String s2 : ParserConstants.FORMAT_DATE) {
						try {
							date = DateTimeFormat.forPattern(s2).parseLocalDateTime(s1);
							dateArr.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
						} catch (NullPointerException e) {

						} catch (IllegalArgumentException e) {

						}
					}
				}
				return dateArr.get(0);
			default:
				return null;
			}
		} else {
			return null;
		}
	}

	/*
	 * Adds today's date to the number of days specified and return the sum as a
	 * String in the format "dd/MM/yy"
	 */
	private static String getDate(int plus) {
		LocalDateTime date = LocalDateTime.now();
		date = date.plusDays(plus);
		return date.toString(ParserConstants.FORMAT_DATE_STORAGE);
	}
}
