package planit;

import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

	public static ArrayList<String> toArrayList(String str) {
		String[] strArr = str.split(ParserConstants.REGEX_WHITESPACES);
		ArrayList<String> strArrList = new ArrayList<String>();
		for (String strTransfer : strArr) {
			strArrList.add(strTransfer);
		}
		return strArrList;
	}

	/*
	 * Returns the first occurrence of arguments signifying a date or time if
	 * none exists, return -1;
	 */
	public static int isDateTimePresent(String str) {
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(ParserConstants.KW_START));
		/*list.addAll(Arrays.asList(ParserConstants.KW_MONDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_TUESDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_WEDNESDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_THURSDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_FRIDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_SATURDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_SUNDAY));*/
		list.addAll(Arrays.asList(ParserConstants.KW_TODAY));
		list.addAll(Arrays.asList(ParserConstants.KW_TOMORROW));
		list.add(ParserConstants.KW_NEXT);
		list.add(ParserConstants.CHAR_RIGHT_ANGLE_BRACKET);
		ArrayList<String> arr = toArrayList(str.trim().toLowerCase());
		int index = arr.size();
		for (String s : list) {
			if (arr.indexOf(s) < index && arr.indexOf(s) != ParserConstants.INDEX_NEGATIVE_ONE) {
				index = arr.indexOf(s);
			}
		}
		if (index == arr.size()) {
			return ParserConstants.INDEX_NEGATIVE_ONE;
		} else {
			return index;
		}
	}

	/*
	 * Checks if the first occurrence of arguments signifying a date belongs
	 * under KW_TODAY or KW_TOMORROW
	 * 
	 * Return 1 if it's KW_TODAY -1 if it's KW_TOMORROW 0 if both are absent
	 */
	public static int isTodayTmr(String str) {
		str = str.trim().toLowerCase();
		for (String s : ParserConstants.KW_TODAY) {
			if (str.equals(s)) {
				return 1;
			}
		}
		for (String s : ParserConstants.KW_TOMORROW) {
			if (str.equals(s)) {
				return -1;
			}
		}
		return 0;
	}
}
