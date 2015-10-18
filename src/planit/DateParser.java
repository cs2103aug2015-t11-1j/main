package planit;

import java.util.ArrayList;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateParser {

	enum TYPES {
		TODAY, TOMORROW, OTHERS;
	}

	public static TYPES getType(String str) {
		if (Parser.isPresent(ParserConstants.KW_TODAY, str)) {
			return TYPES.TODAY;
		} else if (Parser.isPresent(ParserConstants.KW_TOMORROW, str)) {
			return TYPES.TOMORROW;
		} else {
			return TYPES.OTHERS;
		}
	}

	public static String getStartDate(String str) {
		ArrayList<String> arr = Parser.toArrayList(str.trim().toLowerCase());
		int index = Parser.indexOf(ParserConstants.KW_START, str);
		if (index != -1) {
			TYPES type = getType(arr.get(index));
			switch (type) {
			case TODAY:
				return getTodayDate();
			case TOMORROW:
				return getTmrDate();
			case OTHERS:
				// TODO search for the relevant dates
				break;
			default:
				break;
			}
		} else {
			return null;
		}
	}

	public static String getEndDate(String str) {
		ArrayList<String> arr = Parser.toArrayList(str.trim().toLowerCase());
		int index = Parser.lastIndexOf(ParserConstants.KW_END, str);
		if (index != -1) {
			TYPES type = getType(arr.get(index));
			switch (type) {
			case TODAY:
				return getTodayDate();
			case TOMORROW:
				return getTmrDate();
			case OTHERS:
				break;
			default:
				break;
			}
		} else {

		}
	}

	private static String getTodayDate() {
		LocalDateTime date = LocalDateTime.now();
		return date.toString(ParserConstants.FORMAT_DATE_STORAGE);
	}

	private static String getTmrDate() {
		LocalDateTime date = LocalDateTime.now();
		date = date.plusDays(ParserConstants.INT_ONE);
		return date.toString(ParserConstants.FORMAT_DATE_STORAGE);
	}
}
