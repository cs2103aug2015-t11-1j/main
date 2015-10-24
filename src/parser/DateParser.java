/*
 * REFACTORING REQUIRED
 * TWEAKING REQUIRED
 * 
 * ADD SUPPORT FOR "DD MMMM YY" KIND OF FORMAT
 */

package parser;

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

	/*
	 * Method for parsing date arguments for an ADD command
	 */
	protected static ArrayList<String> addDateArg(String str) throws InvalidInputException, NullPointerException {
		ArrayList<String> arr = Parser.toArrayList(str, ParserConstants.CHAR_SINGLE_WHITESPACE);
		ArrayList<String> dateArg = new ArrayList<String>();
		boolean startExist = false;
		boolean endExist = false;

		int startIndex = Parser.indexOf(ParserConstants.KW_START, arr);
		int endIndex = Parser.indexOf(ParserConstants.KW_END, arr);

		ArrayList<String> startArr = new ArrayList<String>();
		ArrayList<String> endArr = new ArrayList<String>();

		if (startIndex != -1 && endIndex != -1) {
			for (int i = startIndex; i < endIndex; i++) {
				startArr.add(arr.get(i));
			}
			for (int i = endIndex + 1; i < arr.size(); i++) {
				endArr.add(arr.get(i));
			}
		} else if (startIndex != -1 && endIndex == -1) {
			for (int i = startIndex; i < arr.size(); i++) {
				startArr.add(arr.get(i));
			}
		} else if (startIndex == -1 && endIndex != -1) {
			for (int i = endIndex + 1; i < arr.size(); i++) {
				endArr.add(arr.get(i));
			}
		}

		try {
			TYPES type = getType(startArr.get(0));
			switch (type) {
			case TODAY:
				dateArg.add(getDate(0));
				startExist = true;
				break;
			case TOMORROW:
				dateArg.add(getDate(1));
				startExist = true;
				break;
			case OTHERS:
				startExist = Parser.extractArguments(dateArg, startExist, startArr, ParserConstants.FORMAT_DATE,
						ParserConstants.FORMAT_DATE_STORAGE);
				break;
			}
		} catch (IndexOutOfBoundsException e) {

		}

		try {
			TYPES type = getType(endArr.get(0));
			switch (type) {
			case TODAY:
				dateArg.add(getDate(0));
				endExist = true;
				break;
			case TOMORROW:
				dateArg.add(getDate(1));
				endExist = true;
				break;
			case OTHERS:
				endExist = Parser.extractArguments(dateArg, endExist, endArr, ParserConstants.FORMAT_DATE,
						ParserConstants.FORMAT_DATE_STORAGE);
				break;
			}
		} catch (IndexOutOfBoundsException e) {

		}

		boolean startTimeExist = false;
		boolean endTimeExist = false;
		startTimeExist = Parser.isPresent(startArr, ParserConstants.FORMAT_TIME);
		endTimeExist = Parser.isPresent(endArr, ParserConstants.FORMAT_TIME);

		// boolean timeArgExist = (startTimeExist || endTimeExist);

		if (dateArg.size() > 2 || (startExist == false && startIndex != -1 && !startTimeExist)
				|| (endExist == false && endIndex != -1 && !endTimeExist)) {
			throw new InvalidInputException();
		} else {
			if (startExist == false && endExist == false && startTimeExist == true && endTimeExist == false) {
				dateArg.add(getDate(0));
				dateArg.add("");
				return dateArg;
			} else if (startExist == false && endExist == false && startTimeExist == false && endTimeExist == true) {
				dateArg.add("");
				dateArg.add(getDate(0));
				return dateArg;
			} else if (startExist == false && endExist == false && startTimeExist == true && endTimeExist == true) {
				dateArg.add(getDate(0));
				dateArg.add(getDate(0));
				return dateArg;
			} else if (startExist == false && endExist == false && startTimeExist == false && endTimeExist == false) {
				dateArg.add("");
				dateArg.add("");
				return dateArg;
			} else if (startExist == false && endExist == true && startTimeExist == true) {
				dateArg.add(dateArg.get(0));
				dateArg.set(0, getDate(0));
				return dateArg;
			} else if (startExist == false && endExist == true && startTimeExist == false) {
				dateArg.add(dateArg.get(0));
				dateArg.set(0, "");
				return dateArg;
			} else if (startExist == true && endExist == false && startTimeExist == false && endTimeExist == true) {
				throw new InvalidInputException();
			} else if (startExist == true && endExist == false) {
				dateArg.add("");
				return dateArg;
			} else {
				return dateArg;
			}
		}
	}
	
	/*
	 * Unique to SHOW action
	 */
	protected static String getShowDate(String str) throws InvalidInputException {
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> returnArr = new ArrayList<String>();
		arr = Parser.toArrayList(str, ParserConstants.CHAR_SINGLE_WHITESPACE);
		for (String s1 : arr) {
			LocalDateTime date = null;
			for (String s2 : ParserConstants.FORMAT_DATE) {
				try {
					date = DateTimeFormat.forPattern(s2).parseLocalDateTime(s1);
					returnArr.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
				} catch (NullPointerException | IllegalArgumentException e) {
					
				}
			}
		}
		if (returnArr.size() != 1) {
			throw new InvalidInputException();
		} else {
			return returnArr.get(0);
		}
	}

	/*
	 * Adds today's date to the number of days specified and return the sum as a
	 * String in the format "dd/MM/yy"
	 */
	protected static String getDate(int plus) {
		LocalDateTime date = LocalDateTime.now();
		date = date.plusDays(plus);
		return date.toString(ParserConstants.FORMAT_DATE_STORAGE);
	}
}
