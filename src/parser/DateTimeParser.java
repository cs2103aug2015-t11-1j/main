/*
 * @author: Jeston Teo
 * 
 * This class extracts the date/time arguments in the user's String input
 */

package parser;

import java.util.ArrayList;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;

public class DateTimeParser {

	private static ArrayList<String> dateArgs;
	private static ArrayList<String> timeArgs;

	/*
	 * This method parses the input String for date/time arguments
	 * 
	 * Assumptions 1) There can only be a maximum of 2 date and 2 time argument
	 * 2) There may be date/time related words in the event/task argument. Use
	 * ">" to differentiate them 3) A date which has passed will throw an
	 * InvalidInputException 4) Start time without a start date will
	 * automatically have today's date added to dateArgs 5) Having keywords but
	 * no following date/time arguments will not throw an exception
	 */
	protected static void getDateTimeArgs(String str) throws InvalidInputException {
		LocalDate now = new LocalDate();
		dateArgs = new ArrayList<String>();
		timeArgs = new ArrayList<String>();

		ArrayList<String> arr = Parser.toArrayList(str, ParserConstants.CHAR_SINGLE_WHITESPACE);
		ArrayList<String> startArr = new ArrayList<String>();
		ArrayList<String> endArr = new ArrayList<String>();

		/** Partitioning **/
		partition(arr, startArr, endArr);

		/** Start Date/Time Arguments **/
		try {
			for (String string : startArr) {
				convertTodayToDateTime(string);
				convertTmrToDateTime(string);
				parseForDateTime(now, string);
			}
		} catch (IndexOutOfBoundsException e) {

		}

		if (dateArgs.size() > ParserConstants.INT_ONE || timeArgs.size() > ParserConstants.INT_ONE) {
			throw new InvalidInputException("Invalid input: Too many inputs");
		} else if (dateArgs.isEmpty() && !timeArgs.isEmpty()) {
			dateArgs.add(getDate(ParserConstants.INT_ZERO));
		} else if (!dateArgs.isEmpty() && timeArgs.isEmpty()) {
			timeArgs.add("");
		} else if (dateArgs.isEmpty() && timeArgs.isEmpty()) {
			dateArgs.add("");
			timeArgs.add("");
		}

		/** End Date/Time Arguments **/
		try {
			for (String string : endArr) {
				convertTodayToDateTime(string);
				convertTmrToDateTime(string);
				parseForDateTime(now, string);
			}
		} catch (IndexOutOfBoundsException e) {

		}

		if (dateArgs.size() > ParserConstants.INT_TWO || timeArgs.size() > ParserConstants.INT_TWO) {
			throw new InvalidInputException("Invalid input: Too many inputs");
		} else if (dateArgs.size() == ParserConstants.INT_ONE && timeArgs.size() == ParserConstants.INT_TWO) {
			dateArgs.add(getDate(ParserConstants.INT_ZERO));
		} else if (dateArgs.size() == ParserConstants.INT_TWO && timeArgs.size() == ParserConstants.INT_ONE) {
			timeArgs.add("");
		} else if (dateArgs.size() == ParserConstants.INT_ONE && timeArgs.size() == ParserConstants.INT_ONE) {
			dateArgs.add("");
			timeArgs.add("");
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

	/***** GETTERS *****/
	protected static ArrayList<String> getDateArgs() {
		return dateArgs;
	}

	protected static ArrayList<String> getTimeArgs() {
		return timeArgs;
	}

	/*
	 * Parses the target String and adds it to the corresponding ArrayList
	 * should it match the format
	 * 
	 * Throws an InvalidInputException if the date entered has passed
	 */
	private static void parseForDateTime(LocalDate now, String target) throws InvalidInputException {
		LocalDate date;
		for (String keyword : ParserConstants.FORMAT_DATE_WITHOUT_YEAR) {
			try {
				date = DateTimeFormat.forPattern(keyword).parseLocalDate(target).withYear(now.getYear());
				if (date.compareTo(now) == ParserConstants.INT_NEG_ONE) {
					throw new InvalidInputException("Invalid input: Please enter valid dates");
				}
				dateArgs.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
			} catch (IllegalArgumentException | NullPointerException e) {

			}
		}
		for (String keyword : ParserConstants.FORMAT_DATE_WITH_YEAR) {
			try {
				date = DateTimeFormat.forPattern(keyword).parseLocalDate(target);
				if (date.compareTo(now) == ParserConstants.INT_NEG_ONE) {
					throw new InvalidInputException("Invalid input: Please enter valid dates");
				}
				dateArgs.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
			} catch (IllegalArgumentException | NullPointerException e) {

			}
		}
		LocalTime time = null;
		for (String keyword : ParserConstants.FORMAT_TIME) {
			try {
				time = DateTimeFormat.forPattern(keyword).parseLocalTime(target);
				timeArgs.add(time.toString(ParserConstants.FORMAT_TIME_STORAGE));
			} catch (IllegalArgumentException | NullPointerException e) {

			}
		}
	}

	private static void convertTmrToDateTime(String target) {
		for (String keyword : ParserConstants.KW_TOMORROW) {
			if (target.equals(keyword)) {
				dateArgs.add(getDate(ParserConstants.INT_ONE));
			}
		}
	}

	private static void convertTodayToDateTime(String target) {
		for (String keyword : ParserConstants.KW_TODAY) {
			if (target.equals(keyword)) {
				dateArgs.add(getDate(ParserConstants.INT_ZERO));
			}
		}
	}

	/*
	 * This method partitions arr into 2 parts: startArr and endArr.
	 * 
	 * Partitions are determined primarily by the presence of ">" and by
	 * elements contained in KW_END
	 */
	private static void partition(ArrayList<String> arr, ArrayList<String> startArr, ArrayList<String> endArr) {
		if (arr.contains(ParserConstants.CHAR_RIGHT_ANGLE_BRACKET)) {
			int strictIndex = Parser.indexOf(ParserConstants.CHAR_RIGHT_ANGLE_BRACKET, arr);
			ArrayList<String> temp = new ArrayList<String>();
			for (int i = strictIndex; i < arr.size(); i++) {
				temp.add(arr.get(i));
			}
			int endIndex = Parser.indexOf(ParserConstants.KW_END, temp);
			if (endIndex == ParserConstants.INT_NEG_ONE) {
				for (int i = ParserConstants.INT_ZERO; i < temp.size(); i++) {
					startArr.add(temp.get(i));
				}
			} else {
				for (int i = ParserConstants.INT_ZERO; i < endIndex; i++) {
					startArr.add(temp.get(i));
				}
				for (int i = endIndex; i < temp.size(); i++) {
					endArr.add(temp.get(i));
				}
			}
		} else {
			int endIndex = Parser.indexOf(ParserConstants.KW_END, arr);
			if (endIndex == ParserConstants.INT_NEG_ONE) {
				for (int i = ParserConstants.INT_ZERO; i < arr.size(); i++) {
					startArr.add(arr.get(i));
				}
			} else {
				for (int i = ParserConstants.INT_ZERO; i < endIndex; i++) {
					startArr.add(arr.get(i));
				}
				for (int i = endIndex; i < arr.size(); i++) {
					endArr.add(arr.get(i));
				}
			}
		}
	}
}
