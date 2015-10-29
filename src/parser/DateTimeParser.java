/*
 * Work in progress
 */

package parser;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

public class DateTimeParser {

	private static ArrayList<String> dateArgs;
	private static ArrayList<String> timeArgs;

	enum DATE {
		TODAY, TOMORROW, OTHERS;
	}

	private static DATE getDateType(String str) {
		if (Parser.isPresent(ParserConstants.KW_TODAY, str)) {
			return DATE.TODAY;
		} else if (Parser.isPresent(ParserConstants.KW_TOMORROW, str)) {
			return DATE.TOMORROW;
		} else {
			return DATE.OTHERS;
		}
	}

	protected static void getDateTimeArgs(String str) throws InvalidInputException {
		LocalDateTime now = new LocalDateTime();
		dateArgs = new ArrayList<String>();
		timeArgs = new ArrayList<String>();
		/*
		 * String startDate = null; String startTime = null; String endDate =
		 * null; String endTime = null;
		 */
		/*
		 * boolean startDateExist = false; boolean startTimeExist = false;
		 * boolean endDateExist = false; boolean endTimeExist = false;
		 */

		ArrayList<String> arr = Parser.toArrayList(str, ParserConstants.CHAR_SINGLE_WHITESPACE);
		ArrayList<String> startArr = new ArrayList<String>();
		ArrayList<String> endArr = new ArrayList<String>();

		// Strict format: ">"
		int endIndex = Parser.indexOf(ParserConstants.KW_END, arr);
		// System.out.println(endIndex);

		/** Partitioning **/
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
		// System.out.println(startArr.toString());
		// System.out.println(endArr.toString());

		/** Start Date/Time Arguments **/
		try {
			for (String string : startArr) {
				for (String keyword : ParserConstants.KW_TODAY) {
					if (string.equals(keyword)) {
						dateArgs.add(getDate(0));
						// startDateExist = true;
					}
				}
				for (String keyword : ParserConstants.KW_TOMORROW) {
					if (string.equals(keyword)) {
						dateArgs.add(getDate(1));
						// startDateExist = true;
					}
				}
				LocalDateTime date = null;
				for (String keyword : ParserConstants.FORMAT_DATE_WITHOUT_YEAR) {
					try {
						date = DateTimeFormat.forPattern(keyword).parseLocalDateTime(string).withYear(now.getYear());
						if (date.compareTo(now) == -1) {
							throw new InvalidInputException();
						}
						dateArgs.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
						// startDateExist = true;
					} catch (IllegalArgumentException | NullPointerException e) {

					}
				}
				for (String keyword : ParserConstants.FORMAT_DATE_WITH_YEAR) {
					try {
						date = DateTimeFormat.forPattern(keyword).parseLocalDateTime(string);
						if (date.compareTo(now) == -1) {
							throw new InvalidInputException();
						}
						dateArgs.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
						// startDateExist = true;
					} catch (IllegalArgumentException | NullPointerException e) {

					}
				}
				LocalDateTime time = null;
				for (String keyword : ParserConstants.FORMAT_TIME) {
					try {
						time = DateTimeFormat.forPattern(keyword).parseLocalDateTime(string);
						timeArgs.add(time.toString(ParserConstants.FORMAT_TIME_STORAGE));
						// startTimeExist = true;
					} catch (IllegalArgumentException | NullPointerException e) {

					}
				}

			}
		} catch (IndexOutOfBoundsException e) {

		}
		if (dateArgs.size() > 1 || timeArgs.size() > 1) {
			throw new InvalidInputException();
		} else if (dateArgs.isEmpty() && !timeArgs.isEmpty()) {
			dateArgs.add(getDate(0));
		} else if (!dateArgs.isEmpty() && timeArgs.isEmpty()) {
			timeArgs.add("");
		} else if (dateArgs.isEmpty() && timeArgs.isEmpty()) {
			dateArgs.add("");
			timeArgs.add("");
		}
		/** End Date/Time Arguments **/
		try {
			for (String string : endArr) {
				for (String keyword : ParserConstants.KW_TODAY) {
					if (string.equals(keyword)) {
						dateArgs.add(getDate(0));
						// endDateExist = true;
					}
				}
				for (String keyword : ParserConstants.KW_TOMORROW) {
					if (string.equals(keyword)) {
						dateArgs.add(getDate(1));
						// endDateExist = true;
					}
				}
				LocalDateTime date = null;
				for (String keyword : ParserConstants.FORMAT_DATE_WITHOUT_YEAR) {
					try {
						date = DateTimeFormat.forPattern(keyword).parseLocalDateTime(string).withYear(now.getYear());
						if (date.compareTo(now) == -1) {
							throw new InvalidInputException();
						}
						dateArgs.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
						// endDateExist = true;
					} catch (IllegalArgumentException | NullPointerException e) {

					}
				}
				for (String keyword : ParserConstants.FORMAT_DATE_WITH_YEAR) {
					try {
						date = DateTimeFormat.forPattern(keyword).parseLocalDateTime(string);
						if (date.compareTo(now) == -1) {
							throw new InvalidInputException();
						}
						dateArgs.add(date.toString(ParserConstants.FORMAT_DATE_STORAGE));
						// endDateExist = true;
					} catch (IllegalArgumentException | NullPointerException e) {

					}
				}
				LocalDateTime time = null;
				for (String keyword : ParserConstants.FORMAT_TIME) {
					try {
						time = DateTimeFormat.forPattern(keyword).parseLocalDateTime(string);
						timeArgs.add(time.toString(ParserConstants.FORMAT_TIME_STORAGE));
						// endTimeExist = true;
					} catch (IllegalArgumentException | NullPointerException e) {

					}
				}

			}
		} catch (IndexOutOfBoundsException e) {

		}

		if (dateArgs.size() > 2 || timeArgs.size() > 2) {
			throw new InvalidInputException();
		} else if (dateArgs.size() == 1 && timeArgs.size() == 2) {
			dateArgs.add(getDate(0));
		} else if (dateArgs.size() == 2 && timeArgs.size() == 1) {
			timeArgs.add("");
		} else if (dateArgs.size() == 1 && timeArgs.size() == 1) {
			dateArgs.add("");
			timeArgs.add("");
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

	/***** GETTERS *****/
	protected static ArrayList<String> getDateArgs() {
		return dateArgs;
	}

	protected static ArrayList<String> getTimeArgs() {
		return timeArgs;
	}
}
