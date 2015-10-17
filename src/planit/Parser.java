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
	 * Returns the first occurrence of arguments signifying a date or time
	 * If none exists, return -1;
	 */
	public static int isDateTimePresent(String str) {
		ArrayList<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(ParserConstants.KW_START));
		list.addAll(Arrays.asList(ParserConstants.KW_MONDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_TUESDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_WEDNESDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_THURSDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_FRIDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_SATURDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_SUNDAY));
		list.addAll(Arrays.asList(ParserConstants.KW_TODAY));
		list.addAll(Arrays.asList(ParserConstants.KW_TOMORROW));
		list.addAll(Arrays.asList(ParserConstants.KW_NEXT));
		list.add(ParserConstants.CHAR_RIGHT_ANGLE_BRACKET);
		ArrayList<String> arr = Parser.toArrayList(str);
		int index = arr.size();
		for (String s : list) {
			if (arr.indexOf(s) < index && arr.indexOf(s) != -1) {
				index = arr.indexOf(s);
			}
		}
		if (index == arr.size()) {
			return -1;
		} else {
			return index;
		}
	}
}
