/*
 * @@author A0121319R
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
	 */
	protected static void getDateTimeArgs(String str) throws InvalidInputException {
		LocalDate now = new LocalDate();
		dateArgs = new ArrayList<String>();
		timeArgs = new ArrayList<String>();

		LocalDate startDate = null;
		LocalDate endDate = null;
		LocalTime startTime = null;
		LocalTime endTime = null;

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
				parseForDate(now, string);
				parseForTime(string);
			}
		} catch (IndexOutOfBoundsException e) {

		}

		if (dateArgs.size() > 1 || timeArgs.size() > 1) {
			throw new InvalidInputException("Invalid input: Too many inputs");
		} else if (dateArgs.isEmpty() && !timeArgs.isEmpty()) {
			dateArgs.add(getDate(0));
		} else if (!dateArgs.isEmpty() && timeArgs.isEmpty()) {
			timeArgs.add("");
		} else if (dateArgs.isEmpty() && timeArgs.isEmpty()) {
			dateArgs.add("");
			timeArgs.add("");
		}

		try {
			startDate = DateTimeFormat.forPattern(ParserConstants.FORMAT_DATE_STORAGE)
					.parseLocalDate(dateArgs.get(ParserConstants.INDEX_FIRST));
			startTime = DateTimeFormat.forPattern(ParserConstants.FORMAT_TIME_STORAGE)
					.parseLocalTime(timeArgs.get(ParserConstants.INDEX_FIRST));
		} catch (IllegalArgumentException e) {

		}

		/** End Date/Time Arguments **/
		try {
			for (String string : endArr) {
				convertTodayToDateTime(string);
				convertTmrToDateTime(string);
				parseForDate(now, string);
				parseForTime(string);
			}
		} catch (IndexOutOfBoundsException e) {

		}

		if (dateArgs.size() > 2 || timeArgs.size() > 2) {
			throw new InvalidInputException("Invalid input: Too many inputs");
		} else if (dateArgs.size() == 1 && timeArgs.size() == 2) {
			if (startDate != null) {
				dateArgs.add(startDate.toString(ParserConstants.FORMAT_DATE_STORAGE));
			} else {
				dateArgs.add(getDate(0));
			}
		} else if (dateArgs.size() == 2 && timeArgs.size() == 1) {
			timeArgs.add("");
		} else if (dateArgs.size() == 1 && timeArgs.size() == 1) {
			dateArgs.add("");
			timeArgs.add("");
		}
		
		// Shift the endDate/Time to the first index such that it can be shown on the UI
		if (dateArgs.get(0).isEmpty() && !dateArgs.get(1).isEmpty() && timeArgs.get(0).isEmpty()
				&& !timeArgs.get(1).isEmpty()) {
			dateArgs.set(0, dateArgs.get(1));
			dateArgs.set(1, "");
			timeArgs.set(0, timeArgs.get(1));
			timeArgs.set(1, "");
		}

		try {
			endDate = DateTimeFormat.forPattern(ParserConstants.FORMAT_DATE_STORAGE)
					.parseLocalDate(dateArgs.get(ParserConstants.INDEX_SECOND));
			endTime = DateTimeFormat.forPattern(ParserConstants.FORMAT_TIME_STORAGE)
					.parseLocalTime(timeArgs.get(ParserConstants.INDEX_SECOND));
		} catch (IllegalArgumentException e) {

		}

		if (startDate != null && endDate != null) {
			if (startDate.compareTo(endDate) == 1) {
				throw new InvalidInputException("Invalid input: Start date cannot come after the end date");
			} else if (startDate.compareTo(endDate) == 0) {
				if (startTime.compareTo(endTime) == 1) {
					throw new InvalidInputException("Invalid input: Start time cannot come after the end time");
				} else if (startTime.compareTo(endTime) == 0) {
					throw new InvalidInputException(
							"Invalid input: Start time cannot be the same as the end time within the same day");
				}
			}
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
	 * Parses the target String for acceptable date formats and adds it to
	 * dateArgs
	 * 
	 * Throws an InvalidInputException if the date entered has passed
	 */
	private static void parseForDate(LocalDate now, String target) throws InvalidInputException {
		LocalDate date = null;
		for (String keyword : ParserConstants.FORMAT_DATE_WITHOUT_YEAR) {
			try {
				date = DateTimeFormat.forPattern(keyword).parseLocalDate(target).withYear(now.getYear());
				dateArgs.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
			} catch (IllegalArgumentException | NullPointerException e) {

			}
		}
		for (String keyword : ParserConstants.FORMAT_DATE_WITH_YEAR) {
			try {
				date = DateTimeFormat.forPattern(keyword).parseLocalDate(target);
				dateArgs.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
			} catch (IllegalArgumentException | NullPointerException e) {

			}
		}
	}

	/*
	 * Parses the target String for acceptable time formats and adds it to
	 * timeArgs
	 */
	private static void parseForTime(String target) throws InvalidInputException {
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
				dateArgs.add(getDate(1));
			}
		}
	}

	private static void convertTodayToDateTime(String target) {
		for (String keyword : ParserConstants.KW_TODAY) {
			if (target.equals(keyword)) {
				dateArgs.add(getDate(0));
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
			if (endIndex == -1) {
				for (int i = 0; i < temp.size(); i++) {
					startArr.add(temp.get(i));
				}
			} else {
				for (int i = 0; i < endIndex; i++) {
					startArr.add(temp.get(i));
				}
				for (int i = endIndex; i < temp.size(); i++) {
					endArr.add(temp.get(i));
				}
			}
		} else {
			int endIndex = Parser.indexOf(ParserConstants.KW_END, arr);
			if (endIndex == -1) {
				for (int i = 0; i < arr.size(); i++) {
					startArr.add(arr.get(i));
				}
			} else {
				for (int i = 0; i < endIndex; i++) {
					startArr.add(arr.get(i));
				}
				for (int i = endIndex; i < arr.size(); i++) {
					endArr.add(arr.get(i));
				}
			}
		}
	}
}
